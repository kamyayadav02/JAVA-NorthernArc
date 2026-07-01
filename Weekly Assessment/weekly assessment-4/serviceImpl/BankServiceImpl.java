package org.northernarc.assessment4.serviceImpl;
import lombok.RequiredArgsConstructor;
import org.northernarc.assessment4.dto.CustomerSummaryDTO;
import org.northernarc.assessment4.dto.DashboardResponse;
import org.northernarc.assessment4.model.Account;
import org.northernarc.assessment4.model.Customer;
import org.northernarc.assessment4.model.Transaction;
import org.northernarc.assessment4.repository.AccountRepository;
import org.northernarc.assessment4.repository.CustomerRepository;
import org.northernarc.assessment4.repository.TransactionRepository;
import org.northernarc.assessment4.service.BankService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BankServiceImpl implements BankService {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    // ---------------- Task 1 ----------------

    @Override
    @Transactional
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public void deleteAccount(String accountNumber) {
        accountRepository.deleteById(accountNumber);
    }

    // ---------------- Task 3 ----------------

    @Override
    public List<Account> getAccountsByType(String accountType) {
        return accountRepository.findByAccountType(accountType);
    }

    @Override
    public List<Customer> getCustomersByBranch(String branch) {
        return customerRepository.findByBranch(branch);
    }

    @Override
    public List<Transaction> getTransactionsByType(String transactionType) {
        return transactionRepository.findByTransactionType(transactionType);
    }

    @Override
    public List<Account> getAccountsWithBalanceGreaterThan(double amount) {
        return accountRepository.findByBalanceGreaterThan(amount);
    }

    // ---------------- Task 4 ----------------

    @Override
    public List<Customer> getRichCustomers(double threshold) {
        return customerRepository.findRichCustomers(threshold);
    }

    @Override
    public Map<String, Double> getTotalBalancePerBranch() {

        List<Object[]> result = customerRepository.findTotalBalancePerBranch();

        Map<String, Double> balanceMap = new LinkedHashMap<>();

        for (Object[] row : result) {
            balanceMap.put((String) row[0], (Double) row[1]);
        }

        return balanceMap;
    }

    @Override
    public List<Customer> getCustomersWithMultipleAccounts() {
        return customerRepository.findCustomersWithMultipleAccounts();
    }

    @Override
    public Transaction getLatestTransaction() {

        List<Transaction> transactions =
                transactionRepository.findLatestTransaction(Pageable.ofSize(1));

        return transactions.isEmpty() ? null : transactions.get(0);
    }

    @Override
    public List<Account> getAccountsWithNoTransactions() {
        return accountRepository.findAccountsWithNoTransactions();
    }

    // ---------------- Task 5 ----------------

    @Override
    @Transactional
    public void increaseAccountBalance(String accountNumber, double amount) {
        accountRepository.increaseBalance(accountNumber, amount);
    }

    // ---------------- Task 6 ----------------

    @Override
    public Page<Account> getAllAccountsPaginated(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    // ---------------- Task 7 ----------------

    @Override
    public CustomerSummaryDTO getCustomerSummary(Long customerId) {

        Customer customer = customerRepository.findCustomerWithAccounts(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        long numberOfAccounts = customer.getAccounts().size();

        double totalBalance = customer.getAccounts()
                .stream()
                .mapToDouble(Account::getBalance)
                .sum();

        return new CustomerSummaryDTO(
                customer.getCustomerName(),
                customer.getBranch(),
                numberOfAccounts,
                totalBalance
        );
    }

    // ---------------- Final Challenge ----------------

    @Override
    public DashboardResponse getDashboardMetrics() {

        long totalCustomers = customerRepository.count();

        long totalAccounts = accountRepository.count();

        double totalBalance = accountRepository.findAll()
                .stream()
                .mapToDouble(Account::getBalance)
                .sum();

        Map<String, Double> branchBalances = getTotalBalancePerBranch();

        String topBranch = branchBalances.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("N/A");

        String highestBalanceCustomer = customerRepository.findAll()
                .stream()
                .max((c1, c2) -> Double.compare(
                        c1.getAccounts().stream().mapToDouble(Account::getBalance).sum(),
                        c2.getAccounts().stream().mapToDouble(Account::getBalance).sum()))
                .map(Customer::getCustomerName)
                .orElse("N/A");

        return new DashboardResponse(
                totalCustomers,
                totalAccounts,
                totalBalance,
                topBranch,
                highestBalanceCustomer
        );
    }
}