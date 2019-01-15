package cn.itheima.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itheima.springmvc.dao.ItemsMapper;
import cn.itheima.springmvc.pojo.Items;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<Items> selectItemsList() {
		
		return itemsMapper.selectByExampleWithBLOBs(null);
	}

	@Override
	public Items selectItemById(Integer id) {
		return itemsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateById(Items items) {
		itemsMapper.updateByPrimaryKeySelective(items);
	}
}
