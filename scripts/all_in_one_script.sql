DROP SCHEMA IF EXISTS `magic_collection`;

CREATE SCHEMA `magic_collection`;

USE magic_collection;

CREATE TABLE keyword (
	keyword_id int NOT NULL AUTO_INCREMENT,
    keyword_name varchar(255),
    PRIMARY KEY (keyword_id)
);

CREATE TABLE type (
	type_id int NOT NULL AUTO_INCREMENT,
    type_name varchar(255),
    PRIMARY KEY (type_id)
);

CREATE TABLE expansion (
	expansion_id int NOT NULL AUTO_INCREMENT,
    expansion_name varchar(255),
    expansion_code varchar(255),
    released_date DATE,
    PRIMARY KEY (expansion_id)
);

CREATE TABLE user (
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
    FOREIGN KEY (expansion_id) REFERENCES expansion(expansion_id)
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
    FOREIGN KEY (type_id) REFERENCES type(type_id)
);

CREATE TABLE collection (
	collection_id int NOT NULL AUTO_INCREMENT,
    user_id varchar(255),
    PRIMARY KEY (collection_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id)
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
    collection_id int,
    PRIMARY KEY (card_copy_id),
    FOREIGN KEY (card_id) REFERENCES card(card_id),
    FOREIGN KEY (collection_id) REFERENCES collection(collection_id)
);

