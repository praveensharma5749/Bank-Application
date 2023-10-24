package bankingSystem;

public class FinoBank implements RBI{

    private String username;
    private String accNo;
    private String password;
    private int balance;
    public static final double ROI = 6.3;

    public FinoBank(String username, String accNo, String password, int balance) {
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
            return "Money added new balance is = "+balance;
        }
        return "Wrong Password";
    }

    @Override
    public String withdrawMoney(String password, int money) {
        if(password.equals(this.password)){
            if(balance<money){
                return "Insufficient Balance";
            }
            balance = balance - money;
            return "Money withdrawn from your account remaining balance is = "+balance;
        }
        return "Wrong Password";
    }

    @Override
    public int rateOfInterest(int years) {
        return (int) ((balance*ROI*years)/100);
    }
}
