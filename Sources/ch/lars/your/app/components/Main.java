package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;
/**
 * Main Seite 
 * @author Protoss
 *
 */
public class Main extends BaseComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2422856750692725144L;
	/**
	 * Konstruktor Main
	 * @param context super
	 */
	public Main(WOContext context) {
		super(context);
	}
	/**
	 * Fürt zur Admin Seite für die Administration
	 * @return Admin Seite
	 */
	public Admin adminLogin() {
		Admin nextPage = pageWithName(Admin.class);
		return nextPage;
	}
	/**
	 * Fürt zur Einstiegsseite Seite für den Online-Shop
	 * @return Einstiegsseite Seite
	 */
	public Einstiegsseite startShop() {
		Einstiegsseite nextPage = pageWithName(Einstiegsseite.class);
		return nextPage;
	}
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
