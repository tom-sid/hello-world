package com.example.demoblog.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demoblog.entity.Post;
import com.example.demoblog.service.PostService;

@Controller
public class HomeController {

	@Autowired
	private PostService postService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/home")
	public String home(Model model) {
		List<Post> latest5Posts = postService.findLatest5();
		model.addAttribute("latest5posts", latest5Posts);
		List<Post> latest3Posts = latest5Posts.stream().limit(3).collect(Collectors.toList());
		model.addAttribute("latest3posts", latest3Posts);
		return "home";
	}
}
