// DO NOT EDIT.  Make changes to Inhalt.java instead.
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
public abstract class _Inhalt extends ERXGenericRecord {
	public static final String ENTITY_NAME = "Inhalt";

	// Attribute Keys
	public static final ERXKey<String> NAME = new ERXKey<String>("name", Type.Attribute);
	public static final ERXKey<java.math.BigDecimal> PREIS = new ERXKey<java.math.BigDecimal>("preis", Type.Attribute);

	// Relationship Keys
	public static final ERXKey<ch.lars.your.app.eomodel.Artikel> ARTIKELS = new ERXKey<ch.lars.your.app.eomodel.Artikel>(
			"artikels", Type.ToManyRelationship);
	public static final ERXKey<ch.lars.your.app.eomodel.BestellPosition> BESTELL_POSITIONS = new ERXKey<ch.lars.your.app.eomodel.BestellPosition>(
			"bestellPositions", Type.ToManyRelationship);

	// Attributes
	public static final String NAME_KEY = NAME.key();
	public static final String PREIS_KEY = PREIS.key();

	// Relationships
	public static final String ARTIKELS_KEY = ARTIKELS.key();
	public static final String BESTELL_POSITIONS_KEY = BESTELL_POSITIONS.key();

	private static final Logger log = LoggerFactory.getLogger(_Inhalt.class);

	public Inhalt localInstanceIn(EOEditingContext editingContext) {
		Inhalt localInstance = (Inhalt) EOUtilities.localInstanceOfObject(editingContext, this);
		if (localInstance == null) {
			throw new IllegalStateException(
					"You attempted to localInstance " + this + ", which has not yet committed.");
		}
		return localInstance;
	}

	public String name() {
		return (String) storedValueForKey(_Inhalt.NAME_KEY);
	}

	public void setName(String value) {
		log.debug("updating name from {} to {}", name(), value);
		takeStoredValueForKey(value, _Inhalt.NAME_KEY);
	}

	public java.math.BigDecimal preis() {
		return (java.math.BigDecimal) storedValueForKey(_Inhalt.PREIS_KEY);
	}

	public void setPreis(java.math.BigDecimal value) {
		log.debug("updating preis from {} to {}", preis(), value);
		takeStoredValueForKey(value, _Inhalt.PREIS_KEY);
	}

	public NSArray<ch.lars.your.app.eomodel.Artikel> artikels() {
		return (NSArray<ch.lars.your.app.eomodel.Artikel>) storedValueForKey(_Inhalt.ARTIKELS_KEY);
	}

	public NSArray<ch.lars.your.app.eomodel.Artikel> artikels(EOQualifier qualifier) {
		return artikels(qualifier, null);
	}

	public NSArray<ch.lars.your.app.eomodel.Artikel> artikels(EOQualifier qualifier,
			NSArray<EOSortOrdering> sortOrderings) {
		NSArray<ch.lars.your.app.eomodel.Artikel> results;
		results = artikels();
		if (qualifier != null) {
			results = (NSArray<ch.lars.your.app.eomodel.Artikel>) EOQualifier.filteredArrayWithQualifier(results,
					qualifier);
		}
		if (sortOrderings != null) {
			results = (NSArray<ch.lars.your.app.eomodel.Artikel>) EOSortOrdering.sortedArrayUsingKeyOrderArray(results,
					sortOrderings);
		}
		return results;
	}

	public void addToArtikels(ch.lars.your.app.eomodel.Artikel object) {
		includeObjectIntoPropertyWithKey(object, _Inhalt.ARTIKELS_KEY);
	}

	public void removeFromArtikels(ch.lars.your.app.eomodel.Artikel object) {
		excludeObjectFromPropertyWithKey(object, _Inhalt.ARTIKELS_KEY);
	}

