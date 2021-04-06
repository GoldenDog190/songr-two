package com.GoldenDog190.songr;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/hello-world")
        public String helloWorldPage(){
            return "hello-world.html";
    }

    @GetMapping("/capitalize/{capitalize}")
        public String capitalizePage(Model m,
                                     @PathVariable String capitalize){
        String capitalizeWord = new String("Hello");
        System.out.println("capitalize = " + capitalize);
        System.out.println(capitalizeWord.toUpperCase());
        m.addAttribute("capitalize", capitalize.toUpperCase());
        return "capitalize.html";
    }

    @GetMapping("/albums")
    public String albumsPage(Model a){
      ArrayList<Album> albumInfo = new ArrayList<>();
            albumInfo.add(
                    new Album("X&Y", "Coldplay", 12, 3750,
                            "https://upload.wikimedia.org/wikipedia/en/thumb/2/28/Coldplay_X%26Y.svg/480px-Coldplay_X%26Y.svg.png")
            );
            albumInfo.add(
                    new Album("Abbey Road", "The Beatles", 16, 2823,
                            "https://upload.wikimedia.org/wikipedia/en/4/42/Beatles_-_Abbey_Road.jpg")
            );
            albumInfo.add(
                    new Album("Help!", "The Beatles", 14, 2024,
                            "https://upload.wikimedia.org/wikipedia/en/e/e7/Help%21_%28The_Beatles_album_-_cover_art%29.jpg")
            );
        a.addAttribute("album", albumInfo);

        return "albums.html";
    }
}
