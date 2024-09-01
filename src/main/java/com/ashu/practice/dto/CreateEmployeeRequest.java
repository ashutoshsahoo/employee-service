package com.ashu.practice.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateEmployeeRequest {

	private static final String NAME_REGEX = "^[a-zA-Z0-9\\s]+";

	@NotBlank(message = "name should not be empty or null")
	@Size(min = 2, max = 50, message = "name should have minimum 2 characters and maximum 50 characters length")
	@Pattern(regexp = NAME_REGEX, message = "Invalid name - no special characters allowed")
	private String name;

	@NotBlank(message = "designation should not be empty or null")
	@Size(min = 2, max = 20, message = "designation should have minimum 2 characters and maximum 20 characters length")
	@Pattern(regexp = NAME_REGEX, message = "Invalid designation - no special characters allowed")
	private String designation;

	@NotBlank(message = "department should not be empty or null")
	@Size(min = 2, max = 20, message = "department should have minimum 2 characters and maximum 20 characters length")
	@Pattern(regexp = NAME_REGEX, message = "Invalid department - no special characters allowed")
	private String department;

}
