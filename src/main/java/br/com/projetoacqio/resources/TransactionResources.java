package br.com.projetoacqio.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projetoacqio.beans.Transaction;
import br.com.projetoacqio.service.TransactionService;

@RequestMapping(value="transaction")
public class TransactionResources {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping(value="/all")
	public ResponseEntity<List<Transaction>> find(){
		List<Transaction> transaction = this.transactionService.findAll();
		
		return ResponseEntity.ok().body(transaction);
	}
	
	@PostMapping()
	public ResponseEntity<Void> insert(@Valid @RequestBody Transaction transaction){
		transaction = this.transactionService.insert(transaction);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping()
	public ResponseEntity<Void> update(@Valid @RequestBody Transaction transaction, @PathVariable Long id){
		transaction.setId(id);
		transaction = this.transactionService.update(transaction);
		
		return ResponseEntity.noContent().build();
	}
}