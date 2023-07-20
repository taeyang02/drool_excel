package com.example.mydrools_excel;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class Customer {
    private CustomerType type;

    private int years;

    private int discount;

    public Customer(CustomerType type, int years, int discount) {
        this.type = type;
        this.years = years;
        this.discount = discount;
    }

// Standard getters and setters

    public enum CustomerType {
        INDIVIDUAL,
        BUSINESS;
    }

}
