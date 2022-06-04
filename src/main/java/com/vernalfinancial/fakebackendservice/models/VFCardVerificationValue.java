package com.vernalfinancial.fakebackendservice.models;

import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;
import java.util.Objects;
import java.util.Random;

/**
 * This class represents the card verification
 * value for a credit or debit card as understood
 * by Vernal Financial's systems and persisted in
 * the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@Embeddable
public class VFCardVerificationValue {
	@Pattern(regexp = "^\\d{3}$")
	private String cvv;

	/**
	 * The default constructor for the
	 * VFCardVerificationValue class is the
	 * primary constructor for the class.
	 */
	public VFCardVerificationValue() {
		this.cvv = generateCVV();
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VFCardVerificationValue that = (VFCardVerificationValue) o;
		return Objects.equals(getCvv(), that.getCvv());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCvv());
	}

	@Override
	public String toString() {
		return this.getCvv();
	}

	/**
	 * This method generates random three-digit
	 * string that adheres to Vernal Financial's
	 * standards for a Card Verification Value.
	 *
	 * @return String the card verification value
	 */
	public static String generateCVV() {
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			stringBuilder.append(random.nextInt(10));
		}

		return stringBuilder.toString();
	}
}
