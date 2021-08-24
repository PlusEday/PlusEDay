package org.eday.domain;

import lombok.Data;

@Data
public class VolunteerWorkVO {
	private String volunteer_work_id;
	private String title;
	private String detail;
	private int number_of_volunteer;
}
