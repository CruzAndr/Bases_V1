

-- =========================================
-- COMPLEMENTO: FUNCIONES Y PROCEDIMIENTOS RESTANTES
-- PARA: T_Expenses, T_Incomes, T_Debts, T_Loans, T_Transactions
-- =========================================

-- ===================== FUNCIONES =====================
CREATE FUNCTION fn_readExpenses()
RETURNS TABLE
AS
RETURN (
    SELECT * FROM T_Expenses
);
GO

CREATE FUNCTION fn_readIncomes()
RETURNS TABLE
AS
RETURN (
    SELECT * FROM T_Incomes
);
GO

CREATE FUNCTION fn_readDebts()
RETURNS TABLE
AS
RETURN (
    SELECT * FROM T_Debts
);
GO

CREATE FUNCTION fn_readLoans()
RETURNS TABLE
AS
RETURN (
    SELECT * FROM T_Loans
);
GO

CREATE FUNCTION fn_readTransactions()
RETURNS TABLE
AS
RETURN (
    SELECT * FROM T_Transactions
);
GO

-- ===================== PROCEDIMIENTOS UPDATE Y DELETE =====================
-- Expenses
CREATE PROCEDURE sp_updateExpense
    @C_Expense INT,
    @C_User INT,
    @C_Account INT,
    @C_Expense_Type INT,
    @M_Expense_Amount DECIMAL(10,6),
    @D_Expense_Description VARCHAR(100)
AS
BEGIN
    UPDATE T_Expenses
    SET C_User = @C_User,
        C_Account = @C_Account,
        C_Expense_Type = @C_Expense_Type,
        M_Expense_Amount = @M_Expense_Amount,
        D_Expense_Description = @D_Expense_Description
    WHERE C_Expense = @C_Expense;
END;
GO

CREATE PROCEDURE sp_deleteExpense
    @C_Expense INT
AS
BEGIN
    DELETE FROM T_Expenses WHERE C_Expense = @C_Expense;
END;
GO

-- Incomes
CREATE PROCEDURE sp_updateIncome
    @C_Income INT,
    @C_User INT,
    @C_Account INT,
    @C_Income_Type INT,
    @M_Income_Amount DECIMAL(10,6),
    @D_Income_Description VARCHAR(100),
    @F_Income_Date DATETIME
AS
BEGIN
    UPDATE T_Incomes
    SET C_User = @C_User,
        C_Account = @C_Account,
        C_Income_Type = @C_Income_Type,
        M_Income_Amount = @M_Income_Amount,
        D_Income_Description = @D_Income_Description,
        F_Income_Date = @F_Income_Date
    WHERE C_Income = @C_Income;
END;
GO

CREATE PROCEDURE sp_deleteIncome
    @C_Income INT
AS
BEGIN
    DELETE FROM T_Incomes WHERE C_Income = @C_Income;
END;
GO

-- Debts
CREATE PROCEDURE sp_updateDebt
    @C_Debt INT,
    @C_User INT,
    @C_Account INT,
    @C_Creditor INT,
    @C_Debt_Type INT,
    @T_Debt_Status VARCHAR(50),
    @M_Amount DECIMAL(10,3),
    @M_Interest DECIMAL(10,3),
    @M_Remaining_Balance DECIMAL(10,3),
    @F_Start_Date DATETIME,
    @F_Due_Date DATETIME,
    @D_Collateral VARCHAR(100)
AS
BEGIN
    UPDATE T_Debts
    SET C_User = @C_User,
        C_Account = @C_Account,
        C_Creditor = @C_Creditor,
        C_Debt_Type = @C_Debt_Type,
        T_Debt_Status = @T_Debt_Status,
        M_Amount = @M_Amount,
        M_Interest = @M_Interest,
        M_Remaining_Balance = @M_Remaining_Balance,
        F_Start_Date = @F_Start_Date,
        F_Due_Date = @F_Due_Date,
        D_Collateral = @D_Collateral
    WHERE C_Debt = @C_Debt;
END;
GO

CREATE PROCEDURE sp_deleteDebt
    @C_Debt INT
AS
BEGIN
    DELETE FROM T_Debts WHERE C_Debt = @C_Debt;
END;
GO

-- Loans
CREATE PROCEDURE sp_updateLoan
    @C_Loan INT,
    @C_User INT,
    @C_Account INT,
    @C_Creditor INT,
    @C_Loan_Type INT,
    @T_Loan_Status VARCHAR(50),
    @M_Loan_Amount DECIMAL(10,6),
    @M_Interest DECIMAL(10,6),
    @F_Start_Date DATETIME,
    @F_Due_Date DATETIME,
    @D_Collateral VARCHAR(100)
