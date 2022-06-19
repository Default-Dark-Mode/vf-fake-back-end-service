package com.vernalfinancial.fakebackendservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vernalfinancial.fakebackendservice.models.VFBalance;
import com.vernalfinancial.fakebackendservice.models.VFMonetaryValue;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * This class maps to the database representations
 * of a checking account within Vernal Financial's
 * system and associated data.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "checking_accounts")
@Getter
@Setter
public class VFCheckingAccount extends VFFinancialAsset {
	@NotNull
	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "negative", column = @Column(name = "minimum_balance_negative")), @AttributeOverride(name = "amount.dollars", column = @Column(name = "minimum_balance_dollars")), @AttributeOverride(name = "amount.cents", column = @Column(name = "minimum_balance_cents"))})
	private VFBalance minimumBalance;
	@NotNull
	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "dollars", column = @Column(name = "insufficient_funds_fee_dollars")), @AttributeOverride(name = "cents", column = @Column(name = "insufficient_funds_fee_cents"))})
	private VFMonetaryValue insufficientFundsFee;
	@JsonBackReference
	@OneToMany(mappedBy = "source", fetch = FetchType.LAZY)
	private Set<VFDebitCard> debitCards;

	/**
	 * The default constructor for the VFCheckingAccount
	 * entity calls the fully parameterized constructor
	 * with null values for all parameters.
	 */
	public VFCheckingAccount() {
		this(VFRecordType.CheckingAccount, null, null, null, null, null, null, null, null, null, null, null);
	}

	/**
	 * The parameterized constructor for the VFCheckingAccount
	 * entity is the primary constructor and will be called by
	 * any other constructor within the class.
	 *
	 * @param recordType           VFRecordType the record type
	 * @param id                   String the unique id of the account
	 * @param balance              VFBalance the current balance
	 * @param closed               Boolean whether the account is closed
	 * @param outgoingTransactions HashSet<VFFinancialTransaction> outgoing transactions
	 * @param incomingTransactions HashSet<VFFinancialTransaction> incoming transactions
	 * @param createdAt            LocalDateTime when the account was created
	 * @param modifiedAt           LocalDateTime when the account was last modified
	 * @param minimumBalance       VFBalance the minimum acceptable balance
	 * @param insufficientFundsFee VFMonetaryValue the amount of insufficient funds fees
	 */
	public VFCheckingAccount(VFRecordType recordType, String id, @NotNull VFBalance balance, @NotNull Boolean closed, Set<VFFinancialTransaction> outgoingTransactions, Set<VFFinancialTransaction> incomingTransactions, VFAccessAccount accessAccount, @NotNull LocalDateTime createdAt, @NotNull LocalDateTime modifiedAt, VFBalance minimumBalance, VFMonetaryValue insufficientFundsFee, Set<VFDebitCard> debitCards) {
		super(recordType, id, balance, closed, outgoingTransactions, incomingTransactions, accessAccount, createdAt, modifiedAt);
		this.minimumBalance = minimumBalance;
		this.insufficientFundsFee = insufficientFundsFee;
		this.debitCards = debitCards;
	}
}
