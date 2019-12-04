package com.wts.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wts.shop.domain.Goods;
import com.wts.shop.domain.Store;
import com.wts.shop.service.StoreService;

@Controller
public class StoreController {

	@Autowired
	StoreService storeService;
	
	/**
	 * @Title: selList 
	 * @Description: 列表
	 * @param modle
	 * @param pageNum
	 * @return
	 * @return: String
	 */
	@RequestMapping("selList")
	public String selList(Model modle,@RequestParam(defaultValue="1")int pageNum,Store store) {
		PageHelper.startPage(pageNum,3);
		List<Store> list = storeService.getStoreList(store);
		PageInfo<Store> info = new  PageInfo<>(list);
		modle.addAttribute("pg",info);
		modle.addAttribute("store",store);
		return "Select";
	}
	
	// 去添加
	@RequestMapping("toAdd")
	public String toAdd(Model modle) {
		List<Goods> goods = storeService.getGoods();
		modle.addAttribute("goods",goods);
		modle.addAttribute("store",new Store());
		return "Add";
	}
	
	// 添加
	@RequestMapping("add")
	public String add(Model model,Store store) {
		storeService.add(store);
		return "redirect:selList";
	}
	
	// 批删
	@RequestMapping("delMore")
	public String delMore(int[] sids) {
		storeService.delMore(sids);
		return "redirect:selList";
	}
	
	// 详情
	@RequestMapping("getGoodsBySid")
	public String findStoreBySid(int sid,Model model) {
		Store store =  storeService.getGoodsBySid(sid);
		model.addAttribute("store",store);
		return "update";
	}
}
