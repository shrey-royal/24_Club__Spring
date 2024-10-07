package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Author;
import com.bean.Book;
import com.bean.Car;

public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println(context);
//        Car c = context.getBean("c", Car.class);
//        c.setModel("Toyota Fortuner 2024");
//        System.out.println(c.getModel());
//        
        Author author = context.getBean("author", Author.class);
        author.setAuthorName("Dhyey Patel");
        
        //CI - constructor injection
        // Book has author injected automatically
        Book book = context.getBean("book", Book.class);
        book.setTitle("Lies within us");
        System.out.println(book.getTitle());
        System.out.println(book.getAuthor().getAuthorName());
        
    }
}
