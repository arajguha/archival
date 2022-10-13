package app.hook.archival.controller;

import app.hook.archival.commons.ApiResponse;
import app.hook.archival.commons.requests.BackupMessageRequest;
import app.hook.archival.commons.exception.GenericException;
import app.hook.archival.commons.requests.ListMessageRequest;
import app.hook.archival.model.Message;
import app.hook.archival.service.MessageBackupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.*;

// TODO: Use Builder pattern for building ApiResponse object
@RestController
public class MessageBackupController {

    @Autowired
    private MessageBackupService backupService;

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse> getAllMessages() {
        try {
            List<Message> messageList = this.backupService.getAllMessages();
            ApiResponse<List<Message>> response = new ApiResponse<>(messageList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (GenericException e) {
            ApiResponse response = new ApiResponse(e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-message/{messageId}")
    public ResponseEntity<ApiResponse>  getMessageById(@PathVariable String messageId) {
        try {
            ApiResponse response = null;
            Optional<Message> data = this.backupService.getMessageById(messageId);
            if (!data.isPresent()) {
                response = new ApiResponse(true, null, null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            response = new ApiResponse<Optional<Message>>(Optional.of(data.get()));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(new GenericException(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/backup-message")
    public ResponseEntity<ApiResponse> backupMessage(@RequestBody @NonNull BackupMessageRequest requestBody) {
        try {
            requestBody.validate();
            this.backupService.saveMessage(new Message(
                    requestBody.getMessageId(),
                    requestBody.getMessage(),
                    new Date(requestBody.getReceivedAt())
            ));
            return new ResponseEntity<>(new ApiResponse<String>("saved"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(new GenericException(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/list")
    public ResponseEntity<ApiResponse> listMessages(@RequestBody @NonNull ListMessageRequest requestBody) {
        try {
            List<Message> messageList =
                    this.backupService.getMessagesWithinDateRange(requestBody.getStartDate(), requestBody.getEndDate());
            return new ResponseEntity<>(new ApiResponse<List<Message>>(messageList), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(new GenericException(e.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
