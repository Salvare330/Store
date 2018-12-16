package cn.my.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.my.pojo.TbItem;
import cn.my.service.ItemService;
import cn.my.store.common.pojo.EasyUIDataGridResult;
import cn.my.store.common.util.StoreResult;

@Controller
public class ItemController {
@Autowired
private ItemService itemService;
@RequestMapping("/item/{itemId}")
@ResponseBody
public TbItem getItemById(@PathVariable Long itemId) {
	return itemService.getItemById(itemId);
}
@RequestMapping("/item/list")
@ResponseBody
public EasyUIDataGridResult getItemList(Integer page,Integer rows) {
	return itemService.getItemList(page, rows);
	
}

@RequestMapping(value="/item/save" ,method=RequestMethod.POST)
@ResponseBody
public StoreResult addItem(TbItem item,String desc) {
	StoreResult result = itemService.addItem(item, desc);
	return result;
}

@RequestMapping(value="/rest/item/query/item/desc/{itemId}")
@ResponseBody
public StoreResult toEdit(@PathVariable Long itemId) {
	System.out.println(itemId);
	return StoreResult.ok();
	
}
}
