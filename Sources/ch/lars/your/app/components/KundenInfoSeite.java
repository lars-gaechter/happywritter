package ch.lars.your.app.components;


import com.webobjects.appserver.WOContext;

public class KundenInfoSeite extends BaseComponent {
	public KundenInfoSeite(WOContext context) {
		super(context);
		
		
    }

	public Main abbrechen() {
		session().terminate();
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}

	public BestaetigungsSeite confirm() {
		BestaetigungsSeite nextPage = pageWithName(BestaetigungsSeite.class);
		return nextPage;
	}

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
	 * @param kundeseit the kundeseit to set
	 */
	public void setKundeseit(String kundeSeitNeuerKunde) {
		session().setKundeSeitNeuerKunde(kundeSeitNeuerKunde);
	}
	
	
	
}