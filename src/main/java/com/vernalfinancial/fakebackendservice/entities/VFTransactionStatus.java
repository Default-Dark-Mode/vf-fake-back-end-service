package com.vernalfinancial.fakebackendservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

/**
 * This class maps to the representation of the
 * statuses available to
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "transaction_statuses")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class VFTransactionStatus {
	private final VFRecordType recordType;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String name;
	@NotNull
	private String description;
	@NotNull
	private LocalDateTime createdAt;
	@JsonBackReference
	@OneToMany(mappedBy = "status")
	private List<VFFinancialTransaction> transactions;

	public VFTransactionStatus() {
		this(VFRecordType.TransactionStatus, null, null, null, null, null);
	}
}
