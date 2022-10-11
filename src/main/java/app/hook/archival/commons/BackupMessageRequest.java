package app.hook.archival.commons;

public class BackupMessageRequest {
    private Long receivedAt;
    private String messageId;
    private Object message;

    public BackupMessageRequest() {}

    public BackupMessageRequest(String messageId, Object message) {
        this.messageId = messageId;
        this.message = message;
    }

    public BackupMessageRequest(String messageId, Object message, Long receivedAt) {
        this.receivedAt = receivedAt;
        this.messageId = messageId;
        this.message = message;
    }

    public Long getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(Long receivedAt) {
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
