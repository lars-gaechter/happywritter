package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

import java.math.BigDecimal;
import java.math.RoundingMode;

import ch.lars.your.app.Benutzer;
import ch.lars.your.app.Session;
import ch.lars.your.app.components.Main;
import ch.lars.your.app.eomodel.*;


import com.webobjects.appserver.WOComponent;

public class AdminPage extends BaseComponent {
	private Benutzer angemeldeterBenutzer;
	private Session sitzung;
	private int anzahlKunden, anzahlBestellungen, anzahlInhalte, anzahlKonfiguration, anzahlBestellteKonf,
	anzahlBestellposition, anzahlArtikel;

	/**
	 * Bei erstellen eines Objektes wird eine neue Session gestartet.
	 * 
	 * @param context
	 */
	public AdminPage(WOContext context) {
		super(context);
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
		setAnzahlKonfiguration(Konfiguration.fetchAllKonfigurations(session().defaultEditingContext()).count());
		return Konfiguration.fetchAllKonfigurations(session().defaultEditingContext());
	}
	


	/**
	 * @return the kunden
	 */
	public NSArray<Kunde> kunde() {
		setAnzahlKunden(Kunde.fetchAllKundes(session().defaultEditingContext()).count());
		return Kunde.fetchAllKundes(session().defaultEditingContext());
	}





	/**
	 * @return the bestellung
	 */
	public NSArray<Bestellung> bestellung() {
		setAnzahlBestellungen(Bestellung.fetchAllBestellungs(session().defaultEditingContext()).count());
		return Bestellung.fetchAllBestellungs(session().defaultEditingContext());
	}





	/**
	 * @return the bestelltekonfiguration
	 */
	public NSArray<BestellteKonfiguration> bestelltekonfiguration() {
		setAnzahlBestellteKonf(BestellteKonfiguration.fetchAllBestellteKonfigurations(session().defaultEditingContext()).count());
		return BestellteKonfiguration.fetchAllBestellteKonfigurations(session().defaultEditingContext());
	}





	/**
	 * @return the bestellposition
	 */
	public NSArray<BestellPosition> bestellposition() {
		setAnzahlBestellposition(BestellPosition.fetchAllBestellPositions(session().defaultEditingContext()).count());
		return BestellPosition.fetchAllBestellPositions(session().defaultEditingContext());
	}


	/**



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
		
		if(preis == null) {
			session().setNameVonInhalt("");
			session().setPerisVonInhalt(null);
		} else {
			BigDecimal apreis = new BigDecimal(preis);
			session().setPerisVonInhalt(apreis);
		}
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
		if(nameInhalt == "") {
			session().setNameVonInhalt("");
		} else {
			session().setNameVonInhalt(nameInhalt);
		}
	}

	/**
	 * Erstellt einen neuen Inhalt in der Datenbank
	 */
	public void erstelleNeuerInhalt() {
		
		if(session().getNameVonInhalt()==null) {
			
		} else {
			if(session().getNameVonInhalt().length()>50 || session().getNameVonInhalt()=="") {
				
			} else {
				Inhalt anInahlt = new Inhalt();
				anInahlt.setName(session().getNameVonInhalt());
				anInahlt.setPreis(session().getPerisVonInhalt().setScale(4, RoundingMode.HALF_UP));
				session().defaultEditingContext().insertObject(anInahlt);
				session().defaultEditingContext().saveChanges();
			}
		}
		
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

	/**
	 * Stellt Beziehung bzw. Zuweisungen von Artikeln und Inhälten her und könne vom Administrator festgelegt werden.
	 * Der Inhalt diese Methode wurde wegen Abstürzen der Apllikation auskommentiert.
	 */
	public void erstelleBeziehungArtikelInhalt() {
		/*
		Konfiguration aKonfiguration = new Konfiguration();
		Integer artikel = session().getArtikelFuerBeziehung();
		Integer inhalt = session().getInhaltFuerBeziehung();
		aKonfiguration.setInhaltId(inhalt);
		aKonfiguration.setArtikelId(artikel);
		
		session().defaultEditingContext().insertObject(aKonfiguration);
		session().defaultEditingContext().saveChanges();
		*/
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