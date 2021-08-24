package org.eday.domain;

import java.util.List;

import lombok.Data;

@Data
public class ChecklistVO {

	private String checklist_id;
	private String detail;
	private List<MemberVO> memberList;

}
