package com.edia.mvc.textpad.dao;

/**
 * @Author: Plabon Kakoti
 * @Date: 05/06/2017
 */

import java.util.List;

import com.edia.mvc.textpad.entity.TextPad;

public interface TextPadDAO {
    List<TextPad> getAllTexts();
    TextPad getTextById(int id);
    void addText(TextPad text);
    void updateText(TextPad text);
    boolean textExists(String textTitle);
}
