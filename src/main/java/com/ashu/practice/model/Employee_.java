package com.ashu.practice.model;


import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Employee.class)
public class Employee_ {

	public static volatile SingularAttribute<Employee, Long> id;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, String> designation;
	public static volatile SingularAttribute<Employee, String> department;
	public static volatile SingularAttribute<Employee, String> phone;
	public static volatile SingularAttribute<Employee, String> address;

	private Employee_() {
		super();
	}

}
