import java.text.NumberFormat;
import java.util.Scanner;

public class example {

  public static void main(String[] args) {
    final byte ENTIRE_YEAR = 12;
    final byte PERCENTAGE = 100;

    int principal = 0;
    float monthlyAir = 0;
    int numberOfPayments = 0;

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print("Principal: ");
      principal = scanner.nextInt();
      if (principal >= 1000 && principal <= 1_000_000)
        break;
      System.out.println("Please enter an amount between 1,000 and 1,000,000");
    }
    while (true) {
      System.out.print("Annual Interest Rate: ");
      float air = scanner.nextFloat();
      if (air >= 1 && air <= 30) {
        monthlyAir = air / PERCENTAGE / ENTIRE_YEAR;
        break;
      }
      System.out.println("Enter an amount between 1 and 30");
    }

    while (true) {
      System.out.print("Payment Period In Years: ");
      byte years = scanner.nextByte();
      if (years >= 1 && years <= 30) {
        numberOfPayments = years * ENTIRE_YEAR;
        break;
      }
      System.out.println("Enter an amount between 1 and 30");
    }
    double mortgage = principal * (monthlyAir * Math.pow(1 + monthlyAir, numberOfPayments))
        / (Math.pow(1 + monthlyAir, numberOfPayments) - 1);

    String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
    System.out.println("Monthly Mortgage Amount: " + mortgageFormatted);
  }
}