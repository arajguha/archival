package app.hook.archival.messagebackup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MessageBackupService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        List<Message> messageList = new ArrayList<>();
        this.messageRepository.findAll().forEach(m -> messageList.add(m));
        return messageList;
    }

    public Optional<Message> getMessageById(String messageId) {
        return this.messageRepository.findById(messageId);
    }

    public void saveMessage(Message message) {
        this.messageRepository.save(message);
    }
}
