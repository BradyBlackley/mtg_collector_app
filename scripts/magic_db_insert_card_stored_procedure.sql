DELIMITER $$

CREATE PROCEDURE InsertCard(
	IN input_card_id VARCHAR(255),
    IN input_name VARCHAR(255),
    IN input_mana_type ENUM('white','blue','black','red','green','colorless', 'multi-colored'),
    IN input_image_path VARCHAR(255),
    IN input_rarity VARCHAR(255),
    IN input_artist_name VARCHAR(255),
    IN input_converted_mana_cost int,
    IN input_power int,
    IN input_toughness int,
    IN input_expansion_id int,
    IN input_collector_number int,
    IN input_is_modal bool,
    IN input_is_alternate_art bool
)
BEGIN

	
INSERT INTO card (card_id, name, mana_type, image_path, rarity, artist_name, converted_mana_cost, power, toughness,
 expansion_id, collector_number, is_modal, is_alternate_art)
 VALUES (input_card_id, input_name, input_mana_type, input_image_path, input_rarity, input_artist_name, input_converted_mana_cost,
 input_power, input_toughness, input_expansion_id, input_collector_number, input_is_modal, input_is_alternate_art);


END$$

DELIMITER ;

DROP PROCEDURE InsertCard;