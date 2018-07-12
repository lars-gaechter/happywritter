package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;

/**
 * DankesSeite bedankt sich beim Kunden für den Kauf im Online-Shop
 * 
 * @author Protoss
 *
 */
public class DankesSeite extends BaseComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1374605765395661646L;

	/**
	 * Konstruktor DankesSeite Wenn die Danke Seite aufgerufen wird, wird die
	 * Session terminiert
	 * 
	 * @param context
	 *            super
	 */
	public DankesSeite(WOContext context) {
		super(context);
		session().terminate();

	}

	/**
	 * Die Session ist bereits beendet, wenn der Benutzer auf Startseite drückt
	 * kommt er zur Admin seite und muss noch zusätzlich auf zurück drücken
	 * 
	 * @return Main Seite
	 */
	public Main startseite() {
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}

}