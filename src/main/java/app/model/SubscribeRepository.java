package app.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SubscribeRepository extends CrudRepository<Subscribe, Long> {
	public List<Subscribe> findByFromUser(User user);
	public List<Subscribe> findByToUser(User user);
}
interface SubscribeRepositoryCustom {
	public List<Subscribe> findByFromUsername(String username);
	public List<Subscribe> findByToUsername(String username);
}
