package r2s.training.services;

import r2s.training.entities.Customer;
import r2s.training.entities.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    public List<Customer> customers = new ArrayList<>();
    public void createCustomer(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----Enter Customer information---");
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            if (name.equals("n") || name.equals("N")) {
                break;
            }
            System.out.print("Enter phone: ");
            String phone = scanner.nextLine();
            if (phone.equals("n") || phone.equals("N")) {
                break;
            }
            System.out.print("Enter address: ");
            String address = scanner.nextLine();
            if (address.equals("n") || address.equals("N")) {
                break;
            }
            System.out.println("Enter order infor: ");
            System.out.print("+ number: ");
            String number = scanner.nextLine();
            if (number.equals("n") || number.equals("N")) {
                break;
            }
            System.out.print("+ date: ");
            String date = scanner.nextLine();
            if (date.equals("n") || date.equals("N")) {
                break;
            }
            System.out.print("+ quantity: ");
            int quantity;
            String strQuantity = scanner.nextLine();
            if (strQuantity.equals("n") || strQuantity.equals("N")) {
                break;
            } else{
                quantity = Integer.parseInt(strQuantity);
            }
            System.out.print("+ price: ");
            String strPrice = scanner.nextLine();
            int price;
            if (strPrice.equals("n") || strPrice.equals("N")) {
                break;
            } else{
                price = Integer.parseInt(strPrice);
            }

            Date date1;
            try {
                date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Order order = new Order(number, date1, quantity, price);

            List<Order> orders = new ArrayList<>();
            orders.add(order);
            Customer customer = new Customer(name, phone, address, orders);
            customers.add(customer);
            System.out.println("Press any key to continue.. or n to finish");
            String key = scanner.nextLine();
            if (key.equals("N") || key.equals("n")) {
                break;
            }
        }
    }

    public List<Customer> findAll(){
        return customers;
    }

    public void display(List<Customer> customers) {
        for (Customer customer: customers) {
            System.out.println("Customer[name="+ customer.getName() +", phone="+ customer.getPhone() +", address="+ customer.getAddress()+", Order[]]");
        }
    }

    public List<Customer> search(String phone) {
        List<Customer> result = new ArrayList<>();
        for (Customer customer: customers) {
            if (customer.getPhone().equals(phone)) {
                result.add(customer);
            }
        }
        return result;
    }

    public boolean remove(String phone) {
        for (Customer customer: customers) {
            if (customer.getPhone().equals(phone)) {
                customers.remove(customer);
                return true;
            }
        }
        return false;
    }
}
