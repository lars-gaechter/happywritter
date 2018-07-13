package ch.lars.your.app;

import com.webobjects.foundation.NSMutableArray;
import er.extensions.appserver.ERXSession;
import ch.lars.your.app.eomodel.*;

/**
 * Session welche den Kunden, Bestellung, Bestellposition und Artikel speichert
 * 
 * @author Protoss
 *
 */
public class Session extends ERXSession {

	/**
	 * 
	 */
	private static final long serialVersionUID = 885803331277758615L;
	//Admin Artikel und Beziehung zu den Inhalten
	private Integer artikelFuerBeziehung = null, inhaltFuerBeziehung = null;
	private Artikel artikelArtikelSeite = null;
	
	//Name vom Artikel
	private String artikelBezeichnung = "";
	//Name vom Inhalt
	private String nameVonInhalt = "";
	//Preis von einem Inhalt
	private java.math.BigDecimal perisVonInhalt = null;
	//Das Bild vom Artikel
	private String ArtikelIcon = null;
	//Eingaben im Kunde Formular als Strings für Kundeinformationen
	private String vornameNeuerKunde = null, nachnameNeuerKunde = null, strasseNeuerKunde = null, ortNeuerKunde = null,
			plzNeuerKunde = null, telNeuerKunde = null, kundeSeitNeuerKunde = null;
	//Eingaben im Kunde Formular als Strings für Bestellunginformation
	private String bemerkungenNeuerBestellung = null;
	
	//Ein Kunde pro Bestellung
	private Kunde kunde;
	//Eine Bestellung pro Kunde
	private Bestellung bestellung;
	//Eine BestellPosition
	private BestellPosition ware = new BestellPosition();
	//BestellPosition von einer Bestellung des Kunden
	private NSMutableArray<BestellPosition> arikelInhaltKombination = new NSMutableArray<>();
	//Ein Liste aller Inhalte aus der Administrator Konfiguration
	private NSMutableArray<Inhalt> inhalteVonArtikel;
	//Ein Liste aller Inhalte aus der bestellten Konfiguration welche der Kunde ausgewählt hat
	private NSMutableArray<Inhalt> ausgewaehlerInhalt;
	//Während der Detailansicht eines Artikels
	private Artikel artikelJetzt;
	//Ein Liste aller Artikeln welche der Kunde möchte
	private NSMutableArray<Artikel> artikel;
	//Anzal von Inhalten der Liste für die Iteration
	private Inhalt inhaltAnzahl;
	//Anzal von Bestell Positionen der Liste für die Iteration
	private BestellPosition arikelInhaltKombinationAnzahl;
	//Wenn ein Inhlat Objekt einzeln benötigt wird
	private Inhalt inhalt;

	/**
	 * Benutzt Cookies für Session und zeigt die Session ID nicht im URL an
	 */
	public Session() {
		super();

		setStoresIDsInCookies(true);
		setStoresIDsInURLs(false);

	}

	@Override
	public Application application() {
		return (Application) super.application();
	}

	@Override
	public void terminate() {
		super.terminate();
	}

	public Artikel getArtikelArtikelSeite() {
		return artikelArtikelSeite;
	}

	public void setArtikelArtikelSeite(Artikel artikelArtikelSeite) {
		this.artikelArtikelSeite = artikelArtikelSeite;
	}

	public String getVornameNeuerKunde() {
		return vornameNeuerKunde;

	}

	public void setVornameNeuerKunde(String vornameNeuerKunde) {
		this.vornameNeuerKunde = vornameNeuerKunde;
		kunde.setVorname(vornameNeuerKunde);
	}

	public String getNachnameNeuerKunde() {
		return nachnameNeuerKunde;
	}

	public void setNachnameNeuerKunde(String nachnameNeuerKunde) {
		this.nachnameNeuerKunde = nachnameNeuerKunde;
		kunde.setNachname(nachnameNeuerKunde);
	}

	public String getStrasseNeuerKunde() {
		return strasseNeuerKunde;
	}

	public void setStrasseNeuerKunde(String strasseNeuerKunde) {
		this.strasseNeuerKunde = strasseNeuerKunde;
		kunde.setStrasse(strasseNeuerKunde);
	}

	public String getOrtNeuerKunde() {
		return ortNeuerKunde;
	}

	public void setOrtNeuerKunde(String ortNeuerKunde) {
		this.ortNeuerKunde = ortNeuerKunde;
		kunde.setOrt(ortNeuerKunde);
	}

	public String getPlzNeuerKunde() {
		return plzNeuerKunde;
	}

	public void setPlzNeuerKunde(String plzNeuerKunde) {
		this.plzNeuerKunde = plzNeuerKunde;
		kunde.setPlz(plzNeuerKunde);
	}

