package ksj.bitcamp.eoisa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ksj.bitcamp.eoisa.service.FCMService;

@RestController
@EnableScheduling
public class FCMController {
	
	@Autowired
	private FCMService service;

	@Scheduled(fixedDelay = 300000)
	public void push() {
		service.pushMessagingService();
	}

	@PostMapping(value = "/fcm/token", produces = "application/text;charset=UTF-8")
	public void manageToken(@RequestParam("request") String request, @RequestParam("token") String clientToken) {
		service.manageTokenService(request, clientToken);
	}
	
}