CREATE TABLE library (
	library_id int NOT NULL AUTO_INCREMENT,
    library_name varchar(255),
    collection_id int,
    PRIMARY KEY (library_id),
    FOREIGN KEY (collection_id) REFERENCES collection(collection_id)
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

#########################################create stored procedures########################################
DELIMITER $$

CREATE PROCEDURE InsertColor(
	IN input_color_name VARCHAR(255)
)
BEGIN

INSERT INTO color (color_name)
VALUES (input_color_name);

END$$

CREATE PROCEDURE InsertKeyword(
	IN input_keyword_name VARCHAR(255)
)
BEGIN
	
INSERT INTO keyword (keyword_name)
 VALUES (input_keyword_name);

END$$


CREATE PROCEDURE InsertExpansion(
	IN input_expansion_name VARCHAR(255),
    IN input_expansion_code VARCHAR(255),
    IN input_released_date DATE
)
BEGIN
	
INSERT INTO expansion (expansion_name, expansion_code, released_date)
 VALUES (input_expansion_name, input_expansion_code, input_released_date);

END$$

CREATE PROCEDURE InsertType(
	IN input_type_name VARCHAR(255)
)
BEGIN
	
INSERT INTO type (type_name)
 VALUES (input_type_name);

END$$

DELIMITER ;
########################################data inserts########################################
INSERT INTO user VALUES('f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454', 'Test', 'Test');
INSERT INTO collection VALUES(1,'f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454');
INSERT INTO library VALUES(1,'Test Library', 1);
###Color
CALL InsertColor('colorless');
CALL InsertColor('white');
CALL InsertColor('blue');
CALL InsertColor('black');
CALL InsertColor('red');
CALL InsertColor('green');
###Keyword
CALL InsertKeyword('Absorb');
CALL InsertKeyword('Adapt');
CALL InsertKeyword('Affinity');
CALL InsertKeyword('Afterlife');
CALL InsertKeyword('Aftermath');
CALL InsertKeyword('Amplify');
CALL InsertKeyword('Annihilator');
CALL InsertKeyword('Ascend');
CALL InsertKeyword('Aura swap');
CALL InsertKeyword('Bands with other');
CALL InsertKeyword('Battle cry');
CALL InsertKeyword('Bestow');
CALL InsertKeyword('Bolster');
CALL InsertKeyword('Bloodthirst');
CALL InsertKeyword('Bushido');
CALL InsertKeyword('Buyback');
CALL InsertKeyword('Cascade');
CALL InsertKeyword('Champion');
CALL InsertKeyword('Changeling');
CALL InsertKeyword('Cipher');
CALL InsertKeyword('Clash');
CALL InsertKeyword('Conspire');
CALL InsertKeyword('Convoke');
CALL InsertKeyword('Crew');
CALL InsertKeyword('Cumulative upkeep');
CALL InsertKeyword('Cycling');
CALL InsertKeyword('Dash');
CALL InsertKeyword('Daybound');
CALL InsertKeyword('Delve');
CALL InsertKeyword('Detain');
CALL InsertKeyword('Devour');
CALL InsertKeyword('Double Strike');
CALL InsertKeyword('Dredge');
CALL InsertKeyword('Echo');
CALL InsertKeyword('Embalm');
CALL InsertKeyword('Emerge');
CALL InsertKeyword('Entwine');
CALL InsertKeyword('Epic');
CALL InsertKeyword('Evolve');
CALL InsertKeyword('Evoke');
CALL InsertKeyword('Exalted');
CALL InsertKeyword('Exert');
CALL InsertKeyword('Exploit');
CALL InsertKeyword('Explore');
CALL InsertKeyword('Extort');
CALL InsertKeyword('Fabricate');
CALL InsertKeyword('Fading');
CALL InsertKeyword('Fatesteal');
CALL InsertKeyword('Flanking');
CALL InsertKeyword('Flashback');
CALL InsertKeyword('Flip');
CALL InsertKeyword('Flying');
CALL InsertKeyword('Forecast');
CALL InsertKeyword('Foretell');
CALL InsertKeyword('Fortify');
CALL InsertKeyword('Frenzy');
CALL InsertKeyword('Graft');
CALL InsertKeyword('Gravestorm');
CALL InsertKeyword('Haunt');
CALL InsertKeyword('Hideaway');
CALL InsertKeyword('Horsemanship');
CALL InsertKeyword('Infect');
CALL InsertKeyword('Jump-start');
CALL InsertKeyword('Kicker');
CALL InsertKeyword('Level Up');
CALL InsertKeyword('Living Weapon');
CALL InsertKeyword('Madness');
CALL InsertKeyword('Manifest');
CALL InsertKeyword('Meld');
CALL InsertKeyword('Mentor');
CALL InsertKeyword('Miracle');
CALL InsertKeyword('Modular');
CALL InsertKeyword('Monstrosity');
CALL InsertKeyword('Morph');
CALL InsertKeyword('Multikicker');
CALL InsertKeyword('Mutate');
CALL InsertKeyword('Ninjutsu');
CALL InsertKeyword('Nightbound');
CALL InsertKeyword('Offering');
CALL InsertKeyword('Overload');
CALL InsertKeyword('Persist');
CALL InsertKeyword('Poisonous');
CALL InsertKeyword('Populate');
CALL InsertKeyword('Proliferate');
CALL InsertKeyword('Provoke');
CALL InsertKeyword('Prowl');
CALL InsertKeyword('Rampage');
CALL InsertKeyword('Rebound');
CALL InsertKeyword('Recover');
CALL InsertKeyword('Reinforce');
CALL InsertKeyword('Renown');
CALL InsertKeyword('Replicate');
CALL InsertKeyword('Retrace');
CALL InsertKeyword('Riot');
CALL InsertKeyword('Ripple');
CALL InsertKeyword('Scavenge');
CALL InsertKeyword('Shadow');
CALL InsertKeyword('Soulbond');
CALL InsertKeyword('Soulshift');
CALL InsertKeyword('Spectacle');
CALL InsertKeyword('Splice');
CALL InsertKeyword('Split Second');
CALL InsertKeyword('Storm');
CALL InsertKeyword('Sunburst');
CALL InsertKeyword('Support');
CALL InsertKeyword('Surveil');
CALL InsertKeyword('Suspend');
CALL InsertKeyword('Totem Armor');
CALL InsertKeyword('Transfigure');
CALL InsertKeyword('Transform');
CALL InsertKeyword('Transmute');
CALL InsertKeyword('Typecycling');
CALL InsertKeyword('Undying');
CALL InsertKeyword('Unearth');
CALL InsertKeyword('Unleash');
CALL InsertKeyword('Vanishing');
CALL InsertKeyword('Ward');
CALL InsertKeyword('Wither');
CALL InsertKeyword('Addendum');
CALL InsertKeyword('Battalion');
CALL InsertKeyword('Bloodrush');
CALL InsertKeyword('Channel');
CALL InsertKeyword('Chroma');
CALL InsertKeyword('Domain');
CALL InsertKeyword('Enrage');
CALL InsertKeyword('Fateful Hour');
CALL InsertKeyword('Ferocious');
CALL InsertKeyword('Grandeur');
CALL InsertKeyword('Hellbent');
CALL InsertKeyword('Heroic');
CALL InsertKeyword('Imprint');
CALL InsertKeyword('Join Forces');
CALL InsertKeyword('Kinship');
CALL InsertKeyword('Landfall');
CALL InsertKeyword('Metalcraft');
CALL InsertKeyword('Morbid');
CALL InsertKeyword('Radiance');
CALL InsertKeyword('Raid');
CALL InsertKeyword('Rally');
CALL InsertKeyword('Sweep');
CALL InsertKeyword('Threshold');
CALL InsertKeyword('Undergrowth');
CALL InsertKeyword('Banding');
CALL InsertKeyword('Bury');
CALL InsertKeyword('Fear');
CALL InsertKeyword('Intimidate');
CALL InsertKeyword('Landhome');
CALL InsertKeyword('Landwalk');
CALL InsertKeyword('Phasing');
CALL InsertKeyword('Regenerate');
CALL InsertKeyword('Shroud');
CALL InsertKeyword('Substance');
### Expansion
CALL InsertExpansion('Alpha','LEA','1993-08-01');
CALL InsertExpansion('Beta','LEB','1993-10-01');
CALL InsertExpansion('Unlimited Edition','2ED','1993-12-01');
CALL InsertExpansion('Arabian Nights','ARN','1993-12-01');
CALL InsertExpansion('Antiquities','ATQ','1994-03-01');
CALL InsertExpansion('Revised Edition','3ED','1994-04-01');
CALL InsertExpansion('Legends','LEG','1994-06-01');
CALL InsertExpansion('The Dark','DRK','1994-08-01');
CALL InsertExpansion('Fallen Empires','FEM','1994-11-01');
CALL InsertExpansion('Fourth Edition','4ED','1995-05-01');
CALL InsertExpansion('Ice Age','ICE','1995-06-01');
CALL InsertExpansion('Chronicles','CHR','1995-07-01');
CALL InsertExpansion('Renaissance','','1995-08-01');
CALL InsertExpansion('Homelands','HML','1995-10-01');
CALL InsertExpansion('Alliances','ALL','1996-06-01');
CALL InsertExpansion('Mirage','MIR','1996-10-01');
CALL InsertExpansion('Visions','VIS','1997-02-01');
CALL InsertExpansion('Fifth Edition','5ED','1997-03-01');
CALL InsertExpansion('Portal','POR','1997-05-01');
CALL InsertExpansion('Weatherlight','WTH','1997-06-01');
CALL InsertExpansion('Tempest','TMP','1997-10-01');
CALL InsertExpansion('Stronghold','STH','1998-02-01');
CALL InsertExpansion('Exodus','EXO','1998-06-01');
CALL InsertExpansion('Portal Second Age','P02','1998-06-01');
CALL InsertExpansion('Unglued','UGL','1998-08-01');
CALL InsertExpansion('Urza''s Saga','USG','1998-10-01');
CALL InsertExpansion('Anthologies','ATH','1998-11-01');
CALL InsertExpansion('Urza''s Legacy','ULG','1999-02-01');
CALL InsertExpansion('Sixth Edition','6ED','1999-04-01');
CALL InsertExpansion('Portal Three Kingdoms','PTK','1999-05-01');
CALL InsertExpansion('Urza''s Destiny','UDS','1999-06-01');
CALL InsertExpansion('Starter 1999','S99','1999-08-01');
CALL InsertExpansion('Mercadian Masques','MMQ','1999-09-01');
CALL InsertExpansion('Battle Royale','BRB','1999-11-01');
CALL InsertExpansion('Nemesis','NEM','2000-02-01');
CALL InsertExpansion('Starter 2000','S00','2000-04-01');
CALL InsertExpansion('Prophecy','PCY','2000-06-01');
CALL InsertExpansion('Invasion','INV','2000-09-01');
CALL InsertExpansion('Beatdown','BTD','2000-10-01');
CALL InsertExpansion('Planeshift','PLS','2001-01-01');
CALL InsertExpansion('Seventh Edition','7ED','2001-04-01');
CALL InsertExpansion('Apocalypse','APC','2001-05-01');
CALL InsertExpansion('Odyssey','ODY','2001-10-01');
CALL InsertExpansion('Deckmasters 2001','DKM','2001-12-01');
CALL InsertExpansion('Torment','TOR','2002-02-01');
CALL InsertExpansion('Judgement','JUD','2002-05-01');
CALL InsertExpansion('Onslaught','ONS','2002-10-01');
CALL InsertExpansion('Legions','LGN','2003-01-01');
CALL InsertExpansion('Scourge','SCG','2003-05-01');
CALL InsertExpansion('Eighth Edition','8ED','2003-07-01');
CALL InsertExpansion('Mirrodin','MRD','2003-10-01');
CALL InsertExpansion('Darksteel','DST','2004-02-01');
CALL InsertExpansion('Fifth Dawn','5DN','2004-06-01');
CALL InsertExpansion('Champions of Kamigawa','CHK','2004-10-01');
CALL InsertExpansion('Unhinged','UNH','2004-11-01');
CALL InsertExpansion('Betrayers of Kamigawa','BOK','2005-02-01');
CALL InsertExpansion('Saviors of Kamigawa','SOK','2005-06-01');
CALL InsertExpansion('Ninth Edition','9ED','2005-07-01');
CALL InsertExpansion('Salvat 2005','','2005-08-01');
CALL InsertExpansion('Ravnica: City of Guilds','RAV','2005-10-01');
CALL InsertExpansion('Guildpact','GPT','2006-02-01');
CALL InsertExpansion('Dissension','DIS','2006-05-01');
CALL InsertExpansion('Coldsnap','CSP','2006-07-01');
CALL InsertExpansion('Time Spiral','TSP','2006-10-01');
CALL InsertExpansion('Planar Chaos','PLC','2007-02-01');
CALL InsertExpansion('Future Sight','FUT','2007-05-01');
CALL InsertExpansion('Tenth Edition','10E','2007-07-01');
CALL InsertExpansion('Masters Edition','MED','2007-09-01');
CALL InsertExpansion('Lorwyn','LRW','2007-10-01');
CALL InsertExpansion('Duel Decks: Elves vs. Goblins','EVG','2007-11-01');
CALL InsertExpansion('Morningtide','MOR','2008-02-01');
CALL InsertExpansion('Shadowmoor','SHM','2008-05-01');
CALL InsertExpansion('Eventide','EVE','2008-06-01');
CALL InsertExpansion('From the Vault: Dragons','DRB','2008-08-01');
CALL InsertExpansion('Masters Edition II','ME2','2008-09-01');
CALL InsertExpansion('Shards of Alara','ALA','2008-09-01');
CALL InsertExpansion('Duel Decks: Jace vs. Chandra','DD2','2008-11-01');
CALL InsertExpansion('Conflux','CON','2009-02-01');
CALL InsertExpansion('Duel Decks: Divine vs. Demonic','DDC','2009-04-01');
CALL InsertExpansion('Alara Reborn','ARB','2009-04-01');
CALL InsertExpansion('Magic 2010','M10','2009-07-01');
CALL InsertExpansion('Commander Theme Decks','TD0','2009-08-01');
CALL InsertExpansion('From the Vault: Exiled','V09','2009-08-01');
CALL InsertExpansion('Planechase','H0P','2009-09-01');
CALL InsertExpansion('Masters Edition III','ME3','2009-09-01');
CALL InsertExpansion('Zendikar','ZEN','2009-10-01');
CALL InsertExpansion('Duel Decks: Garruk vs. Liliana','DDD','2009-10-01');
CALL InsertExpansion('Premium Deck Series: Slivers','H09','2009-11-01');
CALL InsertExpansion('Worldwake','WWK','2010-02-01');
CALL InsertExpansion('Duel Decks: Phyrexia vs. The Coalition','DDE','2010-03-01');
CALL InsertExpansion('Rise of the Eldrazi','ROE','2010-04-01');
CALL InsertExpansion('Deck Builder''s Toolkit','','2010-05-01');
CALL InsertExpansion('Duels of the Planeswalkers','DPA','2010-06-01');
CALL InsertExpansion('Archenemy','ARC','2010-06-01');
CALL InsertExpansion('Magic 2011','M11','2010-07-01');
CALL InsertExpansion('From the Vault: Relics','V10','2010-08-01');
CALL InsertExpansion('Duel Decks: Elspeth vs. Tezzeret','DDF','2010-09-01');
CALL InsertExpansion('Scars of Mirrodin','SOM','2010-10-01');
CALL InsertExpansion('Magic Online Deck Series','TDO','2010-11-01');
CALL InsertExpansion('Premium Deck Series: Fire & Lightning','PD2','2010-11-01');
CALL InsertExpansion('Momir Basic Event Deck','','2010-11-01');
CALL InsertExpansion('Salvat 2011','','2011-01-01');
CALL InsertExpansion('Masters Edition IV','ME4','2011-01-01');
CALL InsertExpansion('Mirrodin Besieged','MBS','2011-02-01');
CALL InsertExpansion('Deck Builder''s Toolkit','','2011-03-01');
CALL InsertExpansion('Duel Decks: Knights vs. Dragons','DDG','2011-04-01');
CALL InsertExpansion('New Phyrexia','NPH','2011-05-01');
CALL InsertExpansion('Commander','CMD','2011-06-01');
CALL InsertExpansion('Magic 2012','M12','2011-07-01');
CALL InsertExpansion('From the Vault: Legends','V11','2011-08-01');
CALL InsertExpansion('Duel Decks: Ajani vs. Nicol Bolas','DDH','2011-09-01');
CALL InsertExpansion('Innistrad','ISD','2011-09-01');
CALL InsertExpansion('Premium Deck Series: Graveborn','PD3','2011-11-01');
CALL InsertExpansion('Dark Ascension','DKA','2012-02-01');
CALL InsertExpansion('Duel Decks: Venser vs. Koth','DDI','2012-03-01');
CALL InsertExpansion('Avacyn Restored','AVR','2012-05-01');
CALL InsertExpansion('Planechase 2012','PC2','2012-05-01');
CALL InsertExpansion('Magic 2013','M13','2012-07-01');
CALL InsertExpansion('From the Vault: Realms','V12','2012-08-01');
CALL InsertExpansion('Duel Decks: Izzet vs. Golgari','DDJ','2012-09-01');
CALL InsertExpansion('Return to Ravnica','RTR','2012-10-01');
CALL InsertExpansion('Commander''s Arsenal','CM1','2012-11-01');
CALL InsertExpansion('Duel Decks: Mirrodin Pure vs. New Phyrexia','TD2','2013-01-01');
CALL InsertExpansion('Gatecrash','GTC','2013-02-01');
CALL InsertExpansion('Duel Decks: Sorin vs. Tibalt','DDK','2013-03-01');
CALL InsertExpansion('Dragon''s Maze','DGM','2013-05-01');
CALL InsertExpansion('Modern Masters','MMA','2013-06-01');
CALL InsertExpansion('Magic 2014','M14','2013-07-01');
CALL InsertExpansion('From the Vault: Twenty','V13','2013-08-01');
CALL InsertExpansion('Duel Decks: Heroes vs. Monsters','DDL','2013-09-01');
CALL InsertExpansion('Theros','THS','2013-09-01');
CALL InsertExpansion('Commander 2013','C13','2013-11-01');
CALL InsertExpansion('Born of the Gods','BNG','2014-02-01');
CALL InsertExpansion('Duel Decks: Jace vs. Vraska','DDM','2014-03-01');
CALL InsertExpansion('Journey into Nyx','JOU','2014-05-01');
CALL InsertExpansion('Modern Event Deck','MD1','2014-05-01');
CALL InsertExpansion('Conspiracy','CNS','2014-06-01');
CALL InsertExpansion('Vintage Masters','VMA','2014-06-01');
CALL InsertExpansion('Magic 2015','M15','2014-07-01');
CALL InsertExpansion('From the Vault: Annihilation','V14','2014-08-01');
CALL InsertExpansion('Duel Decks: Speed vs. Cunning','DDN','2014-10-01');
CALL InsertExpansion('Khans of Tarkir','KTK','2014-10-01');
CALL InsertExpansion('Commander 2014','C14','2014-11-01');
CALL InsertExpansion('Duel Decks Anthology','DD3','2014-12-01');
CALL InsertExpansion('Fate Reforged','FRF','2015-01-01');
CALL InsertExpansion('Duel Decks: Elspeth vs. Kiora','DDO','2015-02-01');
CALL InsertExpansion('Dragons Tarkir','DTK','2015-03-01');
CALL InsertExpansion('Tempest Remastered','TPR','2015-05-01');
CALL InsertExpansion('Modern Masters 2015','MM2','2015-05-01');
CALL InsertExpansion('Magic Origins','ORI','2015-07-01');
CALL InsertExpansion('From the Vault: Angels','V15','2015-08-01');
CALL InsertExpansion('Duel Decks: Zendikar vs. Eldrazi','DDP','2015-08-01');
CALL InsertExpansion('Battle for Zendikar','BFZ','2015-10-01');
CALL InsertExpansion('Zendikar Expeditions','EXP','2015-10-01');
CALL InsertExpansion('Commander 2015','C15','2015-11-01');
CALL InsertExpansion('Legendary Cube','PZ1','2015-11-01');
CALL InsertExpansion('Oath of the Gatewatch','OGW','2016-01-01');
CALL InsertExpansion('Duel Decks: Blessed vs. Cursed','DDQ','2016-02-01');
CALL InsertExpansion('Welcome Deck 2016','W16','2016-04-01');
CALL InsertExpansion('Shadows over Innistrad','SOI','2016-04-01');
CALL InsertExpansion('Eternal Masters','EMA','2016-06-01');
CALL InsertExpansion('Eldritch Moon','EMN','2016-07-01');
CALL InsertExpansion('From the Vault: Lore','V16','2016-08-01');
CALL InsertExpansion('Conspiracy: Take the Crown','CN2','2016-08-01');
CALL InsertExpansion('Duel Decks: Nissa vs. Ob Nixilis','DDR','2016-09-01');
CALL InsertExpansion('Kaladesh','KLD','2016-09-01');
CALL InsertExpansion('Kaladesh Inventions','MPS','2016-09-01');
CALL InsertExpansion('Treasure Chests','PZ2','2016-10-01');
CALL InsertExpansion('Commander 2016','C16','2016-11-01');
CALL InsertExpansion('You Make the Cube','','2016-11-01');
CALL InsertExpansion('Planechase Anthology','PCA','2016-11-01');
CALL InsertExpansion('Aether Revolt','AER','2017-01-01');
CALL InsertExpansion('Modern Masters 2017','MM3','2017-03-01');
CALL InsertExpansion('Duel Decks: Mind vs. Might','DDS','2017-03-01');
CALL InsertExpansion('Welcome Deck 2017','W17','2017-04-01');
CALL InsertExpansion('Amonkhet','AKH','2017-04-01');
CALL InsertExpansion('Amonkhet Invocations','MP2','2017-04-01');
CALL InsertExpansion('Commander Anthology','CMA','2017-06-01');
CALL InsertExpansion('Archenemy: Nicol Bolas','E01','2017-06-01');
CALL InsertExpansion('Hour of Devastation','HOU','2017-07-01');
CALL InsertExpansion('Commander 2017','C17','2017-08-01');
CALL InsertExpansion('Ixalan','XLN','2017-09-01');
CALL InsertExpansion('Duel Decks: Merfolk vs. Goblins','DDT','2017-11-01');
CALL InsertExpansion('Iconic Masters','IMA','2017-11-01');
CALL InsertExpansion('Explorers of Ixalan','E02','2017-11-01');
CALL InsertExpansion('From the Vault: Transform','V17','2017-11-01');
CALL InsertExpansion('Unstable','UST','2017-12-01');
CALL InsertExpansion('Rivals of Ixalan','RIX','2018-01-01');
CALL InsertExpansion('Masters 25','A25','2018-03-01');
CALL InsertExpansion('Duel Decks: Elves vs. Inventors','DDU','2018-04-01');
CALL InsertExpansion('Challenger Decks','QO1','2018-04-01');
CALL InsertExpansion('Dominaria','DOM','2018-04-01');
CALL InsertExpansion('Commander Anthology Volume II','CM2','2018-06-01');
CALL InsertExpansion('Battlebond','BBD','2018-06-01');
CALL InsertExpansion('Signature Spellbook: Jace','SS1','2018-06-01');
CALL InsertExpansion('Global Series: Jiang Yanggu & Mu Yanling','GS1','2018-06-01');
CALL InsertExpansion('Core Set 2019','M19','2018-07-01');
CALL InsertExpansion('Commander 2018','C18','2018-08-01');
CALL InsertExpansion('Guilds of Ravnica Mythic Edition','MED','2018-10-01');
CALL InsertExpansion('Guilds of Ravnica','GRN','2018-10-01');
CALL InsertExpansion('Spellslinger Starter Kit','SK1','2018-10-01');
CALL InsertExpansion('Guilds of Ravnica Guild Kits','GK1','2018-11-01');
CALL InsertExpansion('Game Night','GNT','2018-11-01');
CALL InsertExpansion('Ultimate Masters','UMA','2018-12-01');
CALL InsertExpansion('Ravnica Allegiance Mythic Edition','MED','2018-10-01');
CALL InsertExpansion('Ravnica Allegiance','RNA','2019-01-01');
CALL InsertExpansion('Ravnica Allegiance Guild Kits','GK2','2019-02-01');
CALL InsertExpansion('Challenger Decks 2019','QO2','2019-04-01');
CALL InsertExpansion('War of the Spark Mythic Edition','MED','2019-05-01');
CALL InsertExpansion('War of the Spark','WAR','2019-05-01');
CALL InsertExpansion('Modern Horizons','MH1','2019-06-01');
CALL InsertExpansion('Signature Spellbook: Gideon','SS2','2019-06-01');
CALL InsertExpansion('Core Set 2020','M20','2019-07-01');
CALL InsertExpansion('Commander 2019','C19','2019-08-01');
CALL InsertExpansion('Throne of Eldraine','ELD','2019-10-01');
CALL InsertExpansion('Mystery Booster','MB1','2019-11-01');
CALL InsertExpansion('Challenger Decks 2019 Japan','','2019-11-01');
CALL InsertExpansion('Game Night 2019','GN2','2019-11-01');
CALL InsertExpansion('Secret Lair Drop Series','SLD','2019-12-01');
CALL InsertExpansion('Theros Beyond Death','THB','2020-01-01');
CALL InsertExpansion('Secret Lair Drop Series: Year of the Rat','SLD','2020-01-01');
CALL InsertExpansion('Secret Lair Drop Series: Theros Stargazing','SLD','2020-02-01');
CALL InsertExpansion('Unsanctioned','UND','2020-02-01');
CALL InsertExpansion('Secret Lair Drop Series: International Women''s Day','SLD','2020-03-01');
CALL InsertExpansion('Secret Lair Drop Series: Thalia - Beyond the Helvault','SLD','2020-03-01');
CALL InsertExpansion('Mystery Booster Retail Edition','MB1','2020-03-01');
CALL InsertExpansion('Challenger Decks 2020','QO3','2020-03-01');
CALL InsertExpansion('Ikoria: Lair of Behemoths','IKO','2020-04-01');
CALL InsertExpansion('Commander 2020','C20','2020-04-01');
CALL InsertExpansion('Secret Lair Drop Series: The Godzilla Lands','SLD','2020-05-01');
CALL InsertExpansion('Secret Lair Drop Series: Summer Superdrop','SLD','2020-06-01');
CALL InsertExpansion('Secret Lair: Ultimate Edition','SLU','2020-06-01');
CALL InsertExpansion('Signature Spellbook: Chandra','SS3','2020-06-01');
CALL InsertExpansion('Core Set 2021','M21','2020-07-01');
CALL InsertExpansion('Jumpstart','JMP','2020-07-01');
CALL InsertExpansion('Double Masters','2XM','2020-08-01');
CALL InsertExpansion('Amonkhet Remastered','AKR','2020-08-01');
CALL InsertExpansion('Secret Lair Drop Series: Prime Slime','SLD','2020-08-01');
CALL InsertExpansion('Secret Lair Drop Series: Every Dog Has Its Day','SLD','2020-08-01');
CALL InsertExpansion('Secret Lair Drop Series: Happy Yargle Day!','SLD','2020-09-01');
CALL InsertExpansion('Secret Lair Drop Series: April Fools','SLD','2020-09-01');
CALL InsertExpansion('Zendikar Rising','ZNR','2020-09-01');
CALL InsertExpansion('Zendikar Rising Expeditions','ZNE','2020-09-01');
CALL InsertExpansion('Zendikar Rising Commander Decks','ZNC','2020-09-01');
CALL InsertExpansion('Secret Lair Drop Series: Showcase: Zendikar Revisited','SLD','2020-09-01');
CALL InsertExpansion('Secret Lair Drop Series: The Walking Dead','SLD','2020-10-01');
CALL InsertExpansion('Secret Lair Drop Series: Extra Life 2020','SLD','2020-11-01');
CALL InsertExpansion('Kaladesh Remastered','KLR','2020-11-01');
CALL InsertExpansion('Commander Legends','CMR','2020-11-01');
CALL InsertExpansion('Commander Legends Commander Decks','CMC','2020-11-01');
CALL InsertExpansion('Secret Lair Drop Series: Secretversary','SLD','2020-11-01');
CALL InsertExpansion('Commander Collection: Green','CC1','2020-12-01');
CALL InsertExpansion('Kaldheim','KHM','2021-02-01');
CALL InsertExpansion('Kaldheim Commander Decks','KHC','2021-02-01');
CALL InsertExpansion('Secret Lair Drop Series: Smitten','SLD','2021-02-01');
CALL InsertExpansion('Secret Lair Drop Series: Black is Magic','SLD','2021-02-01');
CALL InsertExpansion('Time Spiral Remastered','TSR','2021-03-01');
CALL InsertExpansion('Challenger Decks 2021','QO4','2021-03-01');
CALL InsertExpansion('Strixhaven: School of Mages','STX','2021-04-01');
CALL InsertExpansion('Mystical Archive','STA','2021-04-01');
CALL InsertExpansion('Commander 2021','C21','2021-04-01');
CALL InsertExpansion('Secret Lair Drop Series: Dr. Lair''s Secretorium Superdrop','SLD','2021-04-01');
CALL InsertExpansion('Secret Lair: Ultimate Edition 2','SLU','2021-05-01');
CALL InsertExpansion('Modern Horizons 2','MH2','2021-06-01');
CALL InsertExpansion('Secret Lair Drop Series: All-Natural, Totally Refreshing Superdrop','SLD','2021-06-01');
CALL InsertExpansion('Dungeons & Dragons: Adventures in the Forgotten Realms','AFR','2021-07-01');
CALL InsertExpansion('Dungeons & Dragons: Adventures in the Forgotten Realms Commander Decks','AFC','2021-07-01');
CALL InsertExpansion('2021 Arena Starter Kit','SLD','2021-08-01');
CALL InsertExpansion('Secret Lair Drop Series: Out of Time Superdrop','','2021-08-01');
CALL InsertExpansion('Jumpstart: Historic Horizons','J21','2021-08-01');
CALL InsertExpansion('Innistrad: Midnight Hunt','MID','2021-09-01');
CALL InsertExpansion('Innistrad: Midnight Hunt Commander Decks','MIC','2021-09-01');
CALL InsertExpansion('Pioneer Challenger Decks 2021','','2021-10-01');
CALL InsertExpansion('Secret Lair Drop Series: October Superdrop','SLD','2021-10-01');
CALL InsertExpansion('Secret Lair Drop Series: Purrfection','SLD','2021-10-01');
CALL InsertExpansion('Secret Lair Drop Series: Extra Life 2021','SLD','2021-11-01');
CALL InsertExpansion('Innistrad: Crimson Vow','VOW','2021-11-01');
CALL InsertExpansion('Innistrad: Crimson Vow Commander Decks','VOC','2021-11-01');
CALL InsertExpansion('Secret Lair Drop Series: MSCHF','SLD','2021-11-01');
CALL InsertExpansion('Secret Lair Drop Series: Secretversary 2021','SLD','2021-11-01');
CALL InsertExpansion('Commander Collection: Black','CC2','2022-01-01');
CALL InsertExpansion('Innistrad Double Feature','DBL','2022-01-01');
### Type
CALL InsertType('Artifact');
CALL InsertType('Conspiracy');
CALL InsertType('Creature');
CALL InsertType('Dungeon');
CALL InsertType('Enchantment');
CALL InsertType('Instant');
CALL InsertType('Basic Land');
CALL InsertType('Land');
CALL InsertType('Phenomenon');
CALL InsertType('Plane');
CALL InsertType('Planeswalker');
CALL InsertType('Scheme');
CALL InsertType('Sorcery');
CALL InsertType('Tribal');
CALL InsertType('Vanguard');
CALL InsertType('Advisor');
CALL InsertType('Aetherborn');
CALL InsertType('Ally');
CALL InsertType('Angel');
CALL InsertType('Antelope');
CALL InsertType('Ape');
CALL InsertType('Archer');
CALL InsertType('Archon');
CALL InsertType('Army');
CALL InsertType('Artificer');
CALL InsertType('Assassin');
CALL InsertType('Assembly-Worker');
CALL InsertType('Atog');
CALL InsertType('Aurochs');
CALL InsertType('Avatar');
CALL InsertType('Azra');
CALL InsertType('Badger');
CALL InsertType('Barbarian');
CALL InsertType('Bard');
CALL InsertType('Basilisk');
CALL InsertType('Bat');
CALL InsertType('Bear');
CALL InsertType('Beast');
CALL InsertType('Beeble');
CALL InsertType('Beholder');
CALL InsertType('Berserker');
CALL InsertType('Bird');
CALL InsertType('Blinkmoth');
CALL InsertType('Boar');
CALL InsertType('Bringer');
CALL InsertType('Brushwagg');
CALL InsertType('Camarid');
CALL InsertType('Camel');
CALL InsertType('Caribou');
CALL InsertType('Carrier');
CALL InsertType('Cat');
CALL InsertType('Centaur');
CALL InsertType('Cephalid');
CALL InsertType('Chimera');
CALL InsertType('Citizen');
CALL InsertType('Cleric');
CALL InsertType('Cockatrice');
CALL InsertType('Contruct');
CALL InsertType('Coward');
CALL InsertType('Crab');
CALL InsertType('Crocodile');
CALL InsertType('Cyclops');
CALL InsertType('Dauthi');
CALL InsertType('Demigod');
CALL InsertType('Demon');
CALL InsertType('Deserter');
CALL InsertType('Devil');
CALL InsertType('Dinosaur');
CALL InsertType('Djinn');
CALL InsertType('Dog');
CALL InsertType('Dragon');
CALL InsertType('Drake');
CALL InsertType('Dreadnought');
CALL InsertType('Drone');
CALL InsertType('Druid');
CALL InsertType('Dryad');
CALL InsertType('Dwarf');
CALL InsertType('Efreet');
CALL InsertType('Egg');
CALL InsertType('Elder');
CALL InsertType('Eldrazi');
CALL InsertType('Elemental');
CALL InsertType('Elephant');
CALL InsertType('Elf');
CALL InsertType('Elk');
CALL InsertType('Eye');
CALL InsertType('Faerie');
CALL InsertType('Ferret');
CALL InsertType('Fish');
CALL InsertType('Flagbearer');
CALL InsertType('Fox');
CALL InsertType('Fractal');
CALL InsertType('Frog');
CALL InsertType('Fungus');
CALL InsertType('Gargoyle');
CALL InsertType('Germ');
CALL InsertType('Giant');
CALL InsertType('Gnoll');
CALL InsertType('Gnome');
CALL InsertType('Goat');
CALL InsertType('Goblin');
CALL InsertType('God');
CALL InsertType('Golem');
CALL InsertType('Gorgon');
CALL InsertType('Graveborn');
CALL InsertType('Gremlin');
CALL InsertType('Griffin');
CALL InsertType('Hag');
CALL InsertType('Halfling');
CALL InsertType('Hamster');
CALL InsertType('Harpy');
CALL InsertType('Hellion');
CALL InsertType('Hippo');
CALL InsertType('Hippogriff');
CALL InsertType('Homarid');
CALL InsertType('Homunculus');
CALL InsertType('Horror');
CALL InsertType('Horse');
CALL InsertType('Human');
CALL InsertType('Hydra');
CALL InsertType('Hyena');
CALL InsertType('Illusion');
CALL InsertType('Imp');
CALL InsertType('Incarnation');
CALL InsertType('Inkling');
CALL InsertType('Insect');
CALL InsertType('Jackal');
CALL InsertType('Jellyfish');
CALL InsertType('Juggernaut');
CALL InsertType('Kavu');
CALL InsertType('Kirin');
CALL InsertType('Kithkin');
CALL InsertType('Knight');
CALL InsertType('Kobold');
CALL InsertType('Kor');
CALL InsertType('Kraken');
CALL InsertType('Lamia');
CALL InsertType('Lammasu');
CALL InsertType('Leech');
CALL InsertType('Leviathan');
CALL InsertType('Lhurgoyf');
CALL InsertType('Licid');
CALL InsertType('Lizard');
CALL InsertType('Manticore');
CALL InsertType('Masticore');
CALL InsertType('Mercenary');
CALL InsertType('Merfolk');
CALL InsertType('Metathran');
CALL InsertType('Minion');
CALL InsertType('Minotaur');
CALL InsertType('Mole');
CALL InsertType('Monger');
CALL InsertType('Mongoose');
CALL InsertType('Monk');
CALL InsertType('Monkey');
CALL InsertType('Moonfolk');
CALL InsertType('Mouse');
CALL InsertType('Mutant');
CALL InsertType('Myr');
CALL InsertType('Mystic');
CALL InsertType('Naga');
CALL InsertType('Nautilus');
CALL InsertType('Nephilim');
CALL InsertType('Nightmare');
CALL InsertType('Nightstalker');
CALL InsertType('Ninja');
CALL InsertType('Noble');
CALL InsertType('Noggle');
CALL InsertType('Nomad');
CALL InsertType('Nymph');
CALL InsertType('Octopus');
CALL InsertType('Ogre');
CALL InsertType('Ooze');
CALL InsertType('Orb');
CALL InsertType('Orc');
CALL InsertType('Orgg');
CALL InsertType('Otter');
CALL InsertType('Ouphe');
CALL InsertType('Ox');
CALL InsertType('Oyster');
CALL InsertType('Pangolin');
CALL InsertType('Peasant');
CALL InsertType('Pegasus');
CALL InsertType('Pentavite');
CALL InsertType('Pest');
CALL InsertType('Phelddagrif');
CALL InsertType('Phoenix');
CALL InsertType('Phyrexian');
CALL InsertType('Pilot');
CALL InsertType('Pincher');
CALL InsertType('Pirate');
CALL InsertType('Plant');
CALL InsertType('Praetor');
CALL InsertType('Prism');
CALL InsertType('Processor');
CALL InsertType('Rabbit');
CALL InsertType('Ranger');
CALL InsertType('Rat');
CALL InsertType('Rebel');
CALL InsertType('Reflection');
CALL InsertType('Rhino');
CALL InsertType('Rigger');
CALL InsertType('Rogue');
CALL InsertType('Sable');
CALL InsertType('Salamander');
CALL InsertType('Samurai');
CALL InsertType('Sand');
CALL InsertType('Saproling');
CALL InsertType('Satyr');
CALL InsertType('Scarecrow');
CALL InsertType('Scion');
CALL InsertType('Scorpion');
CALL InsertType('Scout');
CALL InsertType('Sculpture');
CALL InsertType('Serf');
CALL InsertType('Serpent');
CALL InsertType('Servo');
CALL InsertType('Shade');
CALL InsertType('Shaman');
CALL InsertType('Shapeshifter');
CALL InsertType('Shark');
CALL InsertType('Sheep');
CALL InsertType('Siren');
CALL InsertType('Skeleton');
CALL InsertType('Slith');
CALL InsertType('Sliver');
CALL InsertType('Slug');
CALL InsertType('Snake');
CALL InsertType('Soldier');
CALL InsertType('Soltari');
CALL InsertType('Spawn');
CALL InsertType('Specter');
CALL InsertType('Spellshaper');
CALL InsertType('Sphinx');
CALL InsertType('Spider');
CALL InsertType('Spike');
CALL InsertType('Spirit');
CALL InsertType('Splinter');
CALL InsertType('Sponge');
CALL InsertType('Squid');
CALL InsertType('Squirrel');
CALL InsertType('Starfish');
CALL InsertType('Surrakar');
CALL InsertType('Survivor');
CALL InsertType('Tentacle');
CALL InsertType('Tetravite');
CALL InsertType('Thalakos');
CALL InsertType('Thopter');
CALL InsertType('Tiefling');
CALL InsertType('Thrull');
CALL InsertType('Treefolk');
CALL InsertType('Trilobite');
CALL InsertType('Triskelavite');
CALL InsertType('Troll');
CALL InsertType('Turtle');
CALL InsertType('Unicorn');
CALL InsertType('Vampire');
CALL InsertType('Vedalken');
CALL InsertType('Viashino');
CALL InsertType('Volver');
CALL InsertType('Wall');
CALL InsertType('Warlock');
CALL InsertType('Warrior');
CALL InsertType('Weird');
CALL InsertType('Werewolf');
CALL InsertType('Whale');
CALL InsertType('Wizard');
CALL InsertType('Wolf');
CALL InsertType('Wolverine');
CALL InsertType('Wombat');
CALL InsertType('Worm');
CALL InsertType('Wraith');
CALL InsertType('Wurm');
CALL InsertType('Yeti');
CALL InsertType('Zombie');
CALL InsertType('Zubera');
CALL InsertType('Plains');
CALL InsertType('Island');
CALL InsertType('Swamp');
CALL InsertType('Mountain');
CALL InsertType('Forest');
CALL InsertType('Desert');
CALL InsertType('Gate');
CALL InsertType('Lair');
CALL InsertType('Locus');
CALL InsertType('Snow-Covered');
CALL InsertType('Urza''s');
CALL InsertType('Mine');
CALL InsertType('Power-Plant');
CALL InsertType('Tower');
########################################Zendikar Rising Card Inserts########################################
### Allied Assault ZNR001
INSERT INTO card VALUES('ZNR001','Allied Assault','card_images/zendikar_rising/allied_assault_001.png','uncommon','Josh Hass','3',null,null,(SELECT expansion_id FROM expansion WHERE expansion_name = 'Zendikar Rising'),'Up to two target creatures each get +X/+X until end of turn, where X is the number of creatures in your party. (Your party consists of up to one each of Cleric, Rogue, Warrior, and Wizard.)');
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Instant'),(SELECT card_id FROM card WHERE card_name='Allied Assault'));
INSERT INTO color_identity (color_id, card_id) VALUES ((SELECT color_id FROM color WHERE color_name = 'white'),(SELECT card_id FROM card WHERE card_name='Allied Assault'));
### Angel of Destiny ZNR002
INSERT INTO card VALUES('ZNR002','Angel of Destiny','card_images/zendikar_rising/angel_of_destiny_002.png','mythic','Ryan Pancoast','5','2','6',(SELECT expansion_id FROM expansion WHERE expansion_name = 'Zendikar Rising'),'Flying, double strike Whenever a creature you control deals combat damage to a player, you and that player each gain that much life. At the beginning of your end step, if you have at least 15 life more than your starting life total, each player Angel of Destiny attacked this turn loses the game.');
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Creature'),(SELECT card_id FROM card WHERE card_name='Angel of Destiny'));
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Angel'),(SELECT card_id FROM card WHERE card_name='Angel of Destiny'));
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Cleric'),(SELECT card_id FROM card WHERE card_name='Angel of Destiny'));
INSERT INTO keyword_list (keyword_id, card_id) VALUES ((SELECT keyword_id FROM keyword WHERE keyword_name = 'Flying'),(SELECT card_id FROM card WHERE card_name='Angel of Destiny'));
INSERT INTO keyword_list (keyword_id, card_id) VALUES ((SELECT keyword_id FROM keyword WHERE keyword_name = 'Double Strike'),(SELECT card_id FROM card WHERE card_name='Angel of Destiny'));
INSERT INTO color_identity (color_id, card_id) VALUES ((SELECT color_id FROM color WHERE color_name = 'white'),(SELECT card_id FROM card WHERE card_name='Angel of Destiny'));
### Angelheart Protector ZNR003
INSERT INTO card VALUES('ZNR003','Angelheart Protector','card_images/zendikar_rising/angelheart_protector_003.png','common','Cristi Balanescu','3','3','2',(SELECT expansion_id FROM expansion WHERE expansion_name = 'Zendikar Rising'),'When Angelheart Protector enters the battlefield, target creature you control gains indestructible until end of turn. (Damage and effects that say "destroy" don''t destroy it.)');
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Creature'),(SELECT card_id FROM card WHERE card_name='Angelheart Protector'));
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Human'),(SELECT card_id FROM card WHERE card_name='Angelheart Protector'));
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Cleric'),(SELECT card_id FROM card WHERE card_name='Angelheart Protector'));
INSERT INTO color_identity (color_id, card_id) VALUES ((SELECT color_id FROM color WHERE color_name = 'white'),(SELECT card_id FROM card WHERE card_name='Angelheart Protector'));
### Archon of Emeria ZNR004
INSERT INTO card VALUES('ZNR004','Archon of Emeria','card_images/zendikar_rising/archon_of_emeria_004.png','rare','Ryan Pancoast','3','2','3',(SELECT expansion_id FROM expansion WHERE expansion_name = 'Zendikar Rising'),'Flying Each player can''t cast more than one spell each turn. Nonbasic lands your opponents control enter the battlefield tapped.');
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Creature'),(SELECT card_id FROM card WHERE card_name='Archon of Emeria'));
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Archon'),(SELECT card_id FROM card WHERE card_name='Archon of Emeria'));
INSERT INTO keyword_list (keyword_id, card_id) VALUES ((SELECT keyword_id FROM keyword WHERE keyword_name = 'Flying'),(SELECT card_id FROM card WHERE card_name='Archon of Emeria'));
INSERT INTO color_identity (color_id, card_id) VALUES ((SELECT color_id FROM color WHERE color_name = 'white'),(SELECT card_id FROM card WHERE card_name='Archon of Emeria'));
### Archpriest of Iona ZNR005
INSERT INTO card VALUES('ZNR005','Archpriest of Iona','card_images/zendikar_rising/archpriest_of_iona_005.png','rare','Denman Rooke','1','*','2',(SELECT expansion_id FROM expansion WHERE expansion_name = 'Zendikar Rising'),'Archpriest of Iona''s power is equal to the number of creatures in your party. (Your party consists of up to one each of Cleric, Rogue, Warrior, and Wizard.) At the beginning of combat on your turn, if you have a full party, target creature gets +1/+1 and gains flying until end of turn.');
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Creature'),(SELECT card_id FROM card WHERE card_name='Archpriest of Iona'));
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Human'),(SELECT card_id FROM card WHERE card_name='Archpriest of Iona'));
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Cleric'),(SELECT card_id FROM card WHERE card_name='Archpriest of Iona'));
INSERT INTO color_identity (color_id, card_id) VALUES ((SELECT color_id FROM color WHERE color_name = 'white'),(SELECT card_id FROM card WHERE card_name='Archpriest of Iona'));
### Attended Healer ZNR006
INSERT INTO card VALUES('ZNR006','Attended Healer','card_images/zendikar_rising/attended_healer_006.png','uncommon','Wisnu Tan','4','2','3',(SELECT expansion_id FROM expansion WHERE expansion_name = 'Zendikar Rising'),'Whenever you gain life for the first time each turn, create a 1/1 white Cat creature token. [2 colorless][white]:Another target Cleric gains lifelink until end of turn.');
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Creature'),(SELECT card_id FROM card WHERE card_name='Attended Healer'));
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Kor'),(SELECT card_id FROM card WHERE card_name='Attended Healer'));
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Cleric'),(SELECT card_id FROM card WHERE card_name='Attended Healer'));
INSERT INTO color_identity (color_id, card_id) VALUES ((SELECT color_id FROM color WHERE color_name = 'white'),(SELECT card_id FROM card WHERE card_name='Attended Healer'));
### Canyon Jerboa ZNR007
INSERT INTO card VALUES('ZNR007','Canyon Jerboa','card_images/zendikar_rising/canyon_jerboa_007.png','uncommon','Antonio José Manzanedo','3','1','2',(SELECT expansion_id FROM expansion WHERE expansion_name = 'Zendikar Rising'),'Landfall - Whenever a land enters the battlefield under your control, creatures you control get +1/+1 until end of turn.');
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Creature'),(SELECT card_id FROM card WHERE card_name='Canyon Jerboa'));
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Mouse'),(SELECT card_id FROM card WHERE card_name='Canyon Jerboa'));
INSERT INTO keyword_list (keyword_id, card_id) VALUES ((SELECT keyword_id FROM keyword WHERE keyword_name = 'Landfall'),(SELECT card_id FROM card WHERE card_name='Canyon Jerboa'));
INSERT INTO color_identity (color_id, card_id) VALUES ((SELECT color_id FROM color WHERE color_name = 'white'),(SELECT card_id FROM card WHERE card_name='Canyon Jerboa'));
### Cliffhaven Sell-Sword ZNR008
INSERT INTO card VALUES('ZNR008','Cliffhaven Sell-Sword','card_images/zendikar_rising/cliffhaven_sell-sword_008.png','common','Jason Rainville','2','3','1',(SELECT expansion_id FROM expansion WHERE expansion_name = 'Zendikar Rising'),null);
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Creature'),(SELECT card_id FROM card WHERE card_name='Cliffhaven Sell-Sword'));
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Kor'),(SELECT card_id FROM card WHERE card_name='Cliffhaven Sell-Sword'));
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Warrior'),(SELECT card_id FROM card WHERE card_name='Cliffhaven Sell-Sword'));
INSERT INTO color_identity (color_id, card_id) VALUES ((SELECT color_id FROM color WHERE color_name = 'white'),(SELECT card_id FROM card WHERE card_name='Cliffhaven Sell-Sword'));
### Dauntless Unity ZNR009
INSERT INTO card VALUES('ZNR009','Dauntless Unity','card_images/zendikar_rising/dauntless_unity_009.png','common','Josu Hernaiz','2',null,null,(SELECT expansion_id FROM expansion WHERE expansion_name = 'Zendikar Rising'),'Kicker [colorless][white] (You may pay an additional [colorless][white] as you cast this spell.) Creatures you control get a +1/+1 until end of turn. If this spell was kicked, those creatures get +2/+1 until end of turn instead.');
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Instant'),(SELECT card_id FROM card WHERE card_name='Dauntless Unity'));
INSERT INTO keyword_list (keyword_id, card_id) VALUES ((SELECT keyword_id FROM keyword WHERE keyword_name = 'Kicker'),(SELECT card_id FROM card WHERE card_name='Dauntless Unity'));
INSERT INTO color_identity (color_id, card_id) VALUES ((SELECT color_id FROM color WHERE color_name = 'white'),(SELECT card_id FROM card WHERE card_name='Dauntless Unity'));
### Disenchant ZNR010
INSERT INTO card VALUES('ZNR010','Disenchant','card_images/zendikar_rising/disenchant_010.png','common','Colin Boyer','2',null,null,(SELECT expansion_id FROM expansion WHERE expansion_name = 'Zendikar Rising'),'Destroy target artifact or enchantment.');
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Instant'),(SELECT card_id FROM card WHERE card_name='Disenchant'));
INSERT INTO color_identity (color_id, card_id) VALUES ((SELECT color_id FROM color WHERE color_name = 'white'),(SELECT card_id FROM card WHERE card_name='Disenchant'));
### Acquisitions Expert ZNR089
INSERT INTO card VALUES('ZNR089','Acquisitions Expert','card_images/zendikar_rising/acquisitions_expert_089.png','uncommon','Anna Steinbauer','2','1','2',(SELECT expansion_id FROM expansion WHERE expansion_name = 'Zendikar Rising'),'When Acquisitions Expert enters the battlefield, target opponent reveals a number of cards from their hand equal to the number of creatures in your party. You choose one of those cards. That player discards that card. (Your party consists of up to one each of Cleric, Rogue, Warrior, Wizard.)');
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Creature'),(SELECT card_id FROM card WHERE card_name='Acquisitions Expert'));
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Human'),(SELECT card_id FROM card WHERE card_name='Acquisitions Expert'));
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Rogue'),(SELECT card_id FROM card WHERE card_name='Acquisitions Expert'));
INSERT INTO color_identity (color_id, card_id) VALUES ((SELECT color_id FROM color WHERE color_name = 'black'),(SELECT card_id FROM card WHERE card_name='Acquisitions Expert'));
### Adventure Awaits ZNR177
INSERT INTO card VALUES ('ZNR177','Adventure Awaits','card_images/zendikar_rising/adventure_awaits_177.png','common','Billy Christian','2',null,null,(SELECT expansion_id FROM expansion WHERE expansion_name = 'Zendikar Rising'),'Look at the top five cards of your library. You may reveal a creature card from among them and put it into your hand. Put the rest on the bottom of your library in a random order. If you didn''t put a card into your hand this way, draw a card.');
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Sorcery'),(SELECT card_id FROM card WHERE card_name='Adventure Awaits'));
INSERT INTO color_identity (color_id, card_id) VALUES ((SELECT color_id FROM color WHERE color_name = 'green'),(SELECT card_id FROM card WHERE card_name='Adventure Awaits'));
### Agadeem's Awakening/Agadeem, the Undercrypt ZNR090
INSERT INTO card VALUES ('ZNR090F','Agadeem''s Awakening','card_images/zendikar_rising/agadeem''s_awakening_090_F.png','mythic','Dmitry Burmak','3X',null,null,(SELECT expansion_id FROM expansion WHERE expansion_name = 'Zendikar Rising'),'Return from your graveyard to the battlefield any number of target creature cards that each have a different converted mana cost X or less.');
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Sorcery'),(SELECT card_id FROM card WHERE card_name='Agadeem''s Awakening'));
INSERT INTO color_identity (color_id, card_id) VALUES ((SELECT color_id FROM color WHERE color_name = 'black'),(SELECT card_id FROM card WHERE card_name='Agadeem''s Awakening'));
INSERT INTO card VALUES ('ZNR090B', 'Agadeem, the Undercrypt','card_images/zendikar_rising/agadeem,_the_undercrypt_090_B.png','mythic','Dmitry Burmak',null,null,null,(SELECT expansion_id FROM expansion WHERE expansion_name = 'Zendikar Rising'),'As Agadeem, the Undercrypt enters the battlefield, you may pay 3 life. If you don''t, it enters the battlefield tapped.[tap]:Add [black].');
INSERT INTO typeline (type_id, card_id) VALUES ((SELECT type_id FROM type WHERE type_name = 'Land'),(SELECT card_id FROM card WHERE card_name='Agadeem, the Undercrypt'));
INSERT INTO color_identity (color_id, card_id) VALUES ((SELECT color_id FROM color WHERE color_name = 'colorless'),(SELECT card_id FROM card WHERE card_name='Agadeem, the Undercrypt'));
INSERT INTO modal VALUES ('ZNR090', 'ZNR090F', 'ZNR090B');

########################################Link card copy to test library########################################
INSERT INTO card_copy (card_id, collection_id) VALUES ((SELECT card_id FROM card WHERE card_name='Acquisitions Expert'), (select collection_id FROM collection where user_id = 'f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454'));
INSERT INTO card_to_library (card_copy_id, library_id) VALUES ((SELECT card_copy_id FROM card_copy cc INNER JOIN card c ON c.card_id = cc.card_id WHERE card_name='Acquisitions Expert' LIMIT 1),
(SELECT library_id FROM library WHERE collection_id = 1));