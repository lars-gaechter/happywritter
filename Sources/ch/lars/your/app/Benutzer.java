package ch.lars.your.app;

/**
 * Benutzer mit Login Daten als Eigenschaften
 * 
 * @author Protoss
 *
 */
public class Benutzer {

	private String benutzername, passwort;

	/**
	 * Benutzer Konstruktor
	 * 
	 * @param benutzername
	 *            vom Admin
	 * @param passwort
	 *            vom Admin
	 */
	public Benutzer(String benutzername, String passwort) {
		super();
		this.benutzername = benutzername;
		this.passwort = passwort;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

}
