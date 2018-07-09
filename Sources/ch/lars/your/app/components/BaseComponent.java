package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

import ch.lars.your.app.Application;
import ch.lars.your.app.Session;
/**
 * BaseComponent erbt von ERXComponent
 * @author Protoss
 *
 */
public class BaseComponent extends ERXComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1997611439366762486L;

	/**
	 * BaseComponent Konstruktor
	 * @param context super
	 */
	public BaseComponent(WOContext context) {
		super(context);
	}
	
	@Override
	public Application application() {
		return (Application)super.application();
	}
	
	@Override
	public Session session() {
		return (Session)super.session();
	}
}
