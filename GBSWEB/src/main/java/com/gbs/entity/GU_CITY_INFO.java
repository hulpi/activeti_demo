package com.gbs.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 城市
 * @author wb00002
 *
 */


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Entity
@Table(name = "GU_CITY_INFO")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GU_CITY_INFO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenerator")
	@SequenceGenerator(name = "mySeqGenerator", sequenceName = "GU_CITY_INFO_SEQ")
	private Long gu_city_info_oid;
	@Column(length=10)
	private String city_code;
	@Column(length=50) 
	private String city_name;
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
	
	@OneToMany(targetEntity=GU_BRANCH_INFO.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="city",nullable=true)
	private Set<GU_BRANCH_INFO> branchSet;

	

	public Long getGu_city_info_oid() {
		return gu_city_info_oid;
	}

	public void setGu_city_info_oid(Long gu_city_info_oid) {
		this.gu_city_info_oid = gu_city_info_oid;
	}

	public String getCity_code() {
		return city_code;
	}

	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
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

	public Set<GU_BRANCH_INFO> getBranchSet() {
		return branchSet;
	}

	public void setBranchSet(Set<GU_BRANCH_INFO> branchSet) {
		this.branchSet = branchSet;
	}

	
}
