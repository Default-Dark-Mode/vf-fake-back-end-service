package com.vernalfinancial.fakebackendservice.models;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VFMonetaryValue implements Serializable, Comparable<VFMonetaryValue> {
	@Min(value = 0, message = "Negative values must be expressed using the negative value indicator")
	private Integer dollars;

	@Min(value = 0, message = "Negative values must be expressed using the negative value indicator")
	@Max(value = 99, message = "Values exceeding $1 cannot be expressed in cents")
	private Integer cents;

	public VFMonetaryValue() {
		this(0, 0);
	}

	public VFMonetaryValue(Integer dollars, Integer cents) {

		this.dollars = dollars;
		this.cents = cents;
	}

	public Integer getDollars() {
		return dollars;
	}

	public void setDollars(Integer dollars) {
		this.dollars = dollars;
	}

	public Integer getCents() {
		return cents;
	}

	public void setCents(Integer cents) {
		this.cents = cents;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VFMonetaryValue that = (VFMonetaryValue) o;
		return Objects.equals(getDollars(), that.getDollars()) && Objects.equals(getCents(), that.getCents());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getDollars(), getCents());
	}

	@Override
	public int compareTo(VFMonetaryValue other) {
		int returnValue = 0;

		if (this.dollars < other.dollars) {
			returnValue = -1;
		} else if (this.dollars > other.dollars) {
			returnValue = 1;
		} else {
			if (this.cents < other.cents) {
				returnValue = -1;
			} else if (this.cents > other.cents) {
				returnValue = 1;
			}
		}

		return returnValue;
	}
}
