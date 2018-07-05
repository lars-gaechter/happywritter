// DO NOT EDIT.  Make changes to Konfiguration.java instead.
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
public abstract class _Konfiguration extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Konfiguration";

  // Attribute Keys
  public static final ERXKey<Integer> ARTIKEL_ID = new ERXKey<Integer>("artikelId", Type.Attribute);
  public static final ERXKey<Integer> INHALT_ID = new ERXKey<Integer>("inhaltId", Type.Attribute);

  // Relationship Keys

  // Attributes
  public static final String ARTIKEL_ID_KEY = ARTIKEL_ID.key();
  public static final String INHALT_ID_KEY = INHALT_ID.key();

  // Relationships

  private static final Logger log = LoggerFactory.getLogger(_Konfiguration.class);

  public Konfiguration localInstanceIn(EOEditingContext editingContext) {
    Konfiguration localInstance = (Konfiguration)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer artikelId() {
    return (Integer) storedValueForKey(_Konfiguration.ARTIKEL_ID_KEY);
  }

  public void setArtikelId(Integer value) {
    log.debug( "updating artikelId from {} to {}", artikelId(), value);
    takeStoredValueForKey(value, _Konfiguration.ARTIKEL_ID_KEY);
  }

  public Integer inhaltId() {
    return (Integer) storedValueForKey(_Konfiguration.INHALT_ID_KEY);
  }

  public void setInhaltId(Integer value) {
    log.debug( "updating inhaltId from {} to {}", inhaltId(), value);
    takeStoredValueForKey(value, _Konfiguration.INHALT_ID_KEY);
  }


  public static Konfiguration createKonfiguration(EOEditingContext editingContext, Integer artikelId
, Integer inhaltId
) {
    Konfiguration eo = (Konfiguration) EOUtilities.createAndInsertInstance(editingContext, _Konfiguration.ENTITY_NAME);
    eo.setArtikelId(artikelId);
    eo.setInhaltId(inhaltId);
    return eo;
  }

  public static ERXFetchSpecification<Konfiguration> fetchSpec() {
    return new ERXFetchSpecification<Konfiguration>(_Konfiguration.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Konfiguration> fetchAllKonfigurations(EOEditingContext editingContext) {
    return _Konfiguration.fetchAllKonfigurations(editingContext, null);
  }

  public static NSArray<Konfiguration> fetchAllKonfigurations(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Konfiguration.fetchKonfigurations(editingContext, null, sortOrderings);
  }

  public static NSArray<Konfiguration> fetchKonfigurations(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Konfiguration> fetchSpec = new ERXFetchSpecification<Konfiguration>(_Konfiguration.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Konfiguration> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Konfiguration fetchKonfiguration(EOEditingContext editingContext, String keyName, Object value) {
    return _Konfiguration.fetchKonfiguration(editingContext, ERXQ.equals(keyName, value));
  }

  public static Konfiguration fetchKonfiguration(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Konfiguration> eoObjects = _Konfiguration.fetchKonfigurations(editingContext, qualifier, null);
    Konfiguration eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Konfiguration that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Konfiguration fetchRequiredKonfiguration(EOEditingContext editingContext, String keyName, Object value) {
    return _Konfiguration.fetchRequiredKonfiguration(editingContext, ERXQ.equals(keyName, value));
  }

  public static Konfiguration fetchRequiredKonfiguration(EOEditingContext editingContext, EOQualifier qualifier) {
    Konfiguration eoObject = _Konfiguration.fetchKonfiguration(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Konfiguration that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Konfiguration localInstanceIn(EOEditingContext editingContext, Konfiguration eo) {
    Konfiguration localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
