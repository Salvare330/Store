package cn.my.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.my.content.service.ContentCategoryService;
import cn.my.store.common.pojo.EasyUITreeNode;
import cn.my.store.common.util.StoreResult;

@Controller
public class ContentCatController {
@Autowired
private ContentCategoryService contentCategoryService;
@RequestMapping("/content/category/list")
@ResponseBody
public List<EasyUITreeNode> getContentCatList(@RequestParam(name="id",defaultValue="0")long parentId) {
	List<EasyUITreeNode> contentCatList = contentCategoryService.getContentCatList(parentId);
	return contentCatList;
}
/**
 * 添加分类节点
 */
@RequestMapping(value="/content/category/create",method=RequestMethod.POST )
@ResponseBody
public StoreResult createContentCategory(Long parentId,String name) {
	//调用添加Service
	StoreResult contentCategory = contentCategoryService.addContentCategory(parentId, name);
	return contentCategory;
}
}
