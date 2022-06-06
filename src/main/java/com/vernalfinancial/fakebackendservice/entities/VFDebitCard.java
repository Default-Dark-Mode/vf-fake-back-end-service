package com.vernalfinancial.fakebackendservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vernalfinancial.fakebackendservice.models.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a debit card as understood
 * by Vernal Financial's systems and as persisted
 * in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "debit_cards")
public class VFDebitCard extends VFFinancialCard {
	@ManyToOne
	@JoinColumn(name = "source_id")
	@JsonManagedReference
	private VFCheckingAccount source;
	@Embedded
	private VFPersonalIdentificationNumber pin;

	/**
	 * The default constructor for the VFDebitCard
	 * class calls the parameterized constructor
	 * with null values for all the parameters.
	 */
	public VFDebitCard() {
		this(null, null, null, null, null, null, null, null, null, null, null);
	}

	/**
	 * The parameterized constructor for the
	 * VFDebitCard class is the primary
	 * constructor and it will be called by
	 * any other constructor in the class.
	 *
	 * @param cardNumber            String the debit card number
	 * @param cardVerificationValue String the card verification value
	 * @param activated             Boolean if the card has been activated
	 * @param deactivated           Boolean if the card has been deactivated
	 * @param issuedTo              VFIdentity the person or organization that was issued the card
	 * @param authorizedUsers       List<VFPerson> the people authorized to use this card
	 * @param replacementFee        VFMonetaryValue the cost of replacing the card
	 * @param issuedDate            LocalDateTime the timestamp for when the card was issued
	 * @param expirationDate        LocalDatetime the timestamp for when the card expires
	 * @param source                VFCheckingAccount the checking account linked to the card
	 * @param pin                   VFPersonalIdentificationNumber the pin established by the cardholder
	 */
	public VFDebitCard(VFFinancialCardNumber cardNumber, VFCardVerificationValue cardVerificationValue,
					   Boolean activated, Boolean deactivated, VFIdentity issuedTo,
					   List<VFPerson> authorizedUsers, VFMonetaryValue replacementFee,
					   LocalDateTime issuedDate, LocalDateTime expirationDate, VFCheckingAccount source, VFPersonalIdentificationNumber pin) {
		super(cardNumber, cardVerificationValue, activated, deactivated, issuedTo, authorizedUsers, replacementFee,
				issuedDate,
				expirationDate);
		this.setRecordType(VFRecordType.DebitCard);
		this.source = source;
		this.pin = pin;
	}

	public VFCheckingAccount getSource() {
		return source;
	}

	public void setSource(VFCheckingAccount source) {
		this.source = source;
	}

	public VFPersonalIdentificationNumber getPin() {
		return pin;
	}

	public void setPin(VFPersonalIdentificationNumber pin) {
		this.pin = pin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		VFDebitCard that = (VFDebitCard) o;
		return Objects.equals(getSource(), that.getSource()) && Objects.equals(getPin(), that.getPin());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getSource(), getPin());
	}

	@Override
	public String toString() {
		return "debit_card{" +
				"source=" + source +
				", pin=" + pin +
				"} " + super.toString();
	}
}