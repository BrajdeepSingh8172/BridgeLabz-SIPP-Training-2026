EXPLAIN SELECT c.Country, c.Date, c.Confirmed_Cases, d.Deaths, v.Total_Vaccinations
FROM covid_cases c
JOIN covid_deaths d ON c.Country = d.Country AND c.Date = d.Date
JOIN covid_vaccines v ON c.Country = v.Country AND c.Date = v.Date
WHERE c.Country = 'India' AND c.Date >= '2021-01-01';