AS
BEGIN
    UPDATE T_Loans
    SET C_User = @C_User,
        C_Account = @C_Account,
        C_Creditor = @C_Creditor,
        C_Loan_Type = @C_Loan_Type,
        T_Loan_Status = @T_Loan_Status,
        M_Loan_Amount = @M_Loan_Amount,
        M_Interest = @M_Interest,
        F_Start_Date = @F_Start_Date,
        F_Due_Date = @F_Due_Date,
        D_Collateral = @D_Collateral
    WHERE C_Loan = @C_Loan;
END;
GO

CREATE PROCEDURE sp_deleteLoan
    @C_Loan INT
AS
BEGIN
    DELETE FROM T_Loans WHERE C_Loan = @C_Loan;
END;
GO

-- Transactions
CREATE PROCEDURE sp_updateTransaction
    @C_Transaction INT,
    @C_User INT,
    @C_Account INT,
    @C_Transaction_Category INT,
    @C_Transaction_Type INT,
    @M_Amount DECIMAL(10,6),
    @D_Transaction_Description VARCHAR(100),
    @F_Date DATETIME
AS
BEGIN
    UPDATE T_Transactions
    SET C_User = @C_User,
        C_Account = @C_Account,
        C_Transaction_Category = @C_Transaction_Category,
        C_Transaction_Type = @C_Transaction_Type,
        M_Amount = @M_Amount,
        D_Transaction_Description = @D_Transaction_Description,
        F_Date = @F_Date
    WHERE C_Transaction = @C_Transaction;
END;
GO

CREATE PROCEDURE sp_deleteTransaction
    @C_Transaction INT
AS
BEGIN
    DELETE FROM T_Transactions WHERE C_Transaction = @C_Transaction;
END;
GO





CREATE PROCEDURE sp_insertTransaction
    @C_User INT,
    @C_Account INT,
    @C_Transaction_Category INT,
    @C_Transaction_Type INT,
    @M_Amount DECIMAL(10,6),
    @D_Transaction_Description VARCHAR(100),
    @F_Date DATETIME
AS
BEGIN
    INSERT INTO T_Transactions (
        C_User,
        C_Account,
        C_Transaction_Category,
        C_Transaction_Type,
        M_Amount,
        D_Transaction_Description,
        F_Date
    )
    VALUES (
        @C_User,
        @C_Account,
        @C_Transaction_Category,
        @C_Transaction_Type,
        @M_Amount,
        @D_Transaction_Description,
        @F_Date
    );
END;


CREATE PROCEDURE sp_insertExpense
    @C_User INT,
    @C_Account INT,
    @C_Expense_Type INT,
    @M_Expense_Amount DECIMAL(10,6),
    @D_Expense_Description VARCHAR(100),
    @C_Transaction_Category INT,
    @C_Transaction_Type INT,
    @F_Date DATETIME
AS
BEGIN
    DECLARE @CurrentBalance DECIMAL(10,6);
    SELECT @CurrentBalance = M_Current_Balance FROM T_Accounts WHERE C_Account = @C_Account;

    IF @CurrentBalance < @M_Expense_Amount
    BEGIN
        RAISERROR('Insufficient balance.', 16, 1);
        RETURN;
    END

    -- Descontar el saldo
    UPDATE T_Accounts
    SET M_Current_Balance = M_Current_Balance - @M_Expense_Amount
    WHERE C_Account = @C_Account;

    -- Insertar el gasto
    INSERT INTO T_Expenses (C_User, C_Account, C_Expense_Type, M_Expense_Amount, D_Expense_Description)
    VALUES (@C_User, @C_Account, @C_Expense_Type, @M_Expense_Amount, @D_Expense_Description);

    -- Registrar en transacciones
    EXEC sp_insertTransaction @C_User, @C_Account, @C_Transaction_Category, @C_Transaction_Type,
                              @M_Expense_Amount, @D_Expense_Description, @F_Date;
END;



CREATE PROCEDURE sp_insertIncome
    @C_User INT,
    @C_Account INT,
    @C_Income_Type INT,
    @M_Income_Amount DECIMAL(10,6),
    @D_Income_Description VARCHAR(100),
    @F_Income_Date DATETIME,
    @C_Transaction_Category INT,
    @C_Transaction_Type INT
