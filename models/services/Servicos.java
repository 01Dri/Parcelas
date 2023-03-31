package models.services;

public interface Servicos {

    double paymentFee(double amount);
    double interest(double amount, int month);

}
