package com.ashu.practice.dto;

import java.io.Serial;
import java.io.Serializable;


import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeSearchRequest implements Serializable {

	@Serial
	private static final long serialVersionUID = -434836238241596395L;
	
	private static final String NAME_REGEX = "^[a-zA-Z0-9\\s]+";

	@Pattern(regexp = NAME_REGEX, message = "Invalid name - no special characters allowed")
	private String name;
	
	@Pattern(regexp = NAME_REGEX, message = "Invalid designation - no special characters allowed")
	private String designation;
	
	@Pattern(regexp = NAME_REGEX, message = "Invalid department - no special characters allowed")
	private String department;
}
