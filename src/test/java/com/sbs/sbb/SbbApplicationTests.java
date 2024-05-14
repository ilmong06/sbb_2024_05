package com.sbs.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = SbbApplication.class)
class SbbApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testWritePage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/write")) // "/write" 경로에 GET 요청을 보냄
				.andExpect(MockMvcResultMatchers.status().isOk()) // HTTP 상태코드가 200인지 확인
				.andExpect(MockMvcResultMatchers.content().string("<!DOCTYPE html>\n" +
						"<html lang=\"ko\">\n" +
						"<head>\n" +
						"    <meta charset=\"UTF-8\">\n" +
						"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
						"    <title>안녕하세요</title>\n" +
						"</head>\n" +
						"<body>\n" +
						"<h1>안녕하세요</h1>\n" +
						"</body>\n" +
						"</html>")); // 응답 본문이 주어진 HTML 코드와 일치하는지 확인
	}
}