	public String getTelNeuerKunde() {
		return telNeuerKunde;
	}

	public void setTelNeuerKunde(String telNeuerKunde) {
		this.telNeuerKunde = telNeuerKunde;
		kunde.setTel(telNeuerKunde);
	}

	public String getKundeSeitNeuerKunde() {
		return kundeSeitNeuerKunde;
	}

	public void setKundeSeitNeuerKunde(String kundeSeitNeuerKunde) {
		this.kundeSeitNeuerKunde = kundeSeitNeuerKunde;
	}

	public String getBemerkungenNeuerBestellung() {
		return bemerkungenNeuerBestellung;
	}

	public void setBemerkungenNeuerBestellung(String bemerkungenNeuerBestellung) {
		this.bemerkungenNeuerBestellung = bemerkungenNeuerBestellung;
		bestellung.setBemerkungen(bemerkungenNeuerBestellung);
	}

	public String getArtikelBezeichnung() {
		return artikelBezeichnung;
	}

	public void setArtikelBezeichnung(String artikelBezeichnung) {
		this.artikelBezeichnung = artikelBezeichnung;
	}

	public String getNameVonInhalt() {
		return nameVonInhalt;
	}

	public void setNameVonInhalt(String nameVonInhalt) {
		this.nameVonInhalt = nameVonInhalt;
	}

	public java.math.BigDecimal getPerisVonInhalt() {
		return perisVonInhalt;
	}

	public void setPerisVonInhalt(java.math.BigDecimal perisVonInhalt) {
		this.perisVonInhalt = perisVonInhalt;
	}

	public Integer getArtikelFuerBeziehung() {
		return artikelFuerBeziehung;
	}

	public void setArtikelFuerBeziehung(Integer artikelFuerBeziehung) {
		this.artikelFuerBeziehung = artikelFuerBeziehung;
	}

	public Integer getInhaltFuerBeziehung() {
		return inhaltFuerBeziehung;
	}

	public void setInhaltFuerBeziehung(Integer inhaltFuerBeziehung) {
		this.inhaltFuerBeziehung = inhaltFuerBeziehung;
	}

	public void addArtikelZuBestellung() {

	}

	public String getArtikelIcon() {
		return ArtikelIcon;
	}

	public void setArtikelIcon(String artikelIcon) {
		ArtikelIcon = artikelIcon;
	}

	public NSMutableArray<BestellPosition> getArikelInhaltKombination() {
		return arikelInhaltKombination;
	}

	public void setArikelInhaltKombination(NSMutableArray<BestellPosition> arikelInhaltKombination) {
		this.arikelInhaltKombination = arikelInhaltKombination;
	}

	public NSMutableArray<Inhalt> getInhalteVonArtikel() {
		return inhalteVonArtikel;
	}

	public void setInhalteVonArtikel(NSMutableArray<Inhalt> inhalteVonArtikel) {
		this.inhalteVonArtikel = inhalteVonArtikel;
	}

	public NSMutableArray<Artikel> getArtikel() {
		return artikel;
	}

	public void setArtikel(NSMutableArray<Artikel> artikel) {
		this.artikel = artikel;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public Bestellung getBestellung() {
		return bestellung;
	}

	public void setBestellung(Bestellung bestellung) {
		this.bestellung = bestellung;
	}

	public Artikel getArtikelJetzt() {
		return artikelJetzt;
	}

	public void setArtikelJetzt(Artikel artikelJetzt) {
		this.artikelJetzt = artikelJetzt;
	}

	public BestellPosition getWare() {
		return ware;
	}

	public void setWare(BestellPosition ware) {
		this.ware = ware;
	}

	public NSMutableArray<Inhalt> getAusgewaehlerInhalt() {
		return ausgewaehlerInhalt;
	}

	public void setAusgewaehlerInhalt(NSMutableArray<Inhalt> ausgewaehlerInhalt) {
		this.ausgewaehlerInhalt = ausgewaehlerInhalt;
	}

	public Inhalt getInhaltAnzahl() {
		return inhaltAnzahl;
	}

	public void setInhaltAnzahl(Inhalt inhaltAnzahl) {
		this.inhaltAnzahl = inhaltAnzahl;
	}

	public BestellPosition getArikelInhaltKombinationAnzahl() {
		return arikelInhaltKombinationAnzahl;
	}

	public void setArikelInhaltKombinationAnzahl(BestellPosition arikelInhaltKombinationAnzahl) {
		this.arikelInhaltKombinationAnzahl = arikelInhaltKombinationAnzahl;
	}

	public Inhalt getInhalt() {
		return inhalt;
	}

	public void setInhalt(Inhalt inhalt) {
		this.inhalt = inhalt;
	}

}