	public void addToArtikelsRelationship(ch.lars.your.app.eomodel.Artikel object) {
		log.debug("adding {} to artikels relationship", object);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			addToArtikels(object);
		} else {
			addObjectToBothSidesOfRelationshipWithKey(object, _Inhalt.ARTIKELS_KEY);
		}
	}

	public void removeFromArtikelsRelationship(ch.lars.your.app.eomodel.Artikel object) {
		log.debug("removing {} from artikels relationship", object);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			removeFromArtikels(object);
		} else {
			removeObjectFromBothSidesOfRelationshipWithKey(object, _Inhalt.ARTIKELS_KEY);
		}
	}

	public ch.lars.your.app.eomodel.Artikel createArtikelsRelationship() {
		EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),
				ch.lars.your.app.eomodel.Artikel.ENTITY_NAME);
		addObjectToBothSidesOfRelationshipWithKey(eo, _Inhalt.ARTIKELS_KEY);
		return (ch.lars.your.app.eomodel.Artikel) eo;
	}

	public void deleteArtikelsRelationship(ch.lars.your.app.eomodel.Artikel object) {
		removeObjectFromBothSidesOfRelationshipWithKey(object, _Inhalt.ARTIKELS_KEY);
		editingContext().deleteObject(object);
	}

	public void deleteAllArtikelsRelationships() {
		Enumeration<ch.lars.your.app.eomodel.Artikel> objects = artikels().immutableClone().objectEnumerator();
		while (objects.hasMoreElements()) {
			deleteArtikelsRelationship(objects.nextElement());
		}
	}

	public NSArray<ch.lars.your.app.eomodel.BestellPosition> bestellPositions() {
		return (NSArray<ch.lars.your.app.eomodel.BestellPosition>) storedValueForKey(_Inhalt.BESTELL_POSITIONS_KEY);
	}

	public NSArray<ch.lars.your.app.eomodel.BestellPosition> bestellPositions(EOQualifier qualifier) {
		return bestellPositions(qualifier, null);
	}

	public NSArray<ch.lars.your.app.eomodel.BestellPosition> bestellPositions(EOQualifier qualifier,
			NSArray<EOSortOrdering> sortOrderings) {
		NSArray<ch.lars.your.app.eomodel.BestellPosition> results;
		results = bestellPositions();
		if (qualifier != null) {
			results = (NSArray<ch.lars.your.app.eomodel.BestellPosition>) EOQualifier
					.filteredArrayWithQualifier(results, qualifier);
		}
		if (sortOrderings != null) {
			results = (NSArray<ch.lars.your.app.eomodel.BestellPosition>) EOSortOrdering
					.sortedArrayUsingKeyOrderArray(results, sortOrderings);
		}
		return results;
	}

	public void addToBestellPositions(ch.lars.your.app.eomodel.BestellPosition object) {
		includeObjectIntoPropertyWithKey(object, _Inhalt.BESTELL_POSITIONS_KEY);
	}

	public void removeFromBestellPositions(ch.lars.your.app.eomodel.BestellPosition object) {
		excludeObjectFromPropertyWithKey(object, _Inhalt.BESTELL_POSITIONS_KEY);
	}

	public void addToBestellPositionsRelationship(ch.lars.your.app.eomodel.BestellPosition object) {
		log.debug("adding {} to bestellPositions relationship", object);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			addToBestellPositions(object);
		} else {
			addObjectToBothSidesOfRelationshipWithKey(object, _Inhalt.BESTELL_POSITIONS_KEY);
		}
	}

	public void removeFromBestellPositionsRelationship(ch.lars.your.app.eomodel.BestellPosition object) {
		log.debug("removing {} from bestellPositions relationship", object);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			removeFromBestellPositions(object);
		} else {
			removeObjectFromBothSidesOfRelationshipWithKey(object, _Inhalt.BESTELL_POSITIONS_KEY);
		}
	}

	public ch.lars.your.app.eomodel.BestellPosition createBestellPositionsRelationship() {
		EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),
				ch.lars.your.app.eomodel.BestellPosition.ENTITY_NAME);
		addObjectToBothSidesOfRelationshipWithKey(eo, _Inhalt.BESTELL_POSITIONS_KEY);
		return (ch.lars.your.app.eomodel.BestellPosition) eo;
	}

	public void deleteBestellPositionsRelationship(ch.lars.your.app.eomodel.BestellPosition object) {
		removeObjectFromBothSidesOfRelationshipWithKey(object, _Inhalt.BESTELL_POSITIONS_KEY);
		editingContext().deleteObject(object);
	}

	public void deleteAllBestellPositionsRelationships() {
		Enumeration<ch.lars.your.app.eomodel.BestellPosition> objects = bestellPositions().immutableClone()
				.objectEnumerator();
		while (objects.hasMoreElements()) {
			deleteBestellPositionsRelationship(objects.nextElement());
		}
	}

	public static Inhalt createInhalt(EOEditingContext editingContext, String name, java.math.BigDecimal preis) {
		Inhalt eo = (Inhalt) EOUtilities.createAndInsertInstance(editingContext, _Inhalt.ENTITY_NAME);
		eo.setName(name);
		eo.setPreis(preis);
		return eo;
	}

	public static ERXFetchSpecification<Inhalt> fetchSpec() {
		return new ERXFetchSpecification<Inhalt>(_Inhalt.ENTITY_NAME, null, null, false, true, null);
	}

	public static NSArray<Inhalt> fetchAllInhalts(EOEditingContext editingContext) {
		return _Inhalt.fetchAllInhalts(editingContext, null);
	}

	public static NSArray<Inhalt> fetchAllInhalts(EOEditingContext editingContext,
			NSArray<EOSortOrdering> sortOrderings) {
		return _Inhalt.fetchInhalts(editingContext, null, sortOrderings);
	}

	public static NSArray<Inhalt> fetchInhalts(EOEditingContext editingContext, EOQualifier qualifier,
			NSArray<EOSortOrdering> sortOrderings) {
		ERXFetchSpecification<Inhalt> fetchSpec = new ERXFetchSpecification<Inhalt>(_Inhalt.ENTITY_NAME, qualifier,
				sortOrderings);
		NSArray<Inhalt> eoObjects = fetchSpec.fetchObjects(editingContext);
		return eoObjects;
	}

	public static Inhalt fetchInhalt(EOEditingContext editingContext, String keyName, Object value) {
		return _Inhalt.fetchInhalt(editingContext, ERXQ.equals(keyName, value));
	}

	public static Inhalt fetchInhalt(EOEditingContext editingContext, EOQualifier qualifier) {
		NSArray<Inhalt> eoObjects = _Inhalt.fetchInhalts(editingContext, qualifier, null);
		Inhalt eoObject;
		int count = eoObjects.count();
		if (count == 0) {
			eoObject = null;
		} else if (count == 1) {
			eoObject = eoObjects.objectAtIndex(0);
		} else {
			throw new IllegalStateException(
					"There was more than one Inhalt that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

	public static Inhalt fetchRequiredInhalt(EOEditingContext editingContext, String keyName, Object value) {
		return _Inhalt.fetchRequiredInhalt(editingContext, ERXQ.equals(keyName, value));
	}

	public static Inhalt fetchRequiredInhalt(EOEditingContext editingContext, EOQualifier qualifier) {
		Inhalt eoObject = _Inhalt.fetchInhalt(editingContext, qualifier);
		if (eoObject == null) {
			throw new NoSuchElementException("There was no Inhalt that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

	public static Inhalt localInstanceIn(EOEditingContext editingContext, Inhalt eo) {
		Inhalt localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
		if (localInstance == null && eo != null) {
			throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
		}
		return localInstance;
	}
}
