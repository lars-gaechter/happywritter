package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOQualifier;

import ch.lars.your.app.Application;
import ch.lars.your.app.Session;
import ch.lars.your.app.components.Main;
import ch.lars.your.app.eomodel.Artikel;

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
		Artikel anArtikel= Artikel.fetchArtikel(session().defaultEditingContext(), Artikel.BEZEICHNUNG.eq("Etui"));
		session().setArtikelArtikelSeite(anArtikel);
		return nextPage;
	}


	public ArtikelSeite getSchachtelBestellen() {
		ArtikelSeite nextPage = pageWithName(ArtikelSeite.class);
		Artikel anArtikel = Artikel.fetchArtikel(session().defaultEditingContext(), Artikel.BEZEICHNUNG.eq("Schachtel"));
		session().setArtikelArtikelSeite(anArtikel);
		return nextPage;
	}



}