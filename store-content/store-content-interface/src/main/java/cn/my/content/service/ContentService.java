package cn.my.content.service;

import java.util.List;

import cn.my.pojo.TbContent;
import cn.my.store.common.util.StoreResult;

public interface ContentService {
StoreResult addContent(TbContent content) ;
List<TbContent> getContentLitsByCid(long cid);
}
