CREATE INDEX idx_covid_country_date 
ON covid_cases (Country, Date);

CREATE INDEX idx_covid_date 
ON covid_cases (Date);