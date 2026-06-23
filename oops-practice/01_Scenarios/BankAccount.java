public class BankAccount {
    private String accountNumber;
    private String holder;
    private double balance;
    private static int totalAccounts;

    public BankAccount(String accountNumber,String holder,double balance){
        this.accountNumber=accountNumber;
        this.holder=holder;
        this.balance=balance;
        totalAccounts++;
    }

    public void deposit(double amount){ balance+=amount; }

    public void withdraw(double amount){
        if(amount<=balance) balance-=amount;
        else System.out.println("Insufficient Balance");
    }

    public void getStatement(){
        System.out.println(accountNumber+" "+holder+" "+balance);
    }
}