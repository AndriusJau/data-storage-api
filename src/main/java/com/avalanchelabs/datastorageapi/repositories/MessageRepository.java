package com.avalanchelabs.datastorageapi.repositories;

import com.avalanchelabs.datastorageapi.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
