package com.vernalfinancial.fakebackendservice.models;

import com.vernalfinancial.fakebackendservice.entities.VFFinancialCard;

import javax.persistence.*;
import java.util.Objects;
import java.util.Random;

/**
 * This class represents the specific card
 * number for a credit or debit card in
 * Vernal Financial's systems and as
 * persisted in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@Embeddable
public class VFFinancialCardNumber {
	@Column(name = "card_number")
	private String number;

	/**
	 * The default constructor for the
	 * VFFinancialCardNumber class is the
	 * primary constructor and is used to
	 * generate a new card number.
	 */
	public VFFinancialCardNumber() {
		this.number = generateCardNumber();
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
		VFFinancialCardNumber that = (VFFinancialCardNumber) o;
		return Objects.equals(getNumber(), that.getNumber());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNumber());
	}

	@Override
	public String toString() {
		return this.number.substring(0, 4) + '-' + this.number.substring(4, 8) +
				'-' + this.number.substring(8, 12) + '-' + this.number.substring(12);
	}

	public static String generateCardNumber() {
		String majorIndustryIdentifier = "9";
		String issuerIdentificationNumber = "91142";

		StringBuilder stringBuilder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			int number = random.nextInt(10);
			stringBuilder.append(number);
		}

		String cardNumber = majorIndustryIdentifier + issuerIdentificationNumber + stringBuilder;

		return VFFinancialCard.luhnAlgorithm(cardNumber) ? cardNumber : generateCardNumber();
	}
}
