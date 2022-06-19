package com.vernalfinancial.fakebackendservice.entities;


import com.vernalfinancial.fakebackendservice.models.VFBalance;
import com.vernalfinancial.fakebackendservice.models.VFMonetaryValue;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * This class maps to the database representations
 * of a savings account within Vernal Financial's
 * system and associated data.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "savings_accounts")
@Getter
@Setter
@Builder
public class VFSavingsAccount extends VFFinancialAsset {
	private final VFRecordType recordType = VFRecordType.SavingsAccount;
	@NotNull
	private Integer annualPercentageRate;
	@NotNull
	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "negative", column = @Column(name = "minimum_balance_negative")), @AttributeOverride(name = "amount.dollars", column = @Column(name = "minimum_balance_dollars")), @AttributeOverride(name = "amount.cents", column = @Column(name = "minimum_balance_cents"))})
	private VFBalance minimumBalance;
	@NotNull
	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "dollars", column = @Column(name = "insufficient_funds_fee_dollars")), @AttributeOverride(name = "cents", column = @Column(name = "insufficient_funds_fee_cents"))})
	private VFMonetaryValue insufficientFundsFee;

	public VFSavingsAccount() {
		this(VFRecordType.SavingsAccount, null, null, null, null, null, null, null, null, null, null);
	}

	public VFSavingsAccount(VFRecordType recordType, String id, @NotNull VFBalance balance, @NotNull Boolean closed, Set<VFFinancialTransaction> outgoingTransactions, Set<VFFinancialTransaction> incomingTransactions, @NotNull LocalDateTime createdAt, @NotNull LocalDateTime modifiedAt, Integer annualPercentageRate, VFBalance minimumBalance, VFMonetaryValue insufficientFundsFee) {
		super(recordType, id, balance, closed, outgoingTransactions, incomingTransactions, createdAt, modifiedAt);
		this.annualPercentageRate = annualPercentageRate;
		this.minimumBalance = minimumBalance;
		this.insufficientFundsFee = insufficientFundsFee;
	}
}
