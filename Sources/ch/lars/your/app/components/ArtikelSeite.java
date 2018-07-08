package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;

import ch.lars.your.app.Application;
import ch.lars.your.app.Session;
import ch.lars.your.app.eomodel.Artikel;
import er.extensions.eof.ERXFetchSpecification;

import java.math.RoundingMode;

import com.ibm.icu.math.BigDecimal;
import com.webobjects.appserver.WOActionResults;

public class ArtikelSeite extends BaseComponent {
	
	//private Session sitzung;
	//private Application application;
	
	public ArtikelSeite(WOContext context) {
		super(context);
	}
	


	public String getArtikelName() {
		return session().getArtikelArtikelSeite().bezeichnung();
	}
	

	/**
	 * @return the artikelIcon
	 */
	public String artikelIcon() {
		return session().getArtikelIcon();
	}


	/**
	 * @return the preis
	 */
	public String getPreis() {
		return "Preis CHF"+session().getArtikelArtikelSeite().preis().setScale(2, RoundingMode.DOWN).toString();
	}



	public Einstiegsseite confirm() {
		//Speichere Artikel mit allen Inhalten
		
		Einstiegsseite nextPage = pageWithName(Einstiegsseite.class);
		return nextPage;
	}
	
	public Einstiegsseite nichtUebernehmen() {
		//Speichere keine Artikel mit allen Inhalten
		session().setArtikelArtikelSeite(null);
		session().setArtikelBezeichnung(null);
		Einstiegsseite nextPage = pageWithName(Einstiegsseite.class);
		return nextPage;
	}



	public Main abbruch() {
		session().terminate();
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}







}

