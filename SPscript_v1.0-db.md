CREATE OR REPLACE FUNCTION qtycalculation()
	RETURNS trigger
	LANGUAGE 'plpgsql'
AS $$	
	DECLARE x INTEGER;
	DECLARE y INTEGER;
BEGIN

	SELECT NEW.orderqty INTO x;
	SELECT NEW.material_id INTO y;
  	
	PERFORM i.material_id, i.orderqty FROM billposition c INNER JOIN orderposition i ON c.material_id=i.material_id;
	
	UPDATE billposition SET billqty=billqty-x WHERE material_id=y;
	
	RETURN	NULL;

END;
	$$;
	




CREATE TRIGGER addOrderPosition
	AFTER INSERT ON orderposition
	FOR EACH ROW
	EXECUTE PROCEDURE qtycalculation();