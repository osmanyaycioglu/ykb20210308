package com.training.micro;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class PaymentRequest {

    @NotNull
    @Positive
    private Long       customerId;
    @NotEmpty
    @Size(min = 2, max = 20)
    private String     customerName;
    @NotNull
    @Max(1000)
    @Positive
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
