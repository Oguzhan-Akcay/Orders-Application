package com.definex;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerService {
    public static List<Customer> customerList = new ArrayList<>();
    public static List<Bill> billList = new ArrayList<>();

    //Written to add customers.
    public static void addCustomer() {
        customerList.add(
                new Customer("Cagri", "EVAM", "Software Development", new Date(2022, Calendar.JUNE, 12),
                        Arrays.asList(new Bill(new Date(2022, Calendar.JUNE, 12), 2000), new Bill(new Date(2022, Calendar.JUNE, 12), 500))));
        customerList.add
                (new Customer("Oguzhan", "Definex", "Software Development", new Date(2022, Calendar.JUNE, 16),
                        Arrays.asList(new Bill(new Date(2022, Calendar.JUNE, 16), 2000), new Bill(new Date(2022, Calendar.JUNE, 16), 1500), new Bill(new Date(2022, Calendar.JUNE, 16), 4000))));

        customerList.add
                (new Customer("Gurkan", "Demir Enerji", "Energy", new Date(2022, Calendar.JULY, 19),
                        Arrays.asList(new Bill(new Date(2022, Calendar.JULY, 19), 3000), new Bill(new Date(2022, Calendar.JULY, 19), 2600), new Bill(new Date(2022, Calendar.JULY, 19), 8000))));
        customerList.add(
                new Customer("Merve", "Bayer", "chemical", new Date(2022, Calendar.MARCH, 12),
                        Arrays.asList(new Bill(new Date(2022, Calendar.MARCH, 12), 100), new Bill(new Date(2022, Calendar.MARCH, 12), 1600), new Bill(new Date(2022, Calendar.MARCH, 12), 19000))));

        customerList.add(
                new Customer("Akcay", "Cv Energy", "Solar Energy", new Date(2022, Calendar.JANUARY, 06),
                        Arrays.asList(new Bill(new Date(2022, Calendar.JANUARY, 06), 4000), new Bill(new Date(2022, Calendar.JANUARY, 06), 2600), new Bill(new Date(2022, Calendar.JANUARY, 06), 200))));
    }

    //Written to call invoice.
    public static void getAllBill() {

        //System.out.println(billList);
        billList.addAll(customerList.stream().flatMap(bills -> bills.getBillList().stream())
                .toList());
        System.out.println(billList);
    }

    //It was written to list the sector in which the companies whose invoices for the month of June average less than 750.
    public static List<String> belowAverageSpecifiedMonthSector(double amount, int month) {
        Map<String, Double> companyToAvgBill = customerList.stream()
                .collect(Collectors.groupingBy(
                        Customer::getCompany,
                        Collectors.averagingDouble(
                                customer -> customer.getBillList().stream()
                                        .filter(bill -> bill.getDate().getMonth() == month)
                                        .mapToDouble(Bill::getAmount)
                                        .average()
                                        .orElse(0)
                        )
                ));
        return companyToAvgBill.entrySet().stream()
                .filter(entry -> entry.getValue() < amount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    //It was written to list the invoices over 1500 TL in the system.
    public static void biggerThanAmountBillList(double amount) {
        billList.stream().filter(x -> x.getAmount() > amount).forEach(System.out::println);
    }

    //It was written to calculate the average of invoices over 1500 in the system.
    public static void biggerThanAmountAverageBillList(double amount) {
        double average = billList.stream().filter(x -> x.getAmount() > amount).
                mapToDouble(Bill::getAmount).average().orElse(0);
        System.out.println(average);
    }

    //It is written to list the names of customers with invoices under 500 in the system.
    public static void lessThanAmount(double amount) {
        customerList.stream()
                .filter(c -> c.getBillList().stream()
                        .anyMatch(i -> i.getAmount() < amount))
                .map(Customer::getName)
                .forEach(System.out::println);
    }

    //Written to list all customers.
    public static void printList() {
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    /*
    public static void printList(List<Customer> list) {
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }*/

    //Written to list customers with the letter 'C' in it
    public static void cLetter() {
        System.out.println("\nCustomers with 'C' in name: ==>");
        customerList.stream()
                .filter(c -> c.getName().toLowerCase().contains("c"))
                .forEach(System.out::println);
    }
/*
    public static List<Customer> filterName(String letter) {
        List<Customer> returnList = new ArrayList<>();
        for (Customer customer : customerList) {
            if (customer.getName().toLowerCase().contains(letter.toLowerCase())) {
                returnList.add(customer);
            }
        }
        return returnList;
    }*/


    //It was written to list the total amount of invoices for customers who signed up in June.
    public static void filterCustomerBySignDate(int month) {
        customerList.stream()
                .filter(customer -> customer.getSignUpDate().getMonth() == month - 1)
                .toList().forEach(customer -> System.out.println(customer.getName() + " Total Order Price ==> " + "$ " +
                        customer.getBillList().stream().mapToDouble(Bill::getAmount).sum()));
    }


}
