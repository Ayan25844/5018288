-- Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer.

BEGIN
    FOR LOAN_RECORD IN (
        SELECT
            L.LOANID,
            C.NAME,
            L.ENDDATE
        FROM
            LOANS     L
            JOIN CUSTOMERS C
            ON L.CUSTOMERID = C.CUSTOMERID
        WHERE
            L.ENDDATE BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer '
                             || LOAN_RECORD.NAME
                             || ' has a loan (ID: '
                             || LOAN_RECORD.LOANID
                             || ') due on '
                             || TO_CHAR(LOAN_RECORD.ENDDATE, 'MM/DD/YYYY'));
    END LOOP;
END;