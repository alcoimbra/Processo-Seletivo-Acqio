package br.com.projetoacqio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.projetoacqio.beans.Transaction;
import br.com.projetoacqio.repository.TransactionRepository;
import br.com.projetoacqio.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public List<Transaction> findAll() {
		return this.transactionRepository.findAll();
	}
	
	@Override
	public Transaction findById(Long id) {
		return this.transactionRepository.findById(id).get();
	}
	
	@Override
	public Transaction update(Transaction transaction) {
		Transaction transactionNew = this.findById(transaction.getId());
		this.updateTransaction(transactionNew, transaction);
		
		return this.transactionRepository.save(transactionNew);
	}

	@Override
	public Transaction insert(Transaction transaction) {
		transaction.setId(null);
		
		return this.transactionRepository.save(transaction);
	}
	
	private void updateTransaction(Transaction transactionNew, Transaction transaction) {
		transactionNew.setDate(transaction.getDate());
		transactionNew.setTime(transaction.getTime());
		transactionNew.setValue(transaction.getValue());
		transactionNew.setCardApplication(transaction.getCardApplication());
		transactionNew.setPaymentStatus(transaction.getPaymentStatus());
	}
}