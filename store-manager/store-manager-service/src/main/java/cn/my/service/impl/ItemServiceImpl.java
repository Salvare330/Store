package cn.my.service.impl;
/**
 * 
 * @author salva
 *
 */

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.my.mapper.TbItemDescMapper;
import cn.my.mapper.TbItemMapper;
import cn.my.pojo.TbItem;
import cn.my.pojo.TbItemDesc;
import cn.my.pojo.TbItemExample;
import cn.my.pojo.TbItemExample.Criteria;
import cn.my.service.ItemService;
import cn.my.store.common.pojo.EasyUIDataGridResult;
import cn.my.store.common.util.IDUtils;
import cn.my.store.common.util.StoreResult;
@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private TbItemMapper tbItemMapper;
	@Autowired
	private TbItemDescMapper tbItemDescMapper;

	@Override
	public TbItem getItemById(long itemId) {
		//主键查询
		//TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
		//条件查询
		TbItemExample tbItemExample = new TbItemExample();
		Criteria criteria = tbItemExample.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> tbItemList = tbItemMapper.selectByExample(tbItemExample);
		if(tbItemList!=null&&tbItemList.size()!=0) {
			return tbItemList.get(0);
		}
		return null;
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//执行
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
		//取结果
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		PageInfo<TbItem> pageinfo = new PageInfo<>(list);
		result.setTotal(pageinfo.getTotal());
		result.setRows(list);
		return result;
	}

	@Override
	public StoreResult addItem(TbItem item, String desc) {
		//补全属性
		long itemId= IDUtils.genItemId();
		item.setId(itemId);
		item.setStatus((byte)1);//1-正常，2-下架，3-删除
		item.setCreated(new Date());
		item.setUpdated(new Date());
		tbItemMapper.insert(item);
		TbItemDesc tbItemDesc = new TbItemDesc();
		tbItemDesc.setItemId(itemId);
		tbItemDesc.setItemDesc(desc);
		tbItemDesc.setUpdated(new Date());
		tbItemDesc.setCreated(new Date());
		tbItemDescMapper.insert(tbItemDesc);
		return StoreResult.ok();
	}
	
}
