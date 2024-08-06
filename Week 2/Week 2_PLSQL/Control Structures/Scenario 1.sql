-- Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.

BEGIN
 
    -- Cursor to fetch customers older than 60
    FOR CUST_REC IN (
        SELECT
            CUSTOMERID,
            DOB
        FROM
            CUSTOMERS
        WHERE
            DOB <= ADD_MONTHS(SYSDATE, -12*60) -- Customers older than 60 years
    ) LOOP
 
        -- Update loan interest rates for the current customer
        UPDATE LOANS
        SET
            INTERESTRATE = INTERESTRATE - 1 -- Applying a 1% discount
        WHERE
            CUSTOMERID = CUST_REC.CUSTOMERID;
    END LOOP;
 

    -- Commit the changes
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
 
        -- Rollback in case of an error
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An error occurred: '
                             || SQLERRM);
END;