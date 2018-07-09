package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOComponent;
/**
 * Stellt Fuss von anderen WOComponenten dar.
 * @author Protoss
 *
 */
public class Fuss extends WOComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3307736628779683383L;

	/**
	 * Fuss Konstruktor
	 * @param context super
	 */
    public Fuss(WOContext context) {
        super(context);
    }
}