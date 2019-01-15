package cn.itheima.springmvc.service;

import java.util.List;

import cn.itheima.springmvc.pojo.Items;

public interface ItemService {

	List<Items> selectItemsList();

	Items selectItemById(Integer id);

	void updateById(Items items);

}
