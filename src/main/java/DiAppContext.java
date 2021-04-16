
import beans.MangerMemoryStudent;
import beans.Quote;
import beans.Student;
import beans.shopApp.Product;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class DiAppContext {

    public static void main(String[] args) throws ServletException {


        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

//        MangerMemoryStudent memoryStudent = context.getBean("memoryStudent", MangerMemoryStudent.class);
//        memoryStudent.addStudent(new Student(1, "Jan", "Nowak", 34));
//        memoryStudent.showListSize();
//
//        Quote quote = context.getBean("quote",Quote.class);
//        quote.saveTOFile();
//        quote.searchQuoteAndAutor();
//        System.out.println("Cytat: " + quote.getQuote());
//        System.out.println("Autor: " + quote.getAuthor());
        Product product = context.getBean("product",Product.class);
        System.out.println(product.toString());
    }

}
