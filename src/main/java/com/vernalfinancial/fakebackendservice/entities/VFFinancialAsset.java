package com.vernalfinancial.fakebackendservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vernalfinancial.fakebackendservice.models.VFBalance;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

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
@Getter
@Setter
@AllArgsConstructor
public abstract class VFFinancialAsset {
	@Enumerated(value = EnumType.STRING)
	private final VFRecordType recordType;
	@Id
	private String id;
	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "negative", column = @Column(name = "balance_negative")), @AttributeOverride(name = "amount.dollars", column = @Column(name = "balance_dollars")), @AttributeOverride(name = "amount.cents", column = @Column(name = "balance_cents"))})
	@NotNull
	private VFBalance balance;
	@NotNull
	private Boolean closed;
	@JsonBackReference
	@OneToMany(mappedBy = "origin")
	private Set<VFFinancialTransaction> outgoingTransactions;
	@JsonBackReference
	@OneToMany(mappedBy = "destination")
	private Set<VFFinancialTransaction> incomingTransactions;
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "access_account")
	private VFAccessAccount accessAccount;
	@NotNull
	private LocalDateTime createdAt;
	@NotNull
	private LocalDateTime modifiedAt;

	/**
	 * The default constructor for the VFFinancialAsset
	 * class calls the parameterized constructor
	 * with null values for all parameters except the
	 * record type.
	 */
	public VFFinancialAsset() {
		this(VFRecordType.UnknownAsset, null, null, false, null, null, null, null, null);
	}

}
