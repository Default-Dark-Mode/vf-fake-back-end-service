package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFCardVerificationValue;
import com.vernalfinancial.fakebackendservice.models.VFFinancialCardNumber;
import com.vernalfinancial.fakebackendservice.models.VFMonetaryValue;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
@Getter
@Setter
@AllArgsConstructor
@Builder
public abstract class VFFinancialCard {
	private final VFRecordType recordType;
	@Id
	private String id;
	@Embedded
	private VFFinancialCardNumber cardNumber;
	@Embedded
	private VFCardVerificationValue cardVerificationValue;
	private Boolean activated;
	private Boolean deactivated;
	@OneToOne
	private VFIdentity issuedTo;
	@ManyToMany(mappedBy = "authorizedCards")
	private List<VFPerson> authorizedUsers;
	@Embedded
	private VFMonetaryValue replacementFee;
	private LocalDateTime issuedDate;
	private LocalDateTime expirationDate;

	public VFFinancialCard() {
		this(VFRecordType.FinancialCard, null, null, null, null, null, null, null, null, null, null);
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