package com.wts.shop.service;

import java.util.List;

import com.wts.shop.domain.Goods;
import com.wts.shop.domain.Store;

public interface StoreService {

	List<Store> getStoreList(Store store);

	List<Goods> getGoods();

	void add(Store store);

	void delMore(int[] sids);

	Store findStoreBySid(int sid);

	Store getGoodsBySid(int sid);
}
