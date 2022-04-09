package io.educative.mediaapp.controller;

import io.educative.mediaapp.database.PlaylistRepository;
import io.educative.mediaapp.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;

@Controller
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/")
    public String listPlaylistAndSongs(Model model) {
        model.addAttribute("playlists", playlistService.getAllPlaylists());
        return "index";
    }

}

