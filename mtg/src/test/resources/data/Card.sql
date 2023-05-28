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
 expansion_id, text_box, back_card_id)
VALUES ('ZNR150', 'Moraug, Fury of Akoum', 'card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg', 'mythic',
 'Rudy Siswanto', '6', '6', '6', 1, 'Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall - Whenever a land enters the battlefield under your control, if it''s your main phase, there''s an additional combat phase after this phase. At the beginning of that combat, untap all creatures you control.',
 null);

INSERT INTO CARD (card_id, card_name, image_path, rarity, artist_name, converted_mana_cost, power, toughness,
 expansion_id, text_box, back_card_id)
VALUES ('ZNR134', 'Akoum Warrior', 'card_images/zendikar_rising/znr-134-akoum-warrior.jpg', 'uncommon',
 'Karl Kopinski', '6', '4', '5', 1, 'Trample', null);

INSERT INTO CARD (card_id, card_name, image_path, rarity, artist_name, converted_mana_cost, power, toughness,
expansion_id, text_box, back_card_id)
VALUES ('ZNR037', 'Sejiri Shelter', 'card_images/zendikar_rising/znr-37-sejiri-shelter.jpg', 'uncommon',
'Darek Zabrocki', '2', null, null, 1, 'Target creature you control gains protection from the color of your choice until end of turn.',
 'ZNR037B');

INSERT INTO CARD (card_id, card_name, image_path, rarity, artist_name, converted_mana_cost, power, toughness,
expansion_id, text_box, back_card_id)
VALUES ('ZNR037B', 'Sejiri Glacier', 'card_images/zendikar_rising/znr-37-sejiri-glacier.jpg', 'uncommon',
'Darek Zabrocki', null, null, null, 1, 'Sejiri Glacier enters the battlefield tapped. [tap]: Add [white].',
 null);

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