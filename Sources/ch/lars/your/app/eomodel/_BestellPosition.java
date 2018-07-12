// DO NOT EDIT.  Make changes to BestellPosition.java instead.
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
public abstract class _BestellPosition extends ERXGenericRecord {
	public static final String ENTITY_NAME = "BestellPosition";

	// Attribute Keys

	// Relationship Keys
	public static final ERXKey<ch.lars.your.app.eomodel.Artikel> ARTIKEL = new ERXKey<ch.lars.your.app.eomodel.Artikel>(
			"artikel", Type.ToOneRelationship);
	public static final ERXKey<ch.lars.your.app.eomodel.Bestellung> BESTELLUNG = new ERXKey<ch.lars.your.app.eomodel.Bestellung>(
			"bestellung", Type.ToOneRelationship);
	public static final ERXKey<ch.lars.your.app.eomodel.Inhalt> INHALTS = new ERXKey<ch.lars.your.app.eomodel.Inhalt>(
			"inhalts", Type.ToManyRelationship);

	// Attributes

	// Relationships
	public static final String ARTIKEL_KEY = ARTIKEL.key();
	public static final String BESTELLUNG_KEY = BESTELLUNG.key();
	public static final String INHALTS_KEY = INHALTS.key();

	private static final Logger log = LoggerFactory.getLogger(_BestellPosition.class);

	public BestellPosition localInstanceIn(EOEditingContext editingContext) {
		BestellPosition localInstance = (BestellPosition) EOUtilities.localInstanceOfObject(editingContext, this);
		if (localInstance == null) {
			throw new IllegalStateException(
					"You attempted to localInstance " + this + ", which has not yet committed.");
		}
		return localInstance;
	}

	public ch.lars.your.app.eomodel.Artikel artikel() {
		return (ch.lars.your.app.eomodel.Artikel) storedValueForKey(_BestellPosition.ARTIKEL_KEY);
	}

	public void setArtikel(ch.lars.your.app.eomodel.Artikel value) {
		takeStoredValueForKey(value, _BestellPosition.ARTIKEL_KEY);
	}

