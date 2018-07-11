package ch.lars.your.app.components;


import com.webobjects.appserver.WOContext;

import ch.lars.your.app.eomodel.*;
import er.extensions.eof.ERXEOControlUtilities;
/**
 * KundenInfoSeite ist ein Formular, Kunde gibt seine Daten an und es wird validiert bevor es in der Session gespeichert wird
 * @author Protoss
 *
 */
public class KundenInfoSeite extends BaseComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = -129975512461412275L;
	/**
	 * Leerer String
	 */
	private String checkEmpty = "";
	/**
	 * Boolean standard false
	 */
	private Boolean aBoolean = false;
	/**
	 * Konstruktor KundenInfoSeite
	 * @param context super
	 */
	
	
	
	private Kunde kunde;

	private Bestellung bestellung;
	
	
	
	public KundenInfoSeite(WOContext context) {
		super(context);
		//session().setaKunde(ERXEOControlUtilities.createAndInsertObject(session().defaultEditingContext(), Kunde.class));
		kunde = ERXEOControlUtilities.createAndInsertObject(session().defaultEditingContext(), Kunde.class);
		bestellung =  ERXEOControlUtilities.createAndInsertObject(session().defaultEditingContext(), Bestellung.class);
		
		
    }
	/**
	 * Kompletter abbruch wärend der Kunde auf der KundenInfoSeite Seite ist
	 * terminiert die Session und schickt den Kunden tur Startseite
	 * @return Main Seite
	 */
	public Main abbrechen() {
		session().terminate();
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}
	/**
	 * Die tatsächliche Bestätigung vom Formular in der Session
	 * Kunde wir an BestaetigungsSeite Seite weitergeleitet
	 * @return BestaetigungsSeite Seite
	 */
	public BestaetigungsSeite confirmm() {
		BestaetigungsSeite nextPage = pageWithName(BestaetigungsSeite.class);
		nextPage.setKunde(kunde);
		nextPage.setBestellung(bestellung);
		return nextPage;
	}
	/**
	 * Bestätigung welche eine Validerung aufruft und dann erst die tatsächliche Bestätigung vom Formular in der Session
	 * @return bestätigung oder null
	 */
	public BestaetigungsSeite confirm() {
		if(kundeFormValidation()==false) {
			return confirmm();
		}
		 else {
			 return null;
		 }
	}
	/**
	 * Geht eine Seite zurück zur Einstiegsseite Seite
	 * @return Einstiegsseite Seite
	 */
	public Einstiegsseite zurueck() {
		Einstiegsseite nextPage = pageWithName(Einstiegsseite.class);
		return nextPage;
	}
	
	public void setVorname(String vornameNeuerKunde) {
		session().setVornameNeuerKunde(vornameNeuerKunde);
	}
	public String getVorname() {
		return session().getVornameNeuerKunde();
	}
	public void setNachname(String nachnameNeuerKunde) {
		session().setNachnameNeuerKunde(nachnameNeuerKunde);
		//session().setNachnameNeuerKunde(nachnameNeuerKunde);
	}
	public String getNachname() {
		return session().getNachnameNeuerKunde();
	}
	public void setStrasse(String strasseNeuerKunde) {
		session().setStrasseNeuerKunde(strasseNeuerKunde);
	}
	public String getStrasse() {
		return session().getStrasseNeuerKunde();
	}
	public void setOrt(String ortNeuerKunde) {
		session().setOrtNeuerKunde(ortNeuerKunde);
	}
	public String getOrt() {
		return session().getOrtNeuerKunde();
	}
	public void setPlz(String plzNeuerKunde) {
		session().setPlzNeuerKunde(plzNeuerKunde);
	}
	public String getPlz() {
		return session().getPlzNeuerKunde();
	}
	public void setTel(String telNeuerKunde) {
		session().setTelNeuerKunde(telNeuerKunde);
	}
	public String getTel() {
		return session().getTelNeuerKunde();
	}
	public void setBemerkungen(String bemerkungenNeuerBestellung) {
		session().setBemerkungenNeuerBestellung(bemerkungenNeuerBestellung);
	}
	public String getBemerkungen() {
		return session().getBemerkungenNeuerBestellung();
	}

	/**
	 * @return the kundeseit
	 */
	public String kundeseit() {
		return session().getKundeSeitNeuerKunde();
	}

	/**
	 * Datum, wann sich der Kunde registriert hat
	 * @param kundeSeitNeuerKunde kundeseit Datum vom Kunde
	 */
	public void setKundeseit(String kundeSeitNeuerKunde) {
		session().setKundeSeitNeuerKunde(kundeSeitNeuerKunde);
	}
	
	/**
	 * Validierung ob der benutzer nicht etwas leeres ausgefüllt hat oder etwas was zu lange ist um in der Datenbank zu speichern
	 * @return boolean ob das Formular valide ist
	 */
	public boolean kundeFormValidation() {
		if((session().getNachnameNeuerKunde() == null)) {
			setCheckEmpty("Nachname ist leer!");
			setaBoolean(true);
			return false;
		} else {
			if(session().getNachnameNeuerKunde().length()>50) {
				setCheckEmpty("Nachname ist zu lange!");
				setaBoolean(true);
				return false;
			}
		}
		if(session().getVornameNeuerKunde() == null) {
			setCheckEmpty("Vorname ist leer!");
			setaBoolean(true);
			return false;
		} else {
			if(session().getVornameNeuerKunde().length()>50) {
				setCheckEmpty("Vorname ist zu lange!");
				setaBoolean(true);
				return false;
			}
		}
		if(session().getStrasseNeuerKunde() == null) {
			setCheckEmpty("Strasse ist leer!");
			setaBoolean(true);
			return false;
		} else {
			if(session().getStrasseNeuerKunde().length()>50) {
				setCheckEmpty("Strasse ist zu lange!");
				setaBoolean(true);
				return false;
			}
		}
		if(session().getPlzNeuerKunde() == null) {
			setCheckEmpty("PLZ ist leer!");
			setaBoolean(true);
			return false;
		} else {
			if(session().getPlzNeuerKunde().length()>50) {
				setCheckEmpty("PLZ ist zu lange!");
				setaBoolean(true);
				return false;
			}
		}
		if(session().getOrtNeuerKunde() == null) {
			setCheckEmpty("Ort ist leer!");
			setaBoolean(true);
			return false;
		} else {
			if(session().getOrtNeuerKunde().length()>50) {
				setCheckEmpty("Ort ist zu lange!");
				setaBoolean(true);
				return false;
			}
		}
		if(session().getTelNeuerKunde() == null) {
			setCheckEmpty("Telefon ist leer!");
			setaBoolean(true);
			return false;
		} else {
			if(session().getTelNeuerKunde().length()>50) {
				setCheckEmpty("Telefon ist zu lange!");
				setaBoolean(true);
				return false;
			}
		}
		if(session().getBemerkungenNeuerBestellung() == null) {
			setCheckEmpty("Bemerkung ist leer!");
			setaBoolean(true);
			return false;
		} else {
			if(session().getBemerkungenNeuerBestellung().length()>50) {
				setCheckEmpty("Bemerkung ist zu lange!");
				setaBoolean(true);
				return false;
			} else {
				setCheckEmpty("");
				return true;
			}
		}
	}

	/**
	 * Prüfen ob checkEmpty leer ist
	 * @return the checkEmpty
	 */
	public String checkEmpty() {
		if(checkEmpty == "") {
			setaBoolean(true);
			return "";
		} else {
			return "Das Feld "+checkEmpty;
		}
	}

	/**
	 * @param checkEmpty the checkEmpty to set
	 */
	public void setCheckEmpty(String checkEmpty) {
		this.checkEmpty = checkEmpty;
	}

	/**
	 * Ein Boolean welcher ein Boolen zurückgibt
	 * @return the aBoolean
	 */
	public Boolean aBoolean() {
		return aBoolean;
	}

	/**
	 * Setzen eines Boolean
	 * @param aBoolean the aBoolean to set
	 */
	public void setaBoolean(Boolean aBoolean) {
		this.aBoolean = aBoolean;
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

	
	
	
	
	
}