package app.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class SubscribeRepositoryImpl implements SubscribeRepositoryCustom{

	@Autowired
	UserRepository userRepository;
	@Autowired
	SubscribeRepository subscribeRepository;
	
	@Override
	public List<Subscribe> findByFromUsername(String username) {
		// TODO Auto-generated method stub
		User filteredUser = userRepository.findByUsername(username);
		return subscribeRepository.findByFromUser(filteredUser);
	}

	@Override
	public List<Subscribe> findByToUsername(String username) {
		// TODO Auto-generated method stub
		User filteredUser = userRepository.findByUsername(username);
		return subscribeRepository.findByToUser(filteredUser);
	}

	

}
