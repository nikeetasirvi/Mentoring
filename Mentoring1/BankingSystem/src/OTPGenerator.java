public class OTPGenerator{
  
  public int generateOTP(){
    int otp = (int) (Math.random() * 9000 + 1000);
    return otp;
  }
}