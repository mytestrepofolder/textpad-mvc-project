package com.edia.mvc.textpad.service;

/**
 * @Author: Plabon Kakoti
 * @Date: 05/06/2017
 */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edia.mvc.textpad.dao.TextPadDAO;
import com.edia.mvc.textpad.entity.TextPad;
import com.edia.mvc.textpad.readability.StringAnalyzer;
import com.edia.mvc.textpad.readability.StringAnalyzer.Stats;
import com.edia.mvc.textpad.readability.TextReadability;

@Service
public class TextPadServiceImpl implements TextPadService {
	
	@Autowired
	TextPadDAO dao;
	
	@Override
	public List<TextPad> getAllTexts() {
		
		return dao.getAllTexts();
	}

	@Override
	public TextPad getTextById(int id) {
		
		return dao.getTextById(id);
	}

	@Override
	public void addText(TextPad text) {
			
		checkTextComplexity(text);
		dao.addText(text);
	}


	@Override
	public void updateText(TextPad text) {
		
		 dao.updateText(text);
	}

	public int checkTextComplexity(TextPad text) {
		
		Stats stats = StringAnalyzer.analyze(text.getTextDesc());
		float fogComplexity = TextReadability.calcFog(stats);
		
		if(fogComplexity <= 9){
			return 1;
		} else if (fogComplexity <= 10 ){
			return 2;		
		} else if (fogComplexity <= 11 ){
			return 3;	
		} else if (fogComplexity <= 12 ){
			return 4;		
		} else if (fogComplexity <= 13){
			return 5;		
		} else if (fogComplexity <= 14) {
			return 6;
		} else if (fogComplexity <= 15) {
			return 7;
		} else if (fogComplexity <= 16 ) {
			return 8;
		} else if (fogComplexity <= 17 ) {
			return 9;
		} else  {
			return 10;
		}
		
	}

}
