package com.vernalfinancial.fakebackendservice.models;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public enum VFOrganizationType {
	Private,
	Religious,
	Governmental,
	Charitable,
	Educational
}
