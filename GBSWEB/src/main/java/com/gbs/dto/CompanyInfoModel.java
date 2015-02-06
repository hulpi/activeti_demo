package com.gbs.dto;

import java.util.List;

public class CompanyInfoModel {
   public List<INDIVIDUAL_COMPANY_DTO> companyInfo;

 public List<INDIVIDUAL_COMPANY_DTO> getCompanyInfo() {
	return companyInfo;
}

public void setCompanyInfo(List<INDIVIDUAL_COMPANY_DTO> companyInfo) {
	this.companyInfo = companyInfo;
}
}
