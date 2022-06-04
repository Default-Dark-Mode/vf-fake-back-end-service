package com.vernalfinancial.fakebackendservice.entities;

import com.vernalfinancial.fakebackendservice.models.VFRecordType;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

/**
 * This class represents a telephone number as
 * understood by Vernal Financial's systems and
 * as persisted in the database.
 *
 * @author Matthew.Crowell1@gmail.com
 */
@Entity
@Table(name = "phone_numbers")
public class VFPhone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Embedded
	private VFRecordType recordType;
	@NotNull
	private Boolean mobile;
	@Pattern(regexp = "\\d{1,4}")
	private String countryCode;
	@Pattern(regexp = "\\d{3}")
	private String areaCode;
	@Pattern(regexp = "\\d{3}")
	private String prefix;
	@Pattern(regexp = "\\d{4}")
	private String line;
	@Pattern(regexp = "\\d{0,5}")
	private String extension;

	/**
	 * The default constructor for the VFPhone class
	 * calls the parameterized constructor with null
	 * values for all parameters.
	 */
	public VFPhone() {
		this(null, null, null, null, null, null);
	}

	/**
	 * The parameterized constructor for the VFPhone
	 * class is the primary constructory and it will
	 * be called by any other constructor in the
	 * class.
	 *
	 * @param mobile      Boolean if the phone number is for a mobile device
	 * @param countryCode String the country code needed for international calling
	 * @param areaCode    String the area code of the phone number
	 * @param prefix      String the three digit prefix of the phone number
	 * @param line        String the four digit line number of the phone number
	 * @param extension   String the extension of the phone number, if applicable
	 */
	public VFPhone(Boolean mobile, String countryCode, String areaCode, String prefix, String line, String extension) {
		this.recordType = VFRecordType.PhoneNumber;
		this.mobile = mobile;
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.line = line;
		this.extension = extension;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VFRecordType getRecordType() {
		return recordType;
	}

	public void setRecordType(VFRecordType recordType) {
		this.recordType = recordType;
	}

	public Boolean getMobile() {
		return mobile;
	}

	public void setMobile(Boolean mobile) {
		this.mobile = mobile;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VFPhone vfPhone = (VFPhone) o;
		return Objects.equals(getId(), vfPhone.getId()) && getRecordType() == vfPhone.getRecordType() && Objects.equals(getMobile(), vfPhone.getMobile()) && Objects.equals(getCountryCode(), vfPhone.getCountryCode()) && Objects.equals(getAreaCode(), vfPhone.getAreaCode()) && Objects.equals(getPrefix(), vfPhone.getPrefix()) && Objects.equals(getLine(), vfPhone.getLine()) && Objects.equals(getExtension(), vfPhone.getExtension());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getRecordType(), getMobile(), getCountryCode(), getAreaCode(), getPrefix(), getLine(), getExtension());
	}

	@Override
	public String toString() {
		return "phone{" +
				"id=" + id +
				", record_type=" + recordType +
				", mobile=" + mobile +
				", country_code='" + countryCode + '\'' +
				", area_code='" + areaCode + '\'' +
				", prefix='" + prefix + '\'' +
				", line='" + line + '\'' +
				", extension='" + extension + '\'' +
				'}';
	}
}
