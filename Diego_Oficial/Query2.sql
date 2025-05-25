

-- Insertar usuario
CREATE PROCEDURE sp_insertUser
    @D_Name VARCHAR(50),
    @D_Email VARCHAR(50),
    @D_Password VARCHAR(50),
    @C_Phone INT,
    @D_Province VARCHAR(50),
    @D_County VARCHAR(50),
    @D_District VARCHAR(50),
    @D_Additional_Address VARCHAR(100),
    @T_Role VARCHAR(50),
    @D_Status VARCHAR(50),
    @F_Registration DATETIME
AS
BEGIN
    INSERT INTO T_Users (D_Name, D_Email, D_Password, C_Phone, D_Province, D_County, D_District, D_Additional_Address, T_Role, D_Status, F_Registration)
    VALUES (@D_Name, @D_Email, @D_Password, @C_Phone, @D_Province, @D_County, @D_District, @D_Additional_Address, @T_Role, @D_Status, @F_Registration);
END;
GO

-- Actualizar usuario
CREATE PROCEDURE sp_updateUser
    @C_User INT,
    @D_Name VARCHAR(50),
    @D_Email VARCHAR(50),
    @D_Password VARCHAR(50),
    @C_Phone INT,
    @D_Province VARCHAR(50),
    @D_County VARCHAR(50),
    @D_District VARCHAR(50),
    @D_Additional_Address VARCHAR(100),
    @T_Role VARCHAR(50),
    @D_Status VARCHAR(50)
AS
BEGIN
    UPDATE T_Users
    SET D_Name = @D_Name, D_Email = @D_Email, D_Password = @D_Password,
        C_Phone = @C_Phone, D_Province = @D_Province, D_County = @D_County,
        D_District = @D_District, D_Additional_Address = @D_Additional_Address,
        T_Role = @T_Role, D_Status = @D_Status
    WHERE C_User = @C_User;
END;
GO

-- Eliminar usuario
CREATE PROCEDURE sp_deleteUser
    @C_User INT
AS
BEGIN
    DELETE FROM T_Users WHERE C_User = @C_User;
END;
GO

-- Función de lectura
CREATE FUNCTION fn_readUsers()
RETURNS TABLE
AS
RETURN (
    SELECT * FROM T_Users
);
GO


CREATE PROCEDURE sp_insertCreditor
    @D_Name VARCHAR(50),
    @D_Email VARCHAR(50),
    @D_Password VARCHAR(50),
    @C_Phone INT,
    @D_Province VARCHAR(50),
    @D_County VARCHAR(50),
    @D_District VARCHAR(50),
    @D_Additional_Address VARCHAR(100)
AS
BEGIN
    INSERT INTO T_Creditor (D_Name, D_Email, D_Password, C_Phone, D_Province, D_County, D_District, D_Additional_Address)
    VALUES (@D_Name, @D_Email, @D_Password, @C_Phone, @D_Province, @D_County, @D_District, @D_Additional_Address);
END;
GO

CREATE PROCEDURE sp_updateCreditor
    @C_Creditor INT,
    @D_Name VARCHAR(50),
    @D_Email VARCHAR(50),
    @D_Password VARCHAR(50),
    @C_Phone INT,
    @D_Province VARCHAR(50),
    @D_County VARCHAR(50),
    @D_District VARCHAR(50),
    @D_Additional_Address VARCHAR(100)
AS
BEGIN
    UPDATE T_Creditor
    SET D_Name = @D_Name, D_Email = @D_Email, D_Password = @D_Password,
        C_Phone = @C_Phone, D_Province = @D_Province, D_County = @D_County,
        D_District = @D_District, D_Additional_Address = @D_Additional_Address
    WHERE C_Creditor = @C_Creditor;
END;
GO

CREATE PROCEDURE sp_deleteCreditor
    @C_Creditor INT
AS
BEGIN
    DELETE FROM T_Creditor WHERE C_Creditor = @C_Creditor;
END;
GO

CREATE FUNCTION fn_readCreditors()
RETURNS TABLE
AS
RETURN (
    SELECT * FROM T_Creditor
);
GO


CREATE PROCEDURE sp_insertAccount
    @C_User INT,
    @D_Account_Name VARCHAR(100),
    @M_Initial_Amount DECIMAL(10,6),
    @M_Current_Balance DECIMAL(10,6),
    @D_Status VARCHAR(50)
AS
BEGIN
    INSERT INTO T_Accounts (C_User, D_Account_Name, M_Initial_Amount, M_Current_Balance, D_Status)
    VALUES (@C_User, @D_Account_Name, @M_Initial_Amount, @M_Current_Balance, @D_Status);
END;
GO

