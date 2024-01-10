package com.restapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Studentinfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String department;
	private String projectT;
	private String project;
	public Studentinfo() {
		super();
	}
	public Studentinfo(int id, String name, String department, String projectT, String project) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.projectT = projectT;
		this.project = project;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getProjectT() {
		return projectT;
	}
	public void setProjectT(String projectT) {
		this.projectT = projectT;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "Studentinfo [id=" + id + ", name=" + name + ", department=" + department + ", projectT=" + projectT
				+ ", project=" + project + "]";
	}
	

}
