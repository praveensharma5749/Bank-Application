package bankingSystem;

import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        System.out.println("Enter Your Information");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Your Name");
        String userName = sc.next();

        System.out.println("Enter Your Account Number");
        String accNo = sc.next();

        System.out.println("Enter Your Password");
        String password = sc.next();

        System.out.println("Enter Amount to be add in your account = ");
        int money = sc.nextInt();

        RBI bankobj;

        System.out.println("Please enter which account you open Kotak or Fino :-");
        String bankName = sc.next();

        if(bankName.equals("Kotak")){
            bankobj=new kotakBank(userName,accNo,password,money);
        }
        else if(bankName.equals("Fino")){
            bankobj=new FinoBank(userName,accNo,password,money);
        }
        else{
            System.out.println("Enter Right Bank Name");
            return ;
        }

        System.out.println("after getting your account balance first enter your password:-");
        String pin=sc.next();

        if(!pin.equals(password)){
            System.out.println("Your password is wrong!!");
            return;
        }
        int currentbalance = bankobj.fetchBalance(pin);
        System.out.println(currentbalance);

        if(!bankName.equals("Kotak") && currentbalance<1000){
            return;
        }

        System.out.println("How much money you want to add in your account");
        money = sc.nextInt();

        System.out.println(bankobj.addMoney(pin,money));

        System.out.println("How much money do you want to widthdraw :-");
        int withdrawMoney= sc.nextInt();

        System.out.println(bankobj.withdrawMoney(pin,withdrawMoney));

        System.out.println("Enter years :- ");
        int years=sc.nextInt();

        System.out.println(bankobj.rateOfInterest(years));
    }

}
