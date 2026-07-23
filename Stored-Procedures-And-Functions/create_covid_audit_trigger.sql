CREATE TABLE IF NOT EXISTS covid_cases_audit (
    audit_id INT AUTO_INCREMENT PRIMARY KEY,
    Country VARCHAR(100),
    Date DATE,
    old_confirmed INT,
    new_confirmed INT,
    old_recoveries INT,
    new_recoveries INT,
    changed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DELIMITER //

CREATE TRIGGER trg_covid_cases_before_update
BEFORE UPDATE ON covid_cases
FOR EACH ROW
BEGIN
    INSERT INTO covid_cases_audit (
        Country,
        Date,
        old_confirmed,
        new_confirmed,
        old_recoveries,
        new_recoveries
    )
    VALUES (
        OLD.Country,
        OLD.Date,
        OLD.Confirmed_Cases,
        NEW.Confirmed_Cases,
        OLD.Recoveries,
        NEW.Recoveries
    );
END //

DELIMITER ;