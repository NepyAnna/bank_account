package com.sheoanna;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        BankAccount account = new BankAccount(0, 0.12f);

        System.out.println(account);

        account.monthlyStatement();

        System.out.println("\n******************************************");
        System.out.println("monthlyStatement with 0 balance");
        System.out.println(account);


        System.out.println("\n******************************************");
        System.out.println("account after deposit");
        account.depositMoney(3400);
        System.out.println(account);

        account.monthlyStatement();
        System.out.println("\n******************************************");
        System.out.println("monthlyStatement with non 0 balance");
        System.out.println(account);
    }
}
