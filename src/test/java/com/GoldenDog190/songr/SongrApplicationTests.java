package com.GoldenDog190.songr;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SongrApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void testHelloPage() throws Exception {
		mockMvc.perform(get("/hello"))
				.andDo(print())
				.andExpect(content().string(containsString("<h1>Hello World</h1>")))
				.andExpect(content().string(containsString("<p>Server is working!</p>")))
				.andExpect(status().isOk());
	}

	@Test
	void testAlbumPage() throws Exception {

	}

	@Test
	void testSongPage() throws Exception {

	}

}
