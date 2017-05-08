package com.edia.mvc.textpad.entity;

/**
 * @Author: Plabon Kakoti
 * @Date: 05/06/2017
 */

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import java.time.LocalDate;

public class TextPad implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	@NotNull
	@Size(min=2, max=50)
	private String textTilte;
	@NotNull
	@Size(min=2, max=500)
	private String textDesc;
	private DateTime creationDate;
	private int textComplexity;
	

	public int getTextComplexity() {
		return textComplexity;
	}
	public void setTextComplexity(int textComplexity) {
		this.textComplexity = textComplexity;
	}
	public DateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(DateTime creationDate) {
		this.creationDate = creationDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTextTilte() {
		return textTilte;
	}
	public void setTextTilte(String textTilte) {
		this.textTilte = textTilte;
	}
	public String getTextDesc() {
		return textDesc;
	}
	public void setTextDesc(String textDesc) {
		this.textDesc = textDesc;
	}
	@Override
	public String toString() {
		return "TextPad [id=" + id + ", textTilte=" + textTilte + ", textDesc=" + textDesc + ", creationDate="
				+ creationDate + "]";
	}
	
}
