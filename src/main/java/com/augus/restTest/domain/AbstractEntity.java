package com.augus.restTest.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractEntity<Id extends Serializable> implements Serializable {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Id id;

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity<?> other = (AbstractEntity<?>) obj;
		if (id == null) {
			return other.id == null;
		} else
			return id.equals(other.id);
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}
}
