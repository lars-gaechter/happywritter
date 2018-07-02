package ch.lars.your.app.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

import ch.lars.your.app.Application;

public class KundenInfoSeite extends BaseComponent {
	public KundenInfoSeite(WOContext context) {
		super(context);
    }

	public Main main() {
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}

	public BestaetigungsSeite confirm() {
		BestaetigungsSeite nextPage = pageWithName(BestaetigungsSeite.class);
		return nextPage;
	}
}