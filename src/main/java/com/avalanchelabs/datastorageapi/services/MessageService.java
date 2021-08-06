package com.avalanchelabs.datastorageapi.services;

import com.avalanchelabs.datastorageapi.domain.Message;
import com.avalanchelabs.datastorageapi.models.MessageDto;
import com.avalanchelabs.datastorageapi.models.MessageModel;
import com.avalanchelabs.datastorageapi.models.mapper.MapStructMapper;
import com.avalanchelabs.datastorageapi.repositories.MessageDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessageDao messageDao;
    private final MapStructMapper mapStructMapper;

    public MessageService(MessageDao messageDao, MapStructMapper mapStructMapper) {
        this.messageDao = messageDao;
        this.mapStructMapper = mapStructMapper;
    }

    public MessageModel saveMessage (MessageDto messageDto) {
        Message message = mapStructMapper.messageDtoToMessage(messageDto);
        Message saved = messageDao.saveMessage(message);
        return mapStructMapper.messageToMessageModel(saved);
    }

    public List<MessageModel> getMessages() {
        return messageDao.getMessages()
                .stream()
                .map(mapStructMapper::messageToMessageModel)
                .collect(Collectors.toList());
    }

    public List<MessageModel> getCachedValues() {
        return messageDao.getCachedValues()
                .stream()
                .map(mapStructMapper::messageToMessageModel)
                .collect(Collectors.toList());
    }

    public MessageModel getCachedValue(String key) {
        return mapStructMapper.messageToMessageModel(messageDao.getCachedValue(key));
    }

    public void flush() {
        messageDao.flush();
    }
}
