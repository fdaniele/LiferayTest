package it.sixmemos.util;

import it.sixmemos.model.Question;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
/**
* Simple application generate test for liferay developer certification
*
* @author  Daniele Fiorio
* @version 1.0
* @since   2016-05-09
*/
public class ReadFileUtil {
	
	private ApplicationContext context;
	
	private HashMap<Integer, String> temp = new HashMap<Integer, String>();
	private HashMap<Integer, Question> map = new HashMap<Integer, Question>();

	public ReadFileUtil(ApplicationContext context){
		this.context = context;
	}
	
	public HashMap<Integer, Question> getMapQuestions() throws IOException{
		Resource resource = context.getResource("classpath:questions/liferay_qa.txt");		
		Integer id = 1;
		for (String line : Files.readAllLines(Paths.get(resource.getFile().getAbsolutePath()), Charset.defaultCharset())) {
			if(!line.isEmpty()){
				if(!line.contains("Answer: "+id+".")){
					if(temp.get(id)==null)
						temp.put(id, line);
					else{
						temp.put(id,temp.get(id).concat("\n"+line));
					}
				} else {
					String answer = line.replaceAll("Answer: "+id+".", "").trim().toLowerCase();
					List<String> answers = Arrays.asList(answer.split("\\,"));
					Question q = new Question();
					q.setId(id);
					String questRep = temp.get(id).replaceAll("\\<", "[[").replaceAll("\\>", "]]").replaceAll("\n", "<br/>");
					q.setQuestion(questRep);
					q.setAnswer(answers);

					map.put(id, q);
					id++;
					//System.out.println(id);
				}
			}
		}
		return map;
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}
	
	
	
}

