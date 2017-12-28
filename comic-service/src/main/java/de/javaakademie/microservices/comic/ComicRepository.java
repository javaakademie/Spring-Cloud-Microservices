package de.javaakademie.microservices.comic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ComicRepository extends JpaRepository<Comic, Integer> {
}