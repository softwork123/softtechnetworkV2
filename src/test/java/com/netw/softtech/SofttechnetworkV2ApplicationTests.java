package com.netw.softtech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.netw.softtech.model.User;
import com.netw.softtech.services.UserService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SofttechnetworkV2ApplicationTests {


	
	@Autowired
	private UserService userService;
	@BeforeEach
	public void initDb() {
		{
		User newUser = new User("testUSer@mail.com","testUSer","123456");
		userService.createUser(newUser);
		}
		{
			User newAdmin = new User("testAdmin@mail.com","AdminUSer","1239999456");
			userService.createUser(newAdmin);
			}
		
		User user = userService.findByEmailLike("testUSer@mail.com");
		
		
	}
	@Test
    public void testUser() {
  	  User user = userService.findByEmailLike("testUser@mail.com");
        assertNotNull(user);
  	  User admin = userService.findByEmailLike("testAdmin@mail.com");
  	  assertEquals(admin.getEmail(),"testAdmin@mail.com");
    }

}