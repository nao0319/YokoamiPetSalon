package com.example.yokoami.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.yokoami.entity.Owner;
import com.example.yokoami.entity.OwnerRepository;

@Controller
@RequestMapping("owner")
public class OwnerController {
	@Autowired
	OwnerRepository ownerRepository;
	
	@RequestMapping("new")
	public String input() {
		return "owner/new";
	}

	@RequestMapping("create")
	public String create(
			Model model,
			@ModelAttribute("owner") @Validated Owner own,
			BindingResult result) {
//		if (result.hasErrors()) {
//			return "owner/new";
//		}
//		ownerRepository.save(own);
		return "owner/confirm";
	}
	
	@RequestMapping("edit")
	public String edit(
			Model model,
			@RequestParam("id") Integer id) {
		Owner own = ownerRepository.findById(id).get();
		model.addAttribute("owner", own);
		return "owner/edit";
	}
	
	@RequestMapping("update")
	public String update(
			Model model,
			@ModelAttribute("owner") Owner ownForm) {
		Owner own = ownerRepository.findById(ownForm.getId()).get();
		own.setName(ownForm.getName());
		own.setAddress(ownForm.getAddress());
		own.setTel(ownForm.getTel());
		own.setEmail(ownForm.getEmail());
		ownerRepository.save(own);
		model.addAttribute("owner", own);
		return "owner/save";
	}
	
	@RequestMapping("save")
	public String save(Model model,
			@ModelAttribute("owner") @Validated Owner own) {
		ownerRepository.save(own);
		return "redirect:/owner/list";
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		List<Owner> list = ownerRepository.findAll();
		model.addAttribute("owners", list);
		return "owner/list";
	}
}
