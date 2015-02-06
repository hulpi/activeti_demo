package com.gbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 * 配制数据字典表
 * @author wb00002
 *
 */
@Entity
@Table(name = "GU_CONFIG_INFO")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GU_CONFIG_INFO {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenerator")
	@SequenceGenerator(name = "mySeqGenerator", sequenceName = "GU_CONFIG_INFO_SEQ")
	private Long GU_CONFIG_INFO_OID;
	@Column(length = 10)
	private String info_key;
	
	@Column(length = 10)
	private String info_code;
	@Column(length = 30)
	private String info_name;
	
	@Column(length = 50)
	private String description;

	public Long getGU_CONFIG_INFO_OID() {
		return GU_CONFIG_INFO_OID;
	}

	public void setGU_CONFIG_INFO_OID(Long gU_CONFIG_INFO_OID) {
		GU_CONFIG_INFO_OID = gU_CONFIG_INFO_OID;
	}

	public String getInfo_key() {
		return info_key;
	}

	public void setInfo_key(String info_key) {
		this.info_key = info_key;
	}

	public String getInfo_code() {
		return info_code;
	}

	public void setInfo_code(String info_code) {
		this.info_code = info_code;
	}

	public String getInfo_name() {
		return info_name;
	}

	public void setInfo_name(String info_name) {
		this.info_name = info_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	

}
