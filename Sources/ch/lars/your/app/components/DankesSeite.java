package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;

import ch.lars.your.app.Application;
import ch.lars.your.app.Session;

import com.webobjects.appserver.WOComponent;

public class DankesSeite extends WOComponent {
    private Session sitzung;
	private Application application;

	public DankesSeite(WOContext context) {
        super(context);
        
        sitzung = (Session) session();
		application = (Application) Application.application();
		sitzung.terminate();
		application = null;
    }
	
	
}