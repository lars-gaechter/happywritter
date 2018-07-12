package ch.lars.your.app;

import com.webobjects.eocontrol.EOQualifier;
import er.extensions.appserver.ERXApplication;

/**
 * Application erbt von ERXApplication
 * 
 * @author Protoss
 *
 */
public class Application extends ERXApplication {
	private EOQualifier qualifier = null;

	public EOQualifier getQualifier() {
		return qualifier;
	}

	public void setQualifier(EOQualifier qualifier) {
		this.qualifier = qualifier;
	}


	public static void main(String[] argv) {
		ERXApplication.main(argv, Application.class);
	}

	/**
	 * Session terminiert automatisch nach 30 Minuten Ein Admin Benutzer wird zum
	 * Benutzer NSMutableArray hinzugefügt
	 */
	public Application() {
		ERXApplication.log.info("Welcome to " + name() + " !");
		setAllowsConcurrentRequestHandling(true);
		setSessionTimeOut(30 * 60);
	}

}
