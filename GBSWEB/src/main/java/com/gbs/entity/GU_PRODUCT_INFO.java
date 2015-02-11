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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 产品
 * 
 * @author wb00002
 * 
 */
@Entity
@Table(name = "GU_PRODUCT_INFO")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GU_PRODUCT_INFO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenerator")
	@SequenceGenerator(name = "mySeqGenerator", sequenceName = "GU_PRODUCT_INFO_SEQ")
	private Long gu_product_info_oid;

	@ManyToOne(targetEntity = GU_FUNDER_INFO.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "funder")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private GU_FUNDER_INFO funder;
	@Column(length = 10)
	private String product_code;
	@Column(length = 100)
	private String product_desc;
	@Column(length = 10)
	private String product_type;

	private Date create_date;

	@Column(length = 10)
	private String create_user;

	public Long getGu_product_info_oid() {
		return gu_product_info_oid;
	}

	public void setGu_product_info_oid(Long gu_product_info_oid) {
		this.gu_product_info_oid = gu_product_info_oid;
	}

	public GU_FUNDER_INFO getFunder() {
		return funder;
	}

	public void setFunder(GU_FUNDER_INFO funder) {
		this.funder = funder;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
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
