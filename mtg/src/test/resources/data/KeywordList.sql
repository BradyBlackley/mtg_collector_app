INSERT INTO KEYWORD (KEYWORD_NAME)
VALUES ('Double Strike');

INSERT INTO KEYWORD (KEYWORD_NAME)
VALUES ('Flying');

INSERT INTO KEYWORD (KEYWORD_NAME)
VALUES ('Vigilance');

INSERT INTO TYPE (TYPE_NAME)
VALUES ('Legendary');

INSERT INTO TYPE (TYPE_NAME)
VALUES ('Creature');

INSERT INTO TYPE (TYPE_NAME)
VALUES ('Minotaur');

INSERT INTO TYPE (TYPE_NAME)
VALUES ('Warrior');

INSERT INTO TYPE (TYPE_NAME)
VALUES ('Wizard');

INSERT INTO EXPANSION (expansion_name, expansion_code, released_date)
VALUES('Zendikar Rising','ZNR','2020-09-01');

INSERT INTO CARD (card_id, card_name, image_path, rarity, artist_name, converted_mana_cost, power, toughness,
 expansion_id, text_box)
VALUES ('ZNR150', 'Moraug, Fury of Akoum', 'card_images/zendikar_rising/znr-150-moraug-fury-of-akoum.jpg', 'mythic',
 'Rudy Siswanto', '6', '6', '6', 1, 'Each creature you control gets +1/+0 for each time it has attacked this turn. Landfall - Whenever a land enters the battlefield under your control, if it''s your main phase, there''s an additional combat phase after this phase. At the beginning of that combat, untap all creatures you control.');

INSERT INTO TYPELINE (type_id, card_id)
VALUES (1, 'ZNR150');

INSERT INTO TYPELINE (type_id, card_id)
VALUES (2, 'ZNR150');

INSERT INTO TYPELINE (type_id, card_id)
VALUES (3, 'ZNR150');

INSERT INTO TYPELINE (type_id, card_id)
VALUES (4, 'ZNR150');

INSERT INTO KEYWORD_LIST (keyword_id, card_id)
VALUES (1, 'ZNR150');

INSERT INTO KEYWORD_LIST (keyword_id, card_id)
VALUES (2, 'ZNR150');

INSERT INTO KEYWORD_LIST (keyword_id, card_id)
VALUES (3, 'ZNR150');