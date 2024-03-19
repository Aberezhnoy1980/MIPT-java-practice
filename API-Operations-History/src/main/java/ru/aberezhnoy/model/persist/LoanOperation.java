package ru.aberezhnoy.model.persist;

import ru.aberezhnoy.exception.CustomerNotFound;
import ru.aberezhnoy.factory.Factory;
import ru.aberezhnoy.model.ConsolePrintable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LoanOperation extends Operation implements ConsolePrintable, Comparable<LoanOperation> {
    private String loanId;
    private String operationType;

    public LoanOperation(long customerId, String amount, String description, String loanId) {
        super(null, customerId, LocalDateTime.now(), new BigDecimal(amount), description);
        this.loanId = loanId;
        this.operationType = this.getClass().getSimpleName();
    }

    public LoanOperation() {
        super();
    }

    @Override
    public void print() {
        System.out.printf("Id: %d, type: %s, loan id: %s, amount: %s, date: %s%n", getId(), operationType, loanId, getAmount(), getDate());
    }

    @Override
    public int compareTo(LoanOperation o) {
        return this.getAmount().compareTo(o.getAmount());
    }

    @Override
    public String toString() {
        return String.format("Id: %d, type: %s, loan id: %s, amount: %s, date: %s", getId(), operationType, loanId, getAmount(), getDate());
    }
}
