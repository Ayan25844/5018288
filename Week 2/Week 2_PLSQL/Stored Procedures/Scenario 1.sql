-- Write a stored procedure ProcessMonthlyInterest that calculates and updates the balance of all savings accounts by applying an interest rate of 1% to the current balance.

CREATE OR REPLACE PROCEDURE PROCESSMONTHLYINTEREST IS
    V_INTEREST_RATE CONSTANT NUMBER := 0.01;
BEGIN
    UPDATE ACCOUNTS
    SET
        BALANCE = BALANCE + (
            BALANCE * V_INTEREST_RATE
        ),
        LASTMODIFIED = SYSDATE
    WHERE
        ACCOUNTTYPE = 'Savings';
END;