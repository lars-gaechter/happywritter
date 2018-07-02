package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;

import ch.lars.your.app.Application;

import com.webobjects.appserver.WOActionResults;

public class Main extends BaseComponent {
	public Main(WOContext context) {
		super(context);
		Application application = (Application)Application.application();
	}

	public KundenInfoSeite detail() {
		KundenInfoSeite nextPage = pageWithName(KundenInfoSeite.class);
		return nextPage;
	}
}
