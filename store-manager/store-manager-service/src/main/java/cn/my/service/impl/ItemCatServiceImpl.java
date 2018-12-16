package cn.my.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.my.mapper.TbItemCatMapper;
import cn.my.pojo.TbItemCat;
import cn.my.pojo.TbItemCatExample;
import cn.my.pojo.TbItemCatExample.Criteria;
import cn.my.service.ItemCatService;
import cn.my.store.common.pojo.EasyUITreeNode;
	@Service
public class ItemCatServiceImpl implements ItemCatService {
		@Autowired
		TbItemCatMapper itemCatMapper;
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		List<EasyUITreeNode> resultList = new ArrayList<>();
		for(TbItemCat tbItemCat:list) {
			EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
			easyUITreeNode.setId(tbItemCat.getId());
			easyUITreeNode.setText(tbItemCat.getName());
			easyUITreeNode.setState(tbItemCat.getIsParent()?"closed":"open");
			resultList.add(easyUITreeNode);
		}
		return resultList;
	}

}
