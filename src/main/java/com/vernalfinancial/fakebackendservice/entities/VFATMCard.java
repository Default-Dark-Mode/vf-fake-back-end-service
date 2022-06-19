package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

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
@Getter
@Setter
@Builder
public class VFATMCard extends VFFinancialCard {
	@Embedded
	private VFPersonalIdentificationNumber personalIdentificationNumber;

	/**
	 * The default constructor for the VFATMCard class
	 * calls the parameterized constructor with null
	 * values for all the parameters.
	 */
	public VFATMCard() {
		this(VFRecordType.ATMCard, null, null, null, null, null, null, null, null, null, null, null);
	}

	/**
	 * The parameterized constructor for the VFATMCard
	 * class is the primary constructor and will be
	 * called by any other constructors in the class.
	 *
	 * @param id                           String the unique id of the carm
	 * @param recordType                   VFRecordType the type of record
	 * @param cardNumber                   String the 16-digit ATM card number
	 * @param cardVerificationValue        String the number used to verify physical position of the card
	 * @param activated                    Boolean if the card has been activated
	 * @param deactivated                  Boolean if the card has been deactivated
	 * @param issuedTo                     VFIdentity the person or organization the card was issued to
	 * @param authorizedUsers              List<VFPerson> the list of people authorized to use the card
	 * @param replacementFee               VFMonetaryValue the cost of replacing the card
	 * @param issuedDate                   LocalDateTime the timestamp for when the card was issued
	 * @param expirationDate               LocalDateTime the timestamp for when the card expires
	 * @param personalIdentificationNumber VFPersonalIdentificationNumber the pin established by the cardholder
	 */
	public VFATMCard(VFRecordType recordType, String id, VFFinancialCardNumber cardNumber, VFCardVerificationValue cardVerificationValue, Boolean activated, Boolean deactivated, VFIdentity issuedTo, List<VFPerson> authorizedUsers, VFMonetaryValue replacementFee, LocalDateTime issuedDate, LocalDateTime expirationDate, VFPersonalIdentificationNumber personalIdentificationNumber) {
		super(recordType, id, cardNumber, cardVerificationValue, activated, deactivated, issuedTo, authorizedUsers, replacementFee, issuedDate, expirationDate);
		this.personalIdentificationNumber = personalIdentificationNumber;
	}
}