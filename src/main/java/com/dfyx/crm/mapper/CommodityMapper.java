package com.dfyx.crm.mapper;

import java.util.List;

import com.dfyx.crm.entity.Commodity;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommodityMapper {
	List<Commodity> listCommodity();
	Commodity getCommodityById(int id);
	int addCommodity(Commodity commodity);
	int updateCommodity(Commodity commodity);
	int deleteCommodity(@Param(value = "id")String id);

	//List<Commodity> listCommoditys(@Param(value = "name") String name, @Param(value = "page") int page, @Param(value = "limit") int limit);
	Page<Commodity> listCommoditys(@Param(value = "name") String name);

	int commodityCount();
}
