package com.vernalfinancial.fakebackendservice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vernalfinancial.fakebackendservice.models.VFDocumentType;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "identification_document_records")
@Getter
@Setter
public class VFIdentificationDocumentRecord extends VFDocumentRecord {
	private String identificationNumber;
	private LocalDateTime issuedDate;
	private LocalDateTime expirationDate;
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "name_record_id")
	private VFNameRecord nameRecord;

	public VFIdentificationDocumentRecord() {
		this(VFRecordType.IdentificationDocumentRecord, null, null, null, null, null, null, null, null, null);
	}

	public VFIdentificationDocumentRecord(VFRecordType recordType, String id, String title, VFDocumentType documentType, LocalDateTime createdAt, LocalDateTime modifiedAt, String identificationNumber, LocalDateTime issuedDate, LocalDateTime expirationDate, VFNameRecord nameRecord) {
		super(recordType, id, title, documentType, createdAt, modifiedAt);
		this.identificationNumber = identificationNumber;
		this.issuedDate = issuedDate;
		this.expirationDate = expirationDate;
		this.nameRecord = nameRecord;
	}
}
