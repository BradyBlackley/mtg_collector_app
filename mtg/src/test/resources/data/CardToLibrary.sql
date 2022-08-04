INSERT INTO EXPANSION
(EXPANSION_NAME,EXPANSION_CODE,RELEASED_DATE)
VALUES
('Zendikar Rising','ZNR','2020-09-01');

INSERT INTO COLOR
(COLOR_NAME)
VALUES
('red');

INSERT INTO TYPE (TYPE_NAME)
VALUES ('Legendary');

INSERT INTO TYPE (TYPE_NAME)
VALUES ('Creature');

INSERT INTO TYPE (TYPE_NAME)
VALUES ('Minotaur');

INSERT INTO TYPE (TYPE_NAME)
VALUES ('Warrior');

INSERT INTO KEYWORD (KEYWORD_NAME)
VALUES ('Trample');

INSERT INTO KEYWORD (KEYWORD_NAME)
VALUES ('Landfall');

INSERT INTO KEYWORD (KEYWORD_NAME)
VALUES ('Vigilance');

INSERT INTO CARD (card_id, card_name, image_path, rarity, artist_name, converted_mana_cost, power, toughness,
 expansion_id, text_box)
VALUES ('ZNR150', 'Moraug, Fury of Akoum', 'card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg', 'mythic',
 'Rudy Siswanto', '6', '6', '6', 1, 'Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall - Whenever a land enters the battlefield under your control, if it''s your main phase, there''s an additional combat phase after this phase. At the beginning of that combat, untap all creatures you control.');

INSERT INTO CARD (card_id, card_name, image_path, rarity, artist_name, converted_mana_cost, power, toughness,
 expansion_id, text_box)
VALUES ('ZNR134', 'Akoum Warrior', 'card_images/zendikar_rising/znr-134-akoum-warrior.jpg', 'uncommon',
 'Karl Kopinski', '6', '4', '5', 1, 'Trample');

INSERT INTO COLOR_IDENTITY
(COLOR_ID, CARD_ID)
VALUES
(1, 'ZNR150');

INSERT INTO TYPELINE (type_id, card_id)
VALUES (1, 'ZNR150');

INSERT INTO TYPELINE (type_id, card_id)
VALUES (2, 'ZNR150');

INSERT INTO TYPELINE (type_id, card_id)
VALUES (3, 'ZNR150');

INSERT INTO TYPELINE (type_id, card_id)
VALUES (4, 'ZNR150');

INSERT INTO KEYWORD_LIST (keyword_id, card_id)
VALUES (1, 'ZNR134');

INSERT INTO KEYWORD_LIST (keyword_id, card_id)
VALUES (2, 'ZNR150');

INSERT INTO EXPANSION
(EXPANSION_NAME,EXPANSION_CODE,RELEASED_DATE)
VALUES
('Zendikar Rising','ZNR','2020-09-01');

INSERT INTO COLOR
(COLOR_NAME)
VALUES
('red');

INSERT INTO TYPE
(TYPE_NAME)
VALUES
('Instant');

INSERT INTO TYPE
(TYPE_NAME)
VALUES
('Land');

INSERT INTO CARD
(CARD_ID,CARD_NAME,IMAGE_PATH,RARITY,ARTIST_NAME,CONVERTED_MANA_COST,POWER,TOUGHNESS,EXPANSION_ID,TEXT_BOX)
VALUES
('ZNR166F','Spikefield Hazard','card_images\\zendikar_rising\\znr-166-spikefield-hazard.jpg','uncommon',
'Tomasz Jedruszek','1',null,null,1,
'Spikefield Hazard deals 1 damage to any target. If a permanent dealt damage this way would die this turn, exile it instead.');

INSERT INTO CARD
(CARD_ID,CARD_NAME,IMAGE_PATH,RARITY,ARTIST_NAME,CONVERTED_MANA_COST,POWER,TOUGHNESS,EXPANSION_ID,TEXT_BOX)
VALUES
('ZNR166B','Spikefield Cave','card_images\\zendikar_rising\\znr-166-spikefield-cave.jpg','uncommon',
'Tomasz Jedruszek','1',null,null,1,'Spikefield Cave enters the battlefield tapped. [tap]: Add [red].');

