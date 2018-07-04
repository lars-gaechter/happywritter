// DO NOT EDIT.  Make changes to Bestellposition.java instead.
package ch.lars.your.app.eoerd;

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
public abstract class _Bestellposition extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Bestellposition";

  // Attribute Keys

  // Relationship Keys
  public static final ERXKey<ch.lars.your.app.eoerd.Artikel> ARTIKEL = new ERXKey<ch.lars.your.app.eoerd.Artikel>("artikel", Type.ToOneRelationship);
  public static final ERXKey<ch.lars.your.app.eoerd.Bestelltekonfiguration> BESTELLTEKONFIGURATIONS = new ERXKey<ch.lars.your.app.eoerd.Bestelltekonfiguration>("bestelltekonfigurations", Type.ToManyRelationship);
  public static final ERXKey<ch.lars.your.app.eoerd.Bestellung> BESTELLUNG = new ERXKey<ch.lars.your.app.eoerd.Bestellung>("bestellung", Type.ToOneRelationship);

  // Attributes

  // Relationships
  public static final String ARTIKEL_KEY = ARTIKEL.key();
  public static final String BESTELLTEKONFIGURATIONS_KEY = BESTELLTEKONFIGURATIONS.key();
  public static final String BESTELLUNG_KEY = BESTELLUNG.key();

  private static final Logger log = LoggerFactory.getLogger(_Bestellposition.class);

  public Bestellposition localInstanceIn(EOEditingContext editingContext) {
    Bestellposition localInstance = (Bestellposition)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public ch.lars.your.app.eoerd.Artikel artikel() {
    return (ch.lars.your.app.eoerd.Artikel)storedValueForKey(_Bestellposition.ARTIKEL_KEY);
  }

  public void setArtikel(ch.lars.your.app.eoerd.Artikel value) {
    takeStoredValueForKey(value, _Bestellposition.ARTIKEL_KEY);
  }

  public void setArtikelRelationship(ch.lars.your.app.eoerd.Artikel value) {
    log.debug("updating artikel from {} to {}", artikel(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setArtikel(value);
    }
    else if (value == null) {
      ch.lars.your.app.eoerd.Artikel oldValue = artikel();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Bestellposition.ARTIKEL_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Bestellposition.ARTIKEL_KEY);
    }
  }

  public ch.lars.your.app.eoerd.Bestellung bestellung() {
    return (ch.lars.your.app.eoerd.Bestellung)storedValueForKey(_Bestellposition.BESTELLUNG_KEY);
  }

  public void setBestellung(ch.lars.your.app.eoerd.Bestellung value) {
    takeStoredValueForKey(value, _Bestellposition.BESTELLUNG_KEY);
  }

  public void setBestellungRelationship(ch.lars.your.app.eoerd.Bestellung value) {
    log.debug("updating bestellung from {} to {}", bestellung(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setBestellung(value);
    }
    else if (value == null) {
      ch.lars.your.app.eoerd.Bestellung oldValue = bestellung();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Bestellposition.BESTELLUNG_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Bestellposition.BESTELLUNG_KEY);
    }
  }

  public NSArray<ch.lars.your.app.eoerd.Bestelltekonfiguration> bestelltekonfigurations() {
    return (NSArray<ch.lars.your.app.eoerd.Bestelltekonfiguration>)storedValueForKey(_Bestellposition.BESTELLTEKONFIGURATIONS_KEY);
  }

  public NSArray<ch.lars.your.app.eoerd.Bestelltekonfiguration> bestelltekonfigurations(EOQualifier qualifier) {
    return bestelltekonfigurations(qualifier, null, false);
  }

  public NSArray<ch.lars.your.app.eoerd.Bestelltekonfiguration> bestelltekonfigurations(EOQualifier qualifier, boolean fetch) {
    return bestelltekonfigurations(qualifier, null, fetch);
  }

  public NSArray<ch.lars.your.app.eoerd.Bestelltekonfiguration> bestelltekonfigurations(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<ch.lars.your.app.eoerd.Bestelltekonfiguration> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(ch.lars.your.app.eoerd.Bestelltekonfiguration.BESTELLPOSITION_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = ch.lars.your.app.eoerd.Bestelltekonfiguration.fetchBestelltekonfigurations(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = bestelltekonfigurations();
      if (qualifier != null) {
        results = (NSArray<ch.lars.your.app.eoerd.Bestelltekonfiguration>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.lars.your.app.eoerd.Bestelltekonfiguration>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToBestelltekonfigurations(ch.lars.your.app.eoerd.Bestelltekonfiguration object) {
    includeObjectIntoPropertyWithKey(object, _Bestellposition.BESTELLTEKONFIGURATIONS_KEY);
  }

  public void removeFromBestelltekonfigurations(ch.lars.your.app.eoerd.Bestelltekonfiguration object) {
    excludeObjectFromPropertyWithKey(object, _Bestellposition.BESTELLTEKONFIGURATIONS_KEY);
  }

  public void addToBestelltekonfigurationsRelationship(ch.lars.your.app.eoerd.Bestelltekonfiguration object) {
    log.debug("adding {} to bestelltekonfigurations relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToBestelltekonfigurations(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Bestellposition.BESTELLTEKONFIGURATIONS_KEY);
    }
  }

  public void removeFromBestelltekonfigurationsRelationship(ch.lars.your.app.eoerd.Bestelltekonfiguration object) {
    log.debug("removing {} from bestelltekonfigurations relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromBestelltekonfigurations(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Bestellposition.BESTELLTEKONFIGURATIONS_KEY);
    }
  }

  public ch.lars.your.app.eoerd.Bestelltekonfiguration createBestelltekonfigurationsRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.lars.your.app.eoerd.Bestelltekonfiguration.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Bestellposition.BESTELLTEKONFIGURATIONS_KEY);
    return (ch.lars.your.app.eoerd.Bestelltekonfiguration) eo;
  }

  public void deleteBestelltekonfigurationsRelationship(ch.lars.your.app.eoerd.Bestelltekonfiguration object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Bestellposition.BESTELLTEKONFIGURATIONS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllBestelltekonfigurationsRelationships() {
    Enumeration<ch.lars.your.app.eoerd.Bestelltekonfiguration> objects = bestelltekonfigurations().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteBestelltekonfigurationsRelationship(objects.nextElement());
    }
  }


  public static Bestellposition createBestellposition(EOEditingContext editingContext) {
    Bestellposition eo = (Bestellposition) EOUtilities.createAndInsertInstance(editingContext, _Bestellposition.ENTITY_NAME);
    return eo;
  }

  public static ERXFetchSpecification<Bestellposition> fetchSpec() {
    return new ERXFetchSpecification<Bestellposition>(_Bestellposition.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Bestellposition> fetchAllBestellpositions(EOEditingContext editingContext) {
    return _Bestellposition.fetchAllBestellpositions(editingContext, null);
  }

  public static NSArray<Bestellposition> fetchAllBestellpositions(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Bestellposition.fetchBestellpositions(editingContext, null, sortOrderings);
  }

  public static NSArray<Bestellposition> fetchBestellpositions(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Bestellposition> fetchSpec = new ERXFetchSpecification<Bestellposition>(_Bestellposition.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Bestellposition> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Bestellposition fetchBestellposition(EOEditingContext editingContext, String keyName, Object value) {
    return _Bestellposition.fetchBestellposition(editingContext, ERXQ.equals(keyName, value));
  }

  public static Bestellposition fetchBestellposition(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Bestellposition> eoObjects = _Bestellposition.fetchBestellpositions(editingContext, qualifier, null);
    Bestellposition eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Bestellposition that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Bestellposition fetchRequiredBestellposition(EOEditingContext editingContext, String keyName, Object value) {
    return _Bestellposition.fetchRequiredBestellposition(editingContext, ERXQ.equals(keyName, value));
  }

  public static Bestellposition fetchRequiredBestellposition(EOEditingContext editingContext, EOQualifier qualifier) {
    Bestellposition eoObject = _Bestellposition.fetchBestellposition(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Bestellposition that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Bestellposition localInstanceIn(EOEditingContext editingContext, Bestellposition eo) {
    Bestellposition localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
