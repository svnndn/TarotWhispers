package ru.itis.tarot_whispers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
    @GetMapping("/")
    String test() {
        return "homepage_view";
    }
}
