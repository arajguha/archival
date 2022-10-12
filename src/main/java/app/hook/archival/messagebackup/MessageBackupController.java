package app.hook.archival.messagebackup;

import app.hook.archival.commons.BackupMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

// TODO: Create custom ApiResponse class to be used inside ResponseEntity
@RestController
public class MessageBackupController {

    @Autowired
    private MessageBackupService backupService;

    @GetMapping("/v1/getAll")
    public ResponseEntity<List<Message>> getAllMessages() {
        return ResponseEntity.status(HttpStatus.OK).body(this.backupService.getAllMessages());
    }

    @GetMapping("/v1/get-message/{messageId}")
    public ResponseEntity<Message>  getMessageById(@PathVariable String messageId) {
        Optional<Message> data = this.backupService.getMessageById(messageId);
        if (!data.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(data.get());
    }

    @PostMapping("/v1/backup-message")
    public ResponseEntity<String> backupMessage(@RequestBody BackupMessageRequest requestBody) {
        this.backupService.saveMessage(new Message(
                requestBody.getMessageId(),
                requestBody.getMessage(),
                new Date(requestBody.getReceivedAt())
        ));
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }
}
