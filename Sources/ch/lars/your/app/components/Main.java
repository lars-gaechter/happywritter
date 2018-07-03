package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;

import ch.lars.your.app.Application;
import ch.lars.your.app.Session;

import com.webobjects.appserver.WOActionResults;

public class Main extends BaseComponent {
	public Main(WOContext context) {
		super(context);
		Application application = (Application) Application.application();
	}

	public KundenInfoSeite detail() {
		KundenInfoSeite nextPage = pageWithName(KundenInfoSeite.class);
		return nextPage;
	}

	public Admin adminLogin() {
		Admin nextPage = pageWithName(Admin.class);
		return nextPage;
	}

	public Einstiegsseite startShop() {
		Einstiegsseite nextPage = pageWithName(Einstiegsseite.class);
		return nextPage;
	}
}
