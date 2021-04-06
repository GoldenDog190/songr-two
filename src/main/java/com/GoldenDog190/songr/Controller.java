package com.GoldenDog190.songr;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    public String albumsPage(){
        return "albums.html";
    }
}
