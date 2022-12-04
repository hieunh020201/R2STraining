package r2s.training.main;

import r2s.training.entities.Customer;
import r2s.training.entities.Order;
import r2s.training.services.CustomerService;
import r2s.training.services.OrderService;
import r2s.training.utils.Validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();
        Scanner scanner = new Scanner(System.in);
        boolean notExit = true;
        while (notExit) {
            System.out.println("Choose function:");
            System.out.println("1. Add a new Customer");
            System.out.println("2. Show all Customers");
            System.out.println("3. Search Order by Customer");
            System.out.println("4. Remove Customer");
            System.out.println("5. Exit");
            String number = scanner.nextLine();
            switch (number){
                case "1": {
                    customerService.createCustomer();
                    break;
                }
                case "2": {
                    System.out.println("List of Customer:");
                    List<Customer> customers = customerService.findAll();
                    if (customers == null) {
                        System.out.println("List is empty\n");
                    } else {
                        customerService.display(customers);
                    }
                    break;
                }
                case "3": {
                    System.out.println("----Search Order----");
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    List<Order> orders = orderService.search(phone);
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    for (Order order: orders) {
                        System.out.println("Order number: " + order.getNumber() + ", date: " + df.format(order.getDate())
                                + ", quantity: "  + order.getQuantity() + ", price: "  + order.getPrice() + "\n");
                    }
                    break;
                }
                case "4": {
                    System.out.println("----Remove Customer----");
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    if (customerService.remove(phone)) {
                        System.out.println("Remove successfully\n");
                    } else {
                        System.out.println("Remove failed\n");
                    }
                    break;
                }
                case "5": {
                    notExit = false;
                    break;
                }
            }
        }
    }
}
