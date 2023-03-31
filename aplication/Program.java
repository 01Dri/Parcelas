package aplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import models.entities.Contrato;
import models.entities.Parcela;
import models.services.ContratoService;
import models.services.PayPalService;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Entre com os dados do contrato: ");
        System.out.print("Numero: ");
        int number = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), format);
        System.out.print("Valor do contrato: ");
        double totalValue = sc.nextDouble();
        Contrato contrato = new Contrato(number, date, totalValue);
        System.out.print("Entre com o numero de parcelas: ");
        int numberParcelas = sc.nextInt();

        ContratoService contractService = new ContratoService(new PayPalService());
        contractService.processContract(contrato, numberParcelas);
        System.out.println("Parcelas: ");
        for (Parcela parcela : contrato.getParcelas()) {
            System.out.println(parcela);
        }

        sc.close();

    }
}
