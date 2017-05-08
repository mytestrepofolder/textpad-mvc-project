package com.edia.mvc.textpad.service;

/**
 * @Author: Plabon Kakoti
 * @Date: 05/06/2017
 */

import java.util.List;

import com.edia.mvc.textpad.entity.TextPad;

public interface TextPadService {
    List<TextPad> getAllTexts();
    TextPad getTextById(int id);
    void addText(TextPad text);
    void updateText(TextPad text);
    int checkTextComplexity(TextPad text);
}
