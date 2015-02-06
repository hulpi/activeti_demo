package com.gbs.entity;

import java.math.BigDecimal;
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
import javax.validation.constraints.Digits;

/**
 * 担保申请表
 * @author wb00002
 *
 */
@Entity
@Table(name = "GU_APPLY_INFO")
public class GU_APPLY_INFO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGenerator")
	@SequenceGenerator(name = "mySeqGenerator", sequenceName = "GU_APPLY_INFO_SEQ")
	private Long gu_apply_info_oid;
	
	@Column(length=30,nullable=false)
	private String guarant_id;// 担保编号
	
	@ManyToOne
	@JoinColumn(name="individual")
	private GU_INDIVIDUAL_INFO individual;//关联人
	
	@ManyToOne
	@JoinColumn(name="enterprise")
	private GU_ENTERPRISE_INFO enterprise;//关联企业 

	@Digits(integer=3,fraction=2)
	private BigDecimal guarant_amt;// 担保金额
	
	@Digits(integer=3,fraction=2)
	private BigDecimal approve_amt;// 审批金额
	
	@ManyToOne(targetEntity=GU_FUNDER_INFO.class,fetch=FetchType.LAZY)
	@JoinColumn(name="funder")
	private GU_FUNDER_INFO funder;//合作方

	@ManyToOne(targetEntity=GU_CITY_INFO.class,fetch=FetchType.LAZY)
	@JoinColumn(name="city")
	private GU_CITY_INFO city;//城市公司

	@ManyToOne(targetEntity=GU_BRANCH_INFO.class,fetch=FetchType.LAZY)
	@JoinColumn(name="branch")
	private GU_BRANCH_INFO branch;//分行

	@ManyToOne(targetEntity=GU_PRODUCT_INFO.class,fetch=FetchType.LAZY)
	@JoinColumn(name="product")
	private GU_PRODUCT_INFO product;//贷款产品

	@Column(length = 10)
	private String guarant_type;// 担保类型

	@Column(length = 5)
	private Long guarant_time_limit;// 担保期限

	@Column(length = 30)
	private String loan_purpose;// 贷款用途

	@Column(length = 30)
	private String repayment_plan_sources;// 还款计划及来源

	@Column(length = 2)
	private String apply_status;// 申请状态
	
	@Column(length = 10)
	private String applicant;// 申请人

	@Temporal(TemporalType.DATE)
	private Date apply_date;// 申请日期
	

	@Column(length = 64)
	private String process_instance_id;//工作流ID
	
	@Column(length = 30)
	private String ecm_barcode;//影像CODE
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_date;
	@Column(length=10)
	private String create_user;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_date;
	@Column(length=10)
	private String update_user;
	
	

	public Long getGu_apply_info_oid() {
		return gu_apply_info_oid;
	}

	public void setGu_apply_info_oid(Long gu_apply_info_oid) {
		this.gu_apply_info_oid = gu_apply_info_oid;
	}

	public String getGuarant_id() {
		return guarant_id;
	}

	public void setGuarant_id(String guarant_id) {
		this.guarant_id = guarant_id;
	}

	public BigDecimal getGuarant_amt() {
		return guarant_amt;
	}

	public void setGuarant_amt(BigDecimal guarant_amt) {
		this.guarant_amt = guarant_amt;
	}

	public BigDecimal getApprove_amt() {
		return approve_amt;
	}

	public void setApprove_amt(BigDecimal approve_amt) {
		this.approve_amt = approve_amt;
	}

	public GU_FUNDER_INFO getFunder() {
		return funder;
	}

	public void setFunder(GU_FUNDER_INFO funder) {
		this.funder = funder;
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

	public GU_PRODUCT_INFO getProduct() {
		return product;
	}

	public void setProduct(GU_PRODUCT_INFO product) {
		this.product = product;
	}

	public String getGuarant_type() {
		return guarant_type;
	}

	public void setGuarant_type(String guarant_type) {
		this.guarant_type = guarant_type;
	}

	public Long getGuarant_time_limit() {
		return guarant_time_limit;
	}

	public void setGuarant_time_limit(Long guarant_time_limit) {
		this.guarant_time_limit = guarant_time_limit;
	}

	public String getLoan_purpose() {
		return loan_purpose;
	}

	public void setLoan_purpose(String loan_purpose) {
		this.loan_purpose = loan_purpose;
	}

	public String getRepayment_plan_sources() {
		return repayment_plan_sources;
	}

	public void setRepayment_plan_sources(String repayment_plan_sources) {
		this.repayment_plan_sources = repayment_plan_sources;
	}

	public String getApply_status() {
		return apply_status;
	}

	public void setApply_status(String apply_status) {
		this.apply_status = apply_status;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public Date getApply_date() {
		return apply_date;
	}

	public void setApply_date(Date apply_date) {
		this.apply_date = apply_date;
	}

	public String getProcess_instance_id() {
		return process_instance_id;
	}

	public void setProcess_instance_id(String process_instance_id) {
		this.process_instance_id = process_instance_id;
	}

	public GU_INDIVIDUAL_INFO getIndividual() {
		return individual;
	}

	public void setIndividual(GU_INDIVIDUAL_INFO individual) {
		this.individual = individual;
	}

	public GU_ENTERPRISE_INFO getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(GU_ENTERPRISE_INFO enterprise) {
		this.enterprise = enterprise;
	}

	public String getEcm_barcode() {
		return ecm_barcode;
	}

	public void setEcm_barcode(String ecm_barcode) {
		this.ecm_barcode = ecm_barcode;
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

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getUpdate_user() {
		return update_user;
	}

	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

	

}
