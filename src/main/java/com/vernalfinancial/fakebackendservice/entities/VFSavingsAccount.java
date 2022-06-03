package com.vernalfinancial.fakebackendservice.entities;


import com.vernalfinancial.fakebackendservice.models.VFBalance;
import com.vernalfinancial.fakebackendservice.models.VFMonetaryValue;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "savings_accounts")
public class VFSavingsAccount extends VFFinancialAsset {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
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
		this(null, null, null, null, null, null, null, null);
	}

	public VFSavingsAccount(VFBalance balance, Boolean closed, LocalDateTime createdAt, LocalDateTime modifiedAt, Integer id, Integer annualPercentageRate, VFBalance minimumBalance, VFMonetaryValue insufficientFundsFee) {
		super(balance, closed, createdAt, modifiedAt);
		this.id = id;
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
		return "savings_account{" + "id=" + id + ", annual_percentage_rate=" + annualPercentageRate + ", " +
				"minimum_balance" +
				"=" + minimumBalance + ", insufficient_funds_fee=" + insufficientFundsFee + '}';
	}
}
