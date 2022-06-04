package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFMonetaryValue;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This class maps to the representation of a
 * financial transaction and related data in
 * Vernal Financial's system.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "transactions")
public class VFFinancialTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Embedded
	private VFRecordType recordType;
	@NotNull
	@ManyToOne
	private VFFinancialAsset origin;
	@NotNull
	@ManyToOne
	private VFFinancialAsset destination;
	@NotNull
	@Embedded
	private VFMonetaryValue amount;
	@NotNull
	@ManyToOne
	@JoinTable(name = "transaction_statuses")
	@JoinColumn(name = "status_id", referencedColumnName = "id")
	private VFTransactionStatus status;
	@NotNull
	private LocalDateTime createdAt;
	@NotNull
	private LocalDateTime receivedAt;
	@NotNull
	private LocalDateTime statusAt;

	/**
	 * The default constructor for the VFFinancialTransaction
	 * class calls the parameterized constructor with null
	 * values for all parameters.
	 */
	public VFFinancialTransaction() {
		this(null, null, null, null, null, null, null);
	}

	/**
	 * The parameterized constructor is the primary constructor
	 * for the VFFinancialAsset class and will be called by any
	 * other constructor within the class.
	 *
	 * @param origin      VFFinancialAsset where the money came from
	 * @param destination VFFinancialAsset where the money is going
	 * @param amount      VFMonetaryValue the amount of money
	 * @param status      VFTransactionStatus the current status of the transaction
	 * @param createdAt   LocalDateTime the timestamp for when the transaction was created
	 * @param receivedAt  LocalDateTime the timestamp for when the transaction was received
	 * @param statusAt    LocalDateTime the timestamp for when the transaction status changed
	 */
	public VFFinancialTransaction(VFFinancialAsset origin, VFFinancialAsset destination, VFMonetaryValue amount, VFTransactionStatus status, LocalDateTime createdAt, LocalDateTime receivedAt, LocalDateTime statusAt) {
		this.recordType = VFRecordType.Transaction;
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
		return "financial_transaction{" + "id=" + id + ", origin=" + origin + ", destination=" + destination + ", " +
				"amount=" + amount + ", status=" + status + ", created_at=" + createdAt + ", received_at=" + receivedAt + ", status_at=" + statusAt + '}';
	}
}
