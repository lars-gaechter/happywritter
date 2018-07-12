package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;

/**
 * Stellt Kopf von anderen WOComponenten dar.
 * 
 * @author Protoss
 *
 */
public class Kopf extends WOComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4699874853646149355L;

	/**
	 * Kopf Konstruktor
	 * 
	 * @param context
	 *            super
	 */
	public Kopf(WOContext context) {
		super(context);
	}
}