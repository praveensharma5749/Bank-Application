package bankingSystem;

public interface RBI {

    public int fetchBalance(String password);

    public String addMoney(String password, int money);

    public String withdrawMoney(String password, int money);

    public int rateOfInterest(int years);
}
