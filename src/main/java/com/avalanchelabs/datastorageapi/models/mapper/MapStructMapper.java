package com.avalanchelabs.datastorageapi.models.mapper;

import com.avalanchelabs.datastorageapi.domain.Message;
import com.avalanchelabs.datastorageapi.models.MessageDto;
import com.avalanchelabs.datastorageapi.models.MessageModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    Message messageDtoToMessage(MessageDto messageDto);
    MessageModel messageToMessageModel(Message message);
}
