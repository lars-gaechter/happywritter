package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;
import ch.lars.your.app.eomodel.Artikel;
import ch.lars.your.app.eomodel.BestellPosition;
import ch.lars.your.app.eomodel.Bestellung;
import ch.lars.your.app.eomodel.Kunde;
/**
 * BestaetigungsSeite Seite wenn der Kunde seinen Kauf und seine Daten Bestätigen möchte
 * @author Protoss
 *
 */
public class BestaetigungsSeite extends BaseComponent {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 728437930614992687L;

	/**
	 * Konstruktor BestaetigungsSeite
	 * @param context super
	 */
	public BestaetigungsSeite(WOContext context) {
        super(context);

    }
	/**
	 * Abbruch in bei BestaetigungsSeite
	 * Terminiert die Session 
	 * @return Main Seite
	 */
	public Main abbrechen() {
		session().terminate();
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}
	/**
	 * Geht eine Seite Zurück zum Kunden Formular
	 * @return KundenInfoSeite Seite
	 */
	public KundenInfoSeite zurueck() {
		KundenInfoSeite nextPage = pageWithName(KundenInfoSeite.class);
		return nextPage;
	}
	/**
	 * Bestätigung vom Kauf
	 * Kunde, Bestellung und Bestellposition wird in der Datenbank gespeichert
	 * @return DankesSeite Seite
	 */
	public DankesSeite confirm() {
		//Create all needed objects
		Kunde kunde = new Kunde();
		Bestellung bestellung = new Bestellung();
		BestellPosition bestellPosition = new BestellPosition();
		Artikel artikel = new Artikel();
		//Set FK from PK Kunde into Bestellung
		bestellung.addObjectToBothSidesOfRelationshipWithKey(kunde, Bestellung.KUNDE_KEY);
		//Kunde data from session set
		kunde.setOrt(session().getOrtNeuerKunde());
		kunde.setPlz(session().getPlzNeuerKunde());
		kunde.setStrasse(session().getStrasseNeuerKunde());
		kunde.setTel(session().getTelNeuerKunde());
		kunde.setVorname(session().getVornameNeuerKunde());
		kunde.setNachname(session().getNachnameNeuerKunde());
		//Bestellung data from session set
		bestellung.setBemerkungen(session().getBemerkungenNeuerBestellung());
		bestellPosition.addObjectToBothSidesOfRelationshipWithKey(bestellung, BestellPosition.BESTELLUNG_KEY);
		bestellPosition.setBestellungID(23123);
		if(session().getArtikelBezeichnung() == "Etui") {
				bestellPosition.setArtikelID(1);
				artikel.setBezeichnung("Etui");
				artikel.setPreis(null);
			}
		if(session().getArtikelBezeichnung() == "Schachtel") {
					bestellPosition.setArtikelID(2);
					artikel.setBezeichnung("Schachtel");
					artikel.setPreis(null);
				}
		//Insert object in Database
		session().defaultEditingContext().insertObject(kunde);
		session().defaultEditingContext().insertObject(bestellung);
		session().defaultEditingContext().insertObject(bestellPosition);
		//Commit
		session().defaultEditingContext().saveChanges();
		DankesSeite nextPage = pageWithName(DankesSeite.class);
		return nextPage;
	}

	/**
	 * @return the nachname
	 */
	public String getNachname() {
		if(session().getNachnameNeuerKunde() == "") {
			System.out.println("nachname ist nicht gesetzt!");
			return "leer";
		} else {
			return session().getNachnameNeuerKunde();
		}
	}
}