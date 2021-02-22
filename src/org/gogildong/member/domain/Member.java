package org.gogildong.member.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	
	private String mid;
	private String mpw;
	private String mname;
	private String address;
	private Date regdate, updateDate;

}
