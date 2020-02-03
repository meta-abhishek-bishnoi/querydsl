package com.metacube.jpa.postgres.model.pojo;

import com.querydsl.core.annotations.QueryProjection;

public class TeacherDetails {
	private Long teacherId;
	private String teacherName;
	private String email;
	private String address;
	private Long departmentId;
	private String departmentName;
	@QueryProjection
	public TeacherDetails(Long teacherId, String teacherName, String email, String address, Long departmentId, String departmentName) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.email = email;
		this.address = address;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	public TeacherDetails() {
		super();
	}
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "TeacherDetails{" +
				"teacherId=" + teacherId +
				", teacherName='" + teacherName + '\'' +
				", email='" + email + '\'' +
				", address='" + address + '\'' +
				", departmentId=" + departmentId +
				", departmentName='" + departmentName + '\'' +
				'}';
	}
}