	public void setArtikelRelationship(ch.lars.your.app.eomodel.Artikel value) {
		log.debug("updating artikel from {} to {}", artikel(), value);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			setArtikel(value);
		} else if (value == null) {
			ch.lars.your.app.eomodel.Artikel oldValue = artikel();
			if (oldValue != null) {
				removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _BestellPosition.ARTIKEL_KEY);
			}
		} else {
			addObjectToBothSidesOfRelationshipWithKey(value, _BestellPosition.ARTIKEL_KEY);
		}
	}

	public ch.lars.your.app.eomodel.Bestellung bestellung() {
		return (ch.lars.your.app.eomodel.Bestellung) storedValueForKey(_BestellPosition.BESTELLUNG_KEY);
	}

	public void setBestellung(ch.lars.your.app.eomodel.Bestellung value) {
		takeStoredValueForKey(value, _BestellPosition.BESTELLUNG_KEY);
	}

	public void setBestellungRelationship(ch.lars.your.app.eomodel.Bestellung value) {
		log.debug("updating bestellung from {} to {}", bestellung(), value);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			setBestellung(value);
		} else if (value == null) {
			ch.lars.your.app.eomodel.Bestellung oldValue = bestellung();
			if (oldValue != null) {
				removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _BestellPosition.BESTELLUNG_KEY);
			}
		} else {
			addObjectToBothSidesOfRelationshipWithKey(value, _BestellPosition.BESTELLUNG_KEY);
		}
	}

	public NSArray<ch.lars.your.app.eomodel.Inhalt> inhalts() {
		return (NSArray<ch.lars.your.app.eomodel.Inhalt>) storedValueForKey(_BestellPosition.INHALTS_KEY);
	}

	public NSArray<ch.lars.your.app.eomodel.Inhalt> inhalts(EOQualifier qualifier) {
		return inhalts(qualifier, null);
	}

	public NSArray<ch.lars.your.app.eomodel.Inhalt> inhalts(EOQualifier qualifier,
			NSArray<EOSortOrdering> sortOrderings) {
		NSArray<ch.lars.your.app.eomodel.Inhalt> results;
		results = inhalts();
		if (qualifier != null) {
			results = (NSArray<ch.lars.your.app.eomodel.Inhalt>) EOQualifier.filteredArrayWithQualifier(results,
					qualifier);
		}
		if (sortOrderings != null) {
			results = (NSArray<ch.lars.your.app.eomodel.Inhalt>) EOSortOrdering.sortedArrayUsingKeyOrderArray(results,
					sortOrderings);
		}
		return results;
	}

	public void addToInhalts(ch.lars.your.app.eomodel.Inhalt object) {
		includeObjectIntoPropertyWithKey(object, _BestellPosition.INHALTS_KEY);
	}

	public void removeFromInhalts(ch.lars.your.app.eomodel.Inhalt object) {
		excludeObjectFromPropertyWithKey(object, _BestellPosition.INHALTS_KEY);
	}

	public void addToInhaltsRelationship(ch.lars.your.app.eomodel.Inhalt object) {
		log.debug("adding {} to inhalts relationship", object);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			addToInhalts(object);
		} else {
			addObjectToBothSidesOfRelationshipWithKey(object, _BestellPosition.INHALTS_KEY);
		}
	}

	public void removeFromInhaltsRelationship(ch.lars.your.app.eomodel.Inhalt object) {
		log.debug("removing {} from inhalts relationship", object);
		if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
			removeFromInhalts(object);
		} else {
			removeObjectFromBothSidesOfRelationshipWithKey(object, _BestellPosition.INHALTS_KEY);
		}
	}

	public ch.lars.your.app.eomodel.Inhalt createInhaltsRelationship() {
		EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),
				ch.lars.your.app.eomodel.Inhalt.ENTITY_NAME);
		addObjectToBothSidesOfRelationshipWithKey(eo, _BestellPosition.INHALTS_KEY);
		return (ch.lars.your.app.eomodel.Inhalt) eo;
	}

	public void deleteInhaltsRelationship(ch.lars.your.app.eomodel.Inhalt object) {
		removeObjectFromBothSidesOfRelationshipWithKey(object, _BestellPosition.INHALTS_KEY);
		editingContext().deleteObject(object);
	}

	public void deleteAllInhaltsRelationships() {
		Enumeration<ch.lars.your.app.eomodel.Inhalt> objects = inhalts().immutableClone().objectEnumerator();
		while (objects.hasMoreElements()) {
			deleteInhaltsRelationship(objects.nextElement());
		}
	}

	public static BestellPosition createBestellPosition(EOEditingContext editingContext,
			ch.lars.your.app.eomodel.Bestellung bestellung) {
		BestellPosition eo = (BestellPosition) EOUtilities.createAndInsertInstance(editingContext,
				_BestellPosition.ENTITY_NAME);
		eo.setBestellungRelationship(bestellung);
		return eo;
	}

	public static ERXFetchSpecification<BestellPosition> fetchSpec() {
		return new ERXFetchSpecification<BestellPosition>(_BestellPosition.ENTITY_NAME, null, null, false, true, null);
	}

	public static NSArray<BestellPosition> fetchAllBestellPositions(EOEditingContext editingContext) {
		return _BestellPosition.fetchAllBestellPositions(editingContext, null);
	}

	public static NSArray<BestellPosition> fetchAllBestellPositions(EOEditingContext editingContext,
			NSArray<EOSortOrdering> sortOrderings) {
		return _BestellPosition.fetchBestellPositions(editingContext, null, sortOrderings);
	}

	public static NSArray<BestellPosition> fetchBestellPositions(EOEditingContext editingContext, EOQualifier qualifier,
			NSArray<EOSortOrdering> sortOrderings) {
		ERXFetchSpecification<BestellPosition> fetchSpec = new ERXFetchSpecification<BestellPosition>(
				_BestellPosition.ENTITY_NAME, qualifier, sortOrderings);
		NSArray<BestellPosition> eoObjects = fetchSpec.fetchObjects(editingContext);
		return eoObjects;
	}

	public static BestellPosition fetchBestellPosition(EOEditingContext editingContext, String keyName, Object value) {
		return _BestellPosition.fetchBestellPosition(editingContext, ERXQ.equals(keyName, value));
	}

	public static BestellPosition fetchBestellPosition(EOEditingContext editingContext, EOQualifier qualifier) {
		NSArray<BestellPosition> eoObjects = _BestellPosition.fetchBestellPositions(editingContext, qualifier, null);
		BestellPosition eoObject;
		int count = eoObjects.count();
		if (count == 0) {
			eoObject = null;
		} else if (count == 1) {
			eoObject = eoObjects.objectAtIndex(0);
		} else {
			throw new IllegalStateException(
					"There was more than one BestellPosition that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

	public static BestellPosition fetchRequiredBestellPosition(EOEditingContext editingContext, String keyName,
			Object value) {
		return _BestellPosition.fetchRequiredBestellPosition(editingContext, ERXQ.equals(keyName, value));
	}

	public static BestellPosition fetchRequiredBestellPosition(EOEditingContext editingContext, EOQualifier qualifier) {
		BestellPosition eoObject = _BestellPosition.fetchBestellPosition(editingContext, qualifier);
		if (eoObject == null) {
			throw new NoSuchElementException(
					"There was no BestellPosition that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

	public static BestellPosition localInstanceIn(EOEditingContext editingContext, BestellPosition eo) {
		BestellPosition localInstance = (eo == null) ? null
				: ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
		if (localInstance == null && eo != null) {
			throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
		}
		return localInstance;
	}
}
