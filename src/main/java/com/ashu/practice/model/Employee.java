package com.ashu.practice.model;

import java.io.Serial;
import java.io.Serializable;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "EMPLOYEES")
public class Employee implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private static final String EMP_SEQ = "EMPLOYEE_ID_SEQUENCE";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = EMP_SEQ)
	@SequenceGenerator(name = EMP_SEQ, sequenceName = EMP_SEQ, allocationSize = 1, initialValue = 1001)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", length = 50, nullable = false)
	private String name;

	@Column(name = "DESIGNATION", length = 20)
	private String designation;

	@Column(name = "DEPARTMENT", length = 20)
	private String department;

	@Column(name = "PHONE", length = 13)
	private String phone;

	@Column(name = "ADDRESS")
	private String address;

	public Employee(String name, String designation, String department) {
		super();
		this.name = name;
		this.designation = designation;
		this.department = department;
	}

}
