package org.northernarc.assessment4.repository;


import org.northernarc.assessment4.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    // Task 3: Derived Query Methods
    List<Account> findByAccountType(String accountType);
    List<Account> findByBalanceGreaterThan(double amount);


    @Query("""
SELECT a
FROM Account a
WHERE a.transactions IS EMPTY
""")
    List<Account> findAccountsWithNoTransactions();

    @Transactional
    @Modifying
    @Query("""
UPDATE Account a
SET a.balance = a.balance + :amount
WHERE a.accountNumber = :accountNumber
""")
    int increaseBalance(@Param("accountNumber") String accountNumber,
                        @Param("amount") Double amount);


}