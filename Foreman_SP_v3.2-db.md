CREATE OR REPLACE FUNCTION checkqty()
	RETURNS trigger
	LANGUAGE 'plpgsql'
AS $$	
	DECLARE newq INTEGER;
	DECLARE newm INTEGER;
	DECLARE newc INTEGER;
	DECLARE newstatus BOOLEAN;
	DECLARE bc INTEGER;
	
BEGIN

	SELECT NEW.orderqty INTO newq;
	SELECT NEW.material_id INTO newm;
	SELECT NEW.construction_id INTO newc;
	SELECT NEW.status_delivered INTO newstatus;
	SELECT bp.billqty FROM billposition bp WHERE bp.material_id=newm AND bp.construction_id=newc INTO bc;
  	
	PERFORM i.construction_id, i.material_id, i.orderqty FROM billposition c INNER JOIN orderposition i ON c.material_id=i.material_id AND c.construction_id=i.construction_id;
	
	UPDATE orderposition SET orderqty=bc WHERE material_id=newm AND construction_id=newc AND newstatus=false AND orderqty > bc;
	
	RETURN	NULL;

END;
	$$;


CREATE TRIGGER chkOrderPosition
	AFTER INSERT OR UPDATE ON orderposition
	FOR EACH ROW
	EXECUTE PROCEDURE checkqty();








CREATE OR REPLACE FUNCTION setdelivered()
	RETURNS trigger
	LANGUAGE 'plpgsql'
AS $$	

	DECLARE newidupd INTEGER;
	DECLARE newstatus BOOLEAN;

BEGIN

	SELECT NEW.id INTO newidupd;
	SELECT NEW.status_executed INTO newstatus;
	
	PERFORM i.order_id FROM "order" r INNER JOIN orderposition i ON r.id=newidupd AND r.id=i.order_id WHERE r.status_executed=true;

	UPDATE orderposition SET status_delivered=true WHERE order_id=newidupd AND newstatus=true;
	
	RETURN	NULL;

END;
	$$;

CREATE TRIGGER updateOrder
	AFTER UPDATE ON "order"
	FOR EACH ROW
	EXECUTE PROCEDURE setdelivered();








CREATE OR REPLACE FUNCTION qtycalculation()
	RETURNS trigger
	LANGUAGE 'plpgsql'
AS $$	
	DECLARE newq INTEGER;
	DECLARE newm INTEGER;
	DECLARE newc INTEGER;
	DECLARE newstatus BOOLEAN;
BEGIN

	SELECT NEW.orderqty INTO newq;
	SELECT NEW.material_id INTO newm;
	SELECT NEW.construction_id INTO newc;
	SELECT NEW.status_delivered INTO newstatus;
  	
	PERFORM i.construction_id, i.material_id, i.orderqty FROM billposition c INNER JOIN orderposition i ON c.material_id=i.material_id AND c.construction_id=i.construction_id AND c.billqty>=newq;
	
	UPDATE billposition SET billqty=billqty-newq WHERE material_id=newm AND construction_id=newc AND newstatus=true;
	
	RETURN	NULL;

END;
	$$;


CREATE TRIGGER updateOrderPosition
	AFTER UPDATE ON orderposition
	FOR EACH ROW
	EXECUTE PROCEDURE qtycalculation();

