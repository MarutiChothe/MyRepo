use test;

drop table if exists cards;

CREATE TABLE `cards` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cardno` BIGINT(16) DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

/*
-- Query: SELECT * FROM test.cards
LIMIT 0, 1000

*/
INSERT INTO `cards` (`cardno`) VALUES (1234541211212124);
INSERT INTO `cards` (`cardno`) VALUES (1234541211212129);
INSERT INTO `cards` (`cardno`) VALUES (1274541211212124);
INSERT INTO `cards` (`cardno`) VALUES (1234541234112124);
INSERT INTO `cards` (`cardno`) VALUES (1234541734112123);
INSERT INTO `cards` (`cardno`) VALUES (1234512134112123);
12121212121212

--
-- Create the Stored Procedure: getCars
--

drop procedure if exists validateCard;

DELIMITER //

CREATE PROCEDURE `validateCard`(IN crdno bigint, OUT status_code VARCHAR(4), OUT status_message VARCHAR(128))
BEGIN
	

    DECLARE cardsCount double;
 
    SELECT count(*) INTO cardsCount
    FROM cards
    WHERE cardno = crdno;
 IF cardsCount > 0 THEN
			set status_code = '0000';
			set status_message = 'success';
    ELSE     set status_code = 'D100';
			set status_message = 'Card number not Valid';
    
    END IF;	
	
END//
