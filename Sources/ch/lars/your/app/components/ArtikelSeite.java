package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;

import ch.lars.your.app.Application;

public class ArtikelSeite extends BaseComponent {
	public ArtikelSeite(WOContext context) {
		super(context);
		Application application = (Application)Application.application();
	}
}
