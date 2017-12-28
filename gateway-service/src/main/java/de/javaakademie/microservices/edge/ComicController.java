package de.javaakademie.microservices.edge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
class ComicController {

	private final ComicClient comicClient;

	public ComicController(ComicClient comicClient) {
		this.comicClient = comicClient;
	}

	public Collection<Comic> fallback() {
		return new ArrayList<>();
	}

	@HystrixCommand(fallbackMethod = "fallback")
	@GetMapping("/horror-comics")
	@CrossOrigin(origins = "*")
	public Collection<Comic> goodComics() {
		return comicClient.readComics().getContent().stream().filter(this::isHorror).collect(Collectors.toList());
	}

	private boolean isHorror(Comic comic) {
		return comic.getCategory().equals("Horror");
	}

}