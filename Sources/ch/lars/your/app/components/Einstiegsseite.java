package ch.lars.your.app.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;

import ch.lars.your.app.components.Main;
import ch.lars.your.app.eomodel.Artikel;
import ch.lars.your.app.eomodel.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import com.webobjects.appserver.WOActionResults;


/**
 * Einstiegsseite für den Online-Shop
 * @author Protoss
 *
 */
public class Einstiegsseite extends BaseComponent {
	private BestellPosition arikelInhaltKombinationAnzahl;
	private Inhalt inhaltAnzahl;

	/**
	 * 
	 */
	private static final long serialVersionUID = -7586605316447939334L;
	private String totalPreis;
	private String isWarenkorbEmpty;
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
	public WOComponent getEtuiBestellen() {
		Artikel anArtikel= Artikel.fetchArtikel(session().defaultEditingContext(), Artikel.BEZEICHNUNG.eq("Etui"));
		session().setArtikelArtikelSeite(anArtikel);
		session().setArtikelBezeichnung("Etui");
		session().setArtikelIcon("img/Etui.jpg");
		return (getPageWithArticle("Etui"));
	}

	/**
	 * Setzt Bild und Name vom Artikel Schachtel mit der Bezeichnung aus der Datebank verglichen wird
	 * @return ArtikelSeite Seite
	 */
	public WOComponent getSchachtelBestellen() {
		Artikel anArtikel = Artikel.fetchArtikel(session().defaultEditingContext(), Artikel.BEZEICHNUNG.eq("Schachtel"));
		session().setArtikelArtikelSeite(anArtikel);
		session().setArtikelBezeichnung("Schachtel");
		session().setArtikelIcon("img/Holzschachtel.jpg");
		return (getPageWithArticle("Schachtel"));
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
	
	
	
	
	private final WOComponent getPageWithArticle(String bezeichnung) {
		ArtikelSeite page = pageWithName(ArtikelSeite.class);
		Artikel artikel = Artikel.fetchArtikel(session().defaultEditingContext(),
				Artikel.BEZEICHNUNG.like(bezeichnung));
		page.setArtikelJetzt(artikel);;
		return page;
	}
	/**
	 * @return the totalPreis
	 */
	public String totalPreis() {
		BigDecimal totalPreis = new BigDecimal(0);
		for (BestellPosition bestellPosition : session().getArikelInhaltKombination()) {
			totalPreis = totalPreis.add(bestellPosition.artikel().preis());
			for (Inhalt inhalt : bestellPosition.inhalts()) {
				totalPreis = totalPreis.add(inhalt.preis());
			}
		}
		return totalPreis.toString();
	}
	/**
	 * @param totalPreis the totalPreis to set
	 */
	public void setTotalPreis(String totalPreis) {
		this.totalPreis = totalPreis;
	}
	public BestellPosition getArikelInhaltKombinationAnzahl() {
		return arikelInhaltKombinationAnzahl;
	}
	public void setArikelInhaltKombinationAnzahl(BestellPosition arikelInhaltKombinationAnzahl) {
		this.arikelInhaltKombinationAnzahl = arikelInhaltKombinationAnzahl;
	}
	public Inhalt getInhaltAnzahl() {
		return inhaltAnzahl;
	}
	public void setInhaltAnzahl(Inhalt inhaltAnzahl) {
		this.inhaltAnzahl = inhaltAnzahl;
	}
	public WOActionResults artikelLoeschen() {
		NSMutableArray<BestellPosition> arikelInhaltKombination = session().getArikelInhaltKombination();
		arikelInhaltKombinationAnzahl.delete();
		arikelInhaltKombination.remove(arikelInhaltKombinationAnzahl);
		return null;
	}
	/**
	 * @return ist keine BestellPosition vorhanden
	 */
	public boolean gibtEsKeinArtikel() {
		return session().getArikelInhaltKombination().size() == 0;
	}
	public WOActionResults inhaltLoeschen() {
		//NSMutableArray<Inhalt> inhalteVonArtikel = session().getInhalteVonArtikel();
		//inhaltAnzahl.delete();
		//inhalteVonArtikel.remove(inhaltAnzahl);
		return null;
	}
	public String getIsWarenkorbEmpty() {
		return isWarenkorbEmpty;
	}
	public void setIsWarenkorbEmpty(String isWarenkorbEmpty) {
		this.isWarenkorbEmpty = isWarenkorbEmpty;
	}
	public String getTotalPreis() {
		return totalPreis;
	}
	
	
	
	
	

}