import java.util.*;

class BankService {
    List<Account> accounts = FileHandler.load();
    int idCounter = accounts.size() + 1;

    public void createAccount(String name, double balance) {
        Account acc = new Account(idCounter++, name, balance);
        accounts.add(acc);
        FileHandler.save(accounts);
        System.out.println("Account Created!");
    }

    public void deposit(int id, double amount) {
        for (Account acc : accounts) {
            if (acc.id == id) {
                acc.balance += amount;
                FileHandler.save(accounts);
                System.out.println("Deposited!");
                return;
            }
        }
        System.out.println("Account not found!");
    }

    public void withdraw(int id, double amount) {
        for (Account acc : accounts) {
            if (acc.id == id) {
                if (acc.balance >= amount) {
                    acc.balance -= amount;
                    FileHandler.save(accounts);
                    System.out.println("Withdrawn!");
                } else {
                    System.out.println("Insufficient balance!");
                }
                return;
            }
        }
        System.out.println("Account not found!");
    }

    public void checkBalance(int id) {
        for (Account acc : accounts) {
            if (acc.id == id) {
                System.out.println("Balance: " + acc.balance);
                return;
            }
        }
        System.out.println("Account not found!");
    }
}