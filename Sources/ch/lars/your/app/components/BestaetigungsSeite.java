package ch.lars.your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;

import ch.lars.your.app.Application;
import ch.lars.your.app.Session;
import ch.lars.your.app.eomodel.Artikel;
import ch.lars.your.app.eomodel.BestellPosition;
import ch.lars.your.app.eomodel.Bestellung;
import ch.lars.your.app.eomodel.Kunde;
import er.extensions.eof.ERXEOControlUtilities;

public class BestaetigungsSeite extends BaseComponent {
	


	public BestaetigungsSeite(WOContext context) {
        super(context);

    }

	public Main abbrechen() {
		session().terminate();
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}
	
	public KundenInfoSeite zurueck() {
		KundenInfoSeite nextPage = pageWithName(KundenInfoSeite.class);
		return nextPage;
	}

	public DankesSeite confirm() {
		/*
		session().getaKunde().setNachname(session().getNachnameNeuerKunde());
		session().getaKunde().setVorname(session().getVornameNeuerKunde());
		session().getaKunde().setStrasse(session().getStrasseNeuerKunde());
		session().getaKunde().setPlz(session().getPlzNeuerKunde());
		session().getaKunde().setTel(session().getTelNeuerKunde());
		session().getaBestellung().setBemerkungen(session().getBemerkungenNeuerBestellung());
		*/
		
		//Create all needed objects
		Kunde kunde = new Kunde();
		Bestellung bestellung = new Bestellung();
		BestellPosition bestellPosition = new BestellPosition();
		Artikel artikel = new Artikel();
		
		//Artikel artikel = new Artikel();
		
		//Set FK from PK Kunde into Bestellung
		bestellung.addObjectToBothSidesOfRelationshipWithKey(kunde, Bestellung.KUNDE_KEY);
		
		
		//Set FK Artikel and FK Bestellung into BestellPosition
		//bestellPosition.addObjectToBothSidesOfRelationshipWithKey(bestellung, BestellPosition.BESTELLUNG_KEY);
		//bestellPosition.addObjectToBothSidesOfRelationshipWithKey(artikel, BestellPosition.ARTIKEL_KEY);
		
		//kunde.setNachname(session().getNachnameNeuerKunde());
		//System.out.println("kunde nachname"+kunde.nachname()+kunde.primaryKey()+kunde.entityName()+Kunde.ENTITY_NAME+kunde.kundeseit());
		//ERXEOControlUtilities.createAndInsertObject(session().defaultEditingContext(), Kunde.ENTITY_NAME);
		
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
		//bestellPosition.set
		
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
		//System.out.println("was in der session ist = "+session().getNachnameNeuerKunde());
		
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