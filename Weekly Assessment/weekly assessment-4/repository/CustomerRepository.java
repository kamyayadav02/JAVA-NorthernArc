package org.northernarc.assessment4.repository;

import org.northernarc.assessment4.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Task 3: Derived Query Method
    List<Customer> findByBranch(String branch);


    // Security Helper
    java.util.Optional<Customer> findByEmail(String email);

    @Query("""
SELECT DISTINCT c
FROM Customer c
JOIN c.accounts a
GROUP BY c
HAVING SUM(a.balance) > :amount
""")
    List<Customer> findRichCustomers(@Param("amount") Double amount);

    @Query("""
SELECT c.branch, SUM(a.balance)
FROM Customer c
JOIN c.accounts a
GROUP BY c.branch
""")
    List<Object[]> findTotalBalancePerBranch();

    @Query("""
SELECT c
FROM Customer c
JOIN FETCH c.accounts
WHERE c.customerId = :customerId
""")
    Optional<Customer> findCustomerWithAccounts(@Param("customerId") Long customerId);
    @Query("""
SELECT c
FROM Customer c
WHERE SIZE(c.accounts) > 1
""")
    List<Customer> findCustomersWithMultipleAccounts();
}