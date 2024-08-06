-- Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000.

ALTER TABLE CUSTOMERS
    ADD (
        ISVIP CHAR(1)
    );

BEGIN
    FOR CUSTOMER_RECORD IN (
        SELECT
            CUSTOMERID,
            BALANCE
        FROM
            CUSTOMERS
    ) LOOP
 
        -- Check if the customer's balance is over $10,000
        IF CUSTOMER_RECORD.BALANCE > 10000 THEN
 
            -- Set IsVIP to 'TRUE'
            UPDATE CUSTOMERS
            SET
                ISVIP = 'T'
            WHERE
                CUSTOMERID = CUSTOMER_RECORD.CUSTOMERID;
        ELSE
 
            -- Set IsVIP to 'FALSE' for others, if necessary
            UPDATE CUSTOMERS
            SET
                ISVIP = 'F'
            WHERE
                CUSTOMERID = CUSTOMER_RECORD.CUSTOMERID;
        END IF;
    END LOOP;

    COMMIT; -- Commit the changes to the database
END;