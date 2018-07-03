package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;

import ch.lars.your.app.Application;
import ch.lars.your.app.Session;
import ch.lars.your.app.components.Main;

import com.webobjects.appserver.WOActionResults;

public class Einstiegsseite extends BaseComponent {
	
	private ArtikelSeite etuiBestellen;
	private ArtikelSeite schachtelBestellen;
	private Session sitzung;
	private Application application;
	
    public Einstiegsseite(WOContext context) {
        super(context);
        
        sitzung = (Session) session();
		application = (Application) Application.application();
        
    }

	public KundenInfoSeite detail() {
		KundenInfoSeite nextPage = pageWithName(KundenInfoSeite.class);
		return nextPage;
	}


	public ArtikelSeite getEtuiBestellen() {
		ArtikelSeite nextPage = pageWithName(ArtikelSeite.class);
		Artikel etuiBestellen = new Artikel();
		etuiBestellen.setBezeichnung("Etui");
		etuiBestellen.setPreis(15.50);
		etuiBestellen.setIcon("img/Etui.jpg");
		application.setArtikel(etuiBestellen);
		return nextPage;
	}


	public ArtikelSeite getSchachtelBestellen() {
		ArtikelSeite nextPage = pageWithName(ArtikelSeite.class);
		Artikel schachtelBestellen = new Artikel();
		schachtelBestellen.setBezeichnung("Schachtel");
		schachtelBestellen.setPreis(33.9);
		schachtelBestellen.setIcon("img/Holzschachtel.jpg");
		application.setArtikel(schachtelBestellen);
		return nextPage;
	}



}