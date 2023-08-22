CREATE DATABASE `video_juegos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `desarrolladora_fabricante` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `plataforma` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `id_fabricante` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_fabricante` (`id_fabricante`),
  CONSTRAINT `plataforma_ibfk_1` FOREIGN KEY (`id_fabricante`) REFERENCES `desarrolladora_fabricante` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `producto` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `precio` double NOT NULL,
  `id_desarrolladora` int unsigned NOT NULL,
  `id_plataforma` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_desarrolladora` (`id_desarrolladora`),
  KEY `id_plataforma` (`id_plataforma`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`id_desarrolladora`) REFERENCES `desarrolladora_fabricante` (`id`),
  CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`id_plataforma`) REFERENCES `plataforma` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*
-- Query: select * from desarrolladora_fabricante
LIMIT 0, 1000

-- Date: 2023-08-11 09:22
*/
INSERT INTO `desarrolladora_fabricante` VALUES (1,'Microsoft');
INSERT INTO `desarrolladora_fabricante` VALUES (2,'Nintendo');
INSERT INTO `desarrolladora_fabricante` VALUES (3,'Atlus');
INSERT INTO `desarrolladora_fabricante` VALUES (4,'Capcom');
INSERT INTO `desarrolladora_fabricante` VALUES (5,'Insomniac');
INSERT INTO `desarrolladora_fabricante` VALUES (6,'Rockstar');
INSERT INTO `desarrolladora_fabricante` VALUES (7,'Bandai_namco');
INSERT INTO `desarrolladora_fabricante` VALUES (8,'sony');
INSERT INTO `desarrolladora_fabricante` VALUES (9,'gamefreak');
INSERT INTO `desarrolladora_fabricante` VALUES (10,'343 industries');
INSERT INTO `desarrolladora_fabricante` VALUES (11,'mercury steam');
INSERT INTO `desarrolladora_fabricante` VALUES (12,'rare');
INSERT INTO `desarrolladora_fabricante` VALUES (13,'playground games');
INSERT INTO `desarrolladora_fabricante` VALUES (14,'the coalition');
INSERT INTO `desarrolladora_fabricante` VALUES (15,'falcom');
INSERT INTO `desarrolladora_fabricante` VALUES (16,'netherrealm studios');
INSERT INTO `desarrolladora_fabricante` VALUES (17,'hal laboratory');
INSERT INTO `desarrolladora_fabricante` VALUES (18,'retro studios');
INSERT INTO `desarrolladora_fabricante` VALUES (19,'nippon ichi software');
INSERT INTO `desarrolladora_fabricante` VALUES (20,'square enix');
INSERT INTO `desarrolladora_fabricante` VALUES (21,'from software');
INSERT INTO `desarrolladora_fabricante` VALUES (22,'platinum games');
INSERT INTO `desarrolladora_fabricante` VALUES (23,'electronic arts');
INSERT INTO `desarrolladora_fabricante` VALUES (24,'bethesda');
INSERT INTO `desarrolladora_fabricante` VALUES (25,'activision blizzard');
INSERT INTO `desarrolladora_fabricante` VALUES (26,'id software');
INSERT INTO `desarrolladora_fabricante` VALUES (27,'naughty dog');
INSERT INTO `desarrolladora_fabricante` VALUES (28,'sega');
INSERT INTO `desarrolladora_fabricante` VALUES (29,'level 5');
INSERT INTO `desarrolladora_fabricante` VALUES (30,'intelligent systems');
INSERT INTO `desarrolladora_fabricante` VALUES (31,'ubisoft');
INSERT INTO `desarrolladora_fabricante` VALUES (32,'monolith soft');
INSERT INTO `desarrolladora_fabricante` VALUES (33,'respawn entertaintment');
INSERT INTO `desarrolladora_fabricante` VALUES (34,'cd project red');
INSERT INTO `desarrolladora_fabricante` VALUES (35,'bioware');
INSERT INTO `desarrolladora_fabricante` VALUES (36,'rocksteady');
INSERT INTO `desarrolladora_fabricante` VALUES (37,'valve');
INSERT INTO `desarrolladora_fabricante` VALUES (38,'google');
INSERT INTO `desarrolladora_fabricante` VALUES (39,'apple');
INSERT INTO `desarrolladora_fabricante` VALUES (40,'Double fine');
INSERT INTO `desarrolladora_fabricante` VALUES (41,'Moon studios');
INSERT INTO `desarrolladora_fabricante` VALUES (42,'Super giant games');
INSERT INTO `desarrolladora_fabricante` VALUES (43,'Larian studios');
INSERT INTO `desarrolladora_fabricante` VALUES (44,'Obsidian');
INSERT INTO `desarrolladora_fabricante` VALUES (45,'Inxile entertainment');
INSERT INTO `desarrolladora_fabricante` VALUES (46,'Epic games');
INSERT INTO `desarrolladora_fabricante` VALUES (47,'ISOMETRICORP Games ltd.');
INSERT INTO `desarrolladora_fabricante` VALUES (48,'Ninja theory');
INSERT INTO `desarrolladora_fabricante` VALUES (49,'Studio MDHR');
INSERT INTO `desarrolladora_fabricante` VALUES (50,'Tango gameworks');
INSERT INTO `desarrolladora_fabricante` VALUES (51,'Sora LTD.');
INSERT INTO `desarrolladora_fabricante` VALUES (52,'4A games');

/*
-- Query: select * from plataforma
LIMIT 0, 1000

-- Date: 2023-08-11 09:23
*/
INSERT INTO `plataforma` VALUES (1,'Xbox series',1);
INSERT INTO `plataforma` VALUES (2,'Nintendo switch',2);
INSERT INTO `plataforma` VALUES (3,'Playstation 5',8);
INSERT INTO `plataforma` VALUES (4,'Xbox one',1);
INSERT INTO `plataforma` VALUES (5,'Playstation 4',8);
INSERT INTO `plataforma` VALUES (6,'PC (windows)',1);
INSERT INTO `plataforma` VALUES (7,'Android',38);
INSERT INTO `plataforma` VALUES (8,'Mac',39);
INSERT INTO `plataforma` VALUES (9,'PC (Steam)',37);

/*
-- Query: select * from producto
LIMIT 0, 1000

-- Date: 2023-08-11 09:24
*/
INSERT INTO `producto` VALUES (1,'Halo infinite',60,10,1);
INSERT INTO `producto` VALUES (2,'TLOZ breath of the wild',50,2,2);
INSERT INTO `producto` VALUES (3,'Persona 5',60,3,5);
INSERT INTO `producto` VALUES (4,'Disgaea 5 complete',50,19,2);
INSERT INTO `producto` VALUES (5,'Metroid dread',50,11,2);
INSERT INTO `producto` VALUES (6,'Psychonauts 2',40,40,1);
INSERT INTO `producto` VALUES (7,'Shin megami tensei V',50,3,2);
INSERT INTO `producto` VALUES (8,'Forza horizon 4',60,13,4);
INSERT INTO `producto` VALUES (9,'Forza horizon 5',60,13,1);
INSERT INTO `producto` VALUES (10,'Ori and the blind forest',20,41,4);
INSERT INTO `producto` VALUES (11,'Ori and the will of the wisps',20,41,4);
INSERT INTO `producto` VALUES (12,'Hades',20,42,2);
INSERT INTO `producto` VALUES (13,'Forza horizon 3',20,13,4);
INSERT INTO `producto` VALUES (14,'Street fighter V',60,4,5);
INSERT INTO `producto` VALUES (15,'Divinity original sin 2',60,43,9);
INSERT INTO `producto` VALUES (16,'Injustice 2',50,16,4);
INSERT INTO `producto` VALUES (17,'Gears 5',50,14,4);
INSERT INTO `producto` VALUES (18,'Super Mario odyssey',50,2,2);
INSERT INTO `producto` VALUES (19,'Mario + rabbids kingdom battle',50,31,2);
INSERT INTO `producto` VALUES (20,'Astral chain',50,22,2);
INSERT INTO `producto` VALUES (21,'Octopath traveler',50,20,2);
INSERT INTO `producto` VALUES (22,'Mortal kombat 11',60,16,4);
INSERT INTO `producto` VALUES (23,'Elden ring',60,21,1);
INSERT INTO `producto` VALUES (24,'Titanfall 2',40,33,4);
INSERT INTO `producto` VALUES (25,'Ratchet and Clank rift apart',80,5,3);
INSERT INTO `producto` VALUES (26,'Darksouls 3',50,21,4);
INSERT INTO `producto` VALUES (27,'Rare replay',40,12,4);
INSERT INTO `producto` VALUES (28,'Kirby and the forgotten land',50,17,2);
INSERT INTO `producto` VALUES (29,'God of war Ragnarok',80,8,3);
INSERT INTO `producto` VALUES (30,'Sunset overdrive',40,5,4);
INSERT INTO `producto` VALUES (31,'Fortnite',0,46,5);
INSERT INTO `producto` VALUES (32,'Disgaea 7',80,19,3);
INSERT INTO `producto` VALUES (33,'Tunic',20,47,1);
INSERT INTO `producto` VALUES (34,'Street fighter VI',20,4,1);
INSERT INTO `producto` VALUES (35,'The witcher 3',60,34,4);
INSERT INTO `producto` VALUES (36,'Red dead redemption 2',60,6,4);
INSERT INTO `producto` VALUES (37,'Doom (2016)',60,26,4);
INSERT INTO `producto` VALUES (38,'Doom eternal',60,26,4);
INSERT INTO `producto` VALUES (39,'Nier automata',60,22,4);
INSERT INTO `producto` VALUES (40,'Hellblade',60,48,5);
INSERT INTO `producto` VALUES (41,'Cuphead',20,49,4);
INSERT INTO `producto` VALUES (42,'Disgaea 5',60,19,5);
INSERT INTO `producto` VALUES (43,'TLoH trails of cold steel 3',60,15,2);
INSERT INTO `producto` VALUES (44,'Xenoblade chronicles 2',50,32,2);
INSERT INTO `producto` VALUES (45,'Xenoblade chronicles 3',50,32,2);
INSERT INTO `producto` VALUES (46,'YS VIII Lacrimosa of Dana',50,15,2);
INSERT INTO `producto` VALUES (47,'YS VIII Lacrimosa of Dana',60,15,5);
INSERT INTO `producto` VALUES (48,'Fire emblem three houses',60,30,2);
INSERT INTO `producto` VALUES (49,'Triangle strategy',60,20,2);
INSERT INTO `producto` VALUES (50,'Bravely default 2',50,20,2);
INSERT INTO `producto` VALUES (51,'Donkey kong country tropical freeze',50,18,2);
INSERT INTO `producto` VALUES (52,'Fallout 4',40,24,9);
INSERT INTO `producto` VALUES (53,'Dragon age inquisition',40,35,9);
INSERT INTO `producto` VALUES (54,'Hi fi rush',50,50,1);
INSERT INTO `producto` VALUES (55,'Bayonetta 3',50,22,2);
INSERT INTO `producto` VALUES (56,'MEtroid prime remastered',50,18,2);
INSERT INTO `producto` VALUES (57,'Super smash bros ultimate',50,51,2);
INSERT INTO `producto` VALUES (58,'Tales of arise',60,7,4);
INSERT INTO `producto` VALUES (59,'Halo 5 Guardians',40,10,4);
INSERT INTO `producto` VALUES (60,'Fallout 4',40,24,5);
INSERT INTO `producto` VALUES (61,'Diablo IV',60,25,9);
INSERT INTO `producto` VALUES (62,'The outer worlds',40,44,1);
INSERT INTO `producto` VALUES (63,'Torment tides of numenera',40,45,9);
INSERT INTO `producto` VALUES (64,'Pillars of eternity 2',40,44,9);
INSERT INTO `producto` VALUES (65,'Halo the masterchief collection',40,10,4);
INSERT INTO `producto` VALUES (66,'Resident evil VIII',80,4,3);
INSERT INTO `producto` VALUES (67,'MEtro exodus',60,52,4);
INSERT INTO `producto` VALUES (68,'Final fantasy XV',60,20,5);
INSERT INTO `producto` VALUES (69,'Final fantasy XVI',80,20,3);
INSERT INTO `producto` VALUES (70,'Final fantasy XIV a realm reborn',60,20,9);
INSERT INTO `producto` VALUES (71,'Final fantasy XII the zodiac age',60,20,4);
INSERT INTO `producto` VALUES (72,'TLoH trails of cold steel IV',80,15,3);
INSERT INTO `producto` VALUES (73,'Pokemon lets go Eevee',50,9,2);
INSERT INTO `producto` VALUES (74,'Wasteland 3',50,45,9);
INSERT INTO `producto` VALUES (75,'Grand theft auto V',50,6,9);
INSERT INTO `producto` VALUES (76,'Red dead redemption 2',60,6,5);
INSERT INTO `producto` VALUES (77,'Cuphead',20,49,2);
INSERT INTO `producto` VALUES (78,'Cuphead',20,49,5);
INSERT INTO `producto` VALUES (79,'Elden ring',80,21,3);
INSERT INTO `producto` VALUES (80,'Darksouls 3',60,21,5);
INSERT INTO `producto` VALUES (81,'Doom (2016)',60,26,5);
INSERT INTO `producto` VALUES (82,'Doom eternal',60,26,5);
INSERT INTO `producto` VALUES (83,'Dragon age inquisition',60,35,5);
INSERT INTO `producto` VALUES (84,'Dragon age inquisition',60,35,4);
INSERT INTO `producto` VALUES (85,'Titanfall 2',60,33,5);
INSERT INTO `producto` VALUES (86,'Forza horizon 3',60,13,9);
INSERT INTO `producto` VALUES (87,'Forza horizon 4',60,13,9);
INSERT INTO `producto` VALUES (88,'Forza horizon 4',60,13,9);
INSERT INTO `producto` VALUES (89,'Forza horizon 5',60,13,9);
INSERT INTO `producto` VALUES (90,'Divinity original sin 2',60,43,4);
INSERT INTO `producto` VALUES (91,'Divinity original sin 2',60,43,5);
INSERT INTO `producto` VALUES (92,'The outer worlds',60,44,5);
INSERT INTO `producto` VALUES (93,'The outer worlds',60,44,9);
INSERT INTO `producto` VALUES (94,'Metro exodus',60,52,9);
INSERT INTO `producto` VALUES (95,'Metro exodus',60,52,5);
INSERT INTO `producto` VALUES (96,'Psychonauts 2',60,40,5);
INSERT INTO `producto` VALUES (97,'Psychonauts 2',60,40,4);
INSERT INTO `producto` VALUES (98,'Gears 5',60,14,9);
INSERT INTO `producto` VALUES (99,'Gears of war 4',60,14,4);
INSERT INTO `producto` VALUES (100,'Gears of war 4',60,14,9);



