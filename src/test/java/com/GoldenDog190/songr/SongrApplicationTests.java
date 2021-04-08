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
	void testSongPage() throws Exception {
		mockMvc.perform(get("/song"))
				.andDo(print())
				.andExpect(content().string(containsString("<h1>Album</h1>")))
				.andExpect(content().string(containsString("<div>")))
				.andExpect(content().string(containsString("<h2>Title</h2>")))
				.andExpect(content().string(containsString("<p th:text=\"${album.title}\"></p>")))
				.andExpect(content().string(containsString("<h2>Artist</h2>")))
				.andExpect(content().string(containsString("<p th:text=\"${album.artist}\"></p>")))
				.andExpect(content().string(containsString("<h2>Song Count</h2>")))
				.andExpect(content().string(containsString(" <p th:text=\"${album.songCount} + 'songs'\"></p>")))
				.andExpect(content().string(containsString("<h2>Length of Songs</h2>")))
				.andExpect(content().string(containsString("${album.length} + 'seconds'")))
				.andExpect(content().string(containsString("<h2>Album Cover</h2>")))
				.andExpect(content().string(containsString("<img th:src=\"${album.imageUrl}\">")))
				.andExpect(content().string(containsString("</div>")))
				.andExpect(content().string(containsString("<div>")))
				.andExpect(content().string(containsString("<ul th:each=\"song : ${album.songList}\">")))
				.andExpect(content().string(containsString("<li th:text=\"${song.songTitle}\"></li>")))
				.andExpect(content().string(containsString("<li th:text=\"${song.songLength}\"></li>")))
				.andExpect(content().string(containsString("<li th:text=\"${song.trackNumber}\"></li>")))
				.andExpect(content().string(containsString("<li th:text=\"${song.album}\"></li>")))
				.andExpect(content().string(containsString("</div>")))
				.andExpect(content().string(containsString("<div>")))
				.andExpect(content().string(containsString("<form>")))
				.andExpect(content().string(containsString("<legend>Add a song</legend>")))
				.andExpect(content().string(containsString("<label for=\"add-song-title\">Song Title</label>")))
				.andExpect(content().string(containsString("<input id=\"add-song-title\" type=\"text\" name=\"title\">")))
				.andExpect(content().string(containsString("<label for=\"add-song-length\"> Song length</label>")))
				.andExpect(content().string(containsString("<input id=\"add-song-length\" type=\"text\" name=\"length\">")))
				.andExpect(content().string(containsString("<label for=\"add-song-number\">Track number</label>")))
				.andExpect(content().string(containsString("<input id=\"add-song-number\" type=\"text\" name=\"track\">")))
				.andExpect(content().string(containsString("<label for=\"add-song-album\">Album the song is from</label>")))
				.andExpect(content().string(containsString("<input id=\"add-song-album\" type=\"text\" name=\"album\">")))
				.andExpect(content().string(containsString("<input type=\"submit\" value=\"Add Song\">")))
				.andExpect(content().string(containsString("</form>")))
				.andExpect(status().isOk());
	}

}
