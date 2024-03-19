package ru.aberezhnoy.view;

import ru.aberezhnoy.contract.Contract;
import ru.aberezhnoy.exception.UnexpectedChoiceException;
import ru.aberezhnoy.factory.Factory;
import ru.aberezhnoy.model.persist.CashbackOperation;
import ru.aberezhnoy.model.persist.Customer;
import ru.aberezhnoy.model.persist.LoanOperation;

import static ru.aberezhnoy.util.Prompt.prompt;

public class View implements Contract.View {
    private final Contract.Presenter presenter;

    public View() {
        this.presenter = Factory.getPresenter();
    }

    @Override
    public void run() {
        boolean flag = true;

        System.out.println("Welcome to the application!");
        while (flag) {
            System.out.println("""
                    Please select what you want to do:
                    1. Register a user (create)
                    2. Make the transaction
                    3. Get a list of customers
                    4. Get a list of operations
                    5. Get  list of operation by customer
                    6. Delete a customer
                    7. Delete operation
                    8. Leave the application
                    Enter a number from the list above
                      """);
            int choice = prompt();
            switch (choice) {
                case 1:
                    presenter.saveCustomer(Customer.builder()
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
                        presenter.saveOperation(new LoanOperation(Long.parseLong(prompt("Enter customer id: ")), prompt("Enter amount: "), prompt("Enter description: "), prompt("Enter loan id: ")));
                    else if (operationType == 2)
                        presenter.saveOperation(new CashbackOperation(Long.parseLong(prompt("Enter customer id: ")), prompt("Enter amount: "), prompt("Enter description: ")));
                    else
                        throw new UnexpectedChoiceException();
                    break;
                case 3:
                    presenter.findAllCustomers();
                    break;
                case 4:
                    presenter.findAllOperations();
                    break;
                case 5:
                    System.out.println("Please, enter customer id: ");
                    presenter.findOperationsByCustomer(prompt());
                    break;
//                case 6:
//                    System.out.println("Please, enter customer id: ");
//                    presenter.removeCustomerById(prompt());
//                    break;
//                case 5:
//                    System.out.println("Please, enter customer id: ");
//                    presenter.removeOperationById(prompt());
//                    break;
                case 8:
                    flag = false;
                    break;
                default:
                    throw new UnexpectedChoiceException();
            }
        }
    }
}
