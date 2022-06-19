package com.vernalfinancial.fakebackendservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vernalfinancial.fakebackendservice.models.VFMonetaryValue;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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
@Getter
@Setter
@AllArgsConstructor
@Builder
public class VFFinancialTransaction {
	private final VFRecordType recordType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "origin_id", nullable = false)
	@JsonBackReference
	private VFFinancialAsset origin;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "destination_id", nullable = false)
	@JsonBackReference
	private VFFinancialAsset destination;
	@NotNull
	@Embedded
	private VFMonetaryValue amount;
	@NotNull
	@ManyToOne
	@JsonManagedReference
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
		this(VFRecordType.Transaction, null, null, null, null, null, null, null, null);
	}
}
