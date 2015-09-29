package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.Application;
import app.model.Status;
import app.model.StatusRepository;
import app.model.Subscribe;
import app.model.SubscribeRepository;
import app.model.SubscribeRepositoryImpl;
import app.model.User;
import app.model.UserRepository;

@Controller
public class TimelineController {
	@Autowired
	SubscribeRepository subscribeRepository;
	@Autowired
	SubscribeRepositoryImpl subscribeRepositoryImpl;
	@Autowired
	UserRepository userRepository;
	@Autowired
	StatusRepository statusRepository;
	
	public void refreshTimeline(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("name", name);
		User user = userRepository.findByUsername(name);
		List<Subscribe> listFollowerRelationship = subscribeRepositoryImpl.findByToUsername(name);
		List<User> listFollowerUser = new ArrayList<User>();
		for (Subscribe s : listFollowerRelationship) {
			listFollowerUser.add(s.getFromUser());
		}
		List<Subscribe> listFollowingRelationship = subscribeRepositoryImpl.findByFromUsername(name);
		List<User> listFollowingUser = new ArrayList<User>();
		for (Subscribe s : listFollowingRelationship) {
			listFollowingUser.add(s.getToUser());
		}
		
		List<Status> listStatus = statusRepository.findByPostedBy(user);
		
		model.addAttribute("followers", listFollowerUser);
		model.addAttribute("followings", listFollowingUser);
		model.addAttribute("status", new Status());
		model.addAttribute("liststatus", listStatus);
	}

	@RequestMapping(value = { "/timeline" }, method = RequestMethod.GET)
	public String timelineView(Model model) {
		refreshTimeline(model);
		return "timeline";
	}

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@RequestMapping(value = { "/timeline" }, method = RequestMethod.POST)
	public String statusSubmit(@ModelAttribute Status status, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("name", name);
		User user = userRepository.findByUsername(name);
		status.setPostedBy(user);
		// save status //
		statusRepository.save(status);
		
		refreshTimeline(model);
		return "timeline";

	}

}
