package ch.lars.your.app;

import ch.lars.your.app.eomodel.Artikel;
import ch.lars.your.app.eomodel.Bestellung;
import ch.lars.your.app.eomodel.Kunde;
import er.extensions.appserver.ERXSession;

public class Session extends ERXSession {
	private static final long serialVersionUID = 1L;
	private Artikel artikelArtikelSeite = null;
	/*
	private Kunde 	vornameNeuerKunde = null,
					nachnameNeuerKunde = null, 
					strasseNeuerKunde = null, 
					ortNeuerKunde = null, 
					plzNeuerKunde = null, 
					telNeuerKunde = null, 
					kundeSeitNeuerKunde = null;
					
	private Bestellung bemerkungenNeuerBestellung = null;
	*/
	private Kunde aKunde = null;
	private String 	vornameNeuerKunde = null,
			nachnameNeuerKunde = null, 
			strasseNeuerKunde = null, 
			ortNeuerKunde = null, 
			plzNeuerKunde = null, 
			telNeuerKunde = null, 
			kundeSeitNeuerKunde = null;
	private Bestellung aBestellung = null;
	private String bemerkungenNeuerBestellung = null;
	
	public Session() {
		super();

		setStoresIDsInCookies(true);
		setStoresIDsInURLs(false);
	}
	
	@Override
	public Application application() {
		return (Application)super.application();
	}
	
	@Override
	public void terminate() {
		System.out.println("Session terminating...");
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
	}

	public String getNachnameNeuerKunde() {
		return nachnameNeuerKunde;
	}

	public void setNachnameNeuerKunde(String nachnameNeuerKunde) {
		this.nachnameNeuerKunde = nachnameNeuerKunde;
	}

	public String getStrasseNeuerKunde() {
		return strasseNeuerKunde;
	}

	public void setStrasseNeuerKunde(String strasseNeuerKunde) {
		this.strasseNeuerKunde = strasseNeuerKunde;
	}

	public String getOrtNeuerKunde() {
		return ortNeuerKunde;
	}

	public void setOrtNeuerKunde(String ortNeuerKunde) {
		this.ortNeuerKunde = ortNeuerKunde;
	}

	public String getPlzNeuerKunde() {
		return plzNeuerKunde;
	}

	public void setPlzNeuerKunde(String plzNeuerKunde) {
		this.plzNeuerKunde = plzNeuerKunde;
	}

	public String getTelNeuerKunde() {
		return telNeuerKunde;
	}

	public void setTelNeuerKunde(String telNeuerKunde) {
		this.telNeuerKunde = telNeuerKunde;
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
	}

	public Kunde getaKunde() {
		return aKunde;
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
	
	
	
}
