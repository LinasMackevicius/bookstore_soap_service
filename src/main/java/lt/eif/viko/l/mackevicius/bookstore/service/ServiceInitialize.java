package lt.eif.viko.l.mackevicius.bookstore.service;

import jakarta.annotation.PostConstruct;
import org.springframework.schema.web_services.Book;
import org.springframework.schema.web_services.Customer;
import org.springframework.schema.web_services.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceInitialize {

    private static final Map<Integer, Order> orders = new HashMap<>();
    private static final Map<Integer, Customer> customers = new HashMap<>();
    private static final List<Book> books = new ArrayList<>();

    @PostConstruct
    public void initialize(){

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Linas");
        customer1.setLastName("Vilkauskas");

        Book book1 = new Book();
        book1.setId(1);
        book1.setBookName("Haris Poteris");
        book1.setAuthor("J.K.Rowling");
        book1.setYear(2001);
        book1.setPublisher("Alma Litera");
        book1.setPrice(30);

        Order order1 = new Order();
        order1.setId(1);
        order1.setDate("2023-07-27");
        order1.setCustomers(List.of(customer1));
        order1.setBooks(List.of(book1));

        orders.put(order1.getId(), order1);
        customers.put(customer1.getId(), customer1);
        books.add(book1);

    }

    public Order getOrders(Integer id){
        return orders.get(id);
    }

    public Customer getCustomers(Integer id){
        return customers.get(id);
    }

    public List<Book> getAllBooks(){
        return books;
    }
}
