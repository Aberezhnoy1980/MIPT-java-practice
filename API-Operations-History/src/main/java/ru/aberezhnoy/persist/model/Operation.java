package ru.aberezhnoy.persist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.aberezhnoy.persist.ConsolePrintable;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Operation implements ConsolePrintable {
    private Long id;
    private LocalDate date;
    private BigDecimal amount;
    private String description;

    public void print(){
        System.out.printf("Id: %d, amount: %s, date: %s, description: %s%n", id, amount, date, description);
    }
}
