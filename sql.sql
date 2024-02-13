use bankingsystem;

show tables;
CREATE TABLE `user` (
  `account_no` int NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `cdob` date DEFAULT NULL,
  `age` int DEFAULT NULL,
  `creation_acount` datetime DEFAULT CURRENT_TIMESTAMP,
  `passwold` varchar(4) DEFAULT NULL,
  `balance` float DEFAULT NULL,
  PRIMARY KEY (`account_no`),
  UNIQUE KEY `customer_id_UNIQUE` (`account_no`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `passwold` (`passwold`),
  CONSTRAINT `user_chk_1` CHECK ((`balance` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `bankingsystem`.`user`
(`account_no`,
`first_name`,
`last_name`,
`email`,
`cdob`,
`age`,

`passwold`,
`balance`)

VALUES(10001,'pranav','patil','pranvmpatil2002@gmail.com','2002-08-23',21,'2002',1000.53),
(1,'sumit','koulapure','koulapuresumit@gmail.com','2003-04-09',20,'1234',50000);



create table transactions (
    account_no int not null,
     old_balance float not null ,
    balance float not null,
    transaction_type enum('withdraw', 'deposit') not null,
    transaction_date timestamp default current_timestamp,
    foreign key (account_no) references user(account_no)
);

INSERT INTO transactions (account_no,old_balance,balance,transaction_type) VALUES(1,10000,1000,'withdraw');
