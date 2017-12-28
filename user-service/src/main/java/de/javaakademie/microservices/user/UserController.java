package de.javaakademie.microservices.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.javaakademie.microservices.user.intercomm.Comic;
import de.javaakademie.microservices.user.intercomm.ComicClient;

@RestController
public class UserController {

	@Autowired
	private ComicClient comicClient;

	protected Logger logger = Logger.getLogger(UserController.class.getName());

	private List<User> users;

	public UserController() {
		users = new ArrayList<>(Arrays.asList(new User(1, "Marcus"), new User(2, "Gaius"), new User(3, "Publius"),
				new User(4, "Lucius"), new User(5, "Quintus")));
	}

	@RequestMapping("/users/name/{name}")
	public User findByName(@PathVariable("name") String name) throws UserNotFoundException {
		logger.info(String.format("User.findByName(%s)", name));
		Optional<User> userOpt = users.stream().filter(it -> it.getName().equalsIgnoreCase(name)).findFirst();
		if (userOpt.isPresent()) {
			List<Comic> comics = comicClient.readComics().getContent().stream().collect(Collectors.toList());
			userOpt.get().setComics(comics);
			return userOpt.get();
		} else {
			throw new UserNotFoundException(name);
		}
	}

	@RequestMapping("/users")
	public List<User> findAll() {
		logger.info("User.findAll()");
		List<Comic> comics = comicClient.readComics().getContent().stream().collect(Collectors.toList());
		users.stream().forEach(user -> user.setComics(comics));
		return users;
	}

	@RequestMapping("/users/{id}")
	public User findById(@PathVariable("id") Integer id) {
		logger.info(String.format("User.findById(%s)", id));
		User user = users.stream().filter(it -> it.getId().intValue() == id.intValue()).findFirst().get();
		List<Comic> comics = comicClient.readComics().getContent().stream().collect(Collectors.toList());
		user.setComics(comics);
		return user;
	}

}
