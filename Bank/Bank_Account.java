public class Bank_Account {
    private long acc_number;
    private String acc_name;
    private double acc_balance;

    public Bank_Account(long acc_number,String acc_name,double acc_balance){
        this.acc_number  = acc_number;
        this.acc_name    = acc_name;
        this.acc_balance = acc_balance;
    }

    public void details(){
        System.out.println("Acoount number : " + acc_number);
        System.out.println("Name : " + acc_name);
        System.out.println(" Current Balance : Rs. " + acc_balance);
    }

    public void display(){
        System.out.println(" Current Balance : Rs. " + acc_balance);
    }

    public void deposit(double amount){
        if (amount > 0){
            acc_balance = acc_balance + amount;
            System.out.println("Successfully deposited Rs. " + amount);
        } else {
            System.out.println("Depost failed\n*** invalid amount *** please enter amount greater than zero...");
          }
    }

    public boolean withdraw(double amount){
        if (amount < acc_balance && amount > 0){
            acc_balance = acc_balance - amount;
            System.out.println("Successfully withdraw Rs. " + amount);
            return true;
        } else {
            return false;
          }
        
    }

    public double getBalance() {
        return acc_balance ;
    }
}