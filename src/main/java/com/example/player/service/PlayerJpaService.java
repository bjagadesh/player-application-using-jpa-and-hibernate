/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.player.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.player.repository.*;
import com.sun.xml.bind.annotation.OverrideAnnotationOf;
import com.example.player.model.*;


@Service
public class PlayerJpaService implements PlayerRepository{

    @Autowired
    private PlayerJpaRepository playerjparepository;

    @Override
    public ArrayList<Player> getBooks(){
        List<Player> players=playerjparepository.findAll();
        ArrayList<Player> allplayers=new ArrayList<>(players);
        return allplayers; 
    }

    @Override 
    public Player getBook(int playerId){
        try{
        Player player=playerjparepository.findById(playerId).get();
        return player;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override 
    public Player updatePlayer(int id,Player player){
        try{
            Player existingplayer=playerjparepository.findById(id).get();
            if(player.getPlayerName()!=null){
                existingplayer.setPlayerName(player.getPlayerName());
            }
            if(player.getJerseyNumber()!=null){
                existingplayer.setJerseyNumber(player.getJerseyNumber());
            }
            if(player.getRole()!=null){
                existingplayer.setRole(player.getRole());
            }
            playerjparepository.save(existingplayer);
        return existingplayer;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Player addPlayer(Player player){
        playerjparepository.save(player);
        return player;
    }

    public void deletePlayer(int id){
        try{
        playerjparepository.deleteById(id);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}