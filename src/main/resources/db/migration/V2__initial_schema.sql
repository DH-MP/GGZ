DROP TABLE IF EXISTS `developers`;
CREATE TABLE `developers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `games`;
CREATE TABLE `games` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` float DEFAULT '0',
  `rating` int(2) DEFAULT '0',
  `api_id` int(10) NOT NULL DEFAULT '0',
  `image_id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `release_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT 'CURRENT_TIMESTAMP',
  `deck` varchar(511) COLLATE utf8_unicode_ci DEFAULT '',
  `description` mediumtext COLLATE utf8_unicode_ci,
  `quantity` int(11),
  `api_detail_url` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `games_developers`;
CREATE TABLE `games_developers` (
  `id` int(11)  NOT NULL AUTO_INCREMENT,
  `game_id` int(11)  NOT NULL,
  `developer_id` int(11)  NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `game_developer_fk_constraint` (`game_id`,`developer_id`),
  KEY `game_developer_index` (`game_id`,`developer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `games_pg_ratings`;
CREATE TABLE `games_pg_ratings` (
  `id` int(11)  NOT NULL AUTO_INCREMENT,
  `game_id` int(11)  NOT NULL,
  `pg_rating_id` int(11)  NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `game_pgrating_fk_constraint` (`game_id`,`pg_rating_id`),
  KEY `game_pgrating_index` (`game_id`,`pg_rating_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `games_platforms`;
CREATE TABLE `games_platforms` (
  `id` int(11)  NOT NULL AUTO_INCREMENT,
  `game_id` int(11) SIGNED  NOT NULL,
  `platform_id` int(11) SIGNED  NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `game_platform_fk_constraint` (`game_id`,`platform_id`),
  KEY `game_platform_index` (`game_id`,`platform_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
  `id` int(11) SIGNED NOT NULL AUTO_INCREMENT,
  `game_id` int(11) SIGNED NOT NULL,
  `tiny_url` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `medium_url` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `large_url` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `pg_ratings`;
CREATE TABLE `pg_ratings` (
  `id` int(11) SIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `platforms`;
CREATE TABLE `platforms` (
  `id` int(11) SIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `consoles`;
CREATE TABLE `consoles` (
  `id` int(11) SIGNED NOT NULL AUTO_INCREMENT,
  `price` float DEFAULT '0',
  `api_id` int(10) SIGNED NOT NULL DEFAULT '0',
  `platform_id` int(11) SIGNED references platforms(id),
  `description` mediumtext COLLATE utf8_unicode_ci,
  `quantity` int(11),
  `api_detail_url` varchar(255) COLLATE utf8_unicode_ci DEFAULT '',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
