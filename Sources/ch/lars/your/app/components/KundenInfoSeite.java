package ch.lars.your.app.components;


import com.webobjects.appserver.WOContext;

public class KundenInfoSeite extends BaseComponent {
	private String checkEmpty = "";
	private Boolean aBoolean = false;

	public KundenInfoSeite(WOContext context) {
		super(context);
		
		
    }

	public Main abbrechen() {
		session().terminate();
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}

	public BestaetigungsSeite confirmm() {
		BestaetigungsSeite nextPage = pageWithName(BestaetigungsSeite.class);
		return nextPage;
	}
	
	public BestaetigungsSeite confirm() {
		if(kundeFormValidation()==true) {
			return confirmm();
		}
		 else {
			 return null;
		 }
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
	
	public boolean kundeFormValidation() {
		if(session().getNachnameNeuerKunde() == null) {
			setCheckEmpty("Nachname");
			setaBoolean(true);
			return false;
		} 
		if(session().getVornameNeuerKunde() == null) {
			setCheckEmpty("Vorname");
			setaBoolean(true);
			return false;
		} 
		if(session().getStrasseNeuerKunde() == null) {
			setCheckEmpty("Strasse");
			setaBoolean(true);
			return false;
		} 
		if(session().getPlzNeuerKunde() == null) {
			setCheckEmpty("PLZ");
			setaBoolean(true);
			return false;
		} 
		if(session().getOrtNeuerKunde() == null) {
			setCheckEmpty("Ort");
			setaBoolean(true);
			return false;
		} 
		if(session().getTelNeuerKunde() == null) {
			setCheckEmpty("Telefon");
			setaBoolean(true);
			return false;
		} 
		if(session().getBemerkungenNeuerBestellung() == null) {
			setCheckEmpty("Bemerkung");
			setaBoolean(true);
			return false;
		} else {
			setCheckEmpty("");
			return true;
		}
	}

	/**
	 * @return the checkEmpty
	 */
	public String checkEmpty() {
		if(checkEmpty == "") {
			setaBoolean(true);
			return "";
		} else {
			return "Das Feld "+checkEmpty+" ist leer!";
		}
	}

	/**
	 * @param checkEmpty the checkEmpty to set
	 */
	public void setCheckEmpty(String checkEmpty) {
		this.checkEmpty = checkEmpty;
	}

	/**
	 * @return the aBoolean
	 */
	public Boolean aBoolean() {
		return aBoolean;
	}

	/**
	 * @param aBoolean the aBoolean to set
	 */
	public void setaBoolean(Boolean aBoolean) {
		this.aBoolean = aBoolean;
	}
	
	
	
}