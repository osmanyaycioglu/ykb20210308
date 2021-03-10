package com.training.micro;

import java.math.BigDecimal;

public class PaymentRequest {

    private Long       customerId;
    private String     customerName;
    private BigDecimal amount;

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

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(final BigDecimal amountParam) {
        this.amount = amountParam;
    }

    @Override
    public String toString() {
        return "PaymentRequest [customerId="
               + this.customerId
               + ", customerName="
               + this.customerName
               + ", amount="
               + this.amount
               + "]";
    }


}
