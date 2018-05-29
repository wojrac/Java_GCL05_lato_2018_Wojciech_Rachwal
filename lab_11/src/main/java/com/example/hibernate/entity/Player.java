package com.example.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "players")
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="player_id")
    private int player_id;

    @Column(name="player_name")
    private String player_name;

    @Column(name="player_lastname" , unique = true)
    private String player_lastname;

    @Column(name="email")
    private String email;

    @ManyToMany(cascade = {
            CascadeType.ALL,
            CascadeType.MERGE
    })
    @JoinTable(name = "players_club",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "club_id")
    )
    private List<Club> playerGroupList;

    public Player() {
        this.playerGroupList = new ArrayList<>();
    }

    public Player(String player_name, String player_lastname, String email) {
        this.player_name = player_name;
        this.player_lastname = player_lastname;
        this.email = email;
        this.playerGroupList = new ArrayList<>();
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_lastname() {
        return player_lastname;
    }

    public void setPlayer_lastname(String player_lastname) {
        this.player_lastname = player_lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public List<Club> getPlayerGroupList() {
        return playerGroupList;
    }

    public void setPlayerGroupList(List<Club> playerGroupList) {
        this.playerGroupList = playerGroupList;
    }

    @Override
    public String toString() {
        return "Player{" +
                "player_id=" + player_id +
                ", player_name='" + player_name + '\'' +
                ", player_lastname='" + player_lastname + '\'' +
                ", email='" + email + '\'' +
                ", playerGroupList=" + playerGroupList +
                '}';
    }
}
