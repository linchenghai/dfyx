package com.dfyx.crm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dfyx.crm.entity.Commodity;
import com.dfyx.crm.entity.ResponseObj;
import com.dfyx.crm.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value="commodity")
public class CommodityController {

	@Autowired
	CommodityService commodityService;
	
	/*@ResponseBody
	@RequestMapping(value = "listCommodity", method = RequestMethod.GET)
	public String listCommodity(HttpServletRequest request, HttpServletResponse response) {
		return JSON.toJSONString(this.commodityService.listCommodity());
	}*/
	
	/*@ResponseBody
	@RequestMapping(value = "getCommodityById", method = RequestMethod.GET)
	public String getCommodityById(HttpServletRequest request, HttpServletResponse response,int id) {
		return "["+JSON.toJSONString(this.commodityService.getCommodityById(id))+"]";
	}*/
	
	@ResponseBody
	@RequestMapping(value = "addCommodity", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public String addCommodity(@RequestBody(required = false) Commodity commodity, HttpServletRequest request, HttpServletResponse response) {
		ResponseObj<String> responseObj = new ResponseObj<>();
		String str = "";
		try {
			int count = this.commodityService.addCommodity(commodity);
			if(count == 0){
				responseObj.error("新增数据失败！");
				str = JSON.toJSONString(responseObj);
				return str;
			}
		}catch (Exception e){
			responseObj.error("服务器错误，更新增数据失败！");
			str = JSON.toJSONString(responseObj);
			return str;
		}
		str = JSON.toJSONString(responseObj);
		return str;
	}
	
	@ResponseBody
	@RequestMapping(value = "updateCommodity", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public String updateCommodity(@RequestBody(required = false) Commodity commodity,HttpServletRequest request, HttpServletResponse response) {
		ResponseObj<String> responseObj = new ResponseObj<>();
		String str = "";
		try {
			int count = this.commodityService.updateCommodity(commodity);
			if(count == 0){
				responseObj.error("更新数据失败！");
				str = JSON.toJSONString(responseObj);
				return str;
			}
		}catch (Exception e){
			responseObj.error("服务器错误，更新数据失败！");
			str = JSON.toJSONString(responseObj);
			return str;
		}
		str = JSON.toJSONString(responseObj);
		return str;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "deleteCommodity", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public String deleteCommodity(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
		ResponseObj<String> responseObj = new ResponseObj<>();
		String str = "";
		try {
			int count = this.commodityService.deleteCommodity(params.get("id").toString());
			if(count == 0){
				responseObj.error("删除数据失败！");
				str = JSON.toJSONString(responseObj);
				return str;
			}
		}catch (Exception e){
			responseObj.error("服务器错误，删除数据失败！");
			str = JSON.toJSONString(responseObj);
			return str;
		}
		str = JSON.toJSONString(responseObj);
		return str;
	}

	@ResponseBody
	@RequestMapping(value = "allCommodity", method = RequestMethod.GET)
	public String allCommodity(HttpServletRequest request, HttpServletResponse response) {
		ResponseObj<List<Commodity>> responseObj = new ResponseObj<>();
		responseObj.setData(this.commodityService.listCommodity());
		responseObj.setCount(20);
		String str = "";
		str = JSON.toJSONString(responseObj);
		return str;
	}

	@ResponseBody
	@RequestMapping(value = "listCommodity", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public String listCommodity(HttpServletRequest request, HttpServletResponse response, String name, int page, int limit) {
		ResponseObj<List<Commodity>> responseObj = new ResponseObj<>();
		responseObj.setData(this.commodityService.listCommoditys(name, page, limit).getResult());
		responseObj.setCount(this.commodityService.commodityCount());
		String str = "";
		str = JSON.toJSONString(responseObj);
		return str;
	}

	@RequestMapping(value="index", method= RequestMethod.GET)
	public String index () {
		return "indexstatic";
	}

	@RequestMapping(value="console", method= RequestMethod.GET)
	public String console () {
		return "pages/console";
	}

	@RequestMapping(value="test", method= RequestMethod.GET)
	public String test () {
		return "pages/test/test";
	}

	@RequestMapping(value="add", method= RequestMethod.GET)
	public String add () {
		return "pages/test/test-update";
	}
}
