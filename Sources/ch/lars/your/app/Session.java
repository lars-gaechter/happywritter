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
	private Integer artikelFuerBeziehung = null, inhaltFuerBeziehung = null;
	private Artikel artikelArtikelSeite = null;
	private String artikelBezeichnung = "";
	private String nameVonInhalt = "";
	private java.math.BigDecimal perisVonInhalt = null;
	private String ArtikelIcon = null;
	private Kunde aKunde;
	private String vornameNeuerKunde = null, nachnameNeuerKunde = null, strasseNeuerKunde = null, ortNeuerKunde = null,
			plzNeuerKunde = null, telNeuerKunde = null, kundeSeitNeuerKunde = null;
	private Bestellung aBestellung = null;
	private String bemerkungenNeuerBestellung = null;

	private Kunde kunde;
	private Bestellung bestellung;
	private BestellPosition ware = new BestellPosition();
	private NSMutableArray<BestellPosition> arikelInhaltKombination = new NSMutableArray<>();
	private NSMutableArray<Inhalt> inhalteVonArtikel;

	private NSMutableArray<Inhalt> ausgewaehlerInhalt;
	private Artikel artikelJetzt;
	private NSMutableArray<Artikel> artikel;
	private Inhalt inhaltAnzahl;
	private BestellPosition arikelInhaltKombinationAnzahl;
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

	public Kunde getaKunde() {
		return this.aKunde;
	}

	public void setaKunde(Kunde aKunde) {
		this.aKunde = aKunde;
	}

	public Bestellung getaBestellung() {
		return aBestellung;
	}

	public void setaBestellung(Bestellung aBestellung) {
		this.aBestellung = aBestellung;
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
