package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

import java.math.BigDecimal;

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
	private String bestellung;
	private String bestelltekonfiguration;
	private String bestellposition;
	private String kunden;
	private int anzahlKunden, anzahlBestellungen, anzahlInhalte, anzahlKonfiguration, anzahlBestellteKonf,
	anzahlBestellposition, anzahlArtikel;

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
	public NSArray<Artikel> artikel() {
		setAnzahlArtikel(Artikel.fetchAllArtikels(session().defaultEditingContext()).count());
		return Artikel.fetchAllArtikels(session().defaultEditingContext());
	}
	
	/**
	 * fetch all Inhalt records from table Inhalt and returns in NSArray
	 * @return
	 */
	public NSArray<Inhalt> inhalt() {
		setAnzahlInhalte(Inhalt.fetchAllInhalts(session().defaultEditingContext()).count());
		return Inhalt.fetchAllInhalts(session().defaultEditingContext());
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
		setAnzahlKonfiguration(Konfiguration.fetchAllKonfigurations(session().defaultEditingContext()).count());
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
		setAnzahlKunden(Kunde.fetchAllKundes(session().defaultEditingContext()).count());
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
		setAnzahlBestellungen(Bestellung.fetchAllBestellungs(session().defaultEditingContext()).count());
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
	public NSArray<BestellteKonfiguration> bestelltekonfiguration() {
		setAnzahlBestellteKonf(BestellteKonfiguration.fetchAllBestellteKonfigurations(session().defaultEditingContext()).count());
		return BestellteKonfiguration.fetchAllBestellteKonfigurations(session().defaultEditingContext());
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
		setAnzahlBestellposition(BestellPosition.fetchAllBestellPositions(session().defaultEditingContext()).count());
		return BestellPosition.fetchAllBestellPositions(session().defaultEditingContext());
	}


	/**
	 * @param bestellposition the bestellposition to set
	 */
	public void setBestellposition(String bestellposition) {
		this.bestellposition = bestellposition;
	}


	/**
	 * @return the preis
	 */
	public String preisInhalt() {
		if(session().getPerisVonInhalt() != null) {
			return session().getPerisVonInhalt().toString();
		} else {
			return "";
		}
	}


	/**
	 * @param preis the preis to set
	 */
	public void setPreisInhalt(String preis) {
		BigDecimal apreis = new BigDecimal(preis);
		session().setPerisVonInhalt(apreis);
	}


	/**
	 * @return the nameInhalt
	 */
	public String nameInhalt() {
		return session().getNameVonInhalt();
	}


	/**
	 * @param nameInhalt the nameInhalt to set
	 */
	public void setNameInhalt(String nameInhalt) {
		session().setNameVonInhalt(nameInhalt);
	}

	/**
	 * Erstellt einen neuen Inhalt in der Datenbank
	 */
	public void erstelleNeuerInhalt() {
		
		Inhalt anInahlt = new Inhalt();
		anInahlt.setName(session().getNameVonInhalt());
		anInahlt.setPreis(session().getPerisVonInhalt());
		session().defaultEditingContext().insertObject(anInahlt);
		session().defaultEditingContext().saveChanges();
		
	}


	/**
	 * @return the artikelFuerBeziehung
	 */
	public String artikelFuerBeziehung() {
		if(session().getArtikelFuerBeziehung() != null) {
			return session().getArtikelFuerBeziehung().toString();
		} else {
			return "";
		}
	}


	/**
	 * @param artikelFuerBeziehung the artikelFuerBeziehung to set
	 */
	public void setArtikelFuerBeziehung(String artikelFuerBeziehung) {
		Integer anArtikelFuerBeziehung = new Integer(artikelFuerBeziehung);
		session().setArtikelFuerBeziehung(anArtikelFuerBeziehung);
	}


	/**
	 * @return the inhaltFuerBeziehung
	 */
	public String inhaltFuerBeziehung() {
		if(session().getInhaltFuerBeziehung() != null) {
			return session().getInhaltFuerBeziehung().toString();
		} else {
			return "";
		}
	}


	/**
	 * @param inhaltFuerBeziehung the inhaltFuerBeziehung to set
	 */
	public void setInhaltFuerBeziehung(String inhaltFuerBeziehung) {
		Integer anInhaltFuerBeziehung = new Integer(inhaltFuerBeziehung);
		session().setArtikelFuerBeziehung(anInhaltFuerBeziehung);
	}


	public void erstelleBeziehungArtikelInhalt() {
		Inhalt anInahlt = new Inhalt();
		Artikel anArtikel = new Artikel();
		Konfiguration aKonfiguration = new Konfiguration();
		//anInahlt.setId(session().getInhaltFuerBeziehung());
		//anArtikel.setId(session().getArtikelFuerBeziehung());
		//session().defaultEditingContext().insertObject(anInahlt);
		//session().defaultEditingContext().insertObject(anArtikel);
		//aKonfiguration.addObjectToBothSidesOfRelationshipWithKey(anArtikel, Konfiguration.ARTIKEL_ID_KEY);
		//aKonfiguration.addObjectToBothSidesOfRelationshipWithKey(anInahlt, Konfiguration.INHALT_ID_KEY);
		//aKonfiguration.setInhaltId(session().getInhaltFuerBeziehung());
		//Integer inhalt = new Integer(session().getInhaltFuerBeziehung());
		//aKonfiguration.setInhaltId(inhalt);
		//Integer artikel = new Integer(session().getArtikelFuerBeziehung());
		//aKonfiguration.setArtikelId(artikel);
		//aKonfiguration.setInhaltId(1);
		//aKonfiguration.setArtikelId(1);
		//aKonfiguration.setArtikelId(session().getArtikelFuerBeziehung());
		Integer artikel = session().getArtikelFuerBeziehung();
		Integer inhalt = session().getInhaltFuerBeziehung();
		aKonfiguration.setInhaltId(inhalt);
		aKonfiguration.setArtikelId(artikel);
		
		session().defaultEditingContext().insertObject(aKonfiguration);
		session().defaultEditingContext().saveChanges();
	}



	public int getAnzahlKunden() {
		return anzahlKunden;
	}


	public void setAnzahlKunden(int anzahlKunden) {
		this.anzahlKunden = anzahlKunden;
	}


	public int getAnzahlBestellungen() {
		return anzahlBestellungen;
	}


	public void setAnzahlBestellungen(int anzahlBestellungen) {
		this.anzahlBestellungen = anzahlBestellungen;
	}


	public int getAnzahlInhalte() {
		return anzahlInhalte;
	}


	public void setAnzahlInhalte(int anzahlInhalte) {
		this.anzahlInhalte = anzahlInhalte;
	}


	public int getAnzahlKonfiguration() {
		return anzahlKonfiguration;
	}


	public void setAnzahlKonfiguration(int anzahlKonfiguration) {
		this.anzahlKonfiguration = anzahlKonfiguration;
	}


	public int getAnzahlBestellteKonf() {
			return anzahlBestellteKonf;
	}


	public void setAnzahlBestellteKonf(int anzahlBestellteKonf) {
		this.anzahlBestellteKonf = anzahlBestellteKonf;
	}


	public int getAnzahlBestellposition() {
		return anzahlBestellposition;
	}


	public void setAnzahlBestellposition(int anzahlBestellposition) {
		this.anzahlBestellposition = anzahlBestellposition;
	}


	public int getAnzahlArtikel() {
		return anzahlArtikel;
	}


	public void setAnzahlArtikel(int anzahlArtikel) {
		this.anzahlArtikel = anzahlArtikel;
	}
	
	
	
	

}