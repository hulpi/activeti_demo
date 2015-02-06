package com.gbs.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gbs.constant.ProductType;
import com.gbs.dto.CITY_INFO_DTO;
import com.gbs.dto.FUNDER_INFO_DTO;
import com.gbs.dto.PRODUCT_INFO_DTO;
import com.gbs.entity.GU_BRANCH_INFO;
import com.gbs.entity.GU_CITY_FUNDER_INFO;
import com.gbs.entity.GU_CITY_INFO;
import com.gbs.entity.GU_FUNDER_INFO;
import com.gbs.entity.GU_CONFIG_INFO;
import com.gbs.entity.GU_PRODUCT_INFO;
import com.gbs.service.CityFunderService;
import com.gbs.service.CityService;
import com.gbs.service.FunderService;
import com.gbs.service.ConfigService;

/**
 * 参数操作类
 * 
 * @author wb00002
 * 
 */
@Controller
public class CommonController {
	@Resource
	private CityFunderService cityFunderService;
	@Resource
	private FunderService funderService;
	@Resource
	private CityService cityService;
	@Resource
	private ConfigService configService;
	
	Logger log = Logger.getLogger(CommonController.class);
	@RequestMapping(value = "/initData", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String initData()throws Exception {
		Date now = new Date(); 
		//GU_CITY_INFO city = addCity(now);
		//GU_FUNDER_INFO funder = addFunder(now);
		
		GU_CITY_FUNDER_INFO cf = new GU_CITY_FUNDER_INFO();
		cf.setCity(cityService.queryCity().get(0));
		cf.setFunder(funderService.queryFunder().get(0));
		cityFunderService.addCityFunder(cf);
		return null;
	}
	private GU_CITY_INFO addCity(Date now) {
		//城市公司 分行
		GU_CITY_INFO city = new GU_CITY_INFO();
		city.setCity_code("SZ");
		city.setCity_name("深圳公司");
		city.setAddress("深圳市福田区滨河路与香蜜湖路交汇处天安创新科技广场(二期)20楼西2003");
		city.setTel("4001812000");
		city.setFax("0755-88292020");
		city.setCreate_date(now);
		city.setCreate_user("admin");
		
		Set<GU_BRANCH_INFO> branchSet = new HashSet<GU_BRANCH_INFO>(); 
		GU_BRANCH_INFO branch = new GU_BRANCH_INFO();
		branch.setBranch_code("SZ01");
		branch.setBranch_name("深圳总行");
		branch.setBranch_level("1");
		branch.setCreate_date(now);
		branch.setCreate_user("admin");
		branchSet.add(branch);
		city.setBranchSet(branchSet);
		cityService.addCity(city);
		return city;
	}
	private GU_FUNDER_INFO addFunder(Date now) {
		//合作方 贷款产品
		GU_FUNDER_INFO funder = new GU_FUNDER_INFO();
		funder.setFunder_code("01");
		funder.setFunder_desc("搜易贷");
		funder.setCreate_date(now);
		funder.setCreate_user("admin");
		
		GU_PRODUCT_INFO product = new GU_PRODUCT_INFO();
		product.setProduct_code("0101");
		product.setProduct_desc("企业贷");
		product.setProduct_type(ProductType.ENTERPRISE);
		product.setCreate_date(now);
		product.setCreate_user("admin");
		
		GU_PRODUCT_INFO product2 = new GU_PRODUCT_INFO();
		product2.setProduct_code("0102");
		product2.setProduct_desc("生意贷");
		product2.setProduct_type(ProductType.INDIVIDUAL);
		product2.setCreate_date(now);
		product2.setCreate_user("admin");
		
		Set<GU_PRODUCT_INFO> productSet = new HashSet<GU_PRODUCT_INFO>();
		productSet.add(product);
		productSet.add(product2);
		funder.setProductSet(productSet);
		
		funderService.addFunder(funder);
		return funder;
	}
	/**
	 * 贷款产品
	 * @param cityCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "param/getProduct", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String getProduct(String cityId,HttpServletRequest request) throws Exception {
		log.debug("==================查询贷款产品==================");
		List<PRODUCT_INFO_DTO> list = cityFunderService.getProductByCity(cityId);
		JSONObject json = new JSONObject(); 
		json.put("list", list);
		return json.toString();
	}
	/**
	 * 贷款产品
	 * @param cityCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "param/getAllProduct", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String getAllProduct(String cityId,HttpServletRequest request) throws Exception {
		log.debug("==================查询贷款产品==================");
		List<PRODUCT_INFO_DTO> list = cityFunderService.getAllProduct();
		JSONObject json = new JSONObject(); 
		json.put("list", list);
		return json.toString();
	}
	
	
	/**
	 * 贷款用途
	 * @param cityCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "param/getLoanPurpose", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String getLoanPurpose(String cityCode,HttpServletRequest request) throws Exception {
		log.debug("==================查询贷款用途==================");
		List<GU_CONFIG_INFO> list = configService.getLoanPurpose();
		
		JSONObject json = new JSONObject();
		json.put("list", list);
		return json.toString();
	}
	
	
	/**
	 * 产品类型
	 * @param cityCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "param/getProductType", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String getProductType(String cityCode,HttpServletRequest request) throws Exception {
		log.debug("==================查询产品类型==================");
		List<GU_CONFIG_INFO> list = configService.getProductType();
		JSONObject json = new JSONObject();
		json.put("list", list);
		return json.toString();
	}
	/**
	 * 城市公司
	 * @param cityCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "param/getCity", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String getCity(String cityCode,HttpServletRequest request) throws Exception {
		log.debug("==================查询城市公司==================");
		List<CITY_INFO_DTO> list = cityService.getCity();
		
		JSONObject json = new JSONObject();
		json.put("list", list);
		return json.toString();
	}
	
	/**
	 * 合作方
	 * @param cityCode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "param/getFunder", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String getFunder(String cityCode,HttpServletRequest request) throws Exception {
		log.debug("==================查询合作方==================");
		List<FUNDER_INFO_DTO> list = funderService.getFunder();
		JSONObject json = new JSONObject();
		json.put("list", list);
		return json.toString();
	}
}
