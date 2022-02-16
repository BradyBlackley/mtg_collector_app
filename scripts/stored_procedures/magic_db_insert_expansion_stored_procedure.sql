DELIMITER $$

CREATE PROCEDURE InsertExpansion(
	IN input_expansion_name VARCHAR(255),
    IN input_expansion_code VARCHAR(255),
    IN input_released_date DATE
)
BEGIN
	
INSERT INTO expansion (expansion_name, expansion_code, released_date)
 VALUES (input_expansion_name, input_expansion_code, input_released_date);

END$$

DELIMITER ;

# DROP PROCEDURE InsertExpansion;