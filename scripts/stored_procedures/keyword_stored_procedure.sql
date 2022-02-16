DELIMITER $$

CREATE PROCEDURE InsertKeyword(
	IN input_keyword_name VARCHAR(255)
)
BEGIN
	
INSERT INTO keyword (keyword_name)
 VALUES (input_keyword_name);

END$$

DELIMITER ;

# DROP PROCEDURE InsertKeyword;