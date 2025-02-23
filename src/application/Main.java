package application;

import model.entities.Contract;
import services.ContractService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            ContractService contractService = new ContractService();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.println("INSIRA OS DADOS DO CONTRATO:");
            System.out.print("Número:\n-> ");
            int number = sc.nextInt();
            System.out.print("Data (dd/MM/yyyy):\n-> ");
            LocalDate date = LocalDate.parse(sc.next(), dtf);
            System.out.print("Valor do contrato:\n-> R$");
            double totalValue = sc.nextDouble();
            System.out.print("Número de parcelas:\n-> ");
            int months = sc.nextInt();

            Contract contract = new Contract(number, date, totalValue);

            contractService.processContract(contract, months);

            System.out.println();
            System.out.println("PARCELAS:");
            contract.printInstallments();

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}