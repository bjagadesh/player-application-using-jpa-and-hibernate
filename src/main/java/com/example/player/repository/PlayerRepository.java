// Write your code here
package com.example.player.repository;

import java.util.*;
import com.example.player.model.Player;

public interface PlayerRepository{
    ArrayList<Player> getBooks();
    Player getBook(int playerId);
    Player updatePlayer(int playerId,Player player);
    Player addPlayer(Player player);
    void deletePlayer(int playerId);
    
}