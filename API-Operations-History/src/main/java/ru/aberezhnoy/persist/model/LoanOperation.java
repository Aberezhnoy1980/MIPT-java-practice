package ru.aberezhnoy.persist.model;

import ru.aberezhnoy.persist.ConsolePrintable;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanOperation extends Operation implements ConsolePrintable, Comparable<LoanOperation> {
    private int loanId;
    private String operationType;

    public LoanOperation(LocalDate date, int amount, String description, int loanId) {
        super(null, date, new BigDecimal(amount), description);
        this.loanId = loanId;
        this.operationType = this.getClass().getSimpleName();
    }

    public LoanOperation() {
        super();
    }

    @Override
    public void print() {
        System.out.printf("Id: %d, type: %s, loan id: %d, amount: %s, date: %s%n", getId(), operationType, loanId, getAmount(), getDate());
    }

    @Override
    public int compareTo(LoanOperation o) {
        return this.getAmount().compareTo(o.getAmount());
    }

    @Override
    public String toString() {
        return String.format("Id: %d, type: %s, loan id: %d, amount: %s, date: %s", getId(), operationType, loanId, getAmount(), getDate());
    }
}
