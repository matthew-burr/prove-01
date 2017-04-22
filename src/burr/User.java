package burr;

/**
 * The User class represents a User's password for use in hashing and validating
 * the password using the NSALoginController class
 *
 * @author Matthew Burr
 * @version 1.0
 * @since 4/19/2017
 */
public class User {

  private String _password;
  private String _salt;
  private String _hashedPassword;

  // Getters & Setters

  /**
   * @param newValue value to set the password to
   */
  public void setPassword(String newValue) {
    _password = newValue;
  }

  /**
   * @return password (or null, if password is already hashed)
   */
  public String getPassword() {
    return _password;
  }

  /**
   * @param newValue salt to add to the password
   */
  public void setSalt(String newValue) {
    _salt = newValue;
  }

  /**
   * @return salt used when hashing the password
   */
  public String getSalt() {
    return _salt;
  }

  /**
   * @param newValue the hashed password
   */
  public void setHashedPassword(String newValue) {
    _hashedPassword = newValue;
  }

  /**
   * @return the hashed password
   */
  public String getHashedPassword() {
    return _hashedPassword;
  }

  // Constructor(s)

  /**
   * Creates a new User with a given password
   *
   * @param password password for the new user
   */
  public User(String password) {
    _password = password;
  }

  // Methods

  /**
   * Displays the User with their details
   *
   * @return a string representing the user's details
   */
  @Override
  public String toString() {
    return String
        .format("\tPassword: %s\n\tSalt: %s\n\tHash: %s\n", _password, _salt, _hashedPassword);
  }
}
