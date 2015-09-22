package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.model.User;
import app.model.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    UserRepository userRepository;
    
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// add user to repository //
		userRepository.save(new User("admin", "password"));
	}

}
