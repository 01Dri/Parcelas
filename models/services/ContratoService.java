package models.services;

import java.time.LocalDate;

import models.entities.Contrato;
import models.entities.Parcela;

public class ContratoService {

    private Servicos servicos;

    public ContratoService() {

    }

    public ContratoService(Servicos servicos) {
        this.servicos = servicos;
    }

    public void processContract(Contrato contrato, int month) {
        double basicQuota = contrato.getTotalValue() / month;
        for (int i = 1; i <= month; i++) {
            LocalDate dueDate = contrato.getDate().plusMonths(i);
            Double interest = servicos.interest(basicQuota, i);
            Double fee = servicos.paymentFee(basicQuota + interest);
            Double quota = basicQuota + interest + fee;
            contrato.getParcelas().add(new Parcela(dueDate, quota));

        }
    }

}
