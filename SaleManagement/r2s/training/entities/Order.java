package r2s.training.entities;

import java.util.Date;

public class Order {
    public static int numbee = 0;
    private String number;

    private Date date;

    private int quantity;

    private int price;

    public Order() {}

    public Order(String number, Date date, int quantity, int price) {
        this.number = number;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
