package com.apap.tutorial8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tutorial8.model.UserRoleModel;
import com.apap.tutorial8.service.UserRoleService;

@Controller
@RequestMapping("/user")
public class UserRoleController {
	@Autowired
	private UserRoleService userService;
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	private String addUserSubmit(@ModelAttribute UserRoleModel user) {
		userService.addUser(user);
		return "home";
	}
	
	@RequestMapping(value="/update-password", method=RequestMethod.POST)
	private String updatePasswordSubmit(@ModelAttribute UserRoleModel dummyUser, String newPassword, String newPasswordConf, Model model) {
		
		UserRoleModel realUser = userService.getUserByUsername(dummyUser.getUsername());
		if(userService.isMatch(dummyUser.getPassword(), realUser.getPassword())) {
			if (newPassword.equals(newPasswordConf)) {
				realUser.setPassword(newPassword);
				userService.addUser(realUser);
				model.addAttribute("msg", "Password berhasil diubah.");
			}
			else {
				model.addAttribute("msg", "Konfirmasi password tidak sesuai.");
			}
		}
		else {
			model.addAttribute("msg", "Password lama salah.");
		}
		return "home";
	}
	
}