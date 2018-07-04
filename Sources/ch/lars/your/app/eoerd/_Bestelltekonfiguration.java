// DO NOT EDIT.  Make changes to Bestelltekonfiguration.java instead.
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
public abstract class _Bestelltekonfiguration extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Bestelltekonfiguration";

  // Attribute Keys

  // Relationship Keys
  public static final ERXKey<ch.lars.your.app.eoerd.Bestellposition> BESTELLPOSITION = new ERXKey<ch.lars.your.app.eoerd.Bestellposition>("bestellposition", Type.ToOneRelationship);
  public static final ERXKey<ch.lars.your.app.eoerd.Inhalt> INHALT = new ERXKey<ch.lars.your.app.eoerd.Inhalt>("inhalt", Type.ToOneRelationship);

  // Attributes

  // Relationships
  public static final String BESTELLPOSITION_KEY = BESTELLPOSITION.key();
  public static final String INHALT_KEY = INHALT.key();

  private static final Logger log = LoggerFactory.getLogger(_Bestelltekonfiguration.class);

  public Bestelltekonfiguration localInstanceIn(EOEditingContext editingContext) {
    Bestelltekonfiguration localInstance = (Bestelltekonfiguration)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public ch.lars.your.app.eoerd.Bestellposition bestellposition() {
    return (ch.lars.your.app.eoerd.Bestellposition)storedValueForKey(_Bestelltekonfiguration.BESTELLPOSITION_KEY);
  }

  public void setBestellposition(ch.lars.your.app.eoerd.Bestellposition value) {
    takeStoredValueForKey(value, _Bestelltekonfiguration.BESTELLPOSITION_KEY);
  }

  public void setBestellpositionRelationship(ch.lars.your.app.eoerd.Bestellposition value) {
    log.debug("updating bestellposition from {} to {}", bestellposition(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setBestellposition(value);
    }
    else if (value == null) {
      ch.lars.your.app.eoerd.Bestellposition oldValue = bestellposition();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Bestelltekonfiguration.BESTELLPOSITION_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Bestelltekonfiguration.BESTELLPOSITION_KEY);
    }
  }

  public ch.lars.your.app.eoerd.Inhalt inhalt() {
    return (ch.lars.your.app.eoerd.Inhalt)storedValueForKey(_Bestelltekonfiguration.INHALT_KEY);
  }

  public void setInhalt(ch.lars.your.app.eoerd.Inhalt value) {
    takeStoredValueForKey(value, _Bestelltekonfiguration.INHALT_KEY);
  }

  public void setInhaltRelationship(ch.lars.your.app.eoerd.Inhalt value) {
    log.debug("updating inhalt from {} to {}", inhalt(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setInhalt(value);
    }
    else if (value == null) {
      ch.lars.your.app.eoerd.Inhalt oldValue = inhalt();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Bestelltekonfiguration.INHALT_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Bestelltekonfiguration.INHALT_KEY);
    }
  }


  public static Bestelltekonfiguration createBestelltekonfiguration(EOEditingContext editingContext) {
    Bestelltekonfiguration eo = (Bestelltekonfiguration) EOUtilities.createAndInsertInstance(editingContext, _Bestelltekonfiguration.ENTITY_NAME);
    return eo;
  }

  public static ERXFetchSpecification<Bestelltekonfiguration> fetchSpec() {
    return new ERXFetchSpecification<Bestelltekonfiguration>(_Bestelltekonfiguration.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Bestelltekonfiguration> fetchAllBestelltekonfigurations(EOEditingContext editingContext) {
    return _Bestelltekonfiguration.fetchAllBestelltekonfigurations(editingContext, null);
  }

  public static NSArray<Bestelltekonfiguration> fetchAllBestelltekonfigurations(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Bestelltekonfiguration.fetchBestelltekonfigurations(editingContext, null, sortOrderings);
  }

  public static NSArray<Bestelltekonfiguration> fetchBestelltekonfigurations(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Bestelltekonfiguration> fetchSpec = new ERXFetchSpecification<Bestelltekonfiguration>(_Bestelltekonfiguration.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Bestelltekonfiguration> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Bestelltekonfiguration fetchBestelltekonfiguration(EOEditingContext editingContext, String keyName, Object value) {
    return _Bestelltekonfiguration.fetchBestelltekonfiguration(editingContext, ERXQ.equals(keyName, value));
  }

  public static Bestelltekonfiguration fetchBestelltekonfiguration(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Bestelltekonfiguration> eoObjects = _Bestelltekonfiguration.fetchBestelltekonfigurations(editingContext, qualifier, null);
    Bestelltekonfiguration eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Bestelltekonfiguration that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Bestelltekonfiguration fetchRequiredBestelltekonfiguration(EOEditingContext editingContext, String keyName, Object value) {
    return _Bestelltekonfiguration.fetchRequiredBestelltekonfiguration(editingContext, ERXQ.equals(keyName, value));
  }

  public static Bestelltekonfiguration fetchRequiredBestelltekonfiguration(EOEditingContext editingContext, EOQualifier qualifier) {
    Bestelltekonfiguration eoObject = _Bestelltekonfiguration.fetchBestelltekonfiguration(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Bestelltekonfiguration that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Bestelltekonfiguration localInstanceIn(EOEditingContext editingContext, Bestelltekonfiguration eo) {
    Bestelltekonfiguration localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
