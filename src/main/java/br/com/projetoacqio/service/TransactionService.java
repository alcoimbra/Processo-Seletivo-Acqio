package br.com.projetoacqio.service;

import java.util.List;

import br.com.projetoacqio.beans.Transaction;

public interface TransactionService {
	
	List<Transaction> findAll();
	Transaction findById(Long id);
	Transaction update(Transaction transaction);
	Transaction insert(Transaction transaction);
}