package com.gbs.entity;

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
 * 分行与贷款产品的关联表
 * 
 * @author wb00002
 * 
 */
@Entity
@Table(name = "GU_CITY_FUNDER_INFO")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GU_CITY_FUNDER_INFO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenerator")
	@SequenceGenerator(name = "mySeqGenerator", sequenceName = "GU_CITY_FUNDER_INFO_SEQ")
	private Long gu_city_funder_info_oid;
	
	@ManyToOne(targetEntity = GU_CITY_INFO.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "city")
	private GU_CITY_INFO city;
	
	@ManyToOne(targetEntity = GU_FUNDER_INFO.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "funder")
	private GU_FUNDER_INFO funder;


	public Long getGu_city_funder_info_oid() {
		return gu_city_funder_info_oid;
	}

	public void setGu_city_funder_info_oid(Long gu_city_funder_info_oid) {
		this.gu_city_funder_info_oid = gu_city_funder_info_oid;
	}

	public GU_CITY_INFO getCity() {
		return city;
	}

	public void setCity(GU_CITY_INFO city) {
		this.city = city;
	}

	public GU_FUNDER_INFO getFunder() {
		return funder;
	}

	public void setFunder(GU_FUNDER_INFO funder) {
		this.funder = funder;
	}
	
}
