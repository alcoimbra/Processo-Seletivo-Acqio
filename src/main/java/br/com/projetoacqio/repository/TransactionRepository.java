package br.com.projetoacqio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.projetoacqio.beans.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, Long>{

}