CREATE PROCEDURE sp_updateAccount
    @C_Account INT,
    @D_Account_Name VARCHAR(100),
    @M_Initial_Amount DECIMAL(10,6),
    @M_Current_Balance DECIMAL(10,6),
    @D_Status VARCHAR(50)
AS
BEGIN
    UPDATE T_Accounts
    SET D_Account_Name = @D_Account_Name,
        M_Initial_Amount = @M_Initial_Amount,
        M_Current_Balance = @M_Current_Balance,
        D_Status = @D_Status
    WHERE C_Account = @C_Account;
END;
GO

CREATE PROCEDURE sp_deleteAccount
    @C_Account INT
AS
BEGIN
    DELETE FROM T_Accounts WHERE C_Account = @C_Account;
END;
GO

CREATE FUNCTION fn_readAccounts()
RETURNS TABLE
AS
RETURN (
    SELECT * FROM T_Accounts
);
GO



CREATE PROCEDURE sp_insertTransactionType
    @D_Transaction_Name VARCHAR(50)
AS
BEGIN
    INSERT INTO T_Transaction_Type (D_Transaction_Name)
    VALUES (@D_Transaction_Name);
END;
GO

CREATE PROCEDURE sp_updateTransactionType
    @C_Transaction_Type INT,
    @D_Transaction_Name VARCHAR(50)
AS
BEGIN
    UPDATE T_Transaction_Type
    SET D_Transaction_Name = @D_Transaction_Name
    WHERE C_Transaction_Type = @C_Transaction_Type;
END;
GO

CREATE PROCEDURE sp_deleteTransactionType
    @C_Transaction_Type INT
AS
BEGIN
    DELETE FROM T_Transaction_Type
    WHERE C_Transaction_Type = @C_Transaction_Type;
END;
GO

CREATE FUNCTION fn_readTransactionTypes()
RETURNS TABLE
AS
RETURN (
    SELECT * FROM T_Transaction_Type
);
GO

CREATE PROCEDURE sp_insertTransactionCategory
    @D_Category_Name VARCHAR(50),
    @D_Category_Description VARCHAR(100),
    @T_Category_Type VARCHAR(50)
AS
BEGIN
    INSERT INTO T_Transaction_Category (D_Category_Name, D_Category_Description, T_Category_Type)
    VALUES (@D_Category_Name, @D_Category_Description, @T_Category_Type);
END;
GO

CREATE PROCEDURE sp_updateTransactionCategory
    @C_Transaction_Category INT,
    @D_Category_Name VARCHAR(50),
    @D_Category_Description VARCHAR(100),
    @T_Category_Type VARCHAR(50)
AS
BEGIN
    UPDATE T_Transaction_Category
    SET D_Category_Name = @D_Category_Name,
        D_Category_Description = @D_Category_Description,
        T_Category_Type = @T_Category_Type
    WHERE C_Transaction_Category = @C_Transaction_Category;
END;
GO

CREATE PROCEDURE sp_deleteTransactionCategory
    @C_Transaction_Category INT
AS
BEGIN
    DELETE FROM T_Transaction_Category
    WHERE C_Transaction_Category = @C_Transaction_Category;
END;
GO

CREATE FUNCTION fn_readTransactionCategories()
RETURNS TABLE
AS
RETURN (
    SELECT * FROM T_Transaction_Category
);
GO





CREATE PROCEDURE sp_insertDebtType
    @D_Debt_Type_Name VARCHAR(50)
AS
BEGIN
    INSERT INTO T_Debt_Type (D_Debt_Type_Name)
    VALUES (@D_Debt_Type_Name);
END;
GO

CREATE PROCEDURE sp_updateDebtType
    @C_Debt_Type INT,
    @D_Debt_Type_Name VARCHAR(50)
AS
BEGIN
    UPDATE T_Debt_Type
    SET D_Debt_Type_Name = @D_Debt_Type_Name
    WHERE C_Debt_Type = @C_Debt_Type;
END;
GO

CREATE PROCEDURE sp_deleteDebtType
    @C_Debt_Type INT
AS
BEGIN
    DELETE FROM T_Debt_Type
    WHERE C_Debt_Type = @C_Debt_Type;
END;
GO

CREATE FUNCTION fn_readDebtTypes()
RETURNS TABLE
AS
RETURN (
    SELECT * FROM T_Debt_Type
);
GO






-- =========================================
-- PROCEDIMIENTOS Y FUNCIONES PARA:
-- T_Loan_Type, T_Saving_Type, T_Expense_Type, T_Income_Type, T_Projection_Type
-- =========================================

-- ===================== T_Loan_Type =====================
CREATE PROCEDURE sp_insertLoanType
    @D_Loan_Type_Name VARCHAR(50)
AS
BEGIN
    INSERT INTO T_Loan_Type (D_Loan_Type_Name)
    VALUES (@D_Loan_Type_Name);
END;
GO

CREATE PROCEDURE sp_updateLoanType
    @C_Loan_Type INT,
    @D_Loan_Type_Name VARCHAR(50)
AS
BEGIN
    UPDATE T_Loan_Type
    SET D_Loan_Type_Name = @D_Loan_Type_Name
    WHERE C_Loan_Type = @C_Loan_Type;
END;
GO

CREATE PROCEDURE sp_deleteLoanType
    @C_Loan_Type INT
AS
BEGIN
    DELETE FROM T_Loan_Type WHERE C_Loan_Type = @C_Loan_Type;
END;
GO

CREATE FUNCTION fn_readLoanTypes()
RETURNS TABLE
AS
RETURN (
    SELECT * FROM T_Loan_Type
);
GO

-- ===================== T_Saving_Type =====================
CREATE PROCEDURE sp_insertSavingType
    @D_Saving_Type_Name VARCHAR(50)
AS
BEGIN
    INSERT INTO T_Saving_Type (D_Saving_Type_Name)
    VALUES (@D_Saving_Type_Name);
END;
GO

CREATE PROCEDURE sp_updateSavingType
    @C_Saving_Type INT,
    @D_Saving_Type_Name VARCHAR(50)
AS
BEGIN
    UPDATE T_Saving_Type
    SET D_Saving_Type_Name = @D_Saving_Type_Name
    WHERE C_Saving_Type = @C_Saving_Type;
END;
GO

CREATE PROCEDURE sp_deleteSavingType
    @C_Saving_Type INT
AS
BEGIN
    DELETE FROM T_Saving_Type WHERE C_Saving_Type = @C_Saving_Type;
END;
GO

CREATE FUNCTION fn_readSavingTypes()
RETURNS TABLE
AS
RETURN (
    SELECT * FROM T_Saving_Type
);
GO

-- ===================== T_Expense_Type =====================
CREATE PROCEDURE sp_insertExpenseType
    @D_Description VARCHAR(100)
AS
BEGIN
    INSERT INTO T_Expense_Type (D_Description)
    VALUES (@D_Description);
END;
GO

CREATE PROCEDURE sp_updateExpenseType
    @C_Expense_Type INT,
    @D_Description VARCHAR(100)
AS
BEGIN
    UPDATE T_Expense_Type
    SET D_Description = @D_Description
    WHERE C_Expense_Type = @C_Expense_Type;
END;
GO

CREATE PROCEDURE sp_deleteExpenseType
    @C_Expense_Type INT
AS
BEGIN
    DELETE FROM T_Expense_Type WHERE C_Expense_Type = @C_Expense_Type;
END;
GO

CREATE FUNCTION fn_readExpenseTypes()
RETURNS TABLE
AS
RETURN (
    SELECT * FROM T_Expense_Type
);
GO

-- ===================== T_Income_Type =====================
CREATE PROCEDURE sp_insertIncomeType
    @D_Description VARCHAR(100)
AS
BEGIN
    INSERT INTO T_Income_Type (D_Description)
    VALUES (@D_Description);
END;
GO

CREATE PROCEDURE sp_updateIncomeType
    @C_Income_Type INT,
    @D_Description VARCHAR(100)
AS
BEGIN
    UPDATE T_Income_Type
    SET D_Description = @D_Description
    WHERE C_Income_Type = @C_Income_Type;
END;
GO

CREATE PROCEDURE sp_deleteIncomeType
    @C_Income_Type INT
AS
BEGIN
    DELETE FROM T_Income_Type WHERE C_Income_Type = @C_Income_Type;
END;
GO

CREATE FUNCTION fn_readIncomeTypes()
RETURNS TABLE
AS
RETURN (
    SELECT * FROM T_Income_Type
);
GO

-- ===================== T_Projection_Type =====================
CREATE PROCEDURE sp_insertProjectionType
    @D_Projection_Type_Description VARCHAR(100)
AS
BEGIN
    INSERT INTO T_Projection_Type (D_Projection_Type_Description)
    VALUES (@D_Projection_Type_Description);
END;
GO

CREATE PROCEDURE sp_updateProjectionType
    @C_Projection_Type INT,
    @D_Projection_Type_Description VARCHAR(100)
AS
BEGIN
    UPDATE T_Projection_Type
    SET D_Projection_Type_Description = @D_Projection_Type_Description
    WHERE C_Projection_Type = @C_Projection_Type;
END;
GO

CREATE PROCEDURE sp_deleteProjectionType
    @C_Projection_Type INT
AS
BEGIN
    DELETE FROM T_Projection_Type WHERE C_Projection_Type = @C_Projection_Type;
END;
GO

CREATE FUNCTION fn_readProjectionTypes()
RETURNS TABLE
AS
RETURN (
    SELECT * FROM T_Projection_Type
);
GO




