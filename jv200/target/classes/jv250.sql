CREATE TABLE Sample10 (
	no 			INT(11)			PRIMARY KEY	AUTO_INCREMENT,
	name 		VARCHAR(20) 	DEFAULT NULL,
	birthday	DATE			DEFAULT NULL,
	address		VARCHAR(40)		DEFAULT NULL
);

SELECT * FROM Sample10;

INSERT INTO Sample10 (name, birthday, address)VALUES ('유비', '1996-10-25', '대구 중구 반월당'),
('관우', '1202-1-3', '촉 형주'),
('장비', '1212-6-9', '오장원');

CREATE TABLE Customer(
	cid			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	name 		VARCHAR(20)		NOT NULL,
	ssn			VARCHAR(14)		NOT NULL,
	phone		VARCHAR(14)		NOT NULL,
	customerID	VARCHAR(16)		NOT NULL,
	passwd		VARCHAR(16)		NOT NULL,
	regDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 1001;

ALTER TABLE Customer CHANGE customerID userId VARCHAR(16) NOT NULL;

SELECT * FROM Customer;

INSERT INTO Customer (name, ssn, phone, customerID, passwd) 
VALUES ('유비', '961025-1234567', '010-1234-1234', 'java', '1111');

INSERT INTO Customer (name, ssn, phone, customerID, passwd) 
VALUES ('관우', '020103-2345678', '010-2345-2345', 'java11', '2222');

INSERT INTO Customer (name, ssn, phone, customerID, passwd) 
VALUES ('유비', '020609-3456789', '010-3456-3456', 'java8', '3333');

INSERT INTO Customer (name, ssn, phone, customerID, passwd) 
VALUES ('장비', '020609-3456789', '010-3456-3456', 'java8', '3333');

UPDATE Customer SET name='제갈량', phone='010-4501-7852', customerID='java9', passwd='4444' WHERE cid=1003;

UPDATE Customer SET ssn='020412-2451876' WHERE cid=1003;

DELETE FROM Customer WHERE cid=1006;

CREATE TABLE Account(
	aid				BIGINT			PRIMARY KEY	AUTO_INCREMENT,
	accountNum		VARCHAR(11)		NOT NULL, 		-- 111-11-1111
	balance 		DOUBLE			NOT NULL	DEFAULT 0.0,
	interestRate	DOUBLE 			NOT NULL	DEFAULT 0.0,
	overdraft		DOUBLE			NOT NULL	DEFAULT 0.0,
	accountType		CHAR(1)			NOT NULL	DEFAULT 'S',
	customerId		BIGINT			NOT NULL,
	regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	
	CONSTRAINT Account_CustomerId_FK	FOREIGN KEY (customerId) REFERENCES Customer(cid)
)AUTO_INCREMENT = 3001;

DROP TABLE Account;

DELETE FROM Account WHERE aid=3015;

SELECT * FROM Account;

INSERT INTO Account (accountNum, balance, interestRate, customerId) VALUES ('111-11-1111', 2000.1, 5.5, 1001);

-- inner join
SELECT * FROM Account, Customer WHERE Account.customerId = Customer.cid AND Customer.ssn = '961025-1234567';

SELECT * FROM Account a INNER JOIN Customer c ON a.customerId = c.cid;

SELECT * FROM Account a INNER JOIN Customer c ON a.customerId = c.cid
WHERE c.ssn = '961025-1234567';



