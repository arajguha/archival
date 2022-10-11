package app.hook.archival.messagebackup;

import java.util.Date;

public class Message {
    private Date receivedAt;
    private String messageId;
    private Object message;

    public Message() {}

    public Message(String messageId, Object message) {
        this.messageId = messageId;
        this.message = message;
    }

    public Message(String messageId, Object message, Date receivedAt) {
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

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
