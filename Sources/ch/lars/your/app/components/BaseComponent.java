package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

import ch.lars.your.app.Application;
import ch.lars.your.app.Session;

public class BaseComponent extends ERXComponent {
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
