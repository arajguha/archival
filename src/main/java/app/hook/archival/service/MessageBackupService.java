package app.hook.archival.service;

import app.hook.archival.commons.exception.GenericException;
import app.hook.archival.model.Message;
import app.hook.archival.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MessageBackupService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages() throws GenericException {
        try {
            List<Message> messageList = new ArrayList<>();
            this.messageRepository.findAll().forEach(m -> messageList.add(m));
            return messageList;
        } catch (Exception e) {
            throw new GenericException(e);
        }
    }

    public Optional<Message> getMessageById(String messageId) {
        return this.messageRepository.findById(messageId);
    }

    public void saveMessage(Message message) {
        this.messageRepository.save(message);
    }
}
