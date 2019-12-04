package com.wts.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wts.shop.domain.Goods;
import com.wts.shop.domain.Store;

public interface StoreMapper {

	List<Store> getStoreList(Store store);

	List<Goods> getGoods();

	void addStore(Store store);

	void addCenter(@Param("sid")Integer sid,@Param("gid")Integer gid);

	void delStore(@Param("sids")int[] sids);

	void delSc(@Param("sids")int[] sids);

	Store findStoreBySid(@Param("sid")int sid);

	Store getGoodsBySid(@Param("sid")int sid);
}
