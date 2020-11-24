CREATE OR REPLACE FUNCTION qtycalculation()
	RETURNS trigger
	LANGUAGE 'plpgsql'
AS $$	
	DECLARE newq INTEGER;
	DECLARE newm INTEGER;
	DECLARE newc INTEGER;
BEGIN

	SELECT NEW.orderqty INTO newq;
	SELECT NEW.material_id INTO newm;
	SELECT NEW.construction_id INTO newc;
  	
	PERFORM i.construction_id, i.material_id, i.orderqty FROM billposition c INNER JOIN orderposition i ON c.material_id=i.material_id AND c.construction_id=i.construction_id AND c.billqty>=newq;
	
	UPDATE billposition SET billqty=billqty-newq WHERE material_id=newm AND construction_id=newc;
	
	RETURN	NULL;

END;
	$$;
	




CREATE TRIGGER addOrderPosition
	AFTER INSERT ON orderposition
	FOR EACH ROW
	EXECUTE PROCEDURE qtycalculation();