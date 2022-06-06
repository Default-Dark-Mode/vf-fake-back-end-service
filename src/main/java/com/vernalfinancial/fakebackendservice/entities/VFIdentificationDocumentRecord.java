package com.vernalfinancial.fakebackendservice.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "identification_document_records")
public class VFIdentificationDocumentRecord extends VFDocumentRecord{
	private String identificationNumber;
	private LocalDateTime issuedDate;
	private LocalDateTime expirationDate;
	@ManyToOne
	@JoinColumn(name = "name_record_id")
	private VFNameRecord nameRecord;
}
