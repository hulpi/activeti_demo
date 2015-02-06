package com.gbs.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "GU_USER_INFO")
public class GU_USER_INFO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenerator")
	@SequenceGenerator(name = "mySeqGenerator", sequenceName = "GU_USER_INFO_SEQ")
	private Long gu_user_info_oid;
	
	 
	@Column(length = 40)
	private String username;
	
	@Column(length = 40)
	private String password;


	@ManyToOne
	@JoinColumn(name="city")
	private GU_CITY_INFO city;//城市公司
	
	@ManyToOne
	@JoinColumn(name="branch")
	private GU_BRANCH_INFO branch;//分行
	
	@Column(length = 32)
	private String tel;

	@Column(length=20)
	private String email;

	public Long getGu_user_info_oid() {
		return gu_user_info_oid;
	}

	public void setGu_user_info_oid(Long gu_user_info_oid) {
		this.gu_user_info_oid = gu_user_info_oid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public GU_CITY_INFO getCity() {
		return city;
	}

	public void setCity(GU_CITY_INFO city) {
		this.city = city;
	}

	public GU_BRANCH_INFO getBranch() {
		return branch;
	}

	public void setBranch(GU_BRANCH_INFO branch) {
		this.branch = branch;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 
	
	
}
