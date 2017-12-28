package de.javaakademie.microservices.edge;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("comic-service")
public interface ComicClient {

	@GetMapping("/comics")
	Resources<Comic> readComics();

}
