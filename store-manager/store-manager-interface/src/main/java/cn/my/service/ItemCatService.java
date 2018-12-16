package cn.my.service;
import java.util.List;

import cn.my.store.common.pojo.EasyUITreeNode;
public interface ItemCatService {
List<EasyUITreeNode> getItemCatList(long parentId);
}
