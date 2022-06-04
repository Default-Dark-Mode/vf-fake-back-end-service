package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This class represents an Automatic Teller
 * Machine (ATM) card as understood by Vernal
 * Financial's systems and persisted in the
 * database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "atm_cards")
public class VFATMCard extends VFFinancialCard {
	@Embedded
	private VFPersonalIdentificationNumber personalIdentificationNumber;

	/**
	 * The default constructor for the VFATMCard class
	 * calls the parameterized constructor with null
	 * values for all the parameters.
	 */
	public VFATMCard() {
		this(null, null, null, null, null, null, null, null, null);
	}

	/**
	 * The parameterized constructor for the VFATMCard
	 * class is the primary constructor and will be
	 * called by any other constructors in the class.
	 *
	 * @param cardNumber                   String the 16-digit ATM card number
	 * @param cardVerificationValue        String the number used to verify physical position of the card
	 * @param activated                    Boolean if the card has been activated
	 * @param deactivated                  Boolean if the card has been deactivated
	 * @param issuedTo                     VFIdentity the person or organization the card was issued to
	 * @param replacementFee               VFMonetaryValue the cost of replacing the card
	 * @param issuedDate                   LocalDateTime the timestamp for when the card was issued
	 * @param expirationDate               LocalDateTime the timestamp for when the card expires
	 * @param personalIdentificationNumber VFPersonalIdentificationNumber the pin established by the cardholder
	 */
	public VFATMCard(VFFinancialCardNumber cardNumber, VFCardVerificationValue cardVerificationValue, Boolean activated, Boolean deactivated, VFIdentity issuedTo, VFMonetaryValue replacementFee, LocalDateTime issuedDate, LocalDateTime expirationDate, VFPersonalIdentificationNumber personalIdentificationNumber) {
		super(cardNumber, cardVerificationValue, activated, deactivated, issuedTo, replacementFee, issuedDate, expirationDate);
		this.setRecordType(VFRecordType.ATMCard);
		this.personalIdentificationNumber = personalIdentificationNumber;
	}

	public VFPersonalIdentificationNumber getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}

	public void setPersonalIdentificationNumber(VFPersonalIdentificationNumber personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		VFATMCard vfatmCard = (VFATMCard) o;
		return Objects.equals(getPersonalIdentificationNumber(), vfatmCard.getPersonalIdentificationNumber());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getPersonalIdentificationNumber());
	}

	@Override
	public String toString() {
		return "atm_card{" +
				"personalIdentificationNumber=" + personalIdentificationNumber +
				"} " + super.toString();
	}
}