package ch.lars.your.app.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.eof.ERXEOControlUtilities;
import ch.lars.your.app.eomodel.*;

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
	
	
	private Artikel artikelJetzt;
	private Inhalt inhaltAnzahl;
	private NSMutableArray<Inhalt> ausgewaehlerInhalt;


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
	public Einstiegsseite confirmm() {
		Einstiegsseite nextPage = pageWithName(Einstiegsseite.class);
		return nextPage;
	}
	public final WOComponent confirm() {
		BestellPosition ware = ERXEOControlUtilities.createAndInsertObject(session().defaultEditingContext(),
				BestellPosition.class);
		
		ware.setArtikel(artikelJetzt);
		//lambda
		
		ausgewaehlerInhalt.forEach(i -> ware.addToInhalts(i));
		
		session().getArikelInhaltKombination().add(ware);
		
		return pageWithName(Einstiegsseite.class);
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


	public Artikel getArtikelJetzt() {
		return artikelJetzt;
	}


	public void setArtikelJetzt(Artikel artikelJetzt) {
		this.artikelJetzt = artikelJetzt;
	}


	public Inhalt getInhaltAnzahl() {
		return inhaltAnzahl;
	}


	public void setInhaltAnzahl(Inhalt inhaltAnzahl) {
		this.inhaltAnzahl = inhaltAnzahl;
	}


	public NSMutableArray<Inhalt> getAusgewaehlerInhalt() {
		return ausgewaehlerInhalt;
	}


	public void setAusgewaehlerInhalt(NSMutableArray<Inhalt> ausgewaehlerInhalt) {
		this.ausgewaehlerInhalt = ausgewaehlerInhalt;
	}
	
	

	

}