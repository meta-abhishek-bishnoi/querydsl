package com.metacube.jpa.postgres.model.pojo;

public class TeacherPojo {
	private Long id;
	private String name;
	private String email;
	private String address;
	private Long deptId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public TeacherPojo(Long id, String name, String email, String address, Long deptId) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.deptId = deptId;
	}
	public TeacherPojo() {
		super();
	}

	@Override
	public String toString() {
		return "TeacherPojo{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", address='" + address + '\'' +
				", deptId=" + deptId +
				'}';
	}
}
