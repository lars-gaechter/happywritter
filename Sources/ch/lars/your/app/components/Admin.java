package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;
import ch.lars.your.app.Application;
import com.webobjects.appserver.WOActionResults;
/**
 * Admin Seite mit benutzername und passwort vom Administrator Login
 * @author Protoss
 *
 */
public class Admin extends BaseComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2543123636469800805L;
	Application application = (Application) Application.application();
	private String benutzername, passwort;
	/**
	 * Admin Konstruktor
	 * @param context super
	 */
    public Admin(WOContext context) {
        super(context);
        
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
	/**
	 * Hier das zusammenbündeln von Benutzername und Passwort
	 * Anmledung vom Administrator prüft erst in der Apllikation Klasse ob diese Daten richtig sind
	 * @return gibt einen angemeldeten benutzer aus der applikation zurück, wenn die Eingaben stimmen
	 */
	public WOActionResults anmelden() {
		return application().anmelden(getBenutzername(), getPasswort());
	}
	/**
	 * Zurück zur Main Seite von der Admin Seite aus
	 * @return Main Seite
	 */
	public Main zurueck() {
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}
    
    
}