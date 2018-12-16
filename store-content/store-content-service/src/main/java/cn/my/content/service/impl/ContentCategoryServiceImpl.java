package cn.my.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.my.content.service.ContentCategoryService;
import cn.my.mapper.TbContentCategoryMapper;
import cn.my.pojo.TbContentCategory;
import cn.my.pojo.TbContentCategoryExample; 
import cn.my.pojo.TbContentCategoryExample.Criteria;
import cn.my.store.common.pojo.EasyUITreeNode;
import cn.my.store.common.util.StoreResult;
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	
	public List<EasyUITreeNode> getContentCatList(long parentId) {
		TbContentCategoryExample contentCategoryExample = new TbContentCategoryExample();
		Criteria criteria = contentCategoryExample.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> catlist = contentCategoryMapper.selectByExample(contentCategoryExample);
		//转换EasyUITreeNode的List
		List<EasyUITreeNode> list = new ArrayList<>();
		for(TbContentCategory contentCategory:catlist) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(contentCategory.getId());
			node.setState(contentCategory.getIsParent()?"closed":"open");
			node.setText(contentCategory.getName());
			list.add(node);
			
			
		}
		return list;
	}
	
	public StoreResult addContentCategory(long parentId, String name) {
		//创建实体类
		TbContentCategory contentCategory= new TbContentCategory();
		//设置属性
		contentCategory.setParentId(parentId);
		contentCategory.setName(name);
		//1正常，2删除
		contentCategory.setStatus(1);
		//新增节点必为叶子节点
		contentCategory.setIsParent(false);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		//插入数据库
		int id = contentCategoryMapper.insert(contentCategory);
		//判断父节点的isparent，使其为父节点
		//查询新节点的父节点
		TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
		if(!parent.getIsParent()) {
			parent.setIsParent(true);
		}
		contentCategoryMapper.updateByPrimaryKey(parent);
		//返回结果
		return StoreResult.ok(contentCategory);
	}

}
