package com.example.redismongo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@Slf4j
public class RedisApplication implements CommandLineRunner{

	private final UserRepository userRepository;

	@Autowired
	public RedisApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

	@Override
	public void run(String... strings) {
		//Populating embedded database here
		log.info("Saving users. Current user count is {}.", userRepository.count());
		User shubham = new User("Kumar");
		User pankaj = new User("Matt");
		User lewis = new User("Sesha");

		userRepository.save(shubham);
		userRepository.save(pankaj);
		userRepository.save(lewis);
		log.info("Done saving users. Data: {}.", userRepository.findAll());
	}


}

