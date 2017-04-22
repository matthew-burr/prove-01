package burr;

import java.util.Scanner;

/**
 * Tests the User class in conjunction with the NSALoginController.
 *
 * @author Matthew Burr
 * @version 1.0
 * @since 4/19/2017
 */
public class Test {

  private static Scanner _scanner = new Scanner(System.in);

  public static void main(String[] args) {

    // Prompt for a password and store it in a new user object
    User user;
    boolean isValidPassword = false;

    do {
      user = new User(promptForPassword());
      System.out.println("Before");
      System.out.println(user.toString());
      try {
        NSALoginController.hashUserPassword(user);
        isValidPassword = true;
      } catch (WeakPasswordException wpe) {
        System.out.println(
            "The password you gave does not meet NSA password requirements.\nPasswords must be at "
                + "least 8 characters long and contain at least 1 digit.\nTry again.");
      } catch (Exception ex) {
        System.out.println(
            "Ran into an exception while trying to hash the user password: " + ex.getMessage());
      }
    } while (!isValidPassword);

    System.out.println("After");
    System.out.println(user.toString());

    // Now we're going to verify the password by prompting the user for it again and verifying it matches
    user.setPassword(promptForPassword());
    try {
      if (NSALoginController.verifyPassword(user)) {
        System.out.println("Passwords match!");
      } else {
        System.out.println("Passwords DO NOT match!");
      }
    } catch (Exception ex) {
      System.out.println(
          "Ran into an exception while trying to verify the user password: " + ex.getMessage());
    }

  }

  private static String promptForPassword() {
    System.out.print("Password: ");
    return _scanner.nextLine();
  }
}
