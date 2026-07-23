CREATE OR REPLACE VIEW view_latest_covid_data AS
WITH RankedCases AS (
    SELECT 
        c.Country,
        c.Date,
        c.Confirmed_Cases,
        c.Recoveries,
        d.Deaths,
        ROW_NUMBER() OVER (PARTITION BY c.Country ORDER BY c.Date DESC) AS rn
    FROM covid_cases c
    LEFT JOIN covid_deaths d ON c.Country = d.Country AND c.Date = d.Date
)
SELECT 
    Country,
    Date AS Latest_Date,
    Confirmed_Cases,
    Recoveries,
    Deaths
FROM RankedCases
WHERE rn = 1;