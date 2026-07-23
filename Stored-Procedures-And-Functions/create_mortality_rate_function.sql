DELIMITER //

CREATE FUNCTION CalculateMortalityRate(
    p_country VARCHAR(100),
    p_date DATE
) 
RETURNS DECIMAL(5,2)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_confirmed INT;
    DECLARE v_deaths INT;
    DECLARE v_mortality_rate DECIMAL(5,2) DEFAULT 0.00;

    SELECT c.Confirmed_Cases, d.Deaths 
    INTO v_confirmed, v_deaths
    FROM covid_cases c
    LEFT JOIN covid_deaths d ON c.Country = d.Country AND c.Date = d.Date
    WHERE c.Country = p_country AND c.Date = p_date;

    IF v_confirmed IS NOT NULL AND v_confirmed > 0 THEN
        SET v_mortality_rate = (v_deaths / v_confirmed) * 100.0;
    END IF;

    RETURN v_mortality_rate;
END //

DELIMITER ;