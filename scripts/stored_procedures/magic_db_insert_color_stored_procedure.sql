DELIMITER $$

CREATE PROCEDURE InsertColor(
	IN input_color_name VARCHAR(255)
)
BEGIN

INSERT INTO color (color_name)
VALUES (input_color_name);

END$$

DELIMITER ;

# DROP PROCEDURE InsertColor;