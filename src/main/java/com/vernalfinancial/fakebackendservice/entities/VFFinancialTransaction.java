package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFMonetaryValue;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "transactions")
public class VFFinancialTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private VFFinancialAsset origin;
	@ManyToOne
	private VFFinancialAsset destination;
	@Embedded
	private VFMonetaryValue amount;
	@ManyToOne
	@JoinTable(name = "transaction_statuses")
	@JoinColumn(name = "status_id", referencedColumnName = "id")
	private VFTransactionStatus status;
	private LocalDateTime createdAt;
	private LocalDateTime receivedAt;
	private LocalDateTime statusAt;

	public VFFinancialTransaction() {
		this(null, null, null, null, null, null, null);
	}

	public VFFinancialTransaction(VFFinancialAsset origin, VFFinancialAsset destination, VFMonetaryValue amount, VFTransactionStatus status, LocalDateTime createdAt, LocalDateTime receivedAt, LocalDateTime statusAt) {
		this.origin = origin;
		this.destination = destination;
		this.amount = amount;
		this.status = status;
		this.createdAt = createdAt;
		this.receivedAt = receivedAt;
		this.statusAt = statusAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VFFinancialAsset getOrigin() {
		return origin;
	}

	public void setOrigin(VFFinancialAsset origin) {
		this.origin = origin;
	}

	public VFFinancialAsset getDestination() {
		return destination;
	}

	public void setDestination(VFFinancialAsset destination) {
		this.destination = destination;
	}

	public VFMonetaryValue getAmount() {
		return amount;
	}

	public void setAmount(VFMonetaryValue amount) {
		this.amount = amount;
	}

	public VFTransactionStatus getStatus() {
		return status;
	}

	public void setStatus(VFTransactionStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getReceivedAt() {
		return receivedAt;
	}

	public void setReceivedAt(LocalDateTime receivedAt) {
		this.receivedAt = receivedAt;
	}

	public LocalDateTime getStatusAt() {
		return statusAt;
	}

	public void setStatusAt(LocalDateTime statusAt) {
		this.statusAt = statusAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VFFinancialTransaction that = (VFFinancialTransaction) o;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getOrigin(), that.getOrigin()) && Objects.equals(getDestination(), that.getDestination()) && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getStatus(), that.getStatus()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getReceivedAt(), that.getReceivedAt()) && Objects.equals(getStatusAt(), that.getStatusAt());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getOrigin(), getDestination(), getAmount(), getStatus(), getCreatedAt(), getReceivedAt(), getStatusAt());
	}

	@Override
	public String toString() {
		return "VFFinancialTransaction{" + "id=" + id + ", origin=" + origin + ", destination=" + destination + ", amount=" + amount + ", status=" + status + ", createdAt=" + createdAt + ", receivedAt=" + receivedAt + ", statusAt=" + statusAt + '}';
	}
}
