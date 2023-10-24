package bankingSystem;

public class kotakBank implements  RBI{

    private String username;
    private String accNo;
    private String password;
    private int balance;
    public static final double ROI = 7.0;

    public kotakBank(String username, String accNo, String password, int balance) {
        this.username = username;
        this.accNo = accNo;
        this.password = password;
        this.balance = balance;
    }

    @Override
    public int fetchBalance(String password) {
        if(password.equals(this.password)){
            return balance;
        }
        return -1;
    }

    @Override
    public String addMoney(String password, int money) {
        if(password.equals(this.password)){
            balance = balance + money;
            return "Money Added new balance is ="+balance;
        }
        return "Wrong Password";
    }

    @Override
    public String withdrawMoney(String password, int money) {
        if(password.equals(this.password)){
            if(balance-money<=1000){
                return "Please maintain sufficient balance in your account";
            }
            else{
                balance = balance - money;
                return "Money withdrawn from your account remaining balance is  "+balance;
            }
        }
        return "Wrong Password";
    }

    @Override
    public int rateOfInterest(int years) {
        return (int) ((balance*ROI*years)/100);
    }
}
