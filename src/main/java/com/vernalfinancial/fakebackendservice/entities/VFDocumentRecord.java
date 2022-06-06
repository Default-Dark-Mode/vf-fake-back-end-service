package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFDocumentType;
import com.vernalfinancial.fakebackendservice.models.VFRecordType;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "document_records")
public class VFDocumentRecord {
	@Id
	private String id;
	private String title;
	private VFRecordType recordType;
	private VFDocumentType documentType;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
}
