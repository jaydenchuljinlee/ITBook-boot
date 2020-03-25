package com.example.ITBook.rest;

import com.example.ITBook.ItBookApplication;
import com.example.ITBook.common.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItBookApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) // 정해진 포트 (여기서는 8081)
@AutoConfigureTestDatabase
public class RestApplicationTest {

    private TestRestTemplate restTemplate = new TestRestTemplate("test", "test");

    @Test
    public void user_저장_시_생성날짜_지정되는지_테스트() {
        User user = createUser();
        Assert.assertNotNull(user.getCreatedDate());
    }

    @Test
    public void user_수정_시_수정날짜_지정되는지_테스트() {
        User createdUser = createUser();
        User updateUser = updateBoard(createdUser);
        Assert.assertNotNull(updateUser.getUpdatedDate());
    }

    private User createUser() {
        User board = User.builder().name("저장 이벤트 테스트").build();
        return restTemplate.postForObject("http://localhost:8081/api/user", board, User.class);
    }

    private User updateBoard(User createdUser) {
        String updateUri = "http://localhost:8081/api/user/1";
        restTemplate.put(updateUri, createdUser);
        return restTemplate.getForObject(updateUri, User.class);
    }

}
