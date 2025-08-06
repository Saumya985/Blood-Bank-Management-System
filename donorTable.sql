CREATE DATABASE bbms;
USE bbms;

CREATE TABLE donor(
donorID INT auto_increment primary key,
name VARCHAR(100),
father_name VARCHAR(100),
mother_name VARCHAR(100),
dob VARCHAR(20),
mobileNo VARCHAR(10),
gender VARCHAR(10),
email VARCHAR(100),
blood_group VARCHAR(10),
city VARCHAR(80),
address VARCHAR(500)
);

CREATE TABLE stock(
blood_group VARCHAR(20),
unit INT
);
INSERT INTO stock (blood_group, unit) VALUES
('A+', 0),
('A-', 0),
('B+', 0),
('B-', 0),
('O+', 0),
('O-', 0),
('AB+', 0),
('AB-', 0);


SELECT * FROM bbms.donor;
DROP TABLE donor;
DELETE FROM donor WHERE donorID IN (10, 11);

SELECT * FROM stock;
DROP TABLE stock;