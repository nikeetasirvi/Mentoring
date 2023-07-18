import java.util.Scanner;

public class Banking{
  
  private int balance = 1000;
  
  public void checkBalance(){
    System.out.println(balance);
  }
  
  public void deposit(int amount){
    if(amount <= 0){
      System.out.println("Enter the valid amount......!!!");
    } else{
      balance += amount;
      System.out.println("Amount successfully deposited");
    }
  }
  
  public void withdrawal(int amount){
    if(amount > balance || amount <=0){
      System.out.println("Amount must be less than or equal to the balance and a positive number......!!!");
    } else{
      balance -= amount;
      System.out.println("Amount successfully withdrawn");
    }
  }
  
  public void transfer(int amount){
    if(amount > balance || amount <= 0){
      System.out.println("Amount must be less than or equal to the balance and a positive number......!!!");
    } else{
      Scanner input = new Scanner(System.in);
      OTPGenerator o = new OTPGenerator();
      int generatedOTP = o.generateOTP();
      System.out.println("Enter this OTP for verification: " +generatedOTP);
      int otp = input.nextInt();
      if(otp == generatedOTP){
        balance -= amount;
        System.out.println("Amount successfully transfered");
      } else{
        System.out.println("Invalid OTP");
      }
      input.close();
    }
  }
}