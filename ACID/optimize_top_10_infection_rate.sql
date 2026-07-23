CREATE INDEX idx_covid_covering_infection_rate 
ON covid_cases (infection_rate, Country, Date, Confirmed_Cases, Population);

SELECT Country, infection_rate 
FROM covid_cases 
ORDER BY infection_rate DESC 
LIMIT 10;