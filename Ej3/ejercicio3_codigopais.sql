CREATE DATABASE  IF NOT EXISTS `ejercicio3` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ejercicio3`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ejercicio3
-- ------------------------------------------------------
-- Server version	5.6.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `codigopais`
--

DROP TABLE IF EXISTS `codigopais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `codigopais` (
  `CodigoPais` char(3) NOT NULL DEFAULT '',
  `Nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CodigoPais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codigopais`
--

LOCK TABLES `codigopais` WRITE;
/*!40000 ALTER TABLE `codigopais` DISABLE KEYS */;
INSERT INTO `codigopais` VALUES ('ABW','Aruba'),('AFG','Afghanistan'),('AGO','Angola'),('AIA','Anguilla'),('ALA','Åland Islands'),('ALB','Albania'),('AND','Andorra'),('ARE','United Arab Emirates'),('ARG','Argentina'),('ARM','Armenia'),('ASM','American Samoa'),('ATA','Antarctica'),('ATF','French Southern Territories'),('ATG','Antigua and Barbuda'),('AUS','Australia'),('AUT','Austria'),('AZE','Azerbaijan'),('BDI','Burundi'),('BEL','Belgium'),('BEN','Benin'),('BES','Bonaire, Sint Eustatius and Saba'),('BFA','Burkina Faso'),('BGD','Bangladesh'),('BGR','Bulgaria'),('BHR','Bahrain'),('BHS','Bahamas'),('BIH','Bosnia and Herzegovina'),('BLM','Saint Barthélemy'),('BLR','Belarus'),('BLZ','Belize'),('BMU','Bermuda'),('BOL','Bolivia, Plurinational State of'),('BRA','Brazil'),('BRB','Barbados'),('BRN','Brunei Darussalam'),('BTN','Bhutan'),('BVT','Bouvet Island'),('BWA','Botswana'),('CAF','Central African Republic'),('CAN','Canada'),('CCK','Cocos (Keeling) Islands'),('CHE','Switzerland'),('CHL','Chile'),('CHN','China'),('CIV','Côte d\'Ivoire'),('CMR','Cameroon'),('COD','Congo, the Democratic Republic of the'),('COG','Congo'),('COK','Cook Islands'),('COL','Colombia'),('COM','Comoros'),('CPV','Cape Verde'),('CRI','Costa Rica'),('CUB','Cuba'),('CUW','Curaçao'),('CXR','Christmas Island'),('CYM','Cayman Islands'),('CYP','Cyprus'),('CZE','Czech Republic'),('DEU','Germany'),('DJI','Djibouti'),('DMA','Dominica'),('DNK','Denmark'),('DOM','Dominican Republic'),('DZA','Algeria'),('ECU','Ecuador'),('EGY','Egypt'),('ERI','Eritrea'),('ESH','Western Sahara'),('ESP','Spain'),('EST','Estonia'),('ETH','Ethiopia'),('FIN','Finland'),('FJI','Fiji'),('FLK','Falkland Islands (Malvinas)'),('FRA','France'),('FRO','Faroe Islands'),('FSM','Micronesia, Federated States of'),('GAB','Gabon'),('GBR','United Kingdom'),('GEO','Georgia'),('GGY','Guernsey'),('GHA','Ghana'),('GIB','Gibraltar'),('GIN','Guinea'),('GLP','Guadeloupe'),('GMB','Gambia'),('GNB','Guinea-Bissau'),('GNQ','Equatorial Guinea'),('GRC','Greece'),('GRD','Grenada'),('GRL','Greenland'),('GTM','Guatemala'),('GUF','French Guiana'),('GUM','Guam'),('GUY','Guyana'),('HKG','Hong Kong'),('HMD','Heard Island and McDonald Mcdonald Islands'),('HND','Honduras'),('HRV','Croatia'),('HTI','Haiti'),('HUN','Hungary'),('IDN','Indonesia'),('IMN','Isle of Man'),('IND','India'),('IOT','British Indian Ocean Territory'),('IRL','Ireland'),('IRN','Iran, Islamic Republic of'),('IRQ','Iraq'),('ISL','Iceland'),('ISR','Israel'),('ITA','Italy'),('JAM','Jamaica'),('JEY','Jersey'),('JOR','Jordan'),('JPN','Japan'),('KAZ','Kazakhstan'),('KEN','Kenya'),('KGZ','Kyrgyzstan'),('KHM','Cambodia'),('KIR','Kiribati'),('KNA','Saint Kitts and Nevis'),('KOR','Korea, Republic of'),('KWT','Kuwait'),('LAO','Lao People\'s Democratic Republic'),('LBN','Lebanon'),('LBR','Liberia'),('LBY','Libya'),('LCA','Saint Lucia'),('LIE','Liechtenstein'),('LKA','Sri Lanka'),('LSO','Lesotho'),('LTU','Lithuania'),('LUX','Luxembourg'),('LVA','Latvia'),('MAC','Macao'),('MAF','Saint Martin (French part)'),('MAR','Morocco'),('MCO','Monaco'),('MDA','Moldova, Republic of'),('MDG','Madagascar'),('MDV','Maldives'),('MEX','Mexico'),('MHL','Marshall Islands'),('MKD','Macedonia, the Former Yugoslav Republic of'),('MLI','Mali'),('MLT','Malta'),('MMR','Myanmar'),('MNE','Montenegro'),('MNG','Mongolia'),('MNP','Northern Mariana Islands'),('MOZ','Mozambique'),('MRT','Mauritania'),('MSR','Montserrat'),('MTQ','Martinique'),('MUS','Mauritius'),('MWI','Malawi'),('MYS','Malaysia'),('MYT','Mayotte'),('NAM','Namibia'),('NCL','New Caledonia'),('NER','Niger'),('NFK','Norfolk Island'),('NGA','Nigeria'),('NIC','Nicaragua'),('NIU','Niue'),('NLD','Netherlands'),('NOR','Norway'),('NPL','Nepal'),('NRU','Nauru'),('NZL','New Zealand'),('OMN','Oman'),('PAK','Pakistan'),('PAN','Panama'),('PCN','Pitcairn'),('PER','Peru'),('PHL','Philippines'),('PLW','Palau'),('PNG','Papua New Guinea'),('POL','Poland'),('PRI','Puerto Rico'),('PRK','Korea, Democratic People\'s Republic of'),('PRT','Portugal'),('PRY','Paraguay'),('PSE','Palestine, State of'),('PYF','French Polynesia'),('QAT','Qatar'),('REU','Réunion'),('ROU','Romania'),('RUS','Russian Federation'),('RWA','Rwanda'),('SAU','Saudi Arabia'),('SDN','Sudan'),('SEN','Senegal'),('SGP','Singapore'),('SGS','South Georgia and the South Sandwich Islands'),('SHN','Saint Helena, Ascension and Tristan da Cunha'),('SJM','Svalbard and Jan Mayen'),('SLB','Solomon Islands'),('SLE','Sierra Leone'),('SLV','El Salvador'),('SMR','San Marino'),('SOM','Somalia'),('SPM','Saint Pierre and Miquelon'),('SRB','Serbia'),('SSD','South Sudan'),('STP','Sao Tome and Principe'),('SUR','Suriname'),('SVK','Slovakia'),('SVN','Slovenia'),('SWE','Sweden'),('SWZ','Swaziland'),('SXM','Sint Maarten (Dutch part)'),('SYC','Seychelles'),('SYR','Syrian Arab Republic'),('TCA','Turks and Caicos Islands'),('TCD','Chad'),('TGO','Togo'),('THA','Thailand'),('TJK','Tajikistan'),('TKL','Tokelau'),('TKM','Turkmenistan'),('TLS','Timor-Leste'),('TON','Tonga'),('TTO','Trinidad and Tobago'),('TUN','Tunisia'),('TUR','Turkey'),('TUV','Tuvalu'),('TWN','Taiwan, Province of China'),('TZA','Tanzania, United Republic of'),('UGA','Uganda'),('UKR','Ukraine'),('UMI','United States Minor Outlying Islands'),('URY','Uruguay'),('USA','United States'),('UZB','Uzbekistan'),('VAT','Holy See (Vatican City State)'),('VCT','Saint Vincent and the Grenadines'),('VEN','Venezuela, Bolivarian Republic of'),('VGB','Virgin Islands, British'),('VIR','Virgin Islands, U.S.'),('VNM','Viet Nam'),('VUT','Vanuatu'),('WLF','Wallis and Futuna'),('WSM','Samoa'),('YEM','Yemen'),('ZAF','South Africa'),('ZMB','Zambia'),('ZWE','Zimbabwe');
/*!40000 ALTER TABLE `codigopais` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-06  0:43:15
