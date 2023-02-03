package com.definex;
import java.util.Date;
import java.util.List;

public class Customer {
    private String name;
    private String company;
    private String sector;
    private Date signUpDate;
    private List<Bill> billList;

    public Customer(String name, String company, String sector, Date signUpDate, List<Bill> billList) {
        this.name = name;
        this.company = company;
        this.sector = sector;
        this.signUpDate = signUpDate;
        this.billList = billList;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Date getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(Date signUpDate) {
        this.signUpDate = signUpDate;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", sector='" + sector + '\'' +
                ", signUpDate=" + signUpDate +
                ", billList=" + billList +
                '}';
    }
}
