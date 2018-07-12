-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server Version:               10.1.33-MariaDB - mariadb.org binary distribution
-- Server Betriebssystem:        Win32
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Exportiere Datenbank Struktur für newhappywritter
DROP DATABASE IF EXISTS `newhappywritter`;
CREATE DATABASE IF NOT EXISTS `newhappywritter` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_german2_ci */;
USE `newhappywritter`;

-- Exportiere Struktur von Tabelle newhappywritter.artikel
CREATE TABLE IF NOT EXISTS `artikel` (
  `bezeichnung` varchar(50) NOT NULL,
  `id` int(11) NOT NULL,
  `preis` decimal(38,4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle newhappywritter.artikel: ~2 rows (ungefähr)
/*!40000 ALTER TABLE `artikel` DISABLE KEYS */;
INSERT INTO `artikel` (`bezeichnung`, `id`, `preis`) VALUES
	('Etui', 1, 15.5000),
	('Schachtel', 2, 33.9000);
/*!40000 ALTER TABLE `artikel` ENABLE KEYS */;

-- Exportiere Struktur von Tabelle newhappywritter.bestellposition
CREATE TABLE IF NOT EXISTS `bestellposition` (
  `artikelID` int(11) DEFAULT NULL,
  `bestellungID` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bestellposition_artikel` (`artikelID`),
  KEY `FK_bestellposition_bestellung` (`bestellungID`),
  CONSTRAINT `FK_bestellposition_artikel` FOREIGN KEY (`artikelID`) REFERENCES `artikel` (`id`),
  CONSTRAINT `FK_bestellposition_bestellung` FOREIGN KEY (`bestellungID`) REFERENCES `bestellung` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle newhappywritter.bestellposition: ~5 rows (ungefähr)
/*!40000 ALTER TABLE `bestellposition` DISABLE KEYS */;
/*!40000 ALTER TABLE `bestellposition` ENABLE KEYS */;

-- Exportiere Struktur von Tabelle newhappywritter.bestelltekonfiguration
CREATE TABLE IF NOT EXISTS `bestelltekonfiguration` (
  `bestellPositionId` int(11) NOT NULL,
  `inhaltId` int(11) NOT NULL,
  PRIMARY KEY (`bestellPositionId`,`inhaltId`),
  KEY `FK_bestelltekonfiguration_inhalt` (`inhaltId`),
  CONSTRAINT `FK_bestelltekonfiguration_bestellposition` FOREIGN KEY (`bestellPositionId`) REFERENCES `bestellposition` (`id`),
  CONSTRAINT `FK_bestelltekonfiguration_inhalt` FOREIGN KEY (`inhaltId`) REFERENCES `inhalt` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle newhappywritter.bestelltekonfiguration: ~6 rows (ungefähr)
/*!40000 ALTER TABLE `bestelltekonfiguration` DISABLE KEYS */;
/*!40000 ALTER TABLE `bestelltekonfiguration` ENABLE KEYS */;

-- Exportiere Struktur von Tabelle newhappywritter.bestellung
CREATE TABLE IF NOT EXISTS `bestellung` (
  `bemerkungen` varchar(50) NOT NULL,
  `datum` date NOT NULL,
  `id` int(11) NOT NULL,
  `kundeID` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_bestellung_kunde` (`kundeID`),
  CONSTRAINT `FK_bestellung_kunde` FOREIGN KEY (`kundeID`) REFERENCES `kunde` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle newhappywritter.bestellung: ~5 rows (ungefähr)
/*!40000 ALTER TABLE `bestellung` DISABLE KEYS */;
/*!40000 ALTER TABLE `bestellung` ENABLE KEYS */;

-- Exportiere Struktur von Tabelle newhappywritter.eo_pk_table
CREATE TABLE IF NOT EXISTS `eo_pk_table` (
  `NAME` char(40) NOT NULL,
  `PK` int(11) DEFAULT NULL,
  PRIMARY KEY (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle newhappywritter.eo_pk_table: ~4 rows (ungefähr)
/*!40000 ALTER TABLE `eo_pk_table` DISABLE KEYS */;
INSERT INTO `eo_pk_table` (`NAME`, `PK`) VALUES
	('BestellPosition', 24),
	('Bestellung', 21),
	('Inhalt', 14),
	('Kunde', 21);
/*!40000 ALTER TABLE `eo_pk_table` ENABLE KEYS */;

-- Exportiere Struktur von Tabelle newhappywritter.inhalt
CREATE TABLE IF NOT EXISTS `inhalt` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `preis` decimal(38,4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle newhappywritter.inhalt: ~14 rows (ungefähr)
/*!40000 ALTER TABLE `inhalt` DISABLE KEYS */;
INSERT INTO `inhalt` (`id`, `name`, `preis`) VALUES
	(1, 'Schere', 5.5000),
	(2, 'Schere', 1111.1111),
	(3, 'Schere', 1111.1111),
	(4, 'Schere', 1111.1111),
	(6, 'Schere', 1111.1111);
/*!40000 ALTER TABLE `inhalt` ENABLE KEYS */;

-- Exportiere Struktur von Tabelle newhappywritter.konfiguration
CREATE TABLE IF NOT EXISTS `konfiguration` (
  `artikelId` int(11) DEFAULT NULL,
  `inhaltId` int(11) DEFAULT NULL,
  UNIQUE KEY `artikelId_inhaltId` (`artikelId`,`inhaltId`),
  KEY `inhaltId` (`inhaltId`),
  KEY `artikelId` (`artikelId`),
  CONSTRAINT `FK_konfiguration_artikel` FOREIGN KEY (`artikelId`) REFERENCES `artikel` (`id`),
  CONSTRAINT `FK_konfiguration_inhalt` FOREIGN KEY (`inhaltId`) REFERENCES `inhalt` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle newhappywritter.konfiguration: ~3 rows (ungefähr)
/*!40000 ALTER TABLE `konfiguration` DISABLE KEYS */;
INSERT INTO `konfiguration` (`artikelId`, `inhaltId`) VALUES
	(1, 2),
	(1, 6),
	(2, 4);
/*!40000 ALTER TABLE `konfiguration` ENABLE KEYS */;

-- Exportiere Struktur von Tabelle newhappywritter.kunde
CREATE TABLE IF NOT EXISTS `kunde` (
  `id` int(11) NOT NULL,
  `kundeseit` date NOT NULL,
  `nachname` varchar(50) DEFAULT NULL,
  `ort` varchar(50) DEFAULT NULL,
  `plz` varchar(50) DEFAULT NULL,
  `strasse` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `vorname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportiere Daten aus Tabelle newhappywritter.kunde: ~5 rows (ungefähr)
/*!40000 ALTER TABLE `kunde` DISABLE KEYS */;
/*!40000 ALTER TABLE `kunde` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
