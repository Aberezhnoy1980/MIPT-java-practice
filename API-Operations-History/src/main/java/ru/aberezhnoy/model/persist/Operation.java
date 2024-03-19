package ru.aberezhnoy.model.persist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.aberezhnoy.contract.Contract;
import ru.aberezhnoy.exception.CustomerNotFound;
import ru.aberezhnoy.factory.Factory;
import ru.aberezhnoy.model.ConsolePrintable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Operation implements ConsolePrintable {
    private Long id;
    private long customerId;
    private LocalDateTime date;
    private BigDecimal amount;
    private String description;

    public void print(){
        System.out.printf("Id: %d, amount: %s, date: %s, description: %s%n", id, amount, date, description);
    }
}
