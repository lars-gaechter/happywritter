// DO NOT EDIT.  Make changes to Artikel.java instead.
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
public abstract class _Artikel extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Artikel";

  // Attribute Keys
  public static final ERXKey<String> BEZEICHNUNG = new ERXKey<String>("bezeichnung", Type.Attribute);
  public static final ERXKey<java.math.BigDecimal> PREIS = new ERXKey<java.math.BigDecimal>("preis", Type.Attribute);

  // Relationship Keys
  public static final ERXKey<ch.lars.your.app.eomodel.BestellPosition> BESTELL_POSITIONS = new ERXKey<ch.lars.your.app.eomodel.BestellPosition>("bestellPositions", Type.ToManyRelationship);
  public static final ERXKey<ch.lars.your.app.eomodel.Inhalt> INHALTS = new ERXKey<ch.lars.your.app.eomodel.Inhalt>("inhalts", Type.ToManyRelationship);

  // Attributes
  public static final String BEZEICHNUNG_KEY = BEZEICHNUNG.key();
  public static final String PREIS_KEY = PREIS.key();

  // Relationships
  public static final String BESTELL_POSITIONS_KEY = BESTELL_POSITIONS.key();
  public static final String INHALTS_KEY = INHALTS.key();

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

  public java.math.BigDecimal preis() {
    return (java.math.BigDecimal) storedValueForKey(_Artikel.PREIS_KEY);
  }

  public void setPreis(java.math.BigDecimal value) {
    log.debug( "updating preis from {} to {}", preis(), value);
    takeStoredValueForKey(value, _Artikel.PREIS_KEY);
  }

  public NSArray<ch.lars.your.app.eomodel.BestellPosition> bestellPositions() {
    return (NSArray<ch.lars.your.app.eomodel.BestellPosition>)storedValueForKey(_Artikel.BESTELL_POSITIONS_KEY);
  }

  public NSArray<ch.lars.your.app.eomodel.BestellPosition> bestellPositions(EOQualifier qualifier) {
    return bestellPositions(qualifier, null, false);
  }

  public NSArray<ch.lars.your.app.eomodel.BestellPosition> bestellPositions(EOQualifier qualifier, boolean fetch) {
    return bestellPositions(qualifier, null, fetch);
  }

  public NSArray<ch.lars.your.app.eomodel.BestellPosition> bestellPositions(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<ch.lars.your.app.eomodel.BestellPosition> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(ch.lars.your.app.eomodel.BestellPosition.ARTIKEL_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = ch.lars.your.app.eomodel.BestellPosition.fetchBestellPositions(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = bestellPositions();
      if (qualifier != null) {
        results = (NSArray<ch.lars.your.app.eomodel.BestellPosition>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.lars.your.app.eomodel.BestellPosition>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToBestellPositions(ch.lars.your.app.eomodel.BestellPosition object) {
    includeObjectIntoPropertyWithKey(object, _Artikel.BESTELL_POSITIONS_KEY);
  }

  public void removeFromBestellPositions(ch.lars.your.app.eomodel.BestellPosition object) {
    excludeObjectFromPropertyWithKey(object, _Artikel.BESTELL_POSITIONS_KEY);
  }

  public void addToBestellPositionsRelationship(ch.lars.your.app.eomodel.BestellPosition object) {
    log.debug("adding {} to bestellPositions relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToBestellPositions(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Artikel.BESTELL_POSITIONS_KEY);
    }
  }

  public void removeFromBestellPositionsRelationship(ch.lars.your.app.eomodel.BestellPosition object) {
    log.debug("removing {} from bestellPositions relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromBestellPositions(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Artikel.BESTELL_POSITIONS_KEY);
    }
  }

  public ch.lars.your.app.eomodel.BestellPosition createBestellPositionsRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.lars.your.app.eomodel.BestellPosition.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Artikel.BESTELL_POSITIONS_KEY);
    return (ch.lars.your.app.eomodel.BestellPosition) eo;
  }

  public void deleteBestellPositionsRelationship(ch.lars.your.app.eomodel.BestellPosition object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Artikel.BESTELL_POSITIONS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllBestellPositionsRelationships() {
    Enumeration<ch.lars.your.app.eomodel.BestellPosition> objects = bestellPositions().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteBestellPositionsRelationship(objects.nextElement());
    }
  }

  public NSArray<ch.lars.your.app.eomodel.Inhalt> inhalts() {
    return (NSArray<ch.lars.your.app.eomodel.Inhalt>)storedValueForKey(_Artikel.INHALTS_KEY);
  }

  public NSArray<ch.lars.your.app.eomodel.Inhalt> inhalts(EOQualifier qualifier) {
    return inhalts(qualifier, null);
  }

  public NSArray<ch.lars.your.app.eomodel.Inhalt> inhalts(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<ch.lars.your.app.eomodel.Inhalt> results;
      results = inhalts();
      if (qualifier != null) {
        results = (NSArray<ch.lars.your.app.eomodel.Inhalt>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<ch.lars.your.app.eomodel.Inhalt>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }

  public void addToInhalts(ch.lars.your.app.eomodel.Inhalt object) {
    includeObjectIntoPropertyWithKey(object, _Artikel.INHALTS_KEY);
  }

  public void removeFromInhalts(ch.lars.your.app.eomodel.Inhalt object) {
    excludeObjectFromPropertyWithKey(object, _Artikel.INHALTS_KEY);
  }

  public void addToInhaltsRelationship(ch.lars.your.app.eomodel.Inhalt object) {
    log.debug("adding {} to inhalts relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToInhalts(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Artikel.INHALTS_KEY);
    }
  }

  public void removeFromInhaltsRelationship(ch.lars.your.app.eomodel.Inhalt object) {
    log.debug("removing {} from inhalts relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromInhalts(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Artikel.INHALTS_KEY);
    }
  }

  public ch.lars.your.app.eomodel.Inhalt createInhaltsRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  ch.lars.your.app.eomodel.Inhalt.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Artikel.INHALTS_KEY);
    return (ch.lars.your.app.eomodel.Inhalt) eo;
  }

  public void deleteInhaltsRelationship(ch.lars.your.app.eomodel.Inhalt object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Artikel.INHALTS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllInhaltsRelationships() {
    Enumeration<ch.lars.your.app.eomodel.Inhalt> objects = inhalts().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteInhaltsRelationship(objects.nextElement());
    }
  }


  public static Artikel createArtikel(EOEditingContext editingContext, String bezeichnung
) {
    Artikel eo = (Artikel) EOUtilities.createAndInsertInstance(editingContext, _Artikel.ENTITY_NAME);
    eo.setBezeichnung(bezeichnung);
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
