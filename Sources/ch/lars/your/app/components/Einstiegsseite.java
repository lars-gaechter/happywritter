package ch.lars.your.app.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import ch.lars.your.app.components.Main;
import ch.lars.your.app.eomodel.Artikel;
import ch.lars.your.app.eomodel.*;

import java.math.BigDecimal;

import com.webobjects.appserver.WOActionResults;

/**
 * Einstiegsseite für den Online-Shop
 * 
 * @author Protoss
 *
 */
public class Einstiegsseite extends BaseComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7586605316447939334L;
	private BigDecimal total;

	/**
	 * Konstruktor Einstiegsseite
	 * 
	 * @param context
	 *            super
	 */
	public Einstiegsseite(WOContext context) {
		super(context);

	}

	/**
	 * Wenn der Kunde die Ware bezahlen möchte gibt es einen checkout welcher zum
	 * Kunden Formular fürt Auslöser vom aktiven Bild
	 * 
	 * @return KundenInfoSeite Seite
	 */
	public KundenInfoSeite checkout() {
		KundenInfoSeite nextPage = pageWithName(KundenInfoSeite.class);
		return nextPage;
	}

	/**
	 * Setzt Bild und Name vom Artikel Etui mit der Bezeichnung aus der Datebank
	 * verglichen wird Auslöser vom aktiven Bild
	 * 
	 * @return ArtikelSeite Seite
	 */
	public WOComponent getEtuiBestellen() {
		session().setArtikelJetzt(
				Artikel.fetchArtikel(session().defaultEditingContext(), Artikel.BEZEICHNUNG.eq("Etui")));
		session().setArtikelArtikelSeite(session().getArtikelJetzt());
		session().setArtikelBezeichnung("Etui");
		session().setArtikelIcon("img/Etui.jpg");
		return (getPageWithArticle("Etui"));
	}

	/**
	 * Setzt Bild und Name vom Artikel Schachtel mit der Bezeichnung aus der
	 * Datebank verglichen wird
	 * 
	 * @return ArtikelSeite Seite
	 */
	public WOComponent getSchachtelBestellen() {
		session().setArtikelJetzt(
				Artikel.fetchArtikel(session().defaultEditingContext(), Artikel.BEZEICHNUNG.eq("Schachtel")));
		session().setArtikelArtikelSeite(session().getArtikelJetzt());
		session().setArtikelBezeichnung("Schachtel");
		session().setArtikelIcon("img/Holzschachtel.jpg");
		return (getPageWithArticle("Schachtel"));
	}

	/**
	 * Prüft ob der Kunde sich für mindestens einen Artikel entschieden hat
	 * 
	 * Überprüfen ob die Liste aus allen ARtiken leer ist
	 * 
	 * @return boolean flase or true
	 */
	public Boolean istMinEinArtikelBestaetigt() {
		if (session().getArtikelBezeichnung() == null) {
			return false;
		} else {
			if ((session().getArtikelBezeichnung() == "Etui") || session().getArtikelBezeichnung() == "Schachtel") {
				return true;
			} else {
				return false;
			}
		}
		

	}

	/**
	 * Wenn der Kunde zur Startseite zurück gehen möchte
	 * 
	 * @return Main Seite
	 */
	public Main zurueck() {
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}

	/**
	 * 
	 * @param bezeichnung
	 *            wie die bezeichnung eines Artikel in der Datenbank heisst
	 * @return Artikel Seite welcher gleich dem String im param war
	 */
	private final WOComponent getPageWithArticle(String bezeichnung) {
		ArtikelSeite nextPage = pageWithName(ArtikelSeite.class);
		Artikel artikel = Artikel.fetchArtikel(session().defaultEditingContext(),
				Artikel.BEZEICHNUNG.like(bezeichnung));
		session().setArtikelJetzt(artikel);
		return nextPage;
	}

	/**
	 * Das total von allen BestellPositionen
	 * 
	 * @return das total
	 */
	public final String totalPreis() {
		total = new BigDecimal(0);
		for (BestellPosition bestellPosition : session().getArikelInhaltKombination()) {
			total = total.add(bestellPosition.artikel().preis());
			for (Inhalt inhaltVonArtikel : bestellPosition.inhalts()) {
				total = total.add(inhaltVonArtikel.preis());
			}
		}
		return total.toString();
	}

	public WOActionResults artikelLoeschen() {
		session().getArikelInhaltKombinationAnzahl().delete();
		session().setArtikelBezeichnung(null);
		session().getArikelInhaltKombination().remove(session().getArikelInhaltKombinationAnzahl());
		return null;
	}

	/**
	 * @return ist keine BestellPosition vorhanden
	 */
	public boolean gibtEsKeinArtikel() {
		return session().getArikelInhaltKombination().size() == 0;
	}

	public WOActionResults inhaltLoeschen() {
		// session().getAusgwaehlterInhaltAnzahl().delete();
		// session().getAusgwaehlterInhalteVonArtikel().remove(session().getAusgwaehlterInhaltAnzahl());
		return null;
	}

}