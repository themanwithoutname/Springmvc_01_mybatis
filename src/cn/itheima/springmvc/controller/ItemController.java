package cn.itheima.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.itheima.springmvc.pojo.Items;
import cn.itheima.springmvc.pojo.QueryVo;
import cn.itheima.springmvc.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	// 入门查询 第一
	// @RequestMapping：里面放的是请求的url，和用户请求的url进行匹配
	// action可以写也可以不写
	@RequestMapping(value = "/item/itemlist")
	public ModelAndView itemList() {
		// 创建页面需要显示的商品数据
		List<Items> list = itemService.selectItemsList();
		
		// 创建ModelAndView，用来存放数据和视图
		ModelAndView modelAndView = new ModelAndView();
		// 设置数据到模型中
		modelAndView.addObject("itemList", list);
		// 设置视图jsp，需要设置视图的物理地址
		modelAndView.setViewName("itemList");

		return modelAndView;
	}
	
	/**
	 * 去修改页面
	 */
	@RequestMapping(value="/item/toEdit")
	public ModelAndView go2ModifyPage(@RequestParam(value="id", required=false)Integer id, HttpServletRequest req, HttpServletResponse resp,
			HttpSession session, Model model){
		ModelAndView mv = new ModelAndView("editItem");
		
//		Integer id = Integer.valueOf(req.getParameter("id"));
		Items items = itemService.selectItemById(id);
		mv.addObject("item", items);
		
		return mv;
	}
	
	
	@RequestMapping(value="/item/updateitem")
//	public String updateItem(Items items){
	public String updateItem(QueryVo vo){
		itemService.updateById(vo.getItems());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("itemList");
		
		return "redirect:/item/itemlist";
	}
}
