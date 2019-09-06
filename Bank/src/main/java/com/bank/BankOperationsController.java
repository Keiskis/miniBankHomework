package com.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bank.model.BankOperationTable;
import com.bank.repo.BankOperationsRepository;
import javax.validation.Valid;
import java.util.List;

@RestController
public class BankOperationsController {

	@Autowired
	BankOperationsRepository operationsRepository;

// Get All Operations
	@GetMapping("/operations")
	public List<BankOperationTable> getAllOperations() {
		return operationsRepository.findAll();
	}

// Create User deposit
	@PostMapping("/deposit")
	public BankOperationTable createUserDeposit(@Valid @RequestBody BankOperationTable userDoDeposit) {
		List<BankOperationTable> table = operationsRepository.findAllByUserId(userDoDeposit.getUserId());
		long balance = 0;
		if (table.size() > 0)
		balance = table.get(table.size() - 1).getBalance();
		balance = balance + userDoDeposit.getDeposit();
		userDoDeposit.setBalance(balance);
		userDoDeposit.setWithdrawal(0);
		return operationsRepository.save(userDoDeposit);
	}

	// Create User withdrawal
	@PostMapping("/withdrawal")
	public BankOperationTable createUserWithdrawal(@Valid @RequestBody BankOperationTable userDowithdrawal) {
		List<BankOperationTable> table = operationsRepository.findAllByUserId(userDowithdrawal.getUserId());
		long balance = 0;
		if (table.size() > 0)
		balance = table.get(table.size() - 1).getBalance();
		balance = balance - userDowithdrawal.getWithdrawal();
		userDowithdrawal.setBalance(balance);
		userDowithdrawal.setDeposit(0);
		return operationsRepository.save(userDowithdrawal);
	}

// Get User balance by userID 
	@GetMapping("/balance/{id}")
	public BankOperationTable getBalanceByUserById(@PathVariable(value = "id") Long userId) {
		List<BankOperationTable> table = operationsRepository.findAllByUserId(userId);
		long id = 0;
		if (table.size() > 0)
			id = table.get(table.size() - 1).getId();
		return operationsRepository.findAllByIdAndUserId(id, userId);
	}

	// Get User statement by userID
	@GetMapping("/statement/{id}")
	public List<BankOperationTable> getStatementByUserById(@PathVariable(value = "id") Long userId) {
		return operationsRepository.findAllByUserId(userId);
	}
}