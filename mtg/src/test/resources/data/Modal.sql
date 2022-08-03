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