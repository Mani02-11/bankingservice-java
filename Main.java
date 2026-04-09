import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();

        while (true) {
            System.out.println("\n1.Create \n2.Deposit \n3.Withdraw \n4.Balance \n5.Exit");
            System.out.print("Enter Your Option :");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Balance: ");
                    double bal = sc.nextDouble();
                    bank.createAccount(name, bal);
                    break;

                case 2:
                    System.out.print("Enter Your ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Amount: ");
                    double amt = sc.nextDouble();
                    bank.deposit(id, amt);
                    break;

                case 3:
                    System.out.print("Enter Your ID: ");
                    int wid = sc.nextInt();
                    System.out.print("Enter Amount: ");
                    double wamt = sc.nextDouble();
                    bank.withdraw(wid, wamt);
                    break;

                case 4:
                    System.out.print("Enter YOur ID: ");
                    int bid = sc.nextInt();
                    bank.checkBalance(bid);
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}