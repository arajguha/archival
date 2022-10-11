package app.hook.archival.messagebackup;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MessageBackService {
    private List<Message> messages = new ArrayList<>(Arrays.asList(
            new Message("message-id-1", null),
            new Message("message-id-2", null)
        )
    );

    public List<Message> getAllMessages() {
        return this.messages;
    }

    public void saveMessage(Message message) {
        this.messages.add(message);
    }
}
