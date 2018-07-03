package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;

import ch.lars.your.app.Application;
import ch.lars.your.app.Session;

import com.ibm.icu.math.BigDecimal;
import com.webobjects.appserver.WOActionResults;

public class ArtikelSeite extends BaseComponent {
	
	private Artikel artikel;
	private Session sitzung;
	private Application application;
	private String artikelIcon;
	private String preis;
	
	public ArtikelSeite(WOContext context) {
		super(context);
		sitzung = (Session) session();
		application = (Application) Application.application();
	}
	


	public String getArtikelName() {
		return application.getArtikel().getBezeichnung();
	}
	

	/**
	 * @return the artikelIcon
	 */
	public String artikelIcon() {
		return application.getArtikel().getIcon();
	}


	/**
	 * @return the preis
	 */
	public String getPreis() {
		return application.getArtikel().getPreis().toString();
	}







}

