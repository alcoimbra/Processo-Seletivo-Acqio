package br.com.projetoacqio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.projetoacqio.beans.Transaction;

public class TransactionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private LocalDate date;
	private LocalDateTime time;
	private BigDecimal value;
	
	public TransactionDTO() {}
	
	public TransactionDTO(Transaction transaction) {
		id = transaction.getId();
		date = transaction.getDate();
		time = transaction.getTime();
		value = transaction.getValue();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
}