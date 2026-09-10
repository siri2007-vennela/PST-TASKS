import java.util.Scanner;

// Interface
interface Payment {
    void pay(double amount);
}

// Credit Card Payment
class CreditCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.printf("CreditCard payment: %.2f%n", amount);
    }
}

// UPI Payment
class UPIPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.printf("UPI payment: %.2f%n", amount);
    }
}

// Net Banking Payment
class NetBankingPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.printf("NetBanking payment: %.2f%n", amount);
    }
}

// Abstract class
abstract class PaymentProcessor {

    abstract double processPayment(Payment payment, double amount);
}

// Concrete class
class OnlinePaymentProcessor extends PaymentProcessor {

    @Override
    double processPayment(Payment payment, double amount) {

        double finalAmount;

        if (payment instanceof CreditCardPayment) {
            // 2% processing fee
            finalAmount = amount + (amount * 0.02);
        } 
        else if (payment instanceof UPIPayment) {
            // 1% processing fee
            finalAmount = amount + (amount * 0.01);
        } 
        else if (payment instanceof NetBankingPayment) {
            // 1.5% processing fee
            finalAmount = amount + (amount * 0.015);
        } 
        else {
            finalAmount = amount;
        }

        return finalAmount;
    }
}

// Main class
public class PaymentProcessingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PaymentProcessor processor = new OnlinePaymentProcessor();

        for (int i = 0; i < n; i++) {

            int paymentType = sc.nextInt();
            double amount = sc.nextDouble();

            Payment payment;

            // Runtime polymorphism
            if (paymentType == 1) {
                payment = new CreditCardPayment();
            } 
            else if (paymentType == 2) {
                payment = new UPIPayment();
            } 
            else {
                payment = new NetBankingPayment();
            }

            double finalAmount =
                    processor.processPayment(payment, amount);

            if (paymentType == 1) {
                System.out.printf("CreditCard %.2f%n", finalAmount);
            } 
            else if (paymentType == 2) {
                System.out.printf("UPI %.2f%n", finalAmount);
            } 
            else {
                System.out.printf("NetBanking %.2f%n", finalAmount);
            }
        }

        sc.close();
    }
}