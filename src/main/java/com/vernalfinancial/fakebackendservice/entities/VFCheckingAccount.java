package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFBalance;
import com.vernalfinancial.fakebackendservice.models.VFMonetaryValue;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "checking_accounts")
public class VFCheckingAccount extends VFFinancialAsset{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "negative", column = @Column(name = "minimum_balance_negative")), @AttributeOverride(name = "amount.dollars", column = @Column(name = "minimum_balance_dollars")), @AttributeOverride(name = "amount.cents", column = @Column(name = "minimum_balance_cents"))})
	private VFBalance minimumBalance;
	@NotNull
	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "dollars", column = @Column(name = "insufficient_funds_fee_dollars")), @AttributeOverride(name = "cents", column = @Column(name = "insufficient_funds_fee_cents"))})
	private VFMonetaryValue insufficientFundsFee;

	public VFCheckingAccount() {
		this(null, null, null, null, null, null, null);
	}

	public VFCheckingAccount(VFBalance balance, Boolean closed, LocalDateTime createdAt, LocalDateTime modifiedAt, Integer id, VFBalance minimumBalance, VFMonetaryValue insufficientFundsFee) {
		super(balance, closed, createdAt, modifiedAt);
		this.id = id;
		this.minimumBalance = minimumBalance;
		this.insufficientFundsFee = insufficientFundsFee;
		this.setRecordType(VFRecordType.CheckingAccount);
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
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
		VFCheckingAccount that = (VFCheckingAccount) o;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getMinimumBalance(), that.getMinimumBalance()) && Objects.equals(getInsufficientFundsFee(), that.getInsufficientFundsFee());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getId(), getMinimumBalance(), getInsufficientFundsFee());
	}

	@Override
	public String toString() {
		return "checking_account{" +
				"id=" + id +
				", minimum_balance=" + minimumBalance +
				", insufficient_funds_fee=" + insufficientFundsFee +
				'}';
	}
}
