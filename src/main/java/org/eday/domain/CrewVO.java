package org.eday.domain;

import java.lang.reflect.Member;
import java.util.List;

import lombok.Data;

@Data
public class CrewVO {
	
	private String crew_id;
	private String crew_name;
	private String crew_type;
	private List<Member> memberList;
	
}
