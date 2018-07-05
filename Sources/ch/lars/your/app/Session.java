package ch.lars.your.app;

import ch.lars.your.app.eomodel.Artikel;
import er.extensions.appserver.ERXSession;

public class Session extends ERXSession {
	private static final long serialVersionUID = 1L;
	private Artikel artikelArtikelSeite = null;

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
	
	
	
}
