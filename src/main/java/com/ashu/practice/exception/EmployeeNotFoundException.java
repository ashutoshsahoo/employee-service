package com.ashu.practice.exception;

import java.io.Serial;

public class EmployeeNotFoundException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = -6985010521444270149L;

	public EmployeeNotFoundException(Long id) {
		super("Employee not found for requested id = " + id);
	}

}
