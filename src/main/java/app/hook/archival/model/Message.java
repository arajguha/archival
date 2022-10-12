package app.hook.archival.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Message {

    @Id
    @Column(name = "messageId", nullable = false)
    private String messageId;

    private Date receivedAt;

    private String message; // Stringified JSON

    public Message() {}

    public Message(String messageId, String message) {
        this.messageId = messageId;
        this.message = message;
    }

    public Message(String messageId, String message, Date receivedAt) {
        this.receivedAt = receivedAt;
        this.messageId = messageId;
        this.message = message;
    }

    public Date getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(Date receivedAt) {
        this.receivedAt = receivedAt;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
