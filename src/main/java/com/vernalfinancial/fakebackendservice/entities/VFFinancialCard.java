package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFCardVerificationValue;
import com.vernalfinancial.fakebackendservice.models.VFFinancialCardNumber;
import com.vernalfinancial.fakebackendservice.models.VFMonetaryValue;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This class serves as the abstract base class for
 * automatic teller machine cards, credit cards, and
 * debit cards in Vernal Financial's systems.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@Entity
@Table(name = "financial_cards")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class VFFinancialCard {
	@Id
	private String id;
	@Embedded
	private VFRecordType recordType;
	@Embedded
	private VFFinancialCardNumber cardNumber;
	@Embedded
	private VFCardVerificationValue cardVerificationValue;
	private Boolean activated;
	private Boolean deactivated;
	@OneToOne
	private VFIdentity issuedTo;
	@Embedded
	private VFMonetaryValue replacementFee;
	private LocalDateTime issuedDate;
	private LocalDateTime expirationDate;

	/**
	 * The default constructor for the VFFinancialCard
	 * class calls the parameterized constructor with
	 * null values for all the parameters.
	 */
	public VFFinancialCard() {
		this(null, null, null, null, null, null, null, null);
	}

	public VFFinancialCard(VFFinancialCardNumber cardNumber, VFCardVerificationValue cardVerificationValue, Boolean activated, Boolean deactivated, VFIdentity issuedTo, VFMonetaryValue replacementFee, LocalDateTime issuedDate, LocalDateTime expirationDate) {
		this.recordType = VFRecordType.FinancialCard;
		this.cardNumber = cardNumber;
		this.cardVerificationValue = cardVerificationValue;
		this.activated = activated;
		this.deactivated = deactivated;
		this.issuedTo = issuedTo;
		this.replacementFee = replacementFee;
		this.issuedDate = issuedDate;
		this.expirationDate = expirationDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public VFRecordType getRecordType() {
		return recordType;
	}

	public void setRecordType(VFRecordType recordType) {
		this.recordType = recordType;
	}

	public VFFinancialCardNumber getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(VFFinancialCardNumber cardNumber) {
		this.cardNumber = cardNumber;
	}

	public VFCardVerificationValue getCardVerificationValue() {
		return cardVerificationValue;
	}

	public void setCardVerificationValue(VFCardVerificationValue cardVerificationValue) {
		this.cardVerificationValue = cardVerificationValue;
	}

	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	public Boolean getDeactivated() {
		return deactivated;
	}

	public void setDeactivated(Boolean deactivated) {
		this.deactivated = deactivated;
	}

	public VFIdentity getIssuedTo() {
		return issuedTo;
	}

	public void setIssuedTo(VFIdentity issuedTo) {
		this.issuedTo = issuedTo;
	}

	public VFMonetaryValue getReplacementFee() {
		return replacementFee;
	}

	public void setReplacementFee(VFMonetaryValue replacementFee) {
		this.replacementFee = replacementFee;
	}

	public LocalDateTime getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(LocalDateTime issuedDate) {
		this.issuedDate = issuedDate;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VFFinancialCard that = (VFFinancialCard) o;
		return Objects.equals(getId(), that.getId()) && getRecordType() == that.getRecordType() && Objects.equals(getCardNumber(), that.getCardNumber()) && Objects.equals(getCardVerificationValue(), that.getCardVerificationValue()) && Objects.equals(getActivated(), that.getActivated()) && Objects.equals(getDeactivated(), that.getDeactivated()) && Objects.equals(getIssuedTo(), that.getIssuedTo()) && Objects.equals(getReplacementFee(), that.getReplacementFee()) && Objects.equals(getIssuedDate(), that.getIssuedDate()) && Objects.equals(getExpirationDate(), that.getExpirationDate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getRecordType(), getCardNumber(), getCardVerificationValue(), getActivated(), getDeactivated(), getIssuedTo(), getReplacementFee(), getIssuedDate(), getExpirationDate());
	}

	@Override
	public String toString() {
		return "financial_card{" +
				"id='" + id + '\'' +
				", record_type=" + recordType +
				", card_number=" + cardNumber +
				", card_verification_value=" + cardVerificationValue +
				", activated=" + activated +
				", deactivated=" + deactivated +
				", issued_to=" + issuedTo +
				", replacement_fee=" + replacementFee +
				", issued_date=" + issuedDate +
				", expiration_date=" + expirationDate +
				'}';
	}

	/**
	 * This method takes a VFFinancialCardNumber as
	 * an argument and returns a boolean value
	 * representing if the number is valid.
	 *
	 * @param cardNumber String the VFFinancialCardNumber
	 * @return boolean validity of the provided card number
	 */
	public static boolean luhnAlgorithm(String cardNumber) {
		int length = cardNumber.length();
		int sum = 0;

		if (length % 2 == 0) {
			for (int i = length - 1; i > 0; i--) {
				int integerRepresentation = Integer.parseInt(cardNumber.substring(i, i + 1));

				if (i % 2 == 0) {
					sum += (((integerRepresentation * 2) % 10) + ((integerRepresentation * 2) / 10));
				} else {
					sum += integerRepresentation;
				}
			}
		}

		return sum % 10 == 0;
	}
}