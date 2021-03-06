package com.GoldenDog190.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


//   ==========JPA Stuff========
    @Autowired
    public AlbumRepository albumRepository;

    // =========================

    public void AlbumController() throws FileNotFoundException {
//        if(albumRepository.count() == null){
        // List<Album> albums;
//           try(List<Album> albums = new albumRepository.findAll()){
//            albumRepository.saveAll(albums);
//
//        } catch (IOException e) {
//               throw new IOException("Couldn't add album");
//           }
//        }
    }

    @GetMapping("/albums")
    public String albumsPage(Model a){
      ArrayList<Album> albumInfo = new ArrayList<>();
        List<Album> album = albumRepository.findAll();
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

        a.addAttribute("albumList", album);
//        System.out.println("its working" + album);

        return "albums.html";
    }

    @GetMapping("/")
    public String ShowSplash(){return "splash.html";}

    @PostMapping("/albums")
    public RedirectView addAlbums(String title, String artist, Integer songCount, Integer length, String imageUrl) throws IOException {
        Album albumPost = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(albumPost);

        System.out.println("in albums post route" + albumPost.getId());

        return new RedirectView("/albums");
    }

    @DeleteMapping("/albums/{id}")
    public RedirectView deleteAlbum(@PathVariable long id){
        albumRepository.deleteById(id);
        return new RedirectView("/");
    }
}
