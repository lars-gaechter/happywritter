package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;

import ch.lars.your.app.Application;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOActionResults;

public class Admin extends BaseComponent {
	
	Application application;

	private String benutzername;
	private String passwort;
	
    public Admin(WOContext context) {
        super(context);
        
        application = (Application) Application.application();
        
    }

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public WOActionResults anmelden() {
		//return application.anmelden(getBenutzername(), getPasswort());
		return application().anmelden(getBenutzername(), getPasswort());
	}
    
    
}