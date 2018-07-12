// DO NOT EDIT.  Make changes to Bestellung.java instead.
package ch.lars.your.app.eomodel;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;

import er.extensions.eof.*;
import er.extensions.eof.ERXKey.Type;
import er.extensions.foundation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public abstract class _Bestellung extends ERXGenericRecord {
	public static final String ENTITY_NAME = "Bestellung";

	// Attribute Keys
	public static final ERXKey<String> BEMERKUNGEN = new ERXKey<String>("bemerkungen", Type.Attribute);
	public static final ERXKey<NSTimestamp> DATUM = new ERXKey<NSTimestamp>("datum", Type.Attribute);

	// Relationship Keys
	public static final ERXKey<ch.lars.your.app.eomodel.BestellPosition> BESTELL_POSITIONS = new ERXKey<ch.lars.your.app.eomodel.BestellPosition>(
			"bestellPositions", Type.ToManyRelationship);
	public static final ERXKey<ch.lars.your.app.eomodel.Kunde> KUNDE = new ERXKey<ch.lars.your.app.eomodel.Kunde>(
			"kunde", Type.ToOneRelationship);

	// Attributes
	public static final String BEMERKUNGEN_KEY = BEMERKUNGEN.key();
	public static final String DATUM_KEY = DATUM.key();

	// Relationships
	public static final String BESTELL_POSITIONS_KEY = BESTELL_POSITIONS.key();
	public static final String KUNDE_KEY = KUNDE.key();

	private static final Logger log = LoggerFactory.getLogger(_Bestellung.class);

	public Bestellung localInstanceIn(EOEditingContext editingContext) {
		Bestellung localInstance = (Bestellung) EOUtilities.localInstanceOfObject(editingContext, this);
		if (localInstance == null) {
			throw new IllegalStateException(
					"You attempted to localInstance " + this + ", which has not yet committed.");
		}
		return localInstance;
	}

	public String bemerkungen() {
		return (String) storedValueForKey(_Bestellung.BEMERKUNGEN_KEY);
	}

	public void setBemerkungen(String value) {
		log.debug("updating bemerkungen from {} to {}", bemerkungen(), value);
		takeStoredValueForKey(value, _Bestellung.BEMERKUNGEN_KEY);
	}

	public NSTimestamp datum() {
		return (NSTimestamp) storedValueForKey(_Bestellung.DATUM_KEY);
	}

	public void setDatum(NSTimestamp value) {
		log.debug("updating datum from {} to {}", datum(), value);
		takeStoredValueForKey(value, _Bestellung.DATUM_KEY);
	}

	public ch.lars.your.app.eomodel.Kunde kunde() {
		return (ch.lars.your.app.eomodel.Kunde) storedValueForKey(_Bestellung.KUNDE_KEY);
	}

	public void setKunde(ch.lars.your.app.eomodel.Kunde value) {
		takeStoredValueForKey(value, _Bestellung.KUNDE_KEY);
	}

	public void setKundeRelationship(ch.lars.your.app.eomodel.Kunde value) {
		log.debug("updating kunde from {} to {}", kunde(), value);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			setKunde(value);
		} else if (value == null) {
			ch.lars.your.app.eomodel.Kunde oldValue = kunde();
			if (oldValue != null) {
				removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Bestellung.KUNDE_KEY);
			}
		} else {
			addObjectToBothSidesOfRelationshipWithKey(value, _Bestellung.KUNDE_KEY);
		}
	}

	public NSArray<ch.lars.your.app.eomodel.BestellPosition> bestellPositions() {
		return (NSArray<ch.lars.your.app.eomodel.BestellPosition>) storedValueForKey(_Bestellung.BESTELL_POSITIONS_KEY);
	}

	public NSArray<ch.lars.your.app.eomodel.BestellPosition> bestellPositions(EOQualifier qualifier) {
		return bestellPositions(qualifier, null, false);
	}

	public NSArray<ch.lars.your.app.eomodel.BestellPosition> bestellPositions(EOQualifier qualifier, boolean fetch) {
		return bestellPositions(qualifier, null, fetch);
	}

	public NSArray<ch.lars.your.app.eomodel.BestellPosition> bestellPositions(EOQualifier qualifier,
			NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
		NSArray<ch.lars.your.app.eomodel.BestellPosition> results;
		if (fetch) {
			EOQualifier fullQualifier;
			EOQualifier inverseQualifier = ERXQ.equals(ch.lars.your.app.eomodel.BestellPosition.BESTELLUNG_KEY, this);

			if (qualifier == null) {
				fullQualifier = inverseQualifier;
			} else {
				fullQualifier = ERXQ.and(qualifier, inverseQualifier);
			}

			results = ch.lars.your.app.eomodel.BestellPosition.fetchBestellPositions(editingContext(), fullQualifier,
					sortOrderings);
		} else {
			results = bestellPositions();
			if (qualifier != null) {
				results = (NSArray<ch.lars.your.app.eomodel.BestellPosition>) EOQualifier
						.filteredArrayWithQualifier(results, qualifier);
			}
			if (sortOrderings != null) {
				results = (NSArray<ch.lars.your.app.eomodel.BestellPosition>) EOSortOrdering
						.sortedArrayUsingKeyOrderArray(results, sortOrderings);
			}
		}
		return results;
	}

	public void addToBestellPositions(ch.lars.your.app.eomodel.BestellPosition object) {
		includeObjectIntoPropertyWithKey(object, _Bestellung.BESTELL_POSITIONS_KEY);
	}

	public void removeFromBestellPositions(ch.lars.your.app.eomodel.BestellPosition object) {
		excludeObjectFromPropertyWithKey(object, _Bestellung.BESTELL_POSITIONS_KEY);
	}

	public void addToBestellPositionsRelationship(ch.lars.your.app.eomodel.BestellPosition object) {
		log.debug("adding {} to bestellPositions relationship", object);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			addToBestellPositions(object);
		} else {
			addObjectToBothSidesOfRelationshipWithKey(object, _Bestellung.BESTELL_POSITIONS_KEY);
		}
	}

	public void removeFromBestellPositionsRelationship(ch.lars.your.app.eomodel.BestellPosition object) {
		log.debug("removing {} from bestellPositions relationship", object);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			removeFromBestellPositions(object);
		} else {
			removeObjectFromBothSidesOfRelationshipWithKey(object, _Bestellung.BESTELL_POSITIONS_KEY);
		}
	}

	public ch.lars.your.app.eomodel.BestellPosition createBestellPositionsRelationship() {
		EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),
				ch.lars.your.app.eomodel.BestellPosition.ENTITY_NAME);
		addObjectToBothSidesOfRelationshipWithKey(eo, _Bestellung.BESTELL_POSITIONS_KEY);
		return (ch.lars.your.app.eomodel.BestellPosition) eo;
	}

	public void deleteBestellPositionsRelationship(ch.lars.your.app.eomodel.BestellPosition object) {
		removeObjectFromBothSidesOfRelationshipWithKey(object, _Bestellung.BESTELL_POSITIONS_KEY);
		editingContext().deleteObject(object);
	}

	public void deleteAllBestellPositionsRelationships() {
		Enumeration<ch.lars.your.app.eomodel.BestellPosition> objects = bestellPositions().immutableClone()
				.objectEnumerator();
		while (objects.hasMoreElements()) {
			deleteBestellPositionsRelationship(objects.nextElement());
		}
	}

	public static Bestellung createBestellung(EOEditingContext editingContext, String bemerkungen, NSTimestamp datum,
			ch.lars.your.app.eomodel.Kunde kunde) {
		Bestellung eo = (Bestellung) EOUtilities.createAndInsertInstance(editingContext, _Bestellung.ENTITY_NAME);
		eo.setBemerkungen(bemerkungen);
		eo.setDatum(datum);
		eo.setKundeRelationship(kunde);
		return eo;
	}

	public static ERXFetchSpecification<Bestellung> fetchSpec() {
		return new ERXFetchSpecification<Bestellung>(_Bestellung.ENTITY_NAME, null, null, false, true, null);
	}

	public static NSArray<Bestellung> fetchAllBestellungs(EOEditingContext editingContext) {
		return _Bestellung.fetchAllBestellungs(editingContext, null);
	}

	public static NSArray<Bestellung> fetchAllBestellungs(EOEditingContext editingContext,
			NSArray<EOSortOrdering> sortOrderings) {
		return _Bestellung.fetchBestellungs(editingContext, null, sortOrderings);
	}

	public static NSArray<Bestellung> fetchBestellungs(EOEditingContext editingContext, EOQualifier qualifier,
			NSArray<EOSortOrdering> sortOrderings) {
		ERXFetchSpecification<Bestellung> fetchSpec = new ERXFetchSpecification<Bestellung>(_Bestellung.ENTITY_NAME,
				qualifier, sortOrderings);
		NSArray<Bestellung> eoObjects = fetchSpec.fetchObjects(editingContext);
		return eoObjects;
	}

	public static Bestellung fetchBestellung(EOEditingContext editingContext, String keyName, Object value) {
		return _Bestellung.fetchBestellung(editingContext, ERXQ.equals(keyName, value));
	}

	public static Bestellung fetchBestellung(EOEditingContext editingContext, EOQualifier qualifier) {
		NSArray<Bestellung> eoObjects = _Bestellung.fetchBestellungs(editingContext, qualifier, null);
		Bestellung eoObject;
		int count = eoObjects.count();
		if (count == 0) {
			eoObject = null;
		} else if (count == 1) {
			eoObject = eoObjects.objectAtIndex(0);
		} else {
			throw new IllegalStateException(
					"There was more than one Bestellung that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

	public static Bestellung fetchRequiredBestellung(EOEditingContext editingContext, String keyName, Object value) {
		return _Bestellung.fetchRequiredBestellung(editingContext, ERXQ.equals(keyName, value));
	}

	public static Bestellung fetchRequiredBestellung(EOEditingContext editingContext, EOQualifier qualifier) {
		Bestellung eoObject = _Bestellung.fetchBestellung(editingContext, qualifier);
		if (eoObject == null) {
			throw new NoSuchElementException("There was no Bestellung that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

	public static Bestellung localInstanceIn(EOEditingContext editingContext, Bestellung eo) {
		Bestellung localInstance = (eo == null) ? null
				: ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
		if (localInstance == null && eo != null) {
			throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
		}
		return localInstance;
	}
}
