package com.someonesmarter.bookstore.repository;

import com.someonesmarter.bookstore.entity.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthorRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void whenFindByName_thenReturnAuthor() {
        Author author = new Author();
        author.setName("Author");
        testEntityManager.persist(author);
        testEntityManager.flush();

        Author authorFound = authorRepository.findByName(author.getName());

        assertThat(authorFound.getName())
                .isEqualTo(author.getName());

    }

}
