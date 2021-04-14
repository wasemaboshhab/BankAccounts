import java.util.Scanner;

public class Main {
   public static BankAccount[] accounts = new BankAccount[3];
    public static void main(String[] args) {


        initBankAccount();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("****************");
            System.out.println("Enter your name :");
            String userName;
             userName = scanner.nextLine();
            int checkedALl = accounts.length ;
            for (int i = 0; i < accounts.length ; i++) {
                BankAccount current = accounts[i];
                checkedALl--;
                if (current.getClintName().equals(userName)) {
                    if (current.isSuspended()) {
                        System.out.println("Your Account is Suspended");
                        break;
                    } else {
                        int counter = accounts.length;
                        System.out.println("Found Account");

                        while (counter > 0) {
                            System.out.println("Password :");
                            String userPassword = scanner.next();
                            counter--;
                            if (current.getPassword().equals(userPassword)) {
                                System.out.println("What action do you want to perform ?");
                                System.out.println("[1] - deposit");
                                System.out.println("[2] - withdrawals");
                                System.out.println("[3] - Account Status");
                                int actions = scanner.nextInt();
                                switch (actions) {
                                    case 1:
                                        System.out.println("Machine operation to perform");
                                        current.deposit(scanner.nextInt());
                                        System.out.println("Your Balance now : " + current.getBalance());
                                        break;
                                    case 2:
                                        System.out.println("Machine operation to perform :");
                                        current.withdrawals(scanner.nextInt());
                                        System.out.println("Your Balance now : " + current.getBalance());
                                        break;
                                    case 3:
                                        System.out.println(current);
                                        break;
                                    default:
                                        System.out.println("\t!ERROR!    ");
                                        System.out.println("tro to login again\n\tBYE BYE");
                                        break;
                                }
                                break;

                            } else {
                                System.out.println("Wrong! Password");
                                if (counter==0) continue;
                                System.out.println("You have " + counter + " attempts left");

                            }
                        }
                        if (counter == 0) {
                            current.setSuspended(true);
                            System.out.println("Your Account changed to Suspended");
                            break;
                        }
                        break;
                    }

                    }
                if (checkedALl == 0) {
                    System.out.println("Account Not Founded");
                    break;
                }
            }
        }

            }


    public static void initBankAccount() {
        BankAccount account1 = new BankAccount("Wasim", "1111", 30_000, 5_000, false);
        BankAccount account2 = new BankAccount("Shai", "2222", 50_000, 10_000, false);
        BankAccount account3 = new BankAccount("Ronen", "3333", 100_000, 30_000, true);
        accounts[0] = account1;
        accounts[1] = account2;
        accounts[2] = account3;
    }

}

