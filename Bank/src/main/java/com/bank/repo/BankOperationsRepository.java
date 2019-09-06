package com.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bank.model.BankOperationTable;
@Repository
public interface BankOperationsRepository extends JpaRepository<BankOperationTable, Long> {
	List<BankOperationTable> findAllByUserId(long UserId);
	BankOperationTable findAllByIdAndUserId(long id, long userId);
}