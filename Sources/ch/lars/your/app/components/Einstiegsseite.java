package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOQualifier;

import ch.lars.your.app.Application;
import ch.lars.your.app.Session;
import ch.lars.your.app.components.Main;
import ch.lars.your.app.eomodel.Artikel;

import java.math.RoundingMode;

import com.webobjects.appserver.WOActionResults;

public class Einstiegsseite extends BaseComponent {
	
	private ArtikelSeite etuiBestellen;
	private ArtikelSeite schachtelBestellen;
	private Session sitzung;
	private Application application;
	private String bestellung;
	private String bestelltePositionPreis;
	
    public Einstiegsseite(WOContext context) {
        super(context);
        
        sitzung = (Session) session();
		application = (Application) Application.application();
        
    }

	public KundenInfoSeite checkout() {
		KundenInfoSeite nextPage = pageWithName(KundenInfoSeite.class);
		return nextPage;
	}


	public ArtikelSeite getEtuiBestellen() {
		ArtikelSeite nextPage = pageWithName(ArtikelSeite.class);
		Artikel anArtikel= Artikel.fetchArtikel(session().defaultEditingContext(), Artikel.BEZEICHNUNG.eq("Etui"));
		session().setArtikelArtikelSeite(anArtikel);
		session().setArtikelBezeichnung("Etui");
		session().setArtikelIcon("img/Etui.jpg");
		return nextPage;
	}


	public ArtikelSeite getSchachtelBestellen() {
		ArtikelSeite nextPage = pageWithName(ArtikelSeite.class);
		Artikel anArtikel = Artikel.fetchArtikel(session().defaultEditingContext(), Artikel.BEZEICHNUNG.eq("Schachtel"));
		session().setArtikelArtikelSeite(anArtikel);
		session().setArtikelBezeichnung("Schachtel");
		session().setArtikelIcon("img/Holzschachtel.jpg");
		return nextPage;
	}
	
	public Boolean istMinEinArtikelBestaetigt() {
		if(session().getArtikelBezeichnung() == null) {
			return false;
		} else {
			if((session().getArtikelBezeichnung() == "Etui") || session().getArtikelBezeichnung() == "Schachtel") {
			return true;
		} else {
			return false;
		}
	}

	}

	/**
	 * @return the bestellung
	 */
	public String bestelltePositionArtikel() {
		
		if(session().getArtikelBezeichnung() == null) {
			return "";
		} else {
			if((session().getArtikelBezeichnung() == "Etui") || session().getArtikelBezeichnung() == "Schachtel") {
				return session().getArtikelBezeichnung();
		} else {
			return "";
		}
		}
	}

	/**
	 * @return the bestelltePositionPreis
	 */
	public String bestelltePositionPreis() {
		if(session().getArtikelBezeichnung() == null) {
			return "";
		} else {
			if((session().getArtikelBezeichnung() == "Etui") || session().getArtikelBezeichnung() == "Schachtel") {
				return "CHF "+session().getArtikelArtikelSeite().preis().setScale(2, RoundingMode.DOWN).toString();
		} else {
			return "";
		}
		}
	}

}