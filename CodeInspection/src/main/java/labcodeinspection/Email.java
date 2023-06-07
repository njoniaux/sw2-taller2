package labcodeinspection;

import java.util.Locale;

public class Email {

	private final String m_firstName; // final
	private final String m_lastName; // final
	private String password; // no redundant initialization
	private String department;
	private final int DEFAULT_PASSWORD_LENGTH = 8;
	private String email;

    /**
     * Constructor for Email class.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
	public Email(String firstName, String lastName) {
		this.m_firstName = firstName;
		this.m_lastName = lastName;
	}

    /**
     * Display email information.
     */
	public void showInfo() {
		System.out.println("\nFIRST NAME= " + m_firstName + "\nLAST NAME= " + m_lastName);
		System.out.println("DEPARMENT= " + department + "\nEMAIL= " + email + "\nPASSWORD= " + password);
	}

    /**
     * Set the department based on the provided choice.
     *
     * @param depChoice the department choice
     */
	public void setDeparment(int depChoice) {
		switch (depChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
			break;
		}
	}

	private String randomPassword(int length) {
		String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		return String.valueOf(password); // avoid string instantiation
	}

    /**
     * Generate email and password.
     */
	public void generateEmail() {
		this.password = this.randomPassword(this.DEFAULT_PASSWORD_LENGTH);
		this.email = this.m_firstName.toLowerCase(Locale.ROOT) + this.m_lastName.toLowerCase(Locale.ROOT) + "@" + this.department
				+ ".espol.edu.ec";
	}
}
