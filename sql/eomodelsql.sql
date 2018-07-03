USE eomodelhappywritter;

DROP TABLE EO_PK_TABLE CASCADE;

DROP TABLE artikel CASCADE;

DROP TABLE bestellposition CASCADE;

DROP TABLE bestelltekonfiguration CASCADE;

DROP TABLE bestellung CASCADE;

DROP TABLE inhalt CASCADE;

DROP TABLE konfiguration CASCADE;

DROP TABLE kunde CASCADE;

CREATE TABLE artikel (bezeichnung VARCHAR(45), id INT(10) NOT NULL, preis INT(10));

CREATE TABLE bestellposition (Artikel_id INT(10) NOT NULL, Bestellung_id INT(10) NOT NULL, id INT(10) NOT NULL);

CREATE TABLE bestelltekonfiguration (BestellPosition_id INT(10) NOT NULL, Inhalt_id INT(10) NOT NULL);

CREATE TABLE bestellung (bemerkungen VARCHAR(255) NOT NULL, datum TIMESTAMP, id INT(10) NOT NULL, Kunde_id INT(10) NOT NULL);

CREATE TABLE inhalt (id INT(10) NOT NULL, name VARCHAR(45), preis INT(10));

CREATE TABLE konfiguration (Artikel_id INT(10) NOT NULL, Inhalt_id INT(10) NOT NULL);

CREATE TABLE kunde (id INT(10) NOT NULL, kundeSeit TIMESTAMP, nachname VARCHAR(45), ort VARCHAR(45), plz VARCHAR(45), strasse VARCHAR(45), tel VARCHAR(45), vorname VARCHAR(45));

CREATE TABLE EO_PK_TABLE (NAME CHAR(40) PRIMARY KEY, PK INT);

ALTER TABLE artikel ADD PRIMARY KEY (id);

ALTER TABLE bestellposition ADD PRIMARY KEY (Artikel_id, Bestellung_id, id);

ALTER TABLE bestelltekonfiguration ADD PRIMARY KEY (BestellPosition_id, Inhalt_id);

ALTER TABLE bestellung ADD PRIMARY KEY (id, Kunde_id);

ALTER TABLE inhalt ADD PRIMARY KEY (id);

ALTER TABLE konfiguration ADD PRIMARY KEY (Artikel_id, Inhalt_id);

ALTER TABLE kunde ADD PRIMARY KEY (id);

