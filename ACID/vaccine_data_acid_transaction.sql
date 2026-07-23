START TRANSACTION;

INSERT INTO covid_vaccines (Country, Date, Total_Vaccinations)
VALUES ('India', '2021-05-03', 150000000);

INSERT INTO covid_cases (Country, Date, Confirmed_Cases, Recoveries, Population)
VALUES ('India', '2021-05-03', 19925604, 16293003, 1380004385);

COMMIT;
