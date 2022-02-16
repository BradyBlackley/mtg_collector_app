DELIMITER $$

CREATE PROCEDURE InsertCard(
	IN input_card_id VARCHAR(255),
    IN input_card_name VARCHAR(255),
    IN input_image_path VARCHAR(255),
    IN input_rarity VARCHAR(255),
    IN input_artist_name VARCHAR(255),
    IN input_converted_mana_cost int,
    IN input_power int,
    IN input_toughness int,
    IN input_expansion_id int,
    IN input_text_box longtext
)
BEGIN

	
INSERT INTO card (card_id, card_name, image_path, rarity, artist_name, converted_mana_cost, power, toughness,
 expansion_id, text_box)
 VALUES (input_card_id, input_card_name, input_image_path, input_rarity, input_artist_name, input_converted_mana_cost, 
 input_power, input_toughness, input_expansion_id, input_text_box);


END$$

DELIMITER ;

# DROP PROCEDURE InsertCard;