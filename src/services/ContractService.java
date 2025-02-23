package services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    public void processContract(Contract contract, int months) {

        PaypalService service = new PaypalService();
        double basicQuota = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);
            double updatedAmount = service.paymentFee(service.interest(basicQuota, i));

            contract.addInstallment(new Installment(dueDate, updatedAmount));
        }
    }
}
