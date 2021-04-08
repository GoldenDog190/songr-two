package com.GoldenDog190.songr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

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

       Song song = songRepository.getOne(id);
        s.addAttribute("songList", song);
        return "/song";
    }


    @PostMapping("/song")
    public RedirectView addSong(String songTitle, int songLength, int trackNumber, long id){
        Album albumSong = albumRepository.getOne(id);
        Song song = new Song(songTitle, songLength, trackNumber, albumSong);
        songRepository.save(song);
        return new RedirectView("/song");
    }
}
