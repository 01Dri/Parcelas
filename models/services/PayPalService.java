package models.services;

public class PayPalService implements Servicos {

    @Override
    public double paymentFee(double amount) {
        return amount * 0.02;
    }

    @Override
    public double interest(double amount, int month) {
        return amount * 0.01 * month;
    }

}
