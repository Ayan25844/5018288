CREATE OR REPLACE PROCEDURE UPDATESALARY(
    ID IN EMPLOYEES.EMPLOYEEID%TYPE,
    PERCENTAGE IN NUMBER
) IS
    ID_CHECK EMPLOYEES.EMPLOYEEID%TYPE;
BEGIN
    SELECT
        EMPLOYEEID INTO ID_CHECK
    FROM
        EMPLOYEES
    WHERE
        EMPLOYEEID = ID;
    UPDATE EMPLOYEES
    SET
        SALARY=FLOOR(
            SALARY+(SALARY*(PERCENTAGE/100))
        )
    WHERE
        EMPLOYEEID=ID;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: EMPLOYEE ID '
                             ||ID
                             ||' DOES NOT EXIST IN THE RELATION.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERROR CODE: '
                             ||SQLCODE);
        DBMS_OUTPUT.PUT_LINE('ERROR MESSEGE: '
                             ||SQLERRM);
END;
