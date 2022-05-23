SET MODE MYSQL;

CREATE SCHEMA IF NOT EXISTS TESTDB;

--App Tables
CREATE TABLE keyword (
	keyword_id int NOT NULL AUTO_INCREMENT,
    keyword_name varchar(255),
    PRIMARY KEY (keyword_id)
);

CREATE TABLE `type` (
	type_id int NOT NULL AUTO_INCREMENT,
    type_name varchar(255),
    PRIMARY KEY (type_id)
);

CREATE TABLE `expansion` (
	expansion_id int NOT NULL AUTO_INCREMENT,
    expansion_name varchar(255),
    expansion_code varchar(255),
    released_date DATE,
    PRIMARY KEY (expansion_id)
);

CREATE TABLE `user` (
	user_id varchar(255) NOT NULL,
    username varchar(255),
    `password` varchar(255),
    PRIMARY KEY (user_id)
);

CREATE TABLE color (
	color_id int NOT NULL AUTO_INCREMENT,
    color_name varchar(255),
    PRIMARY KEY (color_id)
);

CREATE TABLE card (
	card_id varchar(255) NOT NULL,
    card_name varchar(255),
    image_path varchar(255),
    rarity ENUM('common', 'uncommon', 'rare', 'mythic'),
    artist_name varchar(255),
    converted_mana_cost varchar(255),
    power varchar(255),
    toughness varchar(255),
    expansion_id int,
    text_box longtext,
    PRIMARY KEY (card_id),
    FOREIGN KEY (expansion_id) REFERENCES `expansion`(expansion_id)
);

CREATE TABLE keyword_list (
	keyword_list_id int NOT NULL AUTO_INCREMENT,
    keyword_id int,
    card_id varchar(255),
    PRIMARY KEY (keyword_list_id),
    FOREIGN KEY (card_id) REFERENCES card(card_id),
    FOREIGN KEY (keyword_id) REFERENCES keyword(keyword_id)
);

CREATE TABLE typeline (
	typeline_id int NOT NULL AUTO_INCREMENT,
    type_id int,
    card_id varchar(255),
    PRIMARY KEY (typeline_id),
    FOREIGN KEY (card_id) REFERENCES card(card_id),
    FOREIGN KEY (type_id) REFERENCES `type`(type_id)
);

CREATE TABLE modal (
	modal_id varchar(255) NOT NULL,
    front_card_id varchar(255),
    back_card_id varchar(255),
    PRIMARY KEY (modal_id),
    FOREIGN KEY (front_card_id) REFERENCES card(card_id),
    FOREIGN KEY (back_card_id) REFERENCES card(card_id)
);

CREATE TABLE card_copy (
	card_copy_id int NOT NULL AUTO_INCREMENT,
    card_id varchar(255),
    user_id varchar(255),
    PRIMARY KEY (card_copy_id),
    FOREIGN KEY (card_id) REFERENCES card(card_id),
    FOREIGN KEY (user_id) REFERENCES `user`(user_id)
);

CREATE TABLE library (
	library_id int NOT NULL AUTO_INCREMENT,
    library_name varchar(255),
    user_id varchar(255),
    PRIMARY KEY (library_id),
    FOREIGN KEY (user_id) REFERENCES `user`(user_id)
);

CREATE TABLE color_identity (
	color_identity_id int NOT NULL AUTO_INCREMENT,
    card_id varchar(255),
    color_id int,
    PRIMARY KEY (color_identity_id),
    FOREIGN KEY (card_id) REFERENCES card(card_id),
    FOREIGN KEY (color_id) REFERENCES color(color_id)
);

CREATE TABLE card_to_library (
	card_to_library_id int NOT NULL AUTO_INCREMENT,
    card_copy_id int,
    library_id int,
    PRIMARY KEY (card_to_library_id),
    FOREIGN KEY (card_copy_id) REFERENCES card_copy(card_copy_id),
    FOREIGN KEY (library_id) REFERENCES library(library_id)
);

