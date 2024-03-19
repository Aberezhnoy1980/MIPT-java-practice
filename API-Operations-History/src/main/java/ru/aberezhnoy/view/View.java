package ru.aberezhnoy.view;

import ru.aberezhnoy.contract.Contract;
import ru.aberezhnoy.exception.UnexpectedChoiceException;
import ru.aberezhnoy.factory.Factory;
import ru.aberezhnoy.model.persist.CashbackOperation;
import ru.aberezhnoy.model.persist.Customer;
import ru.aberezhnoy.model.persist.LoanOperation;
import ru.aberezhnoy.model.persist.Operation;
import ru.aberezhnoy.presenter.CustomerService;
import ru.aberezhnoy.presenter.OperationService;

import static ru.aberezhnoy.util.Prompt.prompt;

public class View implements Contract.View {
    private final OperationService os;
    private final CustomerService cs;

    public View() {
        this.os = Factory.getOperationService();
        this.cs = Factory.getCustomerService();
    }

    @Override
    public void run() {
        boolean flag = true;

        System.out.println("Welcome to the application!");
        while (flag) {
            System.out.println("""
                    Please select what you want to do:
                    1. Register a user (create)
                    2. Rake the transaction
                    3. Get a list of operations
                    4. Leave the application
                    Enter a number from the list above
                      """);
            int choice = prompt();
            switch (choice) {
                case 1:
                    cs.save(Customer.builder()
                            .setFirstname(prompt("Enter your first name: "))
                            .setLastname(prompt("Enter your last name: "))
                            .setSurname(prompt("Enter your surname: "))
                            .setBirthDate(prompt("Enter your birth date. Please, use dd/md/yyyy format: "))
                            .setGender(prompt("Enter your gender: "))
                            .setPhoneNumber("+7" + prompt("Enter your phone number: \n+7"))
                            .setEmail(prompt("Enter your email: "))
                            .build());
                    break;
                case 2:
                    System.out.println("Please, enter 1 for loan, or 2 for cashback: ");
                    int operationType = prompt();
                    if (operationType == 1)
                        os.save(new LoanOperation(Long.parseLong(prompt("Enter customer id: ")), prompt("Enter amount: "), prompt("Enter description: "), prompt("Enter loan id: ")));
                    else if (operationType == 2)
                        os.save(new CashbackOperation(Long.parseLong(prompt("Enter customer id: ")), prompt("Enter amount: "), prompt("Enter description: ")));
                    else
                        throw new UnexpectedChoiceException();
                    break;
                case 3:
                    System.out.println("Please, enter customer id: ");
                    int id = prompt();
                    for (Operation o : os.findAll()) {
                        if (o.getCustomerId() == id)
                            System.out.printf("%s%n", o);
                    }
                    break;
                case 4:
                    flag = false;
                    break;
                case 5:
//                    System.out.println("Please, enter customer id: ");
                    System.out.println(cs.findAll());
                    break;
                case 6:
//                    System.out.println("Please, enter customer id: ");
                    System.out.println(cs.findById(1).getPhoneNumber());
                    break;
                default:
                    throw new UnexpectedChoiceException();
            }
        }
    }
}
