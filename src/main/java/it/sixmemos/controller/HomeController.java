package it.sixmemos.controller;

import it.sixmemos.model.Question;
import it.sixmemos.util.ReadFileUtil;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* Simple application generate test for liferay developer certification
*
* @author  Daniele Fiorio
* @version 1.0
* @since   2016-05-09
*/
@Controller
@EnableAutoConfiguration
public class HomeController {
	
	@Autowired
	private ApplicationContext context;

	private HashMap<Integer, Question> map = new HashMap<Integer, Question>();
	
	@Autowired
	public void context(ApplicationContext ctx) { 
		this.context = ctx; 
	}
	
    @RequestMapping("/")
    public String homepage(Model model) throws IOException {
    	if(map.isEmpty()){
	    	ReadFileUtil readFileUtil = new ReadFileUtil(context); 
	    	map = readFileUtil.getMapQuestions();
	    }
	    model.addAttribute("qa",map);
    	return "index";
    }
}
