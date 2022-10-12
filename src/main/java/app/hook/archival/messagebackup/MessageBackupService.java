package app.hook.archival.messagebackup;

import app.hook.archival.commons.ApiResponse;
import app.hook.archival.commons.exception.GenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
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

    public Optional<Message> getMessageById(String messageId) throws Exception {
        return this.messageRepository.findById(messageId);
    }

    public void saveMessage(Message message) throws Exception {
        this.messageRepository.save(message);
    }
}
