package cn.my.controller;
/**
 * 
 * @author salva
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.my.content.service.ContentService;
import cn.my.pojo.TbContent;
import cn.my.store.common.util.StoreResult;

@Controller
public class ContentController {
@Autowired
private	ContentService contentService;
@RequestMapping(value="/content/save",method=RequestMethod.POST)
@ResponseBody
public StoreResult addContent(TbContent content) {
	return contentService.addContent(content);
}
}
