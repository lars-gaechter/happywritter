package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;
import ch.lars.your.app.components.Main;
import ch.lars.your.app.eomodel.Artikel;
import java.math.RoundingMode;


/**
 * Einstiegsseite für den Online-Shop
 * @author Protoss
 *
 */
public class Einstiegsseite extends BaseComponent {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7586605316447939334L;
	/**
	 * Konstruktor Einstiegsseite
	 * @param context super
	 */
    public Einstiegsseite(WOContext context) {
        super(context);
        
    }
    /**
     * Wenn der Kunde die Ware bezahlen möchte gibt es einen checkout welcher zum Kunden Formular fürt
     * Auslöser vom aktiven Bild
     * @return KundenInfoSeite Seite
     */
	public KundenInfoSeite checkout() {
		KundenInfoSeite nextPage = pageWithName(KundenInfoSeite.class);
		return nextPage;
	}

	/**
	 * Setzt Bild und Name vom Artikel Etui mit der Bezeichnung aus der Datebank verglichen wird
	 * Auslöser vom aktiven Bild
	 * @return ArtikelSeite Seite
	 */
	public ArtikelSeite getEtuiBestellen() {
		ArtikelSeite nextPage = pageWithName(ArtikelSeite.class);
		Artikel anArtikel= Artikel.fetchArtikel(session().defaultEditingContext(), Artikel.BEZEICHNUNG.eq("Etui"));
		session().setArtikelArtikelSeite(anArtikel);
		session().setArtikelBezeichnung("Etui");
		session().setArtikelIcon("img/Etui.jpg");
		return nextPage;
	}

	/**
	 * Setzt Bild und Name vom Artikel Schachtel mit der Bezeichnung aus der Datebank verglichen wird
	 * @return ArtikelSeite Seite
	 */
	public ArtikelSeite getSchachtelBestellen() {
		ArtikelSeite nextPage = pageWithName(ArtikelSeite.class);
		Artikel anArtikel = Artikel.fetchArtikel(session().defaultEditingContext(), Artikel.BEZEICHNUNG.eq("Schachtel"));
		session().setArtikelArtikelSeite(anArtikel);
		session().setArtikelBezeichnung("Schachtel");
		session().setArtikelIcon("img/Holzschachtel.jpg");
		return nextPage;
	}
	/**
	 * Prüft ob der Kunde sich für einen Artikel entschieden hat
	 * @return boolean flase or true
	 */
	public Boolean istMinEinArtikelBestaetigt() {
		if(session().getArtikelBezeichnung() == null) {
			return false;
		} else {
			if((session().getArtikelBezeichnung() == "Etui") || session().getArtikelBezeichnung() == "Schachtel") {
			return true;
		} else {
			return false;
		}
	}

	}

	/**
	 * @return the bestellung
	 */
	public String bestelltePositionArtikel() {
		
		if(session().getArtikelBezeichnung() == null) {
			return "";
		} else {
			if((session().getArtikelBezeichnung() == "Etui") || session().getArtikelBezeichnung() == "Schachtel") {
				return session().getArtikelBezeichnung();
		} else {
			return "";
		}
		}
	}

	/**
	 * @return the bestelltePositionPreis
	 */
	public String bestelltePositionPreis() {
		if(session().getArtikelBezeichnung() == null) {
			return "";
		} else {
			if((session().getArtikelBezeichnung() == "Etui") || session().getArtikelBezeichnung() == "Schachtel") {
				return "CHF "+session().getArtikelArtikelSeite().preis().setScale(2, RoundingMode.DOWN).toString();
		} else {
			return "";
		}
		}
	}
	/**
	 * Wenn der Kunde zur Startseite zurück gehen möchte
	 * @return Main Seite
	 */
	public Main zurueck() {
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}

}