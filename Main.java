package com.bank.main;

import com.bank.dao.*;
import com.bank.model.*;
import com.bank.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // Initialize DAO classes
        BankDAO bankDAO = new BankDAO();
        BranchDAO branchDAO = new BranchDAO();
        DepartmentDAO deptDAO = new DepartmentDAO();
        EmployeeDAO empDAO = new EmployeeDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        AccountDAO accountDAO = new AccountDAO();
        CardDAO cardDAO = new CardDAO();
        TransactionDAO txnDAO = new TransactionDAO();
        LoanDAO loanDAO = new LoanDAO();

        try {
            System.out.println("\n===== ✅ Fetching Records From Database =====\n");

            // 1️⃣ Fetch Banks
            List<Bank> banks = bankDAO.findAll();
            System.out.println("🏦 Banks:");
            for (Bank b : banks) {
                System.out.println(" → " + b.getBankCode() + " | " + b.getBankName() + " | " + b.getAddress());
            }

            // 2️⃣ Fetch Branches
            List<Branch> branches = branchDAO.findAll();
            System.out.println("\n🏢 Branches:");
            for (Branch br : branches) {
                System.out.println(" → " + br.getBranchId() + " | " + br.getBranchName() + " | Bank: " + br.getBank().getBankName());
            }

            // 3️⃣ Fetch Departments
            List<Department> departments = deptDAO.findAll();
            System.out.println("\n🏬 Departments:");
            for (Department d : departments) {
                System.out.println(" → " + d.getDeptId() + " | " + d.getDeptName() + " | Branch: " + d.getBranch().getBranchName());
            }

            // 4️⃣ Fetch Employees
            List<Employee> employees = empDAO.findAll();
            System.out.println("\n👷 Employees:");
            for (Employee e : employees) {
                System.out.println(" → " + e.getEmployeeId() + " | " + e.getEmployeeName() + " | Branch: " + e.getBranch().getBranchName() + " | Phone: " + e.getPhoneNo());
            }

            // 5️⃣ Fetch Customers
            List<Customer> customers = customerDAO.findAll();
            System.out.println("\n👤 Customers:");
            for (Customer c : customers) {
                System.out.println(" → " + c.getCustomerId() + " | " + c.getName() + " | " + c.getPhone());
            }

            // 6️⃣ Fetch Accounts
            List<Account> accounts = accountDAO.findAll();
            System.out.println("\n💰 Accounts:");
            for (Account a : accounts) {
                System.out.println(" → " + a.getAccountNo() + " | Type: " + a.getAccountType() +
                        " | Balance: " + a.getBalance() + " | Customer: " + a.getCustomer().getName());
            }

            // 7️⃣ Fetch Cards
            List<Card> cards = cardDAO.findAll();
            System.out.println("\n💳 Cards:");
            for (Card c : cards) {
                System.out.println(" → " + c.getCardId() + " | " + c.getCardType() +
                        " | Holder: " + c.getCardHolderName() + " | Account: " + c.getAccount().getAccountNo());
            }

            // 8️⃣ Fetch Transactions
            List<Transaction> txns = txnDAO.findAll();
            System.out.println("\n📜 Transactions:");
            for (Transaction t : txns) {
                System.out.println(" → " + t.getTransactionId() + " | " + t.getAmount() +
                        " | Mode: " + t.getTransactionMode() + " | Account: " + t.getAccount().getAccountNo());
            }

            // 9️⃣ Fetch Loans
            List<Loan> loans = loanDAO.findAll();
            System.out.println("\n💸 Loans:");
            for (Loan l : loans) {
                System.out.println(" → " + l.getLoanId() + " | " + l.getLoanType() +
                        " | Amount: " + l.getAmount() + " | Rate: " + l.getInterestRate() +
                        " | Customer: " + l.getCustomer().getName());
            }

            System.out.println("\n✅ All records fetched successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            com.bank.util.HibernateUtil.shutdown();
        }
    }
}
