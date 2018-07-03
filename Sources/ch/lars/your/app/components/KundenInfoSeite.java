package ch.lars.your.app.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

import ch.lars.your.app.Application;
import com.webobjects.appserver.WOActionResults;

public class KundenInfoSeite extends BaseComponent {
	public KundenInfoSeite(WOContext context) {
		super(context);
    }

	public Main abbrechen() {
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
}