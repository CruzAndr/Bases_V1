USE Grupo3_IF51002025_V2
GO

/* ========================================= */
/*               MAIN TABLES                */
/* ========================================= */

CREATE TABLE T_Users (
    C_User INT PRIMARY KEY IDENTITY(1,1),
    D_Name VARCHAR(50),
    D_Email VARCHAR(50),
    D_Password VARCHAR(50),
    C_Phone INT,
    D_Province VARCHAR(50),
    D_County VARCHAR(50),
    D_District VARCHAR(50),
    D_Additional_Address VARCHAR(100),
    T_Role VARCHAR(50),
    D_Status VARCHAR(50),
    F_Registration DATETIME
);

CREATE TABLE T_Creditor (
    C_Creditor INT PRIMARY KEY IDENTITY(1,1),
    D_Name VARCHAR(50),
    D_Email VARCHAR(50),
    D_Password VARCHAR(50),
    C_Phone INT,
    D_Province VARCHAR(50),
    D_County VARCHAR(50),
    D_District VARCHAR(50),
    D_Additional_Address VARCHAR(100)
);

/* ========================================= */
/*               CUENTAS                    */
/* ========================================= */
CREATE TABLE T_Accounts (
    C_Account INT PRIMARY KEY IDENTITY(1,1),     -- Identificador único de cuenta
    C_User INT NOT NULL REFERENCES T_Users(C_User),  -- Relación con el usuario dueño de la cuenta
    D_Account_Name VARCHAR(100),                 -- Nombre personalizado de la cuenta
    M_Initial_Amount DECIMAL(10,6),              -- Monto inicial al crear la cuenta
    M_Current_Balance DECIMAL(10,6),             -- Saldo actualizado de la cuenta
    F_Creation_Date DATETIME DEFAULT GETDATE(),  -- Fecha de creación automática
    D_Status VARCHAR(50)                         -- Estado actual de la cuenta
);

/* ========================================= */
/*             CATALOG TABLES               */
/* ========================================= */

CREATE TABLE T_Transaction_Type (
    C_Transaction_Type INT PRIMARY KEY IDENTITY(1,1),
    D_Transaction_Name VARCHAR(50)
);
CREATE TABLE T_Transaction_Category (
    C_Transaction_Category INT PRIMARY KEY IDENTITY(1,1),
    D_Category_Name VARCHAR(50),
    D_Category_Description VARCHAR(100),
    T_Category_Type VARCHAR(50)
);

CREATE TABLE T_Debt_Type (
    C_Debt_Type INT PRIMARY KEY IDENTITY(1,1),
    D_Debt_Type_Name VARCHAR(50)
);

CREATE TABLE T_Loan_Type (
    C_Loan_Type INT PRIMARY KEY IDENTITY(1,1),
    D_Loan_Type_Name VARCHAR(50)
);

CREATE TABLE T_Saving_Type (
    C_Saving_Type INT PRIMARY KEY IDENTITY(1,1),
    D_Saving_Type_Name VARCHAR(50)
);

CREATE TABLE T_Expense_Type (
    C_Expense_Type INT PRIMARY KEY IDENTITY(1,1),
    D_Description VARCHAR(100)
);

CREATE TABLE T_Income_Type (
    C_Income_Type INT PRIMARY KEY IDENTITY(1,1),
    D_Description VARCHAR(100)
);

CREATE TABLE T_Projection_Type (
    C_Projection_Type INT PRIMARY KEY IDENTITY(1,1),
    D_Projection_Type_Description VARCHAR(100)
);

CREATE TABLE T_Transactions (
    C_Transaction INT PRIMARY KEY IDENTITY(1,1),
    C_User INT NOT NULL REFERENCES T_Users(C_User),
    C_Account INT NOT NULL REFERENCES T_Accounts(C_Account),
    C_Transaction_Category INT NOT NULL REFERENCES T_Transaction_Category(C_Transaction_Category),
    C_Transaction_Type INT NOT NULL REFERENCES T_Transaction_Type(C_Transaction_Type),
    M_Amount DECIMAL(10,6),
    D_Transaction_Description VARCHAR(100),
    F_Date DATETIME
);

CREATE TABLE T_Expenses (
    C_Expense INT PRIMARY KEY IDENTITY(1,1),
    C_User INT REFERENCES T_Users(C_User),
    C_Account INT NOT NULL REFERENCES T_Accounts(C_Account),
    C_Expense_Type INT REFERENCES T_Expense_Type(C_Expense_Type),
    M_Expense_Amount DECIMAL(10,6),
    D_Expense_Description VARCHAR(100)
);


CREATE TABLE T_Incomes (
    C_Income INT PRIMARY KEY IDENTITY(1,1),
    C_User INT REFERENCES T_Users(C_User),
    C_Account INT NOT NULL REFERENCES T_Accounts(C_Account),
    C_Income_Type INT REFERENCES T_Income_Type(C_Income_Type),
    M_Income_Amount DECIMAL(10,6),
    D_Income_Description VARCHAR(100),
    F_Income_Date DATETIME
);

CREATE TABLE T_Debts (
    C_Debt INT PRIMARY KEY IDENTITY(1,1),
    C_User INT REFERENCES T_Users(C_User),
    C_Account INT NOT NULL REFERENCES T_Accounts(C_Account),
    C_Creditor INT REFERENCES T_Creditor(C_Creditor),
    C_Debt_Type INT REFERENCES T_Debt_Type(C_Debt_Type),
    T_Debt_Status VARCHAR(50),
    M_Amount DECIMAL(10,3),
    M_Interest DECIMAL(10,3),
    M_Remaining_Balance DECIMAL(10,3),
    F_Start_Date DATETIME,
    F_Due_Date DATETIME,
    D_Collateral VARCHAR(100)
);

CREATE TABLE T_Loans (
    C_Loan INT PRIMARY KEY IDENTITY(1,1),
    C_User INT REFERENCES T_Users(C_User),
    C_Account INT NOT NULL REFERENCES T_Accounts(C_Account),
    C_Creditor INT REFERENCES T_Creditor(C_Creditor),
    C_Loan_Type INT REFERENCES T_Loan_Type(C_Loan_Type),
    T_Loan_Status VARCHAR(50),
    M_Loan_Amount DECIMAL(10,6),
    M_Interest DECIMAL(10,6),
    F_Start_Date DATETIME,
    F_Due_Date DATETIME,
    D_Collateral VARCHAR(100)
);


CREATE TABLE T_Savings (
    C_Saving INT PRIMARY KEY IDENTITY(1,1),
    C_User INT REFERENCES T_Users(C_User),
    C_Account INT NOT NULL REFERENCES T_Accounts(C_Account),
    C_Saving_Type INT REFERENCES T_Saving_Type(C_Saving_Type),
    D_Goal_Description VARCHAR(100),
    M_Target_Amount DECIMAL(10,6),
    M_Accumulated_Amount DECIMAL(10,6),
    F_Deadline DATETIME,
    F_Record_Date DATETIME
);

CREATE TABLE T_Crypto_History (
    C_Crypto_History INT PRIMARY KEY IDENTITY(1,1),
    C_User INT REFERENCES T_Users(C_User),
    D_Crypto_Name VARCHAR(50),
    F_Date DATETIME,
    M_Value DECIMAL(10,6)
);

CREATE TABLE T_Investment_Type (
    C_Investment_Type INT PRIMARY KEY IDENTITY(1,1),
    D_Investment_Type_Name VARCHAR(50),
    D_Investment_Type_Description VARCHAR(100),
    M_Average_Return DECIMAL(10,6)
);

CREATE TABLE T_Investment_Category (
    C_Investment_Category INT PRIMARY KEY IDENTITY(1,1),
    D_Investment_Category_Description VARCHAR(100)
);

CREATE TABLE T_Investments (
    C_Investment INT PRIMARY KEY IDENTITY(1,1),
    C_User INT REFERENCES T_Users(C_User),
    C_Account INT NOT NULL REFERENCES T_Accounts(C_Account),
    C_Investment_Category INT REFERENCES T_Investment_Category(C_Investment_Category),
    C_Investment_Type INT REFERENCES T_Investment_Type(C_Investment_Type),
    M_Invested_Amount DECIMAL(10,6),
    M_Return DECIMAL(10,6),
    F_Start_Date DATETIME,
    F_End_Date DATETIME,
    C_Crypto_History INT REFERENCES T_Crypto_History(C_Crypto_History)
);

CREATE TABLE T_Projections (
    C_Projection INT PRIMARY KEY IDENTITY(1,1),
    C_User INT REFERENCES T_Users(C_User),
    C_Account INT NOT NULL REFERENCES T_Accounts(C_Account),
    C_Projection_Type INT REFERENCES T_Projection_Type(C_Projection_Type),
    M_Estimated_Amount DECIMAL(10,6),
    F_Start_Date DATETIME,
    F_End_Date DATETIME,
    T_Status VARCHAR(50)
);

-- =============================================
-- Tabla: T_Loan_Payments
-- Descripción: Registro de pagos de préstamos, enlazados a transacciones y cuentas
-- =============================================
CREATE TABLE T_Loan_Payments (
    C_Loan_Payment INT PRIMARY KEY IDENTITY(1,1),
    C_Loan INT NOT NULL REFERENCES T_Loans(C_Loan),
    C_Transaction INT NOT NULL REFERENCES T_Transactions(C_Transaction),
    C_Account INT NOT NULL REFERENCES T_Accounts(C_Account),
    F_Payment_Date DATETIME,
    M_Payment_Amount DECIMAL(10,6),
    M_Interest_Paid DECIMAL(10,6),
    M_Remaining_Balance DECIMAL(10,6)
);


-- =============================================
-- Tabla: T_Debt_Payments
-- Descripción: Registro de pagos de deudas, enlazados a transacciones y cuentas
-- =============================================
CREATE TABLE T_Debt_Payments (
    C_Debt_Payment INT PRIMARY KEY IDENTITY(1,1),
    C_Debt INT NOT NULL REFERENCES T_Debts(C_Debt),
    C_Transaction INT NOT NULL REFERENCES T_Transactions(C_Transaction),
    C_Account INT NOT NULL REFERENCES T_Accounts(C_Account),
    F_Payment_Date DATETIME,
    M_Payment_Amount DECIMAL(10,6),
    M_Interest_Paid DECIMAL(10,6),
    M_Remaining_Balance DECIMAL(10,6)
);

