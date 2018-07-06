package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;

import ch.lars.your.app.Application;
import ch.lars.your.app.Benutzer;
import ch.lars.your.app.Session;
import ch.lars.your.app.components.Main;
import ch.lars.your.app.eomodel.*;
import ch.lars.your.app.eomodel.Inhalt;
import er.extensions.eof.ERXFetchSpecification;
import er.extensions.eof.ERXKey;
import er.extensions.foundation.ERXArrayUtilities.FetchSpecOperator;

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
	public NSArray<Konfiguration> konfiguration() {
		//ch.lars.your.app.eomodel.Artikel.
		/*
		ch.lars.your.app.eomodel.Artikel z = new ch.lars.your.app.eomodel.Artikel();
		ERXKey<ch.lars.your.app.eomodel.Inhalt> test = new ERXKey<ch.lars.your.app.eomodel.Inhalt>("1");
		EOQualifier qualifier = ch.lars.your.app.eomodel.Artikel.INHALTS.eq(test);
		System.out.println("estestestest");
		System.out.println(test);
		System.out.println("estestestest");
		System.out.println(z.inhalts(qualifier));
		System.out.println("estestestest");
		*/
		//System.out.println(z.fetchArtikel(session().defaultEditingContext(), Inhalt.ID_KEY));
		//System.out.println(Konfiguration.id());
		//return z.inhalts(qualifier);
		return Konfiguration.fetchAllKonfigurations(session().defaultEditingContext());
	}
	
	public void testArtikelKonfiguration(){
		/*
		EOQualifier qualifier = ch.lars.your.app.eomodel.Konfiguration.ARTIKEL_ID.eq(Konfiguration.ARTIKEL_ID);
		ERXFetchSpecification<Konfiguration> fetSpc = new ERXFetchSpecification<Konfiguration>(Konfiguration.ENTITY_NAME);
		ERXFetchSpecification<ch.lars.your.app.eomodel.Artikel> fetSpcA = new ERXFetchSpecification<ch.lars.your.app.eomodel.Artikel>(ch.lars.your.app.eomodel.Artikel.ENTITY_NAME);
		ERXFetchSpecification<Inhalt> fetSpcI = new ERXFetchSpecification<Inhalt>(Inhalt.ENTITY_NAME);
		session().defaultEditingContext().objectsWithFetchSpecification(fetSpc);
		session().defaultEditingContext().objectsWithFetchSpecification(fetSpcA);
		session().defaultEditingContext().objectsWithFetchSpecification(fetSpcI);
		Konfiguration.fetchSpec();
		//Konfiguration.fetch
		System.out.println("tatataatata");
		System.out.println("tatataatata"+Konfiguration.fetchKonfiguration(session().defaultEditingContext(), qualifier).toLongString()+"tatataatata");
		//return Konfiguration.objectsWithFetchSpecification(Konfiguration.fetchArtikelByNameandInhaltByName(session().defaultEditingContext(), 1));
		EOQualifier quali = ch.lars.your.app.eomodel.Konfiguration.ARTIKEL_ID.eq(ch.lars.your.app.eomodel.Artikel.ID);
		*/
		
		//EOQualifier qualifier = ch.lars.your.app.eomodel.Artikel.ID.eq(3);
		//ERXFetchSpecification<ch.lars.your.app.eomodel.Artikel> fs = new ERXFetchSpecification<ch.lars.your.app.eomodel.Artikel>(ch.lars.your.app.eomodel.Artikel.ENTITY_NAME, qualifier, null);
		//return Konfiguration.fetchArtikelByNameandInhaltByName(session().defaultEditingContext());
		//return session().defaultEditingContext().objectsWithFetchSpecification(fs);
		//EOQualifier qualifier = ch.lars.your.app.eomodel.Inhalt.ID.eq(ch.lars.your.app.eomodel.Artikel.ID);
		//ERXFetchSpecification<ch.lars.your.app.eomodel.Inhalt> fs = new ERXFetchSpecification<ch.lars.your.app.eomodel.Inhalt>(ch.lars.your.app.eomodel.Artikel.ENTITY_NAME, qualifier, null);
		//return session().defaultEditingContext().objectsWithFetchSpecification(fs);
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
	//public NSArray<ch.lars.your.app.eoerd.Bestelltekonfiguration> bestelltekonfiguration() {
		//return ch.lars.your.app.eoerd.Bestelltekonfiguration.fetchAllBestelltekonfigurations(session().defaultEditingContext());
	//}


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