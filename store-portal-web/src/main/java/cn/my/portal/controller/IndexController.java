package cn.my.portal.controller;
/**
 * 跳转到首页
 * @author salva
 *
 */


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.my.content.service.ContentService;
import cn.my.pojo.TbContent;
@Controller
public class IndexController {
	@Value("${CONTENT_LUNBO_ID}")
	private long CONTENT_LUNBO_ID;
	@Autowired
	ContentService contentService;
@RequestMapping("/index")
public String showIndex(Model model) {
	//查询内容列表
	List<TbContent> contentList = contentService.getContentLitsByCid(CONTENT_LUNBO_ID);
	model.addAttribute("ad1List", contentList);
	
	return "index";
}
}
