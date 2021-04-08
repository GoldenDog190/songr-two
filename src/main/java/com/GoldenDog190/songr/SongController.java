package com.GoldenDog190.songr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SongController {
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @GetMapping("/song/{id}")
    public String songPage(@PathVariable long id, Model s){
        ArrayList<Song> songInfo = new ArrayList<>();
        List<Song> songRepo = songRepository.findAll();
        Album album = albumRepository.getOne(id);
//
//        songInfo.add(
//                new Song("Help!", 300, 3, album)
//        );
//        songRepository.save( new Song("Help!", 300, 3, album));

       Song song = songRepository.getOne(id);
        s.addAttribute("songList", song);
        System.out.println("song" + song);
        return "/albums";
    }


    @PostMapping("/song")
    public RedirectView addSong(String songTitle, Integer songLength, Integer trackNumber, long id) throws IOException {
        Song songPost = new Song(songTitle, songLength, trackNumber);
        Album albumSong = albumRepository.getOne(id);
        songRepository.save(songPost);
        System.out.println("in song post route" + songPost.getId());

        return new RedirectView("/song");
    }
}
