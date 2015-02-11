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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 合作方
 * 
 * @author wb00002
 * 
 */
@Entity
@Table(name = "GU_FUNDER_INFO")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GU_FUNDER_INFO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenerator")
	@SequenceGenerator(name = "mySeqGenerator", sequenceName = "GU_FUNDER_INFO_SEQ")
	private Long gu_funder_info_oid;
	
	@Column(length = 10)
	private String funder_code;
	
	@Column(length = 100)
	private String funder_desc;

	@Temporal(TemporalType.TIME)
	private Date create_date;

	@Column(length = 10)
	private String create_user;

	@OneToMany(targetEntity = GU_PRODUCT_INFO.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "funder")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<GU_PRODUCT_INFO> productSet;

	public Long getGu_funder_info_oid() {
		return gu_funder_info_oid;
	}

	public void setGu_funder_info_oid(Long gu_funder_info_oid) {
		this.gu_funder_info_oid = gu_funder_info_oid;
	}

	public String getFunder_code() {
		return funder_code;
	}

	public void setFunder_code(String funder_code) {
		this.funder_code = funder_code;
	}

	public String getFunder_desc() {
		return funder_desc;
	}

	public void setFunder_desc(String funder_desc) {
		this.funder_desc = funder_desc;
	}

	public Set<GU_PRODUCT_INFO> getProductSet() {
		return productSet;
	}

	public void setProductSet(Set<GU_PRODUCT_INFO> productSet) {
		this.productSet = productSet;
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
