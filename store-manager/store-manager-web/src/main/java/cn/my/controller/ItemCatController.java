package cn.my.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import cn.my.store.common.pojo.EasyUITreeNode;
/**
 * 商品分类
 * @author salva
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.my.service.ItemCatService;
@Controller
public class ItemCatController {
@Autowired
ItemCatService itemCatService;
@RequestMapping("/item/cat/list")
@ResponseBody
public List<EasyUITreeNode> getItemCatList(@RequestParam(name="id",defaultValue="0")Long parentId) {
	List<EasyUITreeNode> list = itemCatService.getItemCatList(parentId);
	return list;
}
}
