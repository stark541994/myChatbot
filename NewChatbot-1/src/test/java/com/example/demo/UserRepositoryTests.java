package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private UserRepository repo;
    
    @Test
    public void testCreateUser() {
    	User user = new User();
    	user.setEmail("sumitk@gmail.com");
    	user.setPassword("sumit2021");
    	user.setFirstName("sumit");
    	user.setLastName("Kulkarni");
    	
    	User savedUser = repo.save(user);
    	
    	User existUser = entityManager.find(User.class, savedUser.getId());
    	
    	assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    	
    }
    
    @Test
    public void testFindUserByEmail() {
    	
    	String email = "aish@gmail.com";
    	User user = repo.findbyEmail(email);
    	assertThat(user).isNotNull();
    }
    
}
