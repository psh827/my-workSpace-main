USE jv250;

SHOW TABLES;

DESC Customer;

CREATE INDEX CustomerIndex ON Customer(ssn);

SELECT a.aid, a.accountNum, a.accountType, a.balance, c.cid FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = '840104-1234567';