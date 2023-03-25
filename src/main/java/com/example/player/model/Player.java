/*
 * You can use the following import statements
 * import javax.persistence.*;
 * 
 */

// Write your code here
package com.example.player.model;

import javax.persistence.*;

@Entity
@Table(name="team")
public class Player{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="playerid")
    private int playerId;

    @Column(name="playername")
    private String playerName;

    @Column(name="jerseynumber")
    private Integer jerseyNumber;

    @Column(name="role")
    private String role;

    public Player(){
    }

    public Player(int playerId,String playerName,Integer jerseyNumber,String role){
        this.playerId=playerId;
        this.playerName=playerName;
        this.jerseyNumber=jerseyNumber;
        this.role=role;
    }

    public void setPlayerId(int playerId){
        this.playerId=playerId;
    }

    public void setPlayerName(String playerName){
        this.playerName=playerName;
    }

    public void setJerseyNumber(Integer jerseyNumber){
        this.jerseyNumber=jerseyNumber;
    }

    public void setRole(String role){
        this.role=role;
    }

    public int getPlayerId(){
        return this.playerId;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public Integer getJerseyNumber(){
        return this.jerseyNumber;
    }

    public String getRole(){
        return this.role;
    }
}