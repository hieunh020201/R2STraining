package r2s.training.services;

import r2s.training.entities.Customer;
import r2s.training.entities.Order;
import r2s.training.utils.Constants;
import r2s.training.utils.Validator;

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
            if (checkQuit(name)) {
                break;
            }

            System.out.print("Enter phone: ");
            String phone = scanner.nextLine();
            boolean checkPhone;
            boolean flag = true;
            while (true) {
                if (checkQuit(phone)) {
                    flag = false;
                    break;
                }else {
                    checkPhone = Validator.checkFormatPhone(phone);
                    if (checkPhone) {
                        break;
                    } else {
                        System.err.print("Error format phone! Enter phone again: ");
                        phone = scanner.nextLine();
                    }
                }
            }

            if (!flag) {
                break;
            }

            System.out.print("Enter address: ");
            String address = scanner.nextLine();
            if (checkQuit(address)) {
                break;
            }

            System.out.println("Enter order infor: ");
            List<Order> orders = new ArrayList<>();
            while (true) {
                System.out.print("+ number: ");
                String number = scanner.nextLine();
                boolean format;
                while (true) {
                    if (checkQuit(number)) {
                        flag = false;
                        break;
                    }else {
                        format = Constants.checkFormatNumber(number);
                        if (format) {
                            break;
                        } else {
                            System.err.println("Number string has length equals 10! Enter number again: ");
                            number = scanner.nextLine();
                        }
                    }
                }

                if (!flag) {
                    break;
                }

                System.out.print("+ date: ");
                String date = scanner.nextLine();
                if (checkQuit(date)) {
                    break;
                }
                Date date1;
                try {
                    date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                System.out.print("+ quantity: ");
                int quantity;
                String strQuantity = scanner.nextLine();
                if (checkQuit(strQuantity)) {
                    break;
                } else{
                    quantity = Integer.parseInt(strQuantity);
                }

                System.out.print("+ price: ");
                String strPrice = scanner.nextLine();
                int price;
                if (checkQuit(strPrice)) {
                    break;
                } else{
                    price = Integer.parseInt(strPrice);
                }

                Order order = new Order(number, date1, quantity, price);
                orders.add(order);
                System.out.println("Press any key to continue create new order or n to finish");
                String key = scanner.nextLine();
                if (checkQuit(key)) {
                    break;
                }
            }

            Customer customer = new Customer(name, phone, address, orders);
            customers.add(customer);

            System.out.println("Press any key to continue create new customer or n to finish");
            String key = scanner.nextLine();
            if (checkQuit(key)) {
                break;
            }
        }
    }

    public List<Customer> findAll(){
        return customers;
    }

    public void display(List<Customer> customers) {
        for (Customer customer: customers) {
            System.out.println("Customer[name="+ customer.getName() +", phone="+ customer.getPhone()
                    +", address="+ customer.getAddress()+", Order[]]");
        }
    }

    public List<Order> search(String phone) {
        List<Order> result = new ArrayList<>();
        for (Customer customer: customers) {
            if (customer.getPhone().equals(phone)) {
                result.addAll(customer.getOrders());
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

    private boolean checkQuit(String key) {
        if (key.equals("n") || key.equals("N")) {
            return true;
        } else {
            return false;
        }
    }
}
