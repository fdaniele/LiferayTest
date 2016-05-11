package it.sixmemos.controller;

import it.sixmemos.model.Question;
import it.sixmemos.util.ReadFileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@Autowired
	public void context(ApplicationContext ctx) { 
		this.context = ctx; 
	}
	
    @RequestMapping("/")
    public String homepage(Model model,@RequestParam(value="shuffle", required=false, defaultValue="false") Boolean shuffle) throws IOException {
    	HashMap<Integer, Question> map = populateHashQuestions();
    	List<Question> listQuestion = new ArrayList<Question>(map.values());
    	if(shuffle){
    		Collections.shuffle(listQuestion);
	    }
	    model.addAttribute("qa",listQuestion);
    	return "index";
    }
    
    private HashMap<Integer, Question> populateHashQuestions() throws IOException{
    	ReadFileUtil readFileUtil = new ReadFileUtil(context); 
    	return readFileUtil.getMapQuestions();
    }
}
