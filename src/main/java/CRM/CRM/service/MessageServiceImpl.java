package CRM.CRM.service;

import CRM.CRM.model.Message;

import java.util.List;

public interface MessageServiceImpl {

    List<Message> findAll();
    
    List<Message> findMessage(Long senderId, Long recipientId);
}
