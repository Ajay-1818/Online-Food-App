import java.util.Random;
import java.util.Scanner;

class CreditCardPayment extends PaymentMethod {
    @Override
    public void pay(double amount) {
        Scanner scanner = new Scanner(System.in);
        int otp = generateOtp();
        System.out.println("An OTP has been sent to your registered mobile number.");
        System.out.print("Enter the OTP to confirm payment: ");
        int userOtp = scanner.nextInt();
        if (userOtp == otp) {
            System.out.println("OTP verified successfully.");
            System.out.println("Paid $" + amount + " using Credit Card.");
        } else {
            System.out.println("Incorrect OTP. Payment failed.");
        }
    }
    private int generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // 6-digit OTP
        System.out.println("[DEBUG] Generated OTP (for simulation): " + otp); // For simulation only
        return otp;
    }
}

