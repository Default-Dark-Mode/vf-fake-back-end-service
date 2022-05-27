package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFBalance;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class VFFinancialAsset {
	@Id
	@GeneratedValue
	private Integer id;
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
	private VFBalance balance;
	private Boolean closed;
	@OneToMany(mappedBy = "origin")
	private List<VFFinancialTransaction> outgoingTransactions;
	@OneToMany(mappedBy = "destination")
	private List<VFFinancialTransaction> incomingTransactions;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;

	public VFFinancialAsset() {
		this(null, false, null, null);
	}

	public VFFinancialAsset(VFBalance balance, Boolean closed, LocalDateTime createdAt, LocalDateTime modifiedAt) {
		this.balance = balance;
		this.closed = closed;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VFFinancialAsset that = (VFFinancialAsset) o;
		return Objects.equals(getId(), that.getId()) && isClosed() == that.isClosed() && Objects.equals(getBalance(), that.getBalance()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getModifiedAt(), that.getModifiedAt());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getBalance(), isClosed(), getCreatedAt(), getModifiedAt());
	}

	@Override
	public String toString() {
		return "VFFinancialAsset{" +
				"id=" + id +
				", balance=" + balance +
				", closed=" + closed +
				", createdAt=" + createdAt +
				", modifiedAt=" + modifiedAt +
				'}';
	}
}
