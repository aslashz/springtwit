package app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.model.Subscribe;
import app.model.SubscribeRepository;
import app.model.SubscribeRepositoryImpl;
import app.model.User;
import app.model.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	UserRepository userRepository;
	@Autowired
	SubscribeRepository subscibeRepository;
	@Autowired
	SubscribeRepositoryImpl subscribeRepositoryImpl;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// add user to repository //
		User user1 = new User("user1", "user1");
		User user2 = new User("user2", "user2");

		userRepository.save(user1);
		userRepository.save(user2);

		subscibeRepository.save(new Subscribe(user1, user2));
		List<Subscribe> resultFromUser1 = subscribeRepositoryImpl.findByFromUsername("user1");
		log.info("SIZE : " + resultFromUser1.size() + "");
	}

	private static final Logger log = LoggerFactory.getLogger(Application.class);
}
