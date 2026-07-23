DELIMITER //

CREATE FUNCTION CalculateRecoveryRate(
    p_country VARCHAR(100),
    p_date DATE
) 
RETURNS DECIMAL(5,2)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_confirmed INT;
    DECLARE v_recoveries INT;
    DECLARE v_recovery_rate DECIMAL(5,2) DEFAULT 0.00;

    SELECT Confirmed_Cases, Recoveries 
    INTO v_confirmed, v_recoveries
    FROM covid_cases
    WHERE Country = p_country AND Date = p_date;

    IF v_confirmed IS NOT NULL AND v_confirmed > 0 THEN
        SET v_recovery_rate = (v_recoveries / v_confirmed) * 100.0;
    END IF;

    RETURN v_recovery_rate;
END //

DELIMITER ;