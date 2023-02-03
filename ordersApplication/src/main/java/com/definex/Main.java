package com.definex;

public class Main {


    public static void main(String[] args) {
        System.out.println("Add Customer; ");
        CustomerService.addCustomer();

        System.out.println("Print List; ");
        CustomerService.printList();

        CustomerService.cLetter();

        System.out.println("Sign Date June");
        CustomerService.filterCustomerBySignDate(6);

        System.out.println("All Bill List");
        CustomerService.getAllBill();

        System.out.println("Bigger Than 1500 Bill List");
        CustomerService.biggerThanAmountBillList(1500);
        System.out.println("Bigger Than 1500 Average Bill List");
        CustomerService.biggerThanAmountAverageBillList(1500);

        System.out.println("Names of customers with invoices under 500 in the system");
        CustomerService.lessThanAmount(500);

        System.out.println("Below Average Specified June Sector");
        System.out.println(CustomerService.belowAverageSpecifiedMonthSector(750,6));
    }
}