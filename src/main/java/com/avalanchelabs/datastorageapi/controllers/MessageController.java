package com.avalanchelabs.datastorageapi.controllers;

import com.avalanchelabs.datastorageapi.models.MessageDto;
import com.avalanchelabs.datastorageapi.models.MessageModel;
import com.avalanchelabs.datastorageapi.services.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/migration/ocr")
    public MessageModel saveMessage(@Valid @RequestBody MessageDto messageDto) {
        return messageService.saveMessage(messageDto);
    }

    @GetMapping("/all")
    public List<MessageModel> getMessages() {
        return messageService.getMessages();
    }

    @GetMapping("/cached/all")
    public List<MessageModel> getCachedValues() {
        return messageService.getCachedValues();
    }

    @GetMapping("/cached/details/{foreign_id}")
    public MessageModel getCachedValue(@PathVariable("foreign_id") String key) {
        return messageService.getCachedValue(key);
    }

    @GetMapping("/cached/flush")
    public void flush() {
        messageService.flush();
    }
}
