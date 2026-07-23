DELIMITER //

CREATE PROCEDURE UpdateCovidStats(
    IN p_country VARCHAR(100),
    IN p_date DATE,
    IN p_confirmed INT,
    IN p_recoveries INT,
    IN p_deaths INT
)
BEGIN
    START TRANSACTION;

    INSERT INTO covid_cases (Country, Date, Confirmed_Cases, Recoveries)
    VALUES (p_country, p_date, p_confirmed, p_recoveries)
    ON DUPLICATE KEY UPDATE
        Confirmed_Cases = p_confirmed,
        Recoveries = p_recoveries;

    INSERT INTO covid_deaths (Country, Date, Deaths)
    VALUES (p_country, p_date, p_deaths)
    ON DUPLICATE KEY UPDATE
        Deaths = p_deaths;

    COMMIT;
END //

DELIMITER ;