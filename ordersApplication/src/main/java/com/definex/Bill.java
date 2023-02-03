package com.definex;
import java.util.Date;

public class Bill {
    private Date date;
    private double amount;

    public Bill(Date date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public Bill() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "date=" + date +
                ", amount=" + amount +
                '}';
    }
}
