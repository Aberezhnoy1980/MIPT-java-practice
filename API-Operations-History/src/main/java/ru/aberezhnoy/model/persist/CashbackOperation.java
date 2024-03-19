package ru.aberezhnoy.model.persist;

import ru.aberezhnoy.model.ConsolePrintable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CashbackOperation extends Operation implements ConsolePrintable, Comparable<CashbackOperation> {
    private int cashbackAmount;
    private String operationType;

    public CashbackOperation(long customerId, String amount, String description) {
        super(null, customerId, LocalDateTime.now(), new BigDecimal(amount), description);
        this.operationType = this.getClass().getSimpleName();
        this.cashbackAmount = Integer.parseInt(String.valueOf(this.getAmount().multiply(new BigDecimal("0.15"))).split("\\.")[0]);
    }

    public CashbackOperation() {
        super();
    }

    @Override
    public void print() {
        System.out.printf("Id: %d, type: %s, amount: %s, cashback: %s, date: %s%n", getId(), operationType, getAmount(), cashbackAmount, getDate());
    }

    @Override
    public int compareTo(CashbackOperation o) {
        return this.getAmount().compareTo(o.getAmount());
    }

    @Override
    public String toString() {
        return String.format("Id: %d, type: %s, amount: %s, cashback: %s, date: %s", getId(), operationType, getAmount(), cashbackAmount, getDate());
    }
}