AS
BEGIN
    -- Aumentar el saldo
    UPDATE T_Accounts
    SET M_Current_Balance = M_Current_Balance + @M_Income_Amount
    WHERE C_Account = @C_Account;

    -- Insertar ingreso
    INSERT INTO T_Incomes (C_User, C_Account, C_Income_Type, M_Income_Amount, D_Income_Description, F_Income_Date)
    VALUES (@C_User, @C_Account, @C_Income_Type, @M_Income_Amount, @D_Income_Description, @F_Income_Date);

    -- Registrar en transacciones
    EXEC sp_insertTransaction @C_User, @C_Account, @C_Transaction_Category, @C_Transaction_Type,
                              @M_Income_Amount, @D_Income_Description, @F_Income_Date;
END;


CREATE PROCEDURE sp_insertDebt
    @C_User INT,
    @C_Account INT,
    @C_Creditor INT,
    @C_Debt_Type INT,
    @T_Debt_Status VARCHAR(50),
    @M_Amount DECIMAL(10,3),
    @M_Interest DECIMAL(10,3),
    @M_Remaining_Balance DECIMAL(10,3),
    @F_Start_Date DATETIME,
    @F_Due_Date DATETIME,
    @D_Collateral VARCHAR(100),
    @C_Transaction_Category INT,
    @C_Transaction_Type INT
AS
BEGIN
    DECLARE @Total DECIMAL(10,6) = @M_Amount + @M_Interest;
    DECLARE @CurrentBalance DECIMAL(10,6);
    SELECT @CurrentBalance = M_Current_Balance FROM T_Accounts WHERE C_Account = @C_Account;

    IF @CurrentBalance < @Total
    BEGIN
        RAISERROR('Insufficient balance for new debt.', 16, 1);
        RETURN;
    END

    -- Descontar total del saldo
    UPDATE T_Accounts
    SET M_Current_Balance = M_Current_Balance - @Total
    WHERE C_Account = @C_Account;

    -- Insertar deuda
    INSERT INTO T_Debts (C_User, C_Account, C_Creditor, C_Debt_Type, T_Debt_Status, M_Amount,
                         M_Interest, M_Remaining_Balance, F_Start_Date, F_Due_Date, D_Collateral)
    VALUES (@C_User, @C_Account, @C_Creditor, @C_Debt_Type, @T_Debt_Status, @M_Amount,
            @M_Interest, @M_Remaining_Balance, @F_Start_Date, @F_Due_Date, @D_Collateral);

    -- Registrar en transacciones
    EXEC sp_insertTransaction @C_User, @C_Account, @C_Transaction_Category, @C_Transaction_Type,
                              @Total, @D_Collateral, @F_Start_Date;
END;



CREATE PROCEDURE sp_insertLoan
    @C_User INT,
    @C_Account INT,
    @C_Creditor INT,
    @C_Loan_Type INT,
    @T_Loan_Status VARCHAR(50),
    @M_Loan_Amount DECIMAL(10,6),
    @M_Interest DECIMAL(10,6),
    @F_Start_Date DATETIME,
    @F_Due_Date DATETIME,
    @D_Collateral VARCHAR(100),
    @C_Transaction_Category INT,
    @C_Transaction_Type INT
AS
BEGIN
    DECLARE @Total DECIMAL(10,6) = @M_Loan_Amount + @M_Interest;
    DECLARE @CurrentBalance DECIMAL(10,6);
    SELECT @CurrentBalance = M_Current_Balance FROM T_Accounts WHERE C_Account = @C_Account;

    IF @CurrentBalance < @Total
    BEGIN
        RAISERROR('Insufficient balance for new loan.', 16, 1);
        RETURN;
    END

    -- Descontar total del saldo
    UPDATE T_Accounts
    SET M_Current_Balance = M_Current_Balance - @Total
    WHERE C_Account = @C_Account;

    -- Insertar préstamo
    INSERT INTO T_Loans (C_User, C_Account, C_Creditor, C_Loan_Type, T_Loan_Status, M_Loan_Amount,
                         M_Interest, F_Start_Date, F_Due_Date, D_Collateral)
    VALUES (@C_User, @C_Account, @C_Creditor, @C_Loan_Type, @T_Loan_Status, @M_Loan_Amount,
            @M_Interest, @F_Start_Date, @F_Due_Date, @D_Collateral);

    -- Registrar en transacciones
    EXEC sp_insertTransaction @C_User, @C_Account, @C_Transaction_Category, @C_Transaction_Type,
                              @Total, @D_Collateral, @F_Start_Date;
END;
