package com.dfyx.crm.service;

import java.util.List;

import com.dfyx.crm.entity.Commodity;
import com.dfyx.crm.mapper.CommodityMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommodityService {

	@Autowired
	private CommodityMapper commodityMapper;
	//int id = 0;
	
	public List<Commodity> listCommodity(){
		return this.commodityMapper.listCommodity();
	}
	
	public Commodity getCommodityById(int id){
		return this.commodityMapper.getCommodityById(id);
	}
	
	public int addCommodity(Commodity commodity) {
		//commodity.setId(id);
		//id++;
		commodity.setDiscount(10);
		return this.commodityMapper.addCommodity(commodity);
	}
	
	public int updateCommodity(Commodity commodity) {
		return this.commodityMapper.updateCommodity(commodity);
	}
	
	public int deleteCommodity(String id) {
		return this.commodityMapper.deleteCommodity(id);
	}
	
	
	/*public List<Commodity> listCommoditys(String name, int page, int limit){
		return this.commodityMapper.listCommoditys(name,page,limit);
	}*/
	public Page<Commodity> listCommoditys(String name, int page, int limit){
		Page<Commodity> list = PageHelper.startPage(page, limit);
		commodityMapper.listCommoditys(name);
		return list;
	}

	public int commodityCount(){ return this.commodityMapper.commodityCount(); }
}
