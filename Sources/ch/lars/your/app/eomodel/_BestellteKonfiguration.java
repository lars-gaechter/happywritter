// DO NOT EDIT.  Make changes to BestellteKonfiguration.java instead.
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
public abstract class _BestellteKonfiguration extends ERXGenericRecord {
	public static final String ENTITY_NAME = "BestellteKonfiguration";

	// Attribute Keys

	// Relationship Keys

	// Attributes

	// Relationships

	private static final Logger log = LoggerFactory.getLogger(_BestellteKonfiguration.class);

	public BestellteKonfiguration localInstanceIn(EOEditingContext editingContext) {
		BestellteKonfiguration localInstance = (BestellteKonfiguration) EOUtilities
				.localInstanceOfObject(editingContext, this);
		if (localInstance == null) {
			throw new IllegalStateException(
					"You attempted to localInstance " + this + ", which has not yet committed.");
		}
		return localInstance;
	}

	public static BestellteKonfiguration createBestellteKonfiguration(EOEditingContext editingContext) {
		BestellteKonfiguration eo = (BestellteKonfiguration) EOUtilities.createAndInsertInstance(editingContext,
				_BestellteKonfiguration.ENTITY_NAME);
		return eo;
	}

	public static ERXFetchSpecification<BestellteKonfiguration> fetchSpec() {
		return new ERXFetchSpecification<BestellteKonfiguration>(_BestellteKonfiguration.ENTITY_NAME, null, null, false,
				true, null);
	}

	public static NSArray<BestellteKonfiguration> fetchAllBestellteKonfigurations(EOEditingContext editingContext) {
		return _BestellteKonfiguration.fetchAllBestellteKonfigurations(editingContext, null);
	}

	public static NSArray<BestellteKonfiguration> fetchAllBestellteKonfigurations(EOEditingContext editingContext,
			NSArray<EOSortOrdering> sortOrderings) {
		return _BestellteKonfiguration.fetchBestellteKonfigurations(editingContext, null, sortOrderings);
	}

	public static NSArray<BestellteKonfiguration> fetchBestellteKonfigurations(EOEditingContext editingContext,
			EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
		ERXFetchSpecification<BestellteKonfiguration> fetchSpec = new ERXFetchSpecification<BestellteKonfiguration>(
				_BestellteKonfiguration.ENTITY_NAME, qualifier, sortOrderings);
		NSArray<BestellteKonfiguration> eoObjects = fetchSpec.fetchObjects(editingContext);
		return eoObjects;
	}

	public static BestellteKonfiguration fetchBestellteKonfiguration(EOEditingContext editingContext, String keyName,
			Object value) {
		return _BestellteKonfiguration.fetchBestellteKonfiguration(editingContext, ERXQ.equals(keyName, value));
	}

	public static BestellteKonfiguration fetchBestellteKonfiguration(EOEditingContext editingContext,
			EOQualifier qualifier) {
		NSArray<BestellteKonfiguration> eoObjects = _BestellteKonfiguration.fetchBestellteKonfigurations(editingContext,
				qualifier, null);
		BestellteKonfiguration eoObject;
		int count = eoObjects.count();
		if (count == 0) {
			eoObject = null;
		} else if (count == 1) {
			eoObject = eoObjects.objectAtIndex(0);
		} else {
			throw new IllegalStateException(
					"There was more than one BestellteKonfiguration that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

	public static BestellteKonfiguration fetchRequiredBestellteKonfiguration(EOEditingContext editingContext,
			String keyName, Object value) {
		return _BestellteKonfiguration.fetchRequiredBestellteKonfiguration(editingContext, ERXQ.equals(keyName, value));
	}

	public static BestellteKonfiguration fetchRequiredBestellteKonfiguration(EOEditingContext editingContext,
			EOQualifier qualifier) {
		BestellteKonfiguration eoObject = _BestellteKonfiguration.fetchBestellteKonfiguration(editingContext,
				qualifier);
		if (eoObject == null) {
			throw new NoSuchElementException(
					"There was no BestellteKonfiguration that matched the qualifier '" + qualifier + "'.");
		}
		return eoObject;
	}

	public static BestellteKonfiguration localInstanceIn(EOEditingContext editingContext, BestellteKonfiguration eo) {
		BestellteKonfiguration localInstance = (eo == null) ? null
				: ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
		if (localInstance == null && eo != null) {
			throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
		}
		return localInstance;
	}
}
