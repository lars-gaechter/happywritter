package ch.lars.your.app;

import java.util.Iterator;

import com.webobjects.foundation.NSMutableArray;
import ch.lars.your.app.components.AdminPage;
import ch.lars.your.app.components.Artikel;
import er.extensions.appserver.ERXApplication;

public class Application extends ERXApplication {
	private NSMutableArray<Benutzer> benutzerListe;
	private Artikel artikel;
	public static void main(String[] argv) {
		ERXApplication.main(argv, Application.class);
	}

	public Application() {
		ERXApplication.log.info("Welcome to " + name() + " !");
		/* ** put your initialization code in here ** */
		setAllowsConcurrentRequestHandling(true);	
		setSessionTimeOut(15 * 60);
		benutzerListe = new NSMutableArray<Benutzer>();
		/* Standard Admin Benutzer vorerfasst */
		benutzerListe.add(new Benutzer("admin", "klapp42stuhl"));
	}

	public AdminPage anmelden(String benutzername, String passwort) {
		Iterator<Benutzer> it = benutzerListe.iterator();

		while (it.hasNext()) {
			Benutzer benutzer = it.next();

			if (benutzer.getBenutzername().equals(benutzername) && benutzer.getPasswort().equals(passwort)) {
				AdminPage anmeldungErfolgreich = pageWithName(AdminPage.class);
				anmeldungErfolgreich.setAngemeldeterBenutzer(benutzer);

				return anmeldungErfolgreich;
			}
		}

		return null;
	}

	public Artikel getArtikel() {
		return artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}
	
	
	
}
