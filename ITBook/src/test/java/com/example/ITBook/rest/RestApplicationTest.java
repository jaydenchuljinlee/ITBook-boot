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
@SpringBootTest(classes = ItBookApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) // ������ ��Ʈ (���⼭�� 8081)
@AutoConfigureTestDatabase
public class RestApplicationTest {

    private TestRestTemplate restTemplate = new TestRestTemplate("test", "test");

    @Test
    public void user_����_��_������¥_�����Ǵ���_�׽�Ʈ() {
        User user = createUser();
        Assert.assertNotNull(user.getCreatedDate());
    }

    @Test
    public void user_����_��_������¥_�����Ǵ���_�׽�Ʈ() {
        User createdUser = createUser();
        User updateUser = updateBoard(createdUser);
        Assert.assertNotNull(updateUser.getUpdatedDate());
    }

    private User createUser() {
        User board = User.builder().name("���� �̺�Ʈ �׽�Ʈ").build();
        return restTemplate.postForObject("http://localhost:8081/api/user", board, User.class);
    }

    private User updateBoard(User createdUser) {
        String updateUri = "http://localhost:8081/api/user/1";
        restTemplate.put(updateUri, createdUser);
        return restTemplate.getForObject(updateUri, User.class);
    }

}
