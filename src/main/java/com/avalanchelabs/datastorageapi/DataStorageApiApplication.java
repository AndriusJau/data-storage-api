package com.avalanchelabs.datastorageapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@SpringBootApplication
@EnableCaching
public class DataStorageApiApplication {

	private RedisServer redisServer;

	public static void main(String[] args) {
		SpringApplication.run(DataStorageApiApplication.class, args);
	}

	@PostConstruct
	public void startRedis() throws IOException {
		redisServer  = new RedisServer(6379);
		redisServer.start();
	}

	@PreDestroy
	public void stopRedis(){
		redisServer.stop();
	}
}
