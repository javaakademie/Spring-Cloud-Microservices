package de.javaakademie.microservices.user.intercomm;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.hateoas.Resources;

@FeignClient("comic-service")
public interface ComicClient {

	@GetMapping("/comics/{comicId}")
	Comic getComic(@PathVariable("comicId") Integer comicId);

	@GetMapping("/comics")
	Resources<Comic> readComics();

}
