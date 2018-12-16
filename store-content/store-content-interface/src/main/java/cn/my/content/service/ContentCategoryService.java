package cn.my.content.service;
import java.util.List;

import cn.my.store.common.pojo.EasyUITreeNode;
import cn.my.store.common.util.StoreResult;
public interface ContentCategoryService {
	List<EasyUITreeNode> getContentCatList(long parentId);
	StoreResult addContentCategory(long parentId,String name);
}
