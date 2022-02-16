#USAGE InsertCard(card_id, name, mana_type, image_path, rarity, artist_name, converted_mana_cost, power, toughness,
#expansion_id, collector_number, is_modal, is_alternate_art)
#add card then typeline then keyword list

CALL InsertCard('002KHM', 'Battershield Warrior', 'white', 'card_images/kaldheim/battershield_warrior_002.png', 'uncommon', 'Colin Boyer', 3, 2, 2,
107, 002, false, false);

SELECT * FROM expansion WHERE name = 'kaldheim';

SELECT * FROM type WHERE name = 'Warrior';


INSERT INTO typeline (card_id, type_id) VALUES('002KHM', 277);

SELECT * FROM keyword WHERE name = 'boast';

SELECT * FROM typeline;
SELECT * FROM keyword_list;
SELECT * FROM card;

INSERT INTO keyword_list (card_id, keyword_id) VALUES ('002KHM', 139);

