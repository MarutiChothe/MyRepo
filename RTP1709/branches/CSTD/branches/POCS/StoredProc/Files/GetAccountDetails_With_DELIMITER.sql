USE `st`;
DROP procedure IF EXISTS `GetAccountDetails`;

DELIMITER $$
USE `st`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAccountDetails`(IN clientName VARCHAR(20),
																																IN channelName VARCHAR(20),
                                                                IN customerId BIGINT(20),
                                                                IN branchCode VARCHAR(20),
                                                                OUT statusCode VARCHAR(10),
                                                                OUT statusMessage VARCHAR(256))
proc_label:BEGIN

    -- declarations
    DECLARE clientIdCount INT;
    DECLARE channelIdCount INT;
    DECLARE clientId INT;
    DECLARE channelId INT;
    DECLARE clientChannelMapping INT;
    DECLARE customerCount INT;
    DECLARE cardCount INT;

		-- check valid client
    SELECT count(id) INTO clientIdCount FROM client WHERE name = clientName;
    IF (clientIdCount = 0) THEN
        SET statusCode = "AD1000";
        SET statusMessage = "INVALID CLIENT ID";
        LEAVE proc_label;
    END IF;

    -- check valid channel
    SELECT count(id) INTO channelIdCount FROM channel WHERE name = channelName;
    IF (channelIdCount = 0) THEN
        SET statusCode = "AD1001";
        SET statusMessage = "INVALID CHANNEL ID";
        LEAVE proc_label;
    END IF;

    -- check valid client and channel combination
    SELECT id INTO clientId FROM client WHERE name = clientName;
    SELECT id INTO channelId FROM channel WHERE name = channelName;
    SELECT count(*) INTO clientChannelMapping FROM client_to_channel_mapping
		WHERE client_id = clientId AND channel_id = channelId;
		IF (clientChannelMapping = 0) THEN
        SET statusCode = "AD1002";
        SET statusMessage = "INVALID CLIENT and CHANNEL ID COMBINATION";
        LEAVE proc_label;
    END IF;

    -- check valid customer and branch code
    SELECT count(id) INTO customerCount FROM customer
		WHERE customer_id = customerId AND branch_code = branchCode;
		IF (customerCount = 0) THEN
        SET statusCode = "AD2000";
        SET statusMessage = "INVALID CUSTOMER DETAILS";
        LEAVE proc_label;
    END IF;

    -- fetch all the cards related to the customer
    SELECT count(id) INTO cardCount FROM card_details WHERE customer_id = customerId;
    IF (cardCount != 0) THEN
				SELECT c.card_number, c.card_type,
               c.over_draft_eligible, c.card_name, c.card_limit, c.used_amount, c.over_draft_limit,
			         c.available_balance
				FROM card_details c
				WHERE c.customer_id = customerId;

        SET statusCode = "AD0000";
        SET statusMessage = "SUCCESS";
		ELSE
        SET statusCode = "AD3000";
        SET statusMessage = "NO CARD FOUND FOR THE CUSTOMER";
        LEAVE proc_label;
    END IF;


END$$

DELIMITER ;
