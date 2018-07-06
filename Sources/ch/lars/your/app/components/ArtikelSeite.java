package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;

import ch.lars.your.app.Application;
import ch.lars.your.app.Session;
import ch.lars.your.app.eomodel.Artikel;
import er.extensions.eof.ERXFetchSpecification;

import com.ibm.icu.math.BigDecimal;
import com.webobjects.appserver.WOActionResults;

public class ArtikelSeite extends BaseComponent {
	
	//private Session sitzung;
	private Application application;
	
	public ArtikelSeite(WOContext context) {
		super(context);
		//sitzung = (Session) session();
		//application = (Application) Application.application();
	}
	


	public String getArtikelName() {
		return session().getArtikelArtikelSeite().bezeichnung();
	}
	

	/**
	 * @return the artikelIcon
	 */
	//public String artikelIcon() {
	//	return application.getArtikelIcon();
	//}


	/**
	 * @return the preis
	 */
	public String getPreis() {
		//return application.getArtikel().getPreis().toString();
		return null;
	}



	public Einstiegsseite confirm() {
		//Speichere Artikel mit allen Inhalten
		
		Einstiegsseite nextPage = pageWithName(Einstiegsseite.class);
		return nextPage;
	}







}

