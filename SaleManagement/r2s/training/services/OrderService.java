package r2s.training.services;

import r2s.training.entities.Customer;
import r2s.training.entities.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
//    Sử dụng static List<Customer> có thể viết hàm tìm kiếm trong OrderService
    public List<Order> search(String phone) {
        List<Order> result = new ArrayList<>();
        for (Customer customer: CustomerService.customers) {
            if (customer.getPhone().equals(phone)) {
                result.addAll(customer.getOrders());
            }
        }
        return result;
    }
}
