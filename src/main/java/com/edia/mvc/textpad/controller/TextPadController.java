package com.edia.mvc.textpad.controller;
/**
 * @Author: Plabon Kakoti
 * @Date: 05/06/2017
 */

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import com.edia.mvc.textpad.entity.TextPad;
import com.edia.mvc.textpad.service.TextPadService;

@Controller
public class TextPadController {

	@Autowired
	private TextPadService textPadService;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private LocaleResolver localeResolver;

	@RequestMapping(value = "textpadlist")
	public ModelAndView textpad() {
		ModelAndView mv = new ModelAndView("textpadlist", "textpad", new TextPad());
		setPageData(mv.getModelMap());
		return mv;
	}

	@RequestMapping(value = "addtext", method = RequestMethod.POST)
	public String addText(@ModelAttribute("textpad") @Valid TextPad textPad, BindingResult result, ModelMap model,
			HttpServletRequest request) {
		if (!result.hasErrors()) {
			int complexity = textPadService.checkTextComplexity(textPad);
			textPadService.addText(textPad);
			model.addAttribute("msg", getMsg("text.created", request));
			model.addAttribute("complexity", complexity);
			setPageData(model);
			return "textpadlist";
		}
		setPageData(model);
		return "textAddForm";
	}

	@RequestMapping(value = "textById")
	public String getPersonById(ModelMap model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		TextPad textpad = textPadService.getTextById(id);
		setPageData(model);
		model.addAttribute("textpad", textpad);
		return "textUpdate";
	}

	@RequestMapping(value = "deleteTextById")
	public String deleteText(ModelMap model, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		textPadService.deleteText(id);
		model.addAttribute("msg", getMsg("text.deleted", request));
		setPageData(model);
		return "textpadlist";
	}

	@RequestMapping(value = "createNew")
	public String createNewText(ModelMap model) {
		setPageData(model);
		model.addAttribute("textpad", new TextPad());
		return "textAddForm";
	}

	@RequestMapping(value = "updateText", method = RequestMethod.POST)
	public String updatePerson(@ModelAttribute("textpad") @Valid TextPad textPad, BindingResult result, ModelMap model,
			HttpServletRequest request) {
		if (!result.hasErrors()) {
			int complexity = textPadService.checkTextComplexity(textPad);
			textPadService.updateText(textPad);
			model.addAttribute(new TextPad());
			model.addAttribute("msg", getMsg("text.udpated", request));
			model.addAttribute("complexity", complexity);
			setPageData(model);
			return "textpadlist";
		}
		setPageData(model);
		return "textUpdate";
	}

	private void setPageData(ModelMap model) {
		model.addAttribute("allData", textPadService.getAllTexts());
	}

	private String getMsg(String key, HttpServletRequest request) {
		return messageSource.getMessage(key, null, localeResolver.resolveLocale(request));
	}

}
