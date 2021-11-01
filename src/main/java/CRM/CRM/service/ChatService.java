package CRM.CRM.service;

import CRM.CRM.model.Chat;
import CRM.CRM.model.User;
import CRM.CRM.repository.ChatRepository;
import CRM.CRM.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ChatService {
	
	@Autowired
	ChatRepository chatRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	public Chat chatSave(String name, Date creationDate){
		return chatRepository.save(new Chat(name,creationDate));
	}
	
	public Chat chatAddUser(Long id, Long userId){
		Chat chat = chatRepository.findById(id).get();
		System.err.println(id);
		User user = userRepository.findById(userId).get();
		
		chat.chatAddUser(user);
		chatRepository.save(chat);
		return chat;
	}
	
	
}
