package app.hook.archival.commons;

public class BackupMessageRequest {
    private Long receivedAt;
    private String messageId;
    private String message; // Stringified JSON

    public BackupMessageRequest() {}

    public BackupMessageRequest(String messageId, String message) {
        this.messageId = messageId;
        this.message = message;
    }

    public BackupMessageRequest(String messageId, String message, Long receivedAt) {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
