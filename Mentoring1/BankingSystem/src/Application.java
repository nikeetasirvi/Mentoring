import java.util.Scanner;

public class Application{
  
  public static void main(String[] args){
    
    Scanner input = new Scanner(System.in);
    
    Customer customer = new Customer("123","123");
    Banking banking = new Banking();
    
    System.out.println("Enter AccountNo");
    String accountNo = input.nextLine();
    System.out.println("Enter password");
    String password = input.nextLine();
    
    if(accountNo.equals(customer.getAccountNo()) && password.equals(customer.getPassword())){
      int option;
      do{
        System.out.println("--------------------------------------");
        System.out.println("1: Check Balance");
        System.out.println("2: Deposit");
        System.out.println("3: Withdrawal");
        System.out.println("4: Transfer");
        System.out.println("0: Logout");
        System.out.println("--------------------------------------");
        System.out.println("Enter an option");
        option = input.nextInt();
        switch(option){
          case 0:{
            break;
          }
          case 1:{
            banking.checkBalance();
            break;
          }
          case 2:{
            System.out.println("Enter the amount to be deposited");
            int depositAmount = input.nextInt();
            banking.deposit(depositAmount);
            break;
          }
          case 3:{
            System.out.println("Enter the amount to be withdrawn");
            int withdrawAmount = input.nextInt();
            banking.withdrawal(withdrawAmount);
            break;
          }
          case 4:{
            System.out.println("Enter the amount to be transfered");
            int transferAmount = input.nextInt();
            banking.transfer(transferAmount);
            break;
          }
          default:{
            System.out.println("Enter valid option..........!!!");
          }
        }
      } while(option != 0);
      System.out.println("Logged out Successfully.......!!!");
    } else{
      System.out.println("Invalid user.....!!!");
    }
    input.close();
  }
}