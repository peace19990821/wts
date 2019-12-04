package com.wts.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wts.shop.dao.StoreMapper;
import com.wts.shop.domain.Goods;
import com.wts.shop.domain.Store;
import com.wts.shop.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	StoreMapper storeMapper;

	@Override
	public List<Store> getStoreList(Store store) {
		return storeMapper.getStoreList(store);
	}

	@Override
	public List<Goods> getGoods() {
		return storeMapper.getGoods();
	}

	@Override
	public void add(Store store) {
		// 添加商场
		storeMapper.addStore(store);
		// 添加中间表
		List<Goods> goodes = store.getGoodes();
		for (Goods goods : goodes) {
			if(goods.getGid() != null) {				
				storeMapper.addCenter(store.getSid(),goods.getGid());
			}
		}
	}

	@Override
	public void delMore(int[] sids) {
		// 删除商场
		storeMapper.delStore(sids);
		// 删除中间表
		storeMapper.delSc(sids);
	}

	@Override
	public Store findStoreBySid(int sid) {
		return storeMapper.findStoreBySid(sid);
	}

	@Override
	public Store getGoodsBySid(int sid) {
		return storeMapper.getGoodsBySid(sid);
	}
}
