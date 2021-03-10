package com.training.micro.order.models;

import java.util.List;

public class Order {

    private Long         orderId;
    private Long         customerId;
    private String       customerName;
    private List<String> meals;

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(final Long orderIdParam) {
        this.orderId = orderIdParam;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final Long customerIdParam) {
        this.customerId = customerIdParam;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(final String customerNameParam) {
        this.customerName = customerNameParam;
    }

    public List<String> getMeals() {
        return this.meals;
    }

    public void setMeals(final List<String> mealsParam) {
        this.meals = mealsParam;
    }

    @Override
    public String toString() {
        return "Order [orderId="
               + this.orderId
               + ", customerId="
               + this.customerId
               + ", customerName="
               + this.customerName
               + ", meals="
               + this.meals
               + "]";
    }


}
