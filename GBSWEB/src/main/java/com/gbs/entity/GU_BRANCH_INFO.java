package com.gbs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 分行
 * @author wb00002
 *
 */
@Entity
@Table(name = "GU_BRANCH_INFO")
public class GU_BRANCH_INFO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenerator")
	@SequenceGenerator(name = "mySeqGenerator", sequenceName = "GU_BRANCH_INFO_SEQ")
	private Long gu_branch_info_oid;

	@ManyToOne(targetEntity=GU_CITY_INFO.class,fetch=FetchType.LAZY)
	@JoinColumn(name="city")
	private GU_CITY_INFO city;
	
	@Column(length=10)
	private String branch_code;
	
	@Column(length=50)
	private String branch_name;
	
	@Column(length=2)
	private String branch_level;
	
	@Column(length=100)
	private String address;
	
	@Column(length=15)
	private String tel;
	
	@Column(length=15)
	private String fax;
	
	@Temporal(TemporalType.TIME)
	private Date create_date;
	
	@Column(length=10)
	private String create_user;


	public Long getGu_branch_info_oid() {
		return gu_branch_info_oid;
	}

	public void setGu_branch_info_oid(Long gu_branch_info_oid) {
		this.gu_branch_info_oid = gu_branch_info_oid;
	}

	public GU_CITY_INFO getCity() {
		return city;
	}

	public void setCity(GU_CITY_INFO city) {
		this.city = city;
	}

	public String getBranch_code() {
		return branch_code;
	}

	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getBranch_level() {
		return branch_level;
	}

	public void setBranch_level(String branch_level) {
		this.branch_level = branch_level;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

}
