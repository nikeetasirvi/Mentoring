public class Customer{

  private String accountNo;
  private String password;
  
  public Customer(String accountNo, String password){
    this.accountNo = accountNo;
    this.password = password;
  }
  
  public void setAccountNo(String accountNo){
    this.accountNo = accountNo;
  }
  
  public String getAccountNo(){
    return accountNo;
  }
  
  public void setPassword(String password){
    this.password = password;
  }
  
  public String getPassword(){
    return password;
  }
}