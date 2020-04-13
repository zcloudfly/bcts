package com.rabbitmq;

import com.rabbitmq.provider.RabbitProvider;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RabbitmqApplication.class)
@RunWith(SpringRunner.class)
class RabbitmqApplicationTests {
	@Autowired
	private RabbitProvider rabbitProvider;

	@Test
	void contextLoads() {
		for (int i = 0; i < 10; i++) {
			rabbitProvider.send(i+"");
		}
	}

}
