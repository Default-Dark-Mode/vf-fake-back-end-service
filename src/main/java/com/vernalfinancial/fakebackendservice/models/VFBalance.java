package com.vernalfinancial.fakebackendservice.models;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Objects;

/**
 * This class represents the balance of an account in
 * the Vernal Financial system.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@Embeddable
public class VFBalance {
	private Boolean negative;
	@Embedded
	private VFMonetaryValue amount;

	/**
	 * The default constructor for the VFBalance class calls
	 * the parameterized constructor using null values for all
	 * parameters.
	 */
	public VFBalance() {
		this(false, 0, 0);
	}

	/**
	 * The parameterized constructor for the VFBalance class is
	 * the primary constructor and will be called by any other
	 * constructor in the class.
	 *
	 * @param negative boolean if the balance is negative
	 * @param dollars  int the number of US dollars
	 * @param cents    int the number of US cents
	 */
	public VFBalance(boolean negative, int dollars, int cents) {
		this.negative = negative;
		this.amount = new VFMonetaryValue(dollars, cents);
	}

	public Boolean isNegative() {
		return negative;
	}

	public void setNegative(Boolean negative) {
		this.negative = negative;
	}

	public VFMonetaryValue getAmount() {
		return amount;
	}

	public void setAmount(VFMonetaryValue amount) {
		this.amount = amount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VFBalance vfBalance = (VFBalance) o;
		return isNegative() == vfBalance.isNegative() && Objects.equals(getAmount(), vfBalance.getAmount());
	}

	@Override
	public int hashCode() {
		return Objects.hash(isNegative(), getAmount());
	}

	@Override
	public String toString() {
		return "VFBalance{" + "negative=" + negative + ", amount=" + amount + '}';
	}
}
