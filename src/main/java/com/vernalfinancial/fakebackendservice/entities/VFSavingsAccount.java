package com.vernalfinancial.fakebackendservice.entities;


import com.vernalfinancial.fakebackendservice.models.VFBalance;
import com.vernalfinancial.fakebackendservice.models.VFMonetaryValue;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This class maps to the database representations
 * of a savings account within Vernal Financial's
 * system and associated data.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@Entity
@Table(name = "savings_accounts")
public class VFSavingsAccount extends VFFinancialAsset {
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

	/**
	 * The default constructor for the VFSavingsAccount
	 * entity calls the fully parameterized constructor
	 * with null values for all parameters.
	 */
	public VFSavingsAccount() {
		this(null, null, null, null, null, null, null, null);
	}

	/**
	 * The parameterized constructor for the VFSavingsAccount
	 * entity is the primary constructor and will be called by
	 * any other constructor within the class.
	 *
	 * @param id                   String the unique id of the account
	 * @param balance              VFBalance the current balance
	 * @param closed               Boolean whether the account is closed
	 * @param createdAt            LocalDateTime when the account was created
	 * @param modifiedAt           LocalDateTime when the account was last modified
	 * @param annualPercentageRate the annual percentage rate of the interest
	 * @param minimumBalance       VFBalance the minimum acceptable balance
	 * @param insufficientFundsFee VFMonetaryValue the amount of insufficient funds fees
	 */
	public VFSavingsAccount(String id, VFBalance balance, Boolean closed, LocalDateTime createdAt,
							LocalDateTime modifiedAt, Integer annualPercentageRate, VFBalance minimumBalance, VFMonetaryValue insufficientFundsFee) {
		super(id, balance, closed, createdAt, modifiedAt);
		this.annualPercentageRate = annualPercentageRate;
		this.minimumBalance = minimumBalance;
		this.insufficientFundsFee = insufficientFundsFee;
		this.setRecordType(VFRecordType.SavingsAccount);
	}

	public Integer getAnnualPercentageRate() {
		return annualPercentageRate;
	}

	public void setAnnualPercentageRate(Integer annualPercentageRate) {
		this.annualPercentageRate = annualPercentageRate;
	}

	public VFBalance getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(VFBalance minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public VFMonetaryValue getInsufficientFundsFee() {
		return insufficientFundsFee;
	}

	public void setInsufficientFundsFee(VFMonetaryValue insufficientFundsFee) {
		this.insufficientFundsFee = insufficientFundsFee;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		VFSavingsAccount that = (VFSavingsAccount) o;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getAnnualPercentageRate(), that.getAnnualPercentageRate()) && Objects.equals(getMinimumBalance(), that.getMinimumBalance()) && Objects.equals(getInsufficientFundsFee(), that.getInsufficientFundsFee());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getId(), getAnnualPercentageRate(), getMinimumBalance(), getInsufficientFundsFee());
	}

	@Override
	public String toString() {
		return "savings_account{" + "id=" + this.getId() + ", annual_percentage_rate=" + annualPercentageRate + ", " +
				"minimum_balance" +
				"=" + minimumBalance + ", insufficient_funds_fee=" + insufficientFundsFee + '}';
	}
}
