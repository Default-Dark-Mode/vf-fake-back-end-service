package com.vernalfinancial.fakebackendservice.models;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import java.util.Objects;
import java.util.Random;

/**
 * This class represents a personal identification
 * number as understood by Vernal Financial's
 * systems and persisted in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
public class VFPersonalIdentificationNumber {
	@Column(name = "pin")
	@Pattern(regexp = "^\\d{4}$")
	private String number;

	/**
	 * The default constructor for the
	 * VFPersonalIdentificationNumber class calls
	 * the parameterized constructor with a
	 * randomly generated PIN.
	 */
	public VFPersonalIdentificationNumber() {
		this(generatePIN());
	}

	/**
	 * The parameterized constructor for the
	 * VFPersonalIdentificationNumber class is the
	 * primary constructor for the class and will
	 * be called by any other constructors in the
	 * class.
	 *
	 * @param number String the personal identification number
	 */
	public VFPersonalIdentificationNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VFPersonalIdentificationNumber that = (VFPersonalIdentificationNumber) o;
		return Objects.equals(getNumber(), that.getNumber());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNumber());
	}

	@Override
	public String toString() {
		return this.getNumber();
	}

	/**
	 * This method generates a personal identification
	 * number randomly with exactly four digits.
	 *
	 * @return String the randomly generated personal identification number
	 */
	public static String generatePIN() {
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < 4; i++) {
			stringBuilder.append(random.nextInt(10));
		}

		return stringBuilder.toString();
	}
}
