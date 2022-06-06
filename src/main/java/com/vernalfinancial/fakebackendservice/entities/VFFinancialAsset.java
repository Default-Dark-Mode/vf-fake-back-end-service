package com.vernalfinancial.fakebackendservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import com.vernalfinancial.fakebackendservice.models.VFBalance;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * This class maps to the database representations
 * of a bank account within Vernal Financial's
 * system and associated data and serves as the
 * abstract base class for all account entities,
 * which allows polymorphic account repository
 * access throughout the system.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@Entity
@Table(name = "financial_assets")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class VFFinancialAsset {
	@Id
	private String id;
	private VFRecordType recordType;
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(
					name = "negative",
					column = @Column(name = "balance_negative")
			),
			@AttributeOverride(
					name = "amount.dollars",
					column = @Column(name = "balance_dollars")
			),
			@AttributeOverride(
					name = "amount.cents",
					column = @Column(name = "balance_cents")
			)
	})
	@NotNull
	private VFBalance balance;
	@NotNull
	private Boolean closed;
	@JsonManagedReference
	@OneToMany(mappedBy = "origin")
	private List<VFFinancialTransaction> outgoingTransactions;
	@JsonManagedReference
	@OneToMany(mappedBy = "destination")
	private List<VFFinancialTransaction> incomingTransactions;
	@NotNull
	private LocalDateTime createdAt;
	@NotNull
	private LocalDateTime modifiedAt;

	/**
	 * The default constructor for the VFFinancialAsset
	 * class calls the fully parameterized constructor
	 * with null values for all parameters.
	 */
	public VFFinancialAsset() {
		this(null, null, false, null, null);
	}

	/**
	 * The parameterized constructor for the VFFinancialAsset
	 * class is the primary constructor and will be called by
	 * any other constructor within the class.
	 *
	 * @param id         String the unique id of the account
	 * @param balance    VFBalance the current balance
	 * @param closed     Boolean whether the account is closed
	 * @param createdAt  LocalDateTime when the account was created
	 * @param modifiedAt LocalDateTime when the account was last modified
	 */
	public VFFinancialAsset(String id, VFBalance balance, Boolean closed, LocalDateTime createdAt,
							LocalDateTime modifiedAt) {
		this.id = UUID.randomUUID().toString();
		this.recordType = VFRecordType.UnknownAsset;
		this.balance = balance;
		this.closed = closed;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public VFRecordType getRecordType() {
		return recordType;
	}

	public void setRecordType(VFRecordType type) {
		this.recordType = type;
	}

	public VFBalance getBalance() {
		return balance;
	}

	public void setBalance(VFBalance balance) {
		this.balance = balance;
	}

	public Boolean isClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
}
