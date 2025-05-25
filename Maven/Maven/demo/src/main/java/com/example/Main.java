package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.example.Controller.Conexion;
import com.example.Controller.CRUDS.UserCRUD;
import com.example.Controller.CRUDS.CreditorCRUD;
import com.example.Controller.CRUDS.DebtCRUD;
import com.example.Controller.CRUDS.DebtTypeCRUD;
import com.example.Controller.CRUDS.ExpenseCRUD;
import com.example.Controller.CRUDS.ExpenseTypeCRUD;
import com.example.Controller.CRUDS.IncomeCRUD;
import com.example.Controller.CRUDS.IncomeTypeCRUD;
import com.example.Controller.CRUDS.LoanCRUD;
import com.example.Controller.CRUDS.LoanTypeCRUD;
import com.example.Controller.CRUDS.ProjectionTypeCRUD;
import com.example.Controller.CRUDS.SavingTypeCRUD;
import com.example.Controller.CRUDS.TransactionCRUD;
import com.example.Controller.CRUDS.TransactionCategoryCRUD;
import com.example.Controller.CRUDS.TransactionTypeCRUD;
import com.example.Controller.CRUDS.AccountCRUD;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello, World!");

        Conexion conec = new Conexion();
        Connection conn = conec.obtenerConexion();

        if (conn != null) {
            // ========== USUARIOS ==========
            UserCRUD userCrud = new UserCRUD();
            // runInsertUser(userCrud, conn);
            // runReadUsers(userCrud, conn);
            // runUpdateUser(userCrud, conn);
            // runDeleteUser(userCrud, conn);

            // ========== ACREEDORES ==========
            CreditorCRUD creditorCrud = new CreditorCRUD();
            // runInsertCreditor(creditorCrud, conn);
            // runReadCreditors(creditorCrud, conn);
            // runUpdateCreditor(creditorCrud, conn);
            // runDeleteCreditor(creditorCrud, conn);

            // ========== CUENTAS ==========
            AccountCRUD accountCrud = new AccountCRUD();
            // runInsertAccount(accountCrud, conn);
            // runReadAccounts(accountCrud, conn);
            // runUpdateAccount(accountCrud, conn);
            // runDeleteAccount(accountCrud, conn);

            // ========== T_Transaction_Type ==========
            TransactionTypeCRUD transTypeCrud = new TransactionTypeCRUD();
            // runInsertTransactionType(transTypeCrud, conn);
            // runReadTransactionTypes(transTypeCrud, conn);
            // runUpdateTransactionType(transTypeCrud, conn);
            // runDeleteTransactionType(transTypeCrud, conn);

            // ========== T_Transaction_Category ==========
            TransactionCategoryCRUD transCatCrud = new TransactionCategoryCRUD();
            // runInsertTransactionCategory(transCatCrud, conn);
            // runReadTransactionCategories(transCatCrud, conn);
            // runUpdateTransactionCategory(transCatCrud, conn);
            // runDeleteTransactionCategory(transCatCrud, conn);

            // ========== T_Debt_Type ==========
            DebtTypeCRUD debtTypeCrud = new DebtTypeCRUD();
            // runInsertDebtType(debtTypeCrud, conn);
            // runReadDebtTypes(debtTypeCrud, conn);
            // runUpdateDebtType(debtTypeCrud, conn);
            // runDeleteDebtType(debtTypeCrud, conn);

            // ========== T_Loan_Type ==========
            LoanTypeCRUD loanTypeCrud = new LoanTypeCRUD();
            // runInsertLoanType(loanTypeCrud, conn);
            // runReadLoanTypes(loanTypeCrud, conn);
            // runUpdateLoanType(loanTypeCrud, conn);
            // runDeleteLoanType(loanTypeCrud, conn);

            // ========== T_Saving_Type ==========
            SavingTypeCRUD savingTypeCrud = new SavingTypeCRUD();
            // runInsertSavingType(savingTypeCrud, conn);
            // runReadSavingTypes(savingTypeCrud, conn);
            // runUpdateSavingType(savingTypeCrud, conn);
            // runDeleteSavingType(savingTypeCrud, conn);

            // ========== T_Expense_Type ==========
            ExpenseTypeCRUD expenseTypeCrud = new ExpenseTypeCRUD();
            // runInsertExpenseType(expenseTypeCrud, conn);
            // runReadExpenseTypes(expenseTypeCrud, conn);
            // runUpdateExpenseType(expenseTypeCrud, conn);
            // runDeleteExpenseType(expenseTypeCrud, conn);

            // ========== T_Income_Type ==========
            IncomeTypeCRUD incomeTypeCrud = new IncomeTypeCRUD();
            // runInsertIncomeType(incomeTypeCrud, conn);
            // runReadIncomeTypes(incomeTypeCrud, conn);
            // runUpdateIncomeType(incomeTypeCrud, conn);
            // runDeleteIncomeType(incomeTypeCrud, conn);

            // ========== T_Projection_Type ==========
            ProjectionTypeCRUD projectionTypeCrud = new ProjectionTypeCRUD();
            // runInsertProjectionType(projectionTypeCrud, conn);
            // runReadProjectionTypes(projectionTypeCrud, conn);
            // runUpdateProjectionType(projectionTypeCrud, conn);
            // runDeleteProjectionType(projectionTypeCrud, conn);

            TransactionCRUD txCrud = new TransactionCRUD();
            ExpenseCRUD expenseCrud = new ExpenseCRUD();
            IncomeCRUD incomeCrud = new IncomeCRUD();
            DebtCRUD debtCrud = new DebtCRUD();
            LoanCRUD loanCrud = new LoanCRUD();

            // --- Pruebas ---
            runInsertExpense(expenseCrud, conn);
            runUpdateExpense(expenseCrud, conn);
            runDeleteExpense(expenseCrud, conn);
            runReadExpenses(expenseCrud, conn);

            runInsertIncome(incomeCrud, conn);
            runUpdateIncome(incomeCrud, conn);
            runDeleteIncome(incomeCrud, conn);
            runReadIncomes(incomeCrud, conn);

            runInsertDebt(debtCrud, conn);
            runUpdateDebt(debtCrud, conn);
            runDeleteDebt(debtCrud, conn);
            runReadDebts(debtCrud, conn);

            runInsertLoan(loanCrud, conn);
            runUpdateLoan(loanCrud, conn);
            runDeleteLoan(loanCrud, conn);
            runReadLoans(loanCrud, conn);

            runReadTransactions(txCrud, conn);

            conn.close();
        } else {
            System.out.println("Error: No se pudo establecer conexión con la base de datos.");
        }
    }

    // === MÉTODOS PARA USUARIOS ===
    public static void runInsertUser(UserCRUD crud, Connection conn) throws SQLException {
        crud.insertUser(conn, "Test User", "test@example.com", "TestPass",
                88880000, "San José", "Central", "Carmen", "Dirección X",
                "tester", "Activo", new Timestamp(System.currentTimeMillis()));
    }

    public static void runReadUsers(UserCRUD crud, Connection conn) throws SQLException {
        crud.readUsers(conn);
    }

    public static void runUpdateUser(UserCRUD crud, Connection conn) throws SQLException {
        crud.updateUser(conn, 2, "Updated User", "updated@mail.com", "NewPass",
                89997777, "Heredia", "Central", "Mercedes", "Dirección Y",
                "admin", "Inactivo");
    }

    public static void runDeleteUser(UserCRUD crud, Connection conn) throws SQLException {
        crud.deleteUser(conn, 1);
    }

    // === MÉTODOS PARA ACREEDORES ===
    public static void runInsertCreditor(CreditorCRUD crud, Connection conn) throws SQLException {
        crud.insertCreditor(conn, "Banco X", "x@banco.com", "claveX",
                80000000, "Cartago", "Central", "Este", "Sucursal A");
    }

    public static void runReadCreditors(CreditorCRUD crud, Connection conn) throws SQLException {
        crud.readCreditors(conn);
    }

    public static void runUpdateCreditor(CreditorCRUD crud, Connection conn) throws SQLException {
        crud.updateCreditor(conn, 1, "Banco Actualizado", "nuevo@banco.com", "nuevaClave",
                81110000, "Alajuela", "Oeste", "La Agonía", "Sucursal Z");
    }

    public static void runDeleteCreditor(CreditorCRUD crud, Connection conn) throws SQLException {
        crud.deleteCreditor(conn, 1);
    }

    // === MÉTODOS PARA CUENTAS ===
    public static void runInsertAccount(AccountCRUD crud, Connection conn) throws SQLException {
        crud.insertAccount(conn, 1, "Cuenta Ahorro", 1000.0, 1000.0, "Activa");
    }

    public static void runReadAccounts(AccountCRUD crud, Connection conn) throws SQLException {
        crud.readAccounts(conn);
    }

    public static void runUpdateAccount(AccountCRUD crud, Connection conn) throws SQLException {
        crud.updateAccount(conn, 1, "Cuenta Actualizada", 1500.0, 1500.0, "Activa");
    }

    public static void runDeleteAccount(AccountCRUD crud, Connection conn) throws SQLException {
        crud.deleteAccount(conn, 1);
    }

    // ==== Métodos para T_Transaction_Type ====
    public static void runInsertTransactionType(TransactionTypeCRUD crud, Connection conn) throws SQLException {
        crud.insertTransactionType(conn, "Ingreso");
    }

    public static void runReadTransactionTypes(TransactionTypeCRUD crud, Connection conn) throws SQLException {
        crud.readTransactionTypes(conn);
    }

    public static void runUpdateTransactionType(TransactionTypeCRUD crud, Connection conn) throws SQLException {
        crud.updateTransactionType(conn, 1, "Ingreso Actualizado");
    }

    public static void runDeleteTransactionType(TransactionTypeCRUD crud, Connection conn) throws SQLException {
        crud.deleteTransactionType(conn, 1);
    }

    // ==== Métodos para T_Transaction_Category ====
    public static void runInsertTransactionCategory(TransactionCategoryCRUD crud, Connection conn) throws SQLException {
        crud.insertTransactionCategory(conn, "Comida", "Gasto alimenticio", "Gasto");
    }

    public static void runReadTransactionCategories(TransactionCategoryCRUD crud, Connection conn) throws SQLException {
        crud.readTransactionCategories(conn);
    }

    public static void runUpdateTransactionCategory(TransactionCategoryCRUD crud, Connection conn) throws SQLException {
        crud.updateTransactionCategory(conn, 1, "Supermercado", "Gastos del hogar", "Gasto");
    }

    public static void runDeleteTransactionCategory(TransactionCategoryCRUD crud, Connection conn) throws SQLException {
        crud.deleteTransactionCategory(conn, 1);
    }

    // ==== Métodos para T_Debt_Type ====
    public static void runInsertDebtType(DebtTypeCRUD crud, Connection conn) throws SQLException {
        crud.insertDebtType(conn, "Tarjeta de crédito");
    }

    public static void runReadDebtTypes(DebtTypeCRUD crud, Connection conn) throws SQLException {
        crud.readDebtTypes(conn);
    }

    public static void runUpdateDebtType(DebtTypeCRUD crud, Connection conn) throws SQLException {
        crud.updateDebtType(conn, 1, "Tarjeta Actualizada");
    }

    public static void runDeleteDebtType(DebtTypeCRUD crud, Connection conn) throws SQLException {
        crud.deleteDebtType(conn, 1);
    }

    public static void runInsertLoanType(LoanTypeCRUD crud, Connection conn) throws SQLException {
        crud.insertLoanType(conn, "Hipotecario");
    }

    public static void runReadLoanTypes(LoanTypeCRUD crud, Connection conn) throws SQLException {
        crud.readLoanTypes(conn);
    }

    public static void runUpdateLoanType(LoanTypeCRUD crud, Connection conn) throws SQLException {
        crud.updateLoanType(conn, 1, "Hipotecario Actualizado");
    }

    public static void runDeleteLoanType(LoanTypeCRUD crud, Connection conn) throws SQLException {
        crud.deleteLoanType(conn, 1);
    }

    public static void runInsertSavingType(SavingTypeCRUD crud, Connection conn) throws SQLException {
        crud.insertSavingType(conn, "Fondo de Emergencia");
    }

    public static void runReadSavingTypes(SavingTypeCRUD crud, Connection conn) throws SQLException {
        crud.readSavingTypes(conn);
    }

    public static void runUpdateSavingType(SavingTypeCRUD crud, Connection conn) throws SQLException {
        crud.updateSavingType(conn, 1, "Meta de Ahorro General");
    }

    public static void runDeleteSavingType(SavingTypeCRUD crud, Connection conn) throws SQLException {
        crud.deleteSavingType(conn, 1);
    }

    public static void runInsertExpenseType(ExpenseTypeCRUD crud, Connection conn) throws SQLException {
        crud.insertExpenseType(conn, "Gasto en transporte");
    }

    public static void runReadExpenseTypes(ExpenseTypeCRUD crud, Connection conn) throws SQLException {
        crud.readExpenseTypes(conn);
    }

    public static void runUpdateExpenseType(ExpenseTypeCRUD crud, Connection conn) throws SQLException {
        crud.updateExpenseType(conn, 1, "Gasto en alimentación");
    }

    public static void runDeleteExpenseType(ExpenseTypeCRUD crud, Connection conn) throws SQLException {
        crud.deleteExpenseType(conn, 1);
    }

    public static void runInsertIncomeType(IncomeTypeCRUD crud, Connection conn) throws SQLException {
        crud.insertIncomeType(conn, "Salario");
    }

    public static void runReadIncomeTypes(IncomeTypeCRUD crud, Connection conn) throws SQLException {
        crud.readIncomeTypes(conn);
    }

    public static void runUpdateIncomeType(IncomeTypeCRUD crud, Connection conn) throws SQLException {
        crud.updateIncomeType(conn, 1, "Salario actualizado");
    }

    public static void runDeleteIncomeType(IncomeTypeCRUD crud, Connection conn) throws SQLException {
        crud.deleteIncomeType(conn, 1);
    }

    public static void runInsertProjectionType(ProjectionTypeCRUD crud, Connection conn) throws SQLException {
        crud.insertProjectionType(conn, "Proyección de ahorro a 6 meses");
    }

    public static void runReadProjectionTypes(ProjectionTypeCRUD crud, Connection conn) throws SQLException {
        crud.readProjectionTypes(conn);
    }

    public static void runUpdateProjectionType(ProjectionTypeCRUD crud, Connection conn) throws SQLException {
        crud.updateProjectionType(conn, 1, "Proyección modificada");
    }

    public static void runDeleteProjectionType(ProjectionTypeCRUD crud, Connection conn) throws SQLException {
        crud.deleteProjectionType(conn, 1);
    }

    // EXPENSE
    public static void runInsertExpense(ExpenseCRUD crud, Connection conn) throws SQLException {
        crud.insertExpense(conn, 1, 1, 1, 500.00, "Pago de servicios", 1, 2, new Timestamp(System.currentTimeMillis()));
    }

    public static void runUpdateExpense(ExpenseCRUD crud, Connection conn) throws SQLException {
        crud.updateExpense(conn, 1, 1, 1, 1, 450.00, "Pago de electricidad");
    }

    public static void runDeleteExpense(ExpenseCRUD crud, Connection conn) throws SQLException {
        crud.deleteExpense(conn, 1);
    }

    public static void runReadExpenses(ExpenseCRUD crud, Connection conn) throws SQLException {
        crud.readExpenses(conn);
    }

    // INCOME
    public static void runInsertIncome(IncomeCRUD crud, Connection conn) throws SQLException {
        crud.insertIncome(conn, 1, 1, 1, 1200.00, "Salario mensual", new Timestamp(System.currentTimeMillis()), 2, 1);
    }

    public static void runUpdateIncome(IncomeCRUD crud, Connection conn) throws SQLException {
        crud.updateIncome(conn, 1, 1, 1, 1, 1250.00, "Salario actualizado", new Timestamp(System.currentTimeMillis()));
    }

    public static void runDeleteIncome(IncomeCRUD crud, Connection conn) throws SQLException {
        crud.deleteIncome(conn, 1);
    }

    public static void runReadIncomes(IncomeCRUD crud, Connection conn) throws SQLException {
        crud.readIncomes(conn);
    }

    // DEBT
    public static void runInsertDebt(DebtCRUD crud, Connection conn) throws SQLException {
        crud.insertDebt(conn, 1, 1, 1, 1, "Activa", 1000.000, 50.000, 950.000,
                Timestamp.valueOf("2025-06-01 00:00:00"),
                Timestamp.valueOf("2025-12-01 00:00:00"),
                "Electrodoméstico", 3, 3);
    }

    public static void runUpdateDebt(DebtCRUD crud, Connection conn) throws SQLException {
        crud.updateDebt(conn, 1, 1, 1, 1, 1, "Activa", 1000.000, 50.000, 900.000,
                Timestamp.valueOf("2025-06-01 00:00:00"),
                Timestamp.valueOf("2025-12-01 00:00:00"),
                "Laptop");
    }

    public static void runDeleteDebt(DebtCRUD crud, Connection conn) throws SQLException {
        crud.deleteDebt(conn, 1);
    }

    public static void runReadDebts(DebtCRUD crud, Connection conn) throws SQLException {
        crud.readDebts(conn);
    }

    // LOAN
    public static void runInsertLoan(LoanCRUD crud, Connection conn) throws SQLException {
        crud.insertLoan(conn, 1, 1, 1, 1, "Activo", 5000.000, 300.000,
                Timestamp.valueOf("2025-06-01 00:00:00"),
                Timestamp.valueOf("2027-06-01 00:00:00"),
                "Casa", 3, 4);
    }

    public static void runUpdateLoan(LoanCRUD crud, Connection conn) throws SQLException {
        crud.updateLoan(conn, 1, 1, 1, 1, 1, "Refinanciado", 5200.000, 280.000,
                Timestamp.valueOf("2025-06-01 00:00:00"),
                Timestamp.valueOf("2027-06-01 00:00:00"),
                "Casa remodelada");
    }

    public static void runDeleteLoan(LoanCRUD crud, Connection conn) throws SQLException {
        crud.deleteLoan(conn, 1);
    }

    public static void runReadLoans(LoanCRUD crud, Connection conn) throws SQLException {
        crud.readLoans(conn);
    }

    // TRANSACTIONS
    public static void runReadTransactions(TransactionCRUD crud, Connection conn) throws SQLException {
        crud.readTransactions(conn);
    }

}
