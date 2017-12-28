package de.javaakademie.microservices.comic;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class ComicInitializer implements CommandLineRunner {

	private final ComicRepository comicRepository;

	ComicInitializer(ComicRepository comicRepository) {
		this.comicRepository = comicRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of(new Comic("Alice Matheson", "Horror"), new Comic("The Walking Dead", "Horror"),
				new Comic("Night of the Living Dead", "Horror"), new Comic("Zombies", "Horror"))
				.forEach(comic -> comicRepository.save(comic));
		comicRepository.findAll().forEach(System.out::println);
	}
}
