USE magic_collection;

CREATE TABLE keyword (
	keyword_id int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    description varchar(255),
    PRIMARY KEY (keyword_id)
);

CREATE TABLE keyword_list (
	keyword_list_id int NOT NULL AUTO_INCREMENT,
    keyword_id int,
    PRIMARY KEY (keyword_list_id),
    FOREIGN KEY (keyword_id) REFERENCES keyword(keyword_id)
);

CREATE TABLE type (
	type_id int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    PRIMARY KEY (type_id)
);

CREATE TABLE typeline (
	typeline_id int NOT NULL AUTO_INCREMENT,
    type_id int,
    PRIMARY KEY (typeline_id),
    FOREIGN KEY (type_id) REFERENCES type(type_id)
);

CREATE TABLE expansion (
	expansion_id int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    expansion_code varchar(255),
    year_released DATE,
    PRIMARY KEY (expansion_id)
);

CREATE TABLE card (
	card_id int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    typeline_id int,
    mana_type ENUM('white', 'blue', 'black', 'red', 'green', 'colorless', 'multi-colored'),
    image BLOB,
    artist_name varchar(255),
    converted_mana_cost int,
    power int,
    toughness int,
    keyword_list_id int,
    expansion_id int,
    collector_number int,
    PRIMARY KEY (card_id),
    FOREIGN KEY (typeline_id) REFERENCES typeline(typeline_id),
    FOREIGN KEY (keyword_list_id) REFERENCES keyword_list(keyword_list_id),
    FOREIGN KEY (expansion_id) REFERENCES expansion(expansion_id)
);

CREATE TABLE card_collection (
	card_collection_id int NOT NULL AUTO_INCREMENT,
    card_id int,
    PRIMARY KEY (card_collection_id),
    FOREIGN KEY (card_id) REFERENCES card(card_id)
);