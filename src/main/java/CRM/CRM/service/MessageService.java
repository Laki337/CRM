package CRM.CRM.service;


import CRM.CRM.model.Message;
import CRM.CRM.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService implements MessageServiceImpl{

    @Autowired
    MessageRepository messageRepository;
    public Message create(String content,Long senderId,Long chatId) {
        Message message = new Message();
        message.setContent(content);
        message.setCreationDate(new Date());
        message.setStatus(false);
        message.setSenderId(senderId);
        message.setChatId(chatId);
       
      messageRepository.save(message);
        return messageRepository.save(message);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }
    
    @Override
    public List<Message> findMessage(Long senderId, Long recipientId) {
        return messageRepository.findBySenderIdAndRecipientId(senderId,recipientId);
    }
}
