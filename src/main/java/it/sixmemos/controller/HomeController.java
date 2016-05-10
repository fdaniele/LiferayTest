package it.sixmemos.controller;

import it.sixmemos.model.Question;
import it.sixmemos.util.ReadFileUtil;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * User: JoaoDuraes
 */

@Controller
public class HomeController {
	
	@Autowired
	private ApplicationContext context;

	private HashMap<Integer, Question> map = new HashMap<Integer, Question>();
	
	@Autowired
	public void context(ApplicationContext ctx) { 
		this.context = ctx; 
	}
	
    @RequestMapping("/")
    public String helloWorld(Model model) throws IOException {
    	if(map.isEmpty()){
	    	ReadFileUtil readFileUtil = new ReadFileUtil(context); 
	    	map = readFileUtil.getMapQuestions();
	    }
	    model.addAttribute("qa",map);
    	return "index";
    }
}
