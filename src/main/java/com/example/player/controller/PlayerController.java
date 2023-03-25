/*
 * 
 * You can use the following import statemets
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 */

// Write your code here
package com.example.player.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.player.service.*;
import com.example.player.model.*;

@RestController
public class PlayerController{

    @Autowired
    public PlayerJpaService playerjpaservice;


    @GetMapping("/players")
    public ArrayList<Player> getbooks(){
        return playerjpaservice.getBooks();
    }

    @GetMapping("/players/{playerId}")
    public Player getBook(@PathVariable("playerId") int playerId){
        return playerjpaservice.getBook(playerId);
    }

    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId")int playerId,@RequestBody Player player){
        return playerjpaservice.updatePlayer(playerId, player);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        return playerjpaservice.addPlayer(player);
    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId){
        playerjpaservice.deletePlayer(playerId);
    }
}