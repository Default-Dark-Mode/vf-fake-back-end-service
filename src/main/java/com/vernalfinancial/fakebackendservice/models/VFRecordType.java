package com.vernalfinancial.fakebackendservice.models;

/**
 * This class represents the type of a given
 * record in the database and can be used to
 * distinguish the data type of an object
 * that has been retrieved from the database
 * after deserialization.
 *
 * @author Matthew.Crowell1@gmail.com
 */
public enum VFRecordType {
	UnknownAsset,
	SavingsAccount,
	CheckingAccount,
	Transaction,
	TransactionStatus,
	Identity,
	Person,
	Organization,
	PersonalName,
	OrganizationalName,
	LoginCredentials,
	EmailAddress,
	PhoneNumber,
	PhysicalAddress,
	ContactInformation,
	FinancialCard,
	ATMCard,
	DebitCard,
	DocumentRecord,
	NameRecord,
	IdentificationDocumentRecord,
	AccessAccount,
	NaturalName
}
