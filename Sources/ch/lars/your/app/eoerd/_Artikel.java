// DO NOT EDIT.  Make changes to Artikel.java instead.
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
public abstract class _Artikel extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Artikel";

  // Attribute Keys
  public static final ERXKey<String> BEZEICHNUNG = new ERXKey<String>("bezeichnung", Type.Attribute);
  public static final ERXKey<Double> PREIS = new ERXKey<Double>("preis", Type.Attribute);

  // Relationship Keys
  public static final ERXKey<ch.lars.your.app.eoerd.Bestellposition> BESTELLPOSITIONS = new ERXKey<ch.lars.your.app.eoerd.Bestellposition>("bestellpositions", Type.ToManyRelationship);
  public static final ERXKey<ch.lars.your.app.eoerd.Konfiguration> KONFIGURATIONS = new ERXKey<ch.lars.your.app.eoerd.Konfiguration>("konfigurations", Type.ToManyRelationship);

  // Attributes
  public static final String BEZEICHNUNG_KEY = BEZEICHNUNG.key();
  public static final String PREIS_KEY = PREIS.key();

  // Relationships
  public static final String BESTELLPOSITIONS_KEY = BESTELLPOSITIONS.key();
  public static final String KONFIGURATIONS_KEY = KONFIGURATIONS.key();

  private static final Logger log = LoggerFactory.getLogger(_Artikel.class);

  public Artikel localInstanceIn(EOEditingContext editingContext) {
    Artikel localInstance = (Artikel)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String bezeichnung() {
    return (String) storedValueForKey(_Artikel.BEZEICHNUNG_KEY);
  }

  public void setBezeichnung(String value) {
    log.debug( "updating bezeichnung from {} to {}", bezeichnung(), value);
    takeStoredValueForKey(value, _Artikel.BEZEICHNUNG_KEY);
  }

  public Double preis() {
    return (Double) storedValueForKey(_Artikel.PREIS_KEY);
  }

  public void setPreis(Double value) {
    log.debug( "updating preis from {} to {}", preis(), value);
    takeStoredValueForKey(value, _Artikel.PREIS_KEY);
  }

  public NSArray<ch.lars.your.app.eoerd.Bestellposition> bestellpositions() {
    return (NSArray<ch.lars.your.app.eoerd.Bestellposition>)storedValueForKey(_Artikel.BESTELLPOSITIONS_KEY);
  }

  public NSArray<ch.lars.your.app.eoerd.Bestellposition> bestellpositions(EOQualifier qualifier) {
    return bestellpositions(qualifier, null, false);
  }

  public NSArray<ch.lars.your.app.eoerd.Bestellposition> bestellpositions(EOQualifier qualifier, boolean fetch) {
    return bestellpositions(qualifier, null, fetch);
  }

  public NSArray<ch.lars.your.app.eoerd.Bestellposition> bestellpositions(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<ch.lars.your.app.eoerd.Bestellposition> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(ch.lars.your.app.eoerd.Bestellposition.ARTIKEL_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = ch.lars.your.app.eoerd.Bestellposition.fetchBestellpositions(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = bestellpositions();
      if (qualifier != null) {
        results = (NSArray<ch.lars.your.app.eoerd.Bestellposition>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.lars.your.app.eoerd.Bestellposition>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToBestellpositions(ch.lars.your.app.eoerd.Bestellposition object) {
    includeObjectIntoPropertyWithKey(object, _Artikel.BESTELLPOSITIONS_KEY);
  }

  public void removeFromBestellpositions(ch.lars.your.app.eoerd.Bestellposition object) {
    excludeObjectFromPropertyWithKey(object, _Artikel.BESTELLPOSITIONS_KEY);
  }

  public void addToBestellpositionsRelationship(ch.lars.your.app.eoerd.Bestellposition object) {
    log.debug("adding {} to bestellpositions relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToBestellpositions(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Artikel.BESTELLPOSITIONS_KEY);
    }
  }

  public void removeFromBestellpositionsRelationship(ch.lars.your.app.eoerd.Bestellposition object) {
    log.debug("removing {} from bestellpositions relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromBestellpositions(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Artikel.BESTELLPOSITIONS_KEY);
    }
  }

  public ch.lars.your.app.eoerd.Bestellposition createBestellpositionsRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.lars.your.app.eoerd.Bestellposition.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Artikel.BESTELLPOSITIONS_KEY);
    return (ch.lars.your.app.eoerd.Bestellposition) eo;
  }

  public void deleteBestellpositionsRelationship(ch.lars.your.app.eoerd.Bestellposition object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Artikel.BESTELLPOSITIONS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllBestellpositionsRelationships() {
    Enumeration<ch.lars.your.app.eoerd.Bestellposition> objects = bestellpositions().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteBestellpositionsRelationship(objects.nextElement());
    }
  }

  public NSArray<ch.lars.your.app.eoerd.Konfiguration> konfigurations() {
    return (NSArray<ch.lars.your.app.eoerd.Konfiguration>)storedValueForKey(_Artikel.KONFIGURATIONS_KEY);
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
      EOQualifier inverseQualifier = ERXQ.equals(ch.lars.your.app.eoerd.Konfiguration.ARTIKEL_KEY, this);

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
    includeObjectIntoPropertyWithKey(object, _Artikel.KONFIGURATIONS_KEY);
  }

  public void removeFromKonfigurations(ch.lars.your.app.eoerd.Konfiguration object) {
    excludeObjectFromPropertyWithKey(object, _Artikel.KONFIGURATIONS_KEY);
  }

  public void addToKonfigurationsRelationship(ch.lars.your.app.eoerd.Konfiguration object) {
    log.debug("adding {} to konfigurations relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToKonfigurations(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Artikel.KONFIGURATIONS_KEY);
    }
  }

  public void removeFromKonfigurationsRelationship(ch.lars.your.app.eoerd.Konfiguration object) {
    log.debug("removing {} from konfigurations relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromKonfigurations(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Artikel.KONFIGURATIONS_KEY);
    }
  }

  public ch.lars.your.app.eoerd.Konfiguration createKonfigurationsRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.lars.your.app.eoerd.Konfiguration.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Artikel.KONFIGURATIONS_KEY);
    return (ch.lars.your.app.eoerd.Konfiguration) eo;
  }

  public void deleteKonfigurationsRelationship(ch.lars.your.app.eoerd.Konfiguration object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Artikel.KONFIGURATIONS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllKonfigurationsRelationships() {
    Enumeration<ch.lars.your.app.eoerd.Konfiguration> objects = konfigurations().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteKonfigurationsRelationship(objects.nextElement());
    }
  }


  public static Artikel createArtikel(EOEditingContext editingContext, Double preis
) {
    Artikel eo = (Artikel) EOUtilities.createAndInsertInstance(editingContext, _Artikel.ENTITY_NAME);
    eo.setPreis(preis);
    return eo;
  }

  public static ERXFetchSpecification<Artikel> fetchSpec() {
    return new ERXFetchSpecification<Artikel>(_Artikel.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Artikel> fetchAllArtikels(EOEditingContext editingContext) {
    return _Artikel.fetchAllArtikels(editingContext, null);
  }

  public static NSArray<Artikel> fetchAllArtikels(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Artikel.fetchArtikels(editingContext, null, sortOrderings);
  }

  public static NSArray<Artikel> fetchArtikels(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Artikel> fetchSpec = new ERXFetchSpecification<Artikel>(_Artikel.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Artikel> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Artikel fetchArtikel(EOEditingContext editingContext, String keyName, Object value) {
    return _Artikel.fetchArtikel(editingContext, ERXQ.equals(keyName, value));
  }

  public static Artikel fetchArtikel(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Artikel> eoObjects = _Artikel.fetchArtikels(editingContext, qualifier, null);
    Artikel eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Artikel that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Artikel fetchRequiredArtikel(EOEditingContext editingContext, String keyName, Object value) {
    return _Artikel.fetchRequiredArtikel(editingContext, ERXQ.equals(keyName, value));
  }

  public static Artikel fetchRequiredArtikel(EOEditingContext editingContext, EOQualifier qualifier) {
    Artikel eoObject = _Artikel.fetchArtikel(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Artikel that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Artikel localInstanceIn(EOEditingContext editingContext, Artikel eo) {
    Artikel localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
