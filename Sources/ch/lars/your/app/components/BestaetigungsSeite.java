package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;

import ch.lars.your.app.Application;
import ch.lars.your.app.Session;

public class BestaetigungsSeite extends BaseComponent {
	
    private Session sitzung;
	private Application application;

	public BestaetigungsSeite(WOContext context) {
        super(context);
        sitzung = (Session) session();
		application = (Application) Application.application();
    }

	public Main abbrechen() {
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}
	
	public KundenInfoSeite zurueck() {
		KundenInfoSeite nextPage = pageWithName(KundenInfoSeite.class);
		return nextPage;
	}

	public DankesSeite confirm() {
		DankesSeite nextPage = pageWithName(DankesSeite.class);
		return nextPage;
	}
}