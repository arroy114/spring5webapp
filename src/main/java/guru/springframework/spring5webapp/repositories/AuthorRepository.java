package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

//Here is to create a Spring data repository by Spring DATA JPA
//Spring data repository is responsible for CRUD operations
//Crud: create, read, update, and delete

//Spring data JPA takes care of the hibernates commands and transactional commands

//Here we provides the interface (AuthorRepository)
//Spring Data JPA provides the implementation by (extends CrudRepository)
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
