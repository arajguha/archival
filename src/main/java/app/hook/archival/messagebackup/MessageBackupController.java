package app.hook.archival.messagebackup;

import app.hook.archival.commons.BackupMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class MessageBackupController {

    @Autowired
    private MessageBackupService backupService;

    @GetMapping("/v1/getAll")
    public ResponseEntity<List<Message>> getAllMessages() {
        return ResponseEntity.status(HttpStatus.OK).body(this.backupService.getAllMessages());
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