INSERT INTO CARD
(CARD_ID,CARD_NAME,IMAGE_PATH,RARITY,ARTIST_NAME,CONVERTED_MANA_COST,POWER,TOUGHNESS,EXPANSION_ID,TEXT_BOX)
VALUES
('ZNR216F','Vastwood Fortification','card_images\\zendikar_rising\\znr-216-vastwood-fortification.jpg','uncommon',
'Sidharth Chaturvedi','1',null,null,'1','Put a +1/+1 counter on target creature.');

INSERT INTO CARD
(CARD_ID,CARD_NAME,IMAGE_PATH,RARITY,ARTIST_NAME,CONVERTED_MANA_COST,POWER,TOUGHNESS,EXPANSION_ID,TEXT_BOX)
VALUES
('ZNR216B','Vastwood Thicket','card_images\\zendikar_rising\\znr-216-vastwood-thicket.jpg','uncommon',
'Sidharth Chaturvedi',null,null,null,'1','Vastwood Thicket enters the battlefield tapped. [tap]: Add [green]');

INSERT INTO COLOR_IDENTITY
(COLOR_ID, CARD_ID)
VALUES
(1, 'ZNR166F');

INSERT INTO COLOR_IDENTITY
(COLOR_ID, CARD_ID)
VALUES
(1, 'ZNR166B');

INSERT INTO TYPELINE
(TYPE_ID, CARD_ID)
VALUES
(1,'ZNR166F');

INSERT INTO TYPELINE
(TYPE_ID, CARD_ID)
VALUES
(2,'ZNR166B');

INSERT INTO MODAL
(MODAL_ID,FRONT_CARD_ID,BACK_CARD_ID)
VALUES
('ZNR166','ZNR166F','ZNR166B');

INSERT INTO USER (USER_ID, USERNAME, PASSWORD)
VALUES('5d209ac0-9102-11ec-b909-0242ac120002', 'TimTheMagicMan',
'5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8');

INSERT INTO USER (USER_ID, USERNAME, PASSWORD)
VALUES('9a219974-9102-11ec-b909-0242ac120002', 'Bobby_LovesPI532',
'd55e52b3e8da93c174bd319178a91f5248d205849e64925fdc76d9fbd62527ca');

INSERT INTO CARD_COPY (CARD_ID, USER_ID)
VALUES ('ZNR150', '5d209ac0-9102-11ec-b909-0242ac120002');

INSERT INTO CARD_COPY (CARD_ID, USER_ID)
VALUES ('ZNR134', '5d209ac0-9102-11ec-b909-0242ac120002');

INSERT INTO CARD_COPY (CARD_ID, USER_ID)
VALUES ('ZNR134', '5d209ac0-9102-11ec-b909-0242ac120002');

INSERT INTO CARD_COPY (CARD_ID, USER_ID)
VALUES ('ZNR134', '5d209ac0-9102-11ec-b909-0242ac120002');

INSERT INTO CARD_COPY (CARD_ID, USER_ID)
VALUES ('ZNR166F', '9a219974-9102-11ec-b909-0242ac120002');

INSERT INTO CARD_COPY (CARD_ID, USER_ID)
VALUES ('ZNR166B', '9a219974-9102-11ec-b909-0242ac120002');

INSERT INTO LIBRARY (LIBRARY_NAME, USER_ID)
VALUES ('Minotaur Deck', '5d209ac0-9102-11ec-b909-0242ac120002');

INSERT INTO LIBRARY (LIBRARY_NAME, USER_ID)
VALUES ('Zombie Deck', '5d209ac0-9102-11ec-b909-0242ac120002');

INSERT INTO CARD_TO_LIBRARY (CARD_COPY_ID, LIBRARY_ID)
VALUES (1, 1);

INSERT INTO CARD_TO_LIBRARY (CARD_COPY_ID, LIBRARY_ID)
VALUES (2, 2);

INSERT INTO CARD_TO_LIBRARY (CARD_COPY_ID, LIBRARY_ID)
VALUES (3, 2);
