package com.vernalfinancial.fakebackendservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "transaction_statuses")
public class VFTransactionStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String name;
	@NotNull
	private String description;
	@NotNull
	private LocalDateTime createdAt;
	@JsonIgnore
	@OneToMany(mappedBy = "id")
	private List<VFFinancialTransaction> transaction;

	public VFTransactionStatus() {
		this("new", "A new transaction status");
	}

	public VFTransactionStatus(String name, String description) {
		this.name = name;
		this.description = description;
		this.createdAt = LocalDateTime.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VFTransactionStatus that = (VFTransactionStatus) o;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getCreatedAt(), that.getCreatedAt());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getDescription(), getCreatedAt());
	}

	@Override
	public String toString() {
		return "VFTransactionStatus{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", createdAt=" + createdAt + '}';
	}
}
