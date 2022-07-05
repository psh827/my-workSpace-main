INSERT INTO Customer (name, ssn) VALUES ('James Bond', '900101-1234567');

INSERT INTO Account (accType, balance, interestRate, overdraftAcount, customerId) 
VALUES ('C', 2000.0, 0.03, 0.0, 1001);

UPDATE Customer SET WHERE cid = 1002;

DELETE FROM Customer WHERE cid = 1002;

SELECT accType, balance FROM Account WHERE aid = 3001;

