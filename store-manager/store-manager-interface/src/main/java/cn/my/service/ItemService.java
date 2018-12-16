package cn.my.service;

import cn.my.pojo.TbItem;
import cn.my.store.common.pojo.EasyUIDataGridResult;
import cn.my.store.common.util.StoreResult;

public interface ItemService {
	TbItem getItemById(long itemId);
	EasyUIDataGridResult getItemList(int page,int rows);
	StoreResult addItem(TbItem item, String desc);
}

