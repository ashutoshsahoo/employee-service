package com.ashu.practice.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateEmployeeRequest extends CreateEmployeeRequest {

	
	private static final String PHONE_REGEX = "^\\d*$";
	
	@Size(min=10, max=13, message = "phone should have minimum 10 characters and maximum 13 characters length")
	@Pattern(regexp = PHONE_REGEX, message = "Invalid phone number")
	private String phone;

	@Size(max = 255, message = "address should have maximum 255 characters length")
	private String address;

}
