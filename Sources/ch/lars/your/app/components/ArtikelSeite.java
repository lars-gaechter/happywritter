package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;
import java.math.RoundingMode;
/**
 * Artikel Seite
 * @author Protoss
 *
 */
public class ArtikelSeite extends BaseComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3112592732690084973L;


	/**
	 * Artikel Seite Konstruktor
	 * @param context super
	 */
	public ArtikelSeite(WOContext context) {
		super(context);
	}
	

	/**
	 * Gibt den Name eines Artikels aus der Session zurück
	 * @return String Artikel Bezeichnung
	 */
	public String getArtikelName() {
		return session().getArtikelArtikelSeite().bezeichnung();
	}
	

	/**
	 * @return the artikelIcon
	 */
	public String artikelIcon() {
		return session().getArtikelIcon();
	}


	/**
	 * @return the preis
	 */
	public String getPreis() {
		return "Preis CHF"+session().getArtikelArtikelSeite().preis().setScale(2, RoundingMode.DOWN).toString();
	}


	/**
	 * Geht ohne jegendliche änderung zur Einstiegsseite zurück
	 * @return Seite Einstiegsseite
	 */
	public Einstiegsseite confirm() {
		Einstiegsseite nextPage = pageWithName(Einstiegsseite.class);
		return nextPage;
	}
	/**
	 * Löscht also speichert nicht Artikel in der Session von einem gleichen field in Session und geht zur Einstiegsseite zurück
	 * @return seite Einstiegsseite
	 */
	public Einstiegsseite nichtUebernehmen() {
		session().setArtikelArtikelSeite(null);
		session().setArtikelBezeichnung(null);
		Einstiegsseite nextPage = pageWithName(Einstiegsseite.class);
		return nextPage;
	}


	/**
	 * Terminiert die Session und geht zur Startseite zurück
	 * @return Seite Main
	 */
	public Main abbruch() {
		session().terminate();
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}


}