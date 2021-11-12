package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import com.example.demo.entity.service.MessageService;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class BotController {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private MessageRepository mrepo;
	
	


	
	@GetMapping("/")
    public String viewHomePage() {
        return "index";
    }
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new User());
	    return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);
		return "register_success";
	}
	
	@GetMapping("/list_users")
	public String viewUsersList(Model model) {
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
	
	@GetMapping("/list_messages")
	public String viewMessagesList(Model model) {
		List<Message> listMessages = mrepo.findAll();
		//List<Message> listMessages = mrepo.findContentByResponse();
		model.addAttribute("listMessages", listMessages);
		return "questions";
	}
	
	@GetMapping("/chatbot")
	public String startChatbot(Model theModel) {
		theModel.addAttribute("theMessage", "Hi There, I am using this Chatbot");
		return "chatbot";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDeniedPage() {
		return "access-denied";
	}
	
	
}
