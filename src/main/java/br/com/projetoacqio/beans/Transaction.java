package br.com.projetoacqio.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import br.com.projetoacqio.beans.enums.CardApplication;
import br.com.projetoacqio.beans.enums.PaymentStatus;

@Document(collection="acqio")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private LocalDate date;
	private LocalDateTime time;
	private BigDecimal value;
	
	private CardApplication cardApplication;
	private PaymentStatus paymentStatus;
	
	public Transaction() {}
	
	public Transaction(Long id, LocalDate date, LocalDateTime time, BigDecimal value,
			CardApplication cardApplication, PaymentStatus paymentStatus) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.value = value;
		this.cardApplication = cardApplication;
		this.paymentStatus = paymentStatus;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	
	@Column(name="date", nullable=false)
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@Column(name="time", nullable=false)
	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	@Column(name="value", nullable=false)
	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="cardApplication", nullable=false)
	public CardApplication getCardApplication() {
		return cardApplication;
	}

	public void setCardApplication(CardApplication cardApplication) {
		this.cardApplication = cardApplication;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="paymentStatus", nullable=false)
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}