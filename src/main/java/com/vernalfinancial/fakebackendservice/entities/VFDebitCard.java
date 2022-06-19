package com.vernalfinancial.fakebackendservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vernalfinancial.fakebackendservice.models.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
@Getter
@Setter
@Builder
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
		this(null, VFRecordType.DebitCard, null, null, null, null, null, null, null, null, null, null, null);
	}

	/**
	 * The parameterized constructor for the
	 * VFDebitCard class is the primary
	 * constructor and it will be called by
	 * any other constructor in the class.
	 *
	 * @param id                    String the unique identifier for the card
	 * @param recordType            VFRecordType the record type
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
	public VFDebitCard(String id, VFRecordType recordType, VFFinancialCardNumber cardNumber, VFCardVerificationValue cardVerificationValue, Boolean activated, Boolean deactivated, VFIdentity issuedTo, List<VFPerson> authorizedUsers, VFMonetaryValue replacementFee, LocalDateTime issuedDate, LocalDateTime expirationDate, VFCheckingAccount source, VFPersonalIdentificationNumber pin) {
		super(recordType, id, cardNumber, cardVerificationValue, activated, deactivated, issuedTo, authorizedUsers, replacementFee, issuedDate, expirationDate);
		this.source = source;
		this.pin = pin;
	}
}