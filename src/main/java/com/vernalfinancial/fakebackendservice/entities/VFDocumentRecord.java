package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFDocumentType;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "document_records")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class VFDocumentRecord {
	private final VFRecordType recordType;
	@Id
	private String id;
	private String title;
	private VFDocumentType documentType;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;

	public VFDocumentRecord() {
		this(VFRecordType.DocumentRecord, null, null, null, null, null);
	}
}
