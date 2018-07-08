package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;

import ch.lars.your.app.Application;
import ch.lars.your.app.Session;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOActionResults;

public class DankesSeite extends BaseComponent {
	private Session sitzung;
	private Application application;

	public DankesSeite(WOContext context) {
        super(context);
        //session().terminate();
        sitzung = (Session) session();
		application = (Application) Application.application();
        
    }

	public Main startseite() {
		sitzung.terminate();
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}
	
	
}