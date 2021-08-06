package com.avalanchelabs.datastorageapi.repositories;

import com.avalanchelabs.datastorageapi.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class MessageDao {

    private final MessageRepository messageRepository;
    private final RedisTemplate redisTemplate;
    private final CacheManager cacheManager;

    private static final String CACHE = "messages";

    public MessageDao(MessageRepository messageRepository, RedisTemplate redisTemplate, CacheManager cacheManager) {
        this.messageRepository = messageRepository;
        this.redisTemplate = redisTemplate;
        this.cacheManager = cacheManager;
    }

    @CachePut(value = CACHE, key = "#message.foreignId")
    public Message saveMessage (Message message) {
        return messageRepository.save(message);
    }

    public List<Message> getMessages() {
        return (List)messageRepository.findAll();
    }

    public List<Message> getCachedValues() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        Set<String> keys = redisTemplate.keys("*");
        List<Message> cachedValues = new ArrayList<>();
        for (String key : keys) {
            cachedValues.add(getCachedValue(key.replace("messages::", "")));
        }
        return cachedValues;
    }

    public Message getCachedValue(String key) {
        return cacheManager.getCache(CACHE).get(key, Message.class);
    }

    public void flush() {
        cacheManager.getCache(CACHE).clear();
    }
}
