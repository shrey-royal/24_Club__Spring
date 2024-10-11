package com.sboot.dao;

import com.sboot.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate stmt;

    public void addUser(UserBean user) {
        stmt.update("INSERT INTO users (firstName, email, password, deleted) VALUES (?, ?, ?, 0)", user.getFirstName(), user.getEmail(), user.getPassword());
    }

    public List<UserBean> getAllUsers() {
        return stmt.query("SELECT * FROM users WHERE deleted != 1", new BeanPropertyRowMapper<UserBean>(UserBean.class));
    }

    public void softDeleteUser(Integer userId) {
        stmt.update("UPDATE users SET deleted = 1 WHERE userId = ?", userId);
    }

    public void hardDeleteUser(Integer userId) {
        stmt.update("DELETE FROM users WHERE userId = ?", userId);
    }

    public List<UserBean> getDeletedUsers() {
        return stmt.query("SELECT * FROM users WHERE deleted = 1", new BeanPropertyRowMapper<UserBean>(UserBean.class));
    }

    public List<UserBean> searchUserByFirstName(String firstName) {
        return stmt.query("SELECT * FROM users WHERE deleted != 1 AND firstName like ?", new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] {firstName + '%'});
    }

    public void updateUser(UserBean user) {
        stmt.update("UPDATE users SET firstName=?, email=?, password=? WHERE userId=?", user.getFirstName(), user.getEmail(), user.getPassword(), user.getUserId());
    }

    public UserBean getUserByUserId(Integer userId) {
        return stmt.queryForObject("SELECT * FROM users WHERE deleted != 1 AND userId = ?", new BeanPropertyRowMapper<UserBean>(UserBean.class), userId);
    }
}
