-- Write a stored procedure UpdateEmployeeBonus that updates the salary of employees in a given department by adding a bonus percentage passed as a parameter.

CREATE OR REPLACE PROCEDURE UPDATEEMPLOYEEBONUS (
    P_DEPARTMENT IN VARCHAR2,
    P_BONUS_PERCENTAGE IN NUMBER
) IS
BEGIN
    UPDATE EMPLOYEES
    SET
        SALARY = SALARY + (
            SALARY * P_BONUS_PERCENTAGE / 100
        )
    WHERE
        DEPARTMENT = P_DEPARTMENT;
    COMMIT; -- Commit the changes, if desired
END;