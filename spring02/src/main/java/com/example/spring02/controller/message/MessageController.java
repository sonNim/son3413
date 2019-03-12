package com.example.spring02.controller.message;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring02.model.message.dto.MessageDTO;
import com.example.spring02.service.message.MessageService;

@RestController
@RequestMapping("messages/*") //공통적인 url mapping
public class MessageController {
	@Inject
	MessageService messageService;
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<String> addMessage(
			@RequestBody MessageDTO dto){
		ResponseEntity<String> entity=null;
		try {
			messageService.addMessage(dto);
			entity=new ResponseEntity<>("success",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(e.getMessage()
					,HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}









