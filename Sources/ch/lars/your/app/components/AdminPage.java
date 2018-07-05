package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

import ch.lars.your.app.Application;
import ch.lars.your.app.Benutzer;
import ch.lars.your.app.Session;
import ch.lars.your.app.components.Main;
import ch.lars.your.app.eomodel.*;

import com.webobjects.appserver.WOComponent;

public class AdminPage extends BaseComponent {
	private Benutzer angemeldeterBenutzer;
	private Session sitzung;
	private Application application;
	private String kunden;
	private String bestellung;
	private String bestelltekonfiguration;
	private String bestellposition;

	/**
	 * Bei erstellen eines Objektes wird eine neue Session gestartet.
	 * 
	 * @param context
	 */
	public AdminPage(WOContext context) {
		super(context);

		sitzung = (Session) session();
		application = (Application) Application.application();
	}


	public void setAngemeldeterBenutzer(Benutzer benutzer) {
		angemeldeterBenutzer = benutzer;
	}

	/**
	 * Überprüft ob der Benutzer angemeldet ist.
	 * 
	 * @return war oder falsch
	 */
	public boolean angemeldet() {
		if (angemeldeterBenutzer != null) {
			return true;
		}

		return false;
	}

	public Benutzer angemeldeterBenutzer() {
		return angemeldeterBenutzer;
	}

	public String vollerName() {
		return angemeldeterBenutzer.getBenutzername();
	}

	/**
	 * Session wird ganz beendet
	 * 
	 * @return
	 */
	public Main abmelden() {
		angemeldeterBenutzer = null;
		sitzung.terminate();
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}


	/**
	 * Funktion müsste überpfüfen ob es ein identischgleiches benutzer objekt ist der Liste gibt
	 * Wenn ja, wird Benutzer nicht aktualisiert
	 * Wenn nein, wird die Änderungsaktion ausgeführt
	 * 
	 * @return ladet die Seite neu
	 */
	public WOComponent aktualisiereBenutzer() {
		return this.context().page();
		
	}
	
	/**
	 * fetch all artikel records from table artikel and returns in NSArray
	 * @return
	 */
	public NSArray<ch.lars.your.app.eomodel.Artikel> artikel() {
		return ch.lars.your.app.eomodel.Artikel.fetchAllArtikels(session().defaultEditingContext());
	}
	
	/**
	 * fetch all Inhalt records from table Inhalt and returns in NSArray
	 * @return
	 */
	public NSArray<ch.lars.your.app.eomodel.Inhalt> inhalt() {
		return ch.lars.your.app.eomodel.Inhalt.fetchAllInhalts(session().defaultEditingContext());
	}
	/**
	 * 
	 * @return
	 */
	public NSArray<ch.lars.your.app.eoerd.Konfiguration> konfiguration() {
		return ch.lars.your.app.eoerd.Konfiguration.fetchAllKonfigurations(session().defaultEditingContext());
	}


	/**
	 * @return the kunden
	 */
	public NSArray<Kunde> kunde() {
		return Kunde.fetchAllKundes(session().defaultEditingContext());
	}


	/**
	 * @param kunden the kunden to set
	 */
	public void setKunden(String kunden) {
		this.kunden = kunden;
	}


	/**
	 * @return the bestellung
	 */
	public NSArray<Bestellung> bestellung() {
		return Bestellung.fetchAllBestellungs(session().defaultEditingContext());
	}


	/**
	 * @param bestellung the bestellung to set
	 */
	public void setBestellung(String bestellung) {
		this.bestellung = bestellung;
	}


	/**
	 * @return the bestelltekonfiguration
	 */
	public NSArray<ch.lars.your.app.eoerd.Bestelltekonfiguration> bestelltekonfiguration() {
		return ch.lars.your.app.eoerd.Bestelltekonfiguration.fetchAllBestelltekonfigurations(session().defaultEditingContext());
	}


	/**
	 * @param bestelltekonfiguration the bestelltekonfiguration to set
	 */
	public void setBestelltekonfiguration(String bestelltekonfiguration) {
		this.bestelltekonfiguration = bestelltekonfiguration;
	}


	/**
	 * @return the bestellposition
	 */
	public NSArray<BestellPosition> bestellposition() {
		return BestellPosition.fetchAllBestellPositions(session().defaultEditingContext());
	}


	/**
	 * @param bestellposition the bestellposition to set
	 */
	public void setBestellposition(String bestellposition) {
		this.bestellposition = bestellposition;
	}
	

}