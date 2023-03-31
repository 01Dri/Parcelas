package models.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcela {

    private LocalDate date;
    private Double amount;
    public static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Parcela() {

    }

    public Parcela(LocalDate date, Double amount) {
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return date.format(FORMAT) + " - " + amount;
    }

}
