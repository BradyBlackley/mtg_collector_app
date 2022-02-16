DELIMITER $$

CREATE PROCEDURE InsertType(
	IN input_type_name VARCHAR(255)
)
BEGIN
	
INSERT INTO type (type_name)
 VALUES (input_type_name);

END$$

DELIMITER ;

# DROP PROCEDURE InsertType;