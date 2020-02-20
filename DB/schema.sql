
DROP TABLE IF EXISTS `wager`;
DROP TABLE IF EXISTS `outcome_odd`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `outcome`;
DROP TABLE IF EXISTS `bet`;
DROP TABLE IF EXISTS `result`;
DROP TABLE IF EXISTS `sport_event`;

CREATE TABLE `sport_event` (
	id INTEGER NOT NULL AUTO_INCREMENT ,
	title VARCHAR(256) NOT NULL,
	start_date DATE,
	end_date DATE,
    event ENUM('FOOTBALL', 'TENNIS'),
    PRIMARY KEY(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE `result` (
	id INTEGER NOT NULL AUTO_INCREMENT,
    sport_even_id INTEGER,
	PRIMARY KEY(id),
	CONSTRAINT fr_sport_event FOREIGN KEY(sport_even_id) REFERENCES `sport_event`(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE `bet` (
	id INTEGER NOT NULL AUTO_INCREMENT,
	sport_event_id INTEGER,
	description varchar(256) NOT NULL,
	bet_type ENUM('GOALS', 'WINNER', 'SCORE'),
	PRIMARY KEY(id),
    CONSTRAINT fk_spport_event FOREIGN KEY(sport_event_id) REFERENCES `sport_event`(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE `outcome` (
	id INTEGER NOT NULL AUTO_INCREMENT,
	outcome VARCHAR(256),
	outcome_odd_id INTEGER,
	result_id INTEGER,
	bet_id INTEGER,
	PRIMARY KEY(id),
	CONSTRAINT fk_bet FOREIGN KEY(bet_id) REFERENCES `bet` (id),
	CONSTRAINT fk_result FOREIGN KEY(result_id) REFERENCES `result` (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE `user` (
	id INT NOT NULL AUTO_INCREMENT ,
	email VARCHAR(256) NOT NULL,
	password VARCHAR(256) NOT NULL,
	is_enabled BOOL,
    name VARCHAR(256),
    account_number BIGINT,
    balance DECIMAL(5,2),
    currency ENUM('EUR','USD','HUF'),
	date_of_birth DATE,
	role ENUM('PLAYER','ADMINS','FOOTBALL_ADMIN','TENNIS_ADMIN'),
    PRIMARY KEY(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE `outcome_odd` (
	id INTEGER NOT NULL AUTO_INCREMENT,
	odd_value FLOAT NOT NULL,
	from_date DATE NOT NULL,
	to_date DATE NOT NULL,
    outcome_id INTEGER,
    CONSTRAINT fr_outcome FOREIGN KEY(outcome_id) REFERENCES `outcome`(id),
	PRIMARY KEY(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE `wager` (
	id INTEGER NOT NULL AUTO_INCREMENT,
	outcome_odd_id INTEGER,
	user_id INTEGER,
	amount DECIMAL(5,2) NOT NULL,
	currency ENUM('EUR','USD','HUF') NOT NULL,
	timestamp DATE NOT NULL,
	is_processed BOOL,
	is_winn BOOL,
	PRIMARY KEY(id),
	CONSTRAINT fk_outcome_odd_2 FOREIGN KEY(outcome_odd_id) REFERENCES `outcome_odd`(id),
    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES `user`(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;