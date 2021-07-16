## Part 1: Test it with SQL
CREATE TABLE jobs (
   id INT,
   name VARCHAR(255),
   employer VARCHAR(255),
   location VARCHAR(255),
   positionType VARCHAR(255),
   skill VARCHAR(255)
);
## Part 2: Test it with SQL
SELECT *
FROM employer
WHERE location = "Saint Louis"
## Part 3: Test it with SQL
DROP TABLE IF EXISTS job;
## Part 4: Test it with SQL