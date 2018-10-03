

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestScanner {

  // Tells the program to prompt the user for inputs one at a time
  // (individually)
  public static final String OPTION_SCAN_INDIVIDUALLY = "INDIVIDUALLY";

  // Tells the program to prompt the user for inputs all on one line
  public static final String OPTION_SCAN_SINGLE_LINE = "SINGLE_LINE";

  /**
   * Private reference to the Scanner instance
   */
  private Scanner scanner;

  /**
   * Constructor - the one, the only
   * 
   * @param scanner
   */
  public TestScanner(Scanner scanner) {
    this.scanner = scanner;
  }

  /**
   * The main() method - drives the program
   * 
   * @param args
   *          Program arguments. First argument tells the program how to
   *          function (if no args, then inputs scanned individually):
   * 
   *          <ul>
   *          <li>INDIVIDUALLY - user is prompted for coin amounts
   *          one-at-a-time</li>
   *          <li>SINGLE_LINS - user is prompted to input coin amounts on a
   *          single line, where coin amounts are separated by a space</li>
   *          </ul>
   */
  public static void main(String[] args) {

    // Create the Scanner
    Scanner scanner = new Scanner(System.in);

    // Create the TestScanner instance
    TestScanner cja = new TestScanner(scanner);

    // Figure out how to scan for coin amounts.
    String scanOption = OPTION_SCAN_INDIVIDUALLY; // Default
    if (args.length > 0) {
      scanOption = args[0];
      // Validate arguments
      if (false == scanOptionValid(scanOption)) {
        showUsage();
        System.exit(-1);
      }
    } else {
      outputMessage("No option selected, going with " + scanOption);
    }

    int[] coins = null;
    if (scanOption.equalsIgnoreCase(OPTION_SCAN_INDIVIDUALLY)) {
      coins = cja.scanInputsIndividually();
    } else if (scanOption.equalsIgnoreCase(OPTION_SCAN_SINGLE_LINE)) {
      coins = cja.scanInputsSingleLine();
    }

    // Just for readability
    int numberOfPennies = coins[0];
    int numberOfNickels = coins[1];
    int numberOfDimes = coins[2];
    int numberOfQuarters = coins[3];

    // Close the scanner
    scanner.close();

    // Calculate the total
    int totalCents = numberOfPennies +
        numberOfNickels * 5 +
        numberOfDimes * 10 +
        numberOfQuarters * 25;
    double dollarValue = totalCents / 100.0;

    outputMessage("Total cents: " + totalCents);
    outputMessage("Total dollar value in change jar: $" + dollarValue);

  }

  /**
   * Scans inputs one-at-a-time (i.e., individually).
   * 
   * @return int[] - An int array containing the coin amounts in this order:
   *         <ol>
   *         <li>pennies</li>
   *         <li>nickels</li>
   *         <li>dimes</li>
   *         <li>quarters</li>
   *         </ol>
   */
  private int[] scanInputsIndividually() {
    int[] ret = { 0, 0, 0, 0 };

    // Number of pennies
    ret[0] = scanLineForInt("Enter number of pennies: ");
    // Number of nickels
    ret[1] = scanLineForInt("Enter number of nickels: ");
    // Number of dimes
    ret[2] = scanLineForInt("Enter number of dimes: ");
    // Number of quarters
    ret[3] = scanLineForInt("Enter number of quarters: ");

    return ret;
  }

  /**
   * Scans inputs on a single line.
   * 
   * @return int[] - An int array containing the coin amounts in this order:
   *         <ol>
   *         <li>pennies</li>
   *         <li>nickels</li>
   *         <li>dimes</li>
   *         <li>quarters</li>
   *         </ol>
   */
  private int[] scanInputsSingleLine() {
    int[] ret = null;

    String message = "Enter number of pennies, nickels, dimes, and quarters on the same line. "
        + "Each amount is separated by a space.";
    outputMessage(message);
    message = "For example: 12 3 2 13 represents 12 pennies, 3 nickels, 2 dimes, and 13 quarters";
    outputMessage(message);
    while (ret == null) {
      int[] coins = { 0, 0, 0, 0 };
      try {
        coins[0] = scanner.nextInt();
        coins[1] = scanner.nextInt();
        coins[2] = scanner.nextInt();
        coins[3] = scanner.nextInt();
        ret = coins;
      } catch (InputMismatchException e) {
        // Advance the scanner past the offending token (or it will hang)
        String token = scanner.next();
        outputMessage("Inputs must be numeric. You entered '" + token + "', please re-enter the line.");
      }
    }

    return ret;
  }

  /**
   * Asks the scanner for the next int on the current line, and does not return
   * until it gets it. Expects only a single number on that line. Handles number
   * format exceptions. Cannot be spoofed by entering all numbers on the same
   * line.
   * 
   * @param message
   *          The message to be displayed to the user
   * 
   * @return int[] - An int array containing the coin amounts in this order:
   *         <ol>
   *         <li>pennies</li>
   *         <li>nickels</li>
   *         <li>dimes</li>
   *         <li>quarters</li>
   *         </ol>
   */
  private Integer scanLineForInt(String message) {
    Integer ret = null;
    String line = null;
    while (line == null) {
      prompt(message);
      line = scanner.nextLine();
      try {
        ret = Integer.valueOf(line);
        break;
      } catch (NumberFormatException e) {
        outputMessage("Numeric value expected, not: '" + line + "', try again.");
        line = null;
      }
    }
    return ret;
  }

  // *****************************************************
  // Utility methods
  // *****************************************************

  private static void prompt(String message) {
    System.out.print(message);
  }

  private static void outputMessage(String message) {
    System.out.println(message);
  }

  private static boolean scanOptionValid(String scanOption) {
    return scanOption.equalsIgnoreCase(OPTION_SCAN_INDIVIDUALLY)
        || scanOption.equalsIgnoreCase(OPTION_SCAN_SINGLE_LINE);
  }

  private static void showUsage() {
    outputMessage("Usage: ");
    outputMessage("\t" + TestScanner.class.getSimpleName() + " scan_option");
    outputMessage("Where:");
    outputMessage("\tscan_option is one of: ");
    outputMessage("\t" + OPTION_SCAN_INDIVIDUALLY + " - user is prompted for coin amounts one-at-a-time");
    outputMessage("\t" + OPTION_SCAN_SINGLE_LINE
        + " - user is prompted for coin amounts on a single line, amounts separated by space");
  }

}
