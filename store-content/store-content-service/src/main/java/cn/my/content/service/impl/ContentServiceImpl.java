package cn.my.content.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.my.content.service.ContentService;
import cn.my.mapper.TbContentMapper;
import cn.my.pojo.TbContent;
import cn.my.pojo.TbContentExample;
import cn.my.pojo.TbContentExample.Criteria;
import cn.my.store.common.util.StoreResult;
/**
 * 内容管理Service
 * @author salva
 *
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	TbContentMapper contentMapper;
	
	public StoreResult addContent(TbContent content) {
		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);
		return StoreResult.ok();
	}


	public List<TbContent> getContentLitsByCid(long cid) {
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		return contentMapper.selectByExampleWithBLOBs(example);
	}

}
