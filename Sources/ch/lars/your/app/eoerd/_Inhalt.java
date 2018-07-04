// DO NOT EDIT.  Make changes to Inhalt.java instead.
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
public abstract class _Inhalt extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Inhalt";

  // Attribute Keys
  public static final ERXKey<String> NAME = new ERXKey<String>("name", Type.Attribute);
  public static final ERXKey<Double> PREIS = new ERXKey<Double>("preis", Type.Attribute);

  // Relationship Keys
  public static final ERXKey<ch.lars.your.app.eoerd.Bestelltekonfiguration> BESTELLTEKONFIGURATIONS = new ERXKey<ch.lars.your.app.eoerd.Bestelltekonfiguration>("bestelltekonfigurations", Type.ToManyRelationship);
  public static final ERXKey<ch.lars.your.app.eoerd.Konfiguration> KONFIGURATIONS = new ERXKey<ch.lars.your.app.eoerd.Konfiguration>("konfigurations", Type.ToManyRelationship);

  // Attributes
  public static final String NAME_KEY = NAME.key();
  public static final String PREIS_KEY = PREIS.key();

  // Relationships
  public static final String BESTELLTEKONFIGURATIONS_KEY = BESTELLTEKONFIGURATIONS.key();
  public static final String KONFIGURATIONS_KEY = KONFIGURATIONS.key();

  private static final Logger log = LoggerFactory.getLogger(_Inhalt.class);

  public Inhalt localInstanceIn(EOEditingContext editingContext) {
    Inhalt localInstance = (Inhalt)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String name() {
    return (String) storedValueForKey(_Inhalt.NAME_KEY);
  }

  public void setName(String value) {
    log.debug( "updating name from {} to {}", name(), value);
    takeStoredValueForKey(value, _Inhalt.NAME_KEY);
  }

  public Double preis() {
    return (Double) storedValueForKey(_Inhalt.PREIS_KEY);
  }

  public void setPreis(Double value) {
    log.debug( "updating preis from {} to {}", preis(), value);
    takeStoredValueForKey(value, _Inhalt.PREIS_KEY);
  }

  public NSArray<ch.lars.your.app.eoerd.Bestelltekonfiguration> bestelltekonfigurations() {
    return (NSArray<ch.lars.your.app.eoerd.Bestelltekonfiguration>)storedValueForKey(_Inhalt.BESTELLTEKONFIGURATIONS_KEY);
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
      EOQualifier inverseQualifier = ERXQ.equals(ch.lars.your.app.eoerd.Bestelltekonfiguration.INHALT_KEY, this);

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
    includeObjectIntoPropertyWithKey(object, _Inhalt.BESTELLTEKONFIGURATIONS_KEY);
  }

  public void removeFromBestelltekonfigurations(ch.lars.your.app.eoerd.Bestelltekonfiguration object) {
    excludeObjectFromPropertyWithKey(object, _Inhalt.BESTELLTEKONFIGURATIONS_KEY);
  }

  public void addToBestelltekonfigurationsRelationship(ch.lars.your.app.eoerd.Bestelltekonfiguration object) {
    log.debug("adding {} to bestelltekonfigurations relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToBestelltekonfigurations(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Inhalt.BESTELLTEKONFIGURATIONS_KEY);
    }
  }

  public void removeFromBestelltekonfigurationsRelationship(ch.lars.your.app.eoerd.Bestelltekonfiguration object) {
    log.debug("removing {} from bestelltekonfigurations relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromBestelltekonfigurations(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Inhalt.BESTELLTEKONFIGURATIONS_KEY);
    }
  }

  public ch.lars.your.app.eoerd.Bestelltekonfiguration createBestelltekonfigurationsRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.lars.your.app.eoerd.Bestelltekonfiguration.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Inhalt.BESTELLTEKONFIGURATIONS_KEY);
    return (ch.lars.your.app.eoerd.Bestelltekonfiguration) eo;
  }

  public void deleteBestelltekonfigurationsRelationship(ch.lars.your.app.eoerd.Bestelltekonfiguration object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Inhalt.BESTELLTEKONFIGURATIONS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllBestelltekonfigurationsRelationships() {
    Enumeration<ch.lars.your.app.eoerd.Bestelltekonfiguration> objects = bestelltekonfigurations().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteBestelltekonfigurationsRelationship(objects.nextElement());
    }
  }

  public NSArray<ch.lars.your.app.eoerd.Konfiguration> konfigurations() {
    return (NSArray<ch.lars.your.app.eoerd.Konfiguration>)storedValueForKey(_Inhalt.KONFIGURATIONS_KEY);
  }

  public NSArray<ch.lars.your.app.eoerd.Konfiguration> konfigurations(EOQualifier qualifier) {
    return konfigurations(qualifier, null, false);
  }

  public NSArray<ch.lars.your.app.eoerd.Konfiguration> konfigurations(EOQualifier qualifier, boolean fetch) {
    return konfigurations(qualifier, null, fetch);
  }

  public NSArray<ch.lars.your.app.eoerd.Konfiguration> konfigurations(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<ch.lars.your.app.eoerd.Konfiguration> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(ch.lars.your.app.eoerd.Konfiguration.INHALT_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = ch.lars.your.app.eoerd.Konfiguration.fetchKonfigurations(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = konfigurations();
      if (qualifier != null) {
        results = (NSArray<ch.lars.your.app.eoerd.Konfiguration>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.lars.your.app.eoerd.Konfiguration>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToKonfigurations(ch.lars.your.app.eoerd.Konfiguration object) {
    includeObjectIntoPropertyWithKey(object, _Inhalt.KONFIGURATIONS_KEY);
  }

  public void removeFromKonfigurations(ch.lars.your.app.eoerd.Konfiguration object) {
    excludeObjectFromPropertyWithKey(object, _Inhalt.KONFIGURATIONS_KEY);
  }

  public void addToKonfigurationsRelationship(ch.lars.your.app.eoerd.Konfiguration object) {
    log.debug("adding {} to konfigurations relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToKonfigurations(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Inhalt.KONFIGURATIONS_KEY);
    }
  }

  public void removeFromKonfigurationsRelationship(ch.lars.your.app.eoerd.Konfiguration object) {
    log.debug("removing {} from konfigurations relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromKonfigurations(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Inhalt.KONFIGURATIONS_KEY);
    }
  }

  public ch.lars.your.app.eoerd.Konfiguration createKonfigurationsRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.lars.your.app.eoerd.Konfiguration.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Inhalt.KONFIGURATIONS_KEY);
    return (ch.lars.your.app.eoerd.Konfiguration) eo;
  }

  public void deleteKonfigurationsRelationship(ch.lars.your.app.eoerd.Konfiguration object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Inhalt.KONFIGURATIONS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllKonfigurationsRelationships() {
    Enumeration<ch.lars.your.app.eoerd.Konfiguration> objects = konfigurations().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteKonfigurationsRelationship(objects.nextElement());
    }
  }


  public static Inhalt createInhalt(EOEditingContext editingContext, Double preis
) {
    Inhalt eo = (Inhalt) EOUtilities.createAndInsertInstance(editingContext, _Inhalt.ENTITY_NAME);
    eo.setPreis(preis);
    return eo;
  }

  public static ERXFetchSpecification<Inhalt> fetchSpec() {
    return new ERXFetchSpecification<Inhalt>(_Inhalt.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Inhalt> fetchAllInhalts(EOEditingContext editingContext) {
    return _Inhalt.fetchAllInhalts(editingContext, null);
  }

  public static NSArray<Inhalt> fetchAllInhalts(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Inhalt.fetchInhalts(editingContext, null, sortOrderings);
  }

  public static NSArray<Inhalt> fetchInhalts(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Inhalt> fetchSpec = new ERXFetchSpecification<Inhalt>(_Inhalt.ENTITY_NAME, qualifier, sortOrderings);
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
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Inhalt that matched the qualifier '" + qualifier + "'.");
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
