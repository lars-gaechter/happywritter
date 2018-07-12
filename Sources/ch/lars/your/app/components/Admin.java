package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;

import ch.lars.your.app.Benutzer;

import java.util.Iterator;

import com.webobjects.appserver.WOActionResults;

/**
 * Admin Seite mit benutzername und passwort vom Administrator Login
 * 
 * @author Protoss
 *
 */
public class Admin extends BaseComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2543123636469800805L;
	private String benutzername, passwort;
	private NSMutableArray<Benutzer> benutzerListe;

	/**
	 * Admin Konstruktor
	 * 
	 * @param context
	 *            super
	 */
	public Admin(WOContext context) {
		super(context);
		benutzerListe = new NSMutableArray<Benutzer>();
		/* Standard Admin Benutzer vorerfasst */
		benutzerListe.add(new Benutzer("admin", "admin"));

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
	 * Hier das zusammenbündeln von Benutzername und Passwort Anmledung vom
	 * Administrator prüft erst in der Apllikation Klasse ob diese Daten richtig
	 * sind
	 * 
	 * @return gibt einen angemeldeten benutzer aus der applikation zurück, wenn die
	 *         Eingaben stimmen
	 */
	public WOActionResults anmelden() {
		Iterator<Benutzer> it = benutzerListe.iterator();

		while (it.hasNext()) {
			Benutzer benutzer = it.next();

			if (benutzer.getBenutzername().equals(getBenutzername()) && benutzer.getPasswort().equals(getPasswort())) {
				AdminPage anmeldungErfolgreich = pageWithName(AdminPage.class);
				anmeldungErfolgreich.setAngemeldeterBenutzer(benutzer);

				return anmeldungErfolgreich;
			}
		}

		return null;
	}

	/**
	 * Zurück zur Main Seite von der Admin Seite aus
	 * 
	 * @return Main Seite
	 */
	public Main zurueck() {
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}

}