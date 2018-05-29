package com.example.hibernate.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "club")
public class Club implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="club_id")
    private int club_id;

    @Column(name="club_name", unique = true)
    private String club_name;

    @ManyToMany(cascade = {
            CascadeType.ALL,
            CascadeType.MERGE
    })
    @JoinTable(name = "players_club",
            joinColumns = @JoinColumn(name = "club_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> playerList;

    public Club() {
        this.playerList = new ArrayList<>();
    }

    public Club(String club_name) {
        this.club_name = club_name;
        this.playerList = new ArrayList<>();
    }

    public int getClub_id() {
        return club_id;
    }

    public void setClub_id(int club_id) {
        this.club_id = club_id;
    }

    public String getClub_Name() {
        return club_name;
    }

    public void setName(String club_name) {
        this.club_name = club_name;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    @Override
    public String toString() {
        return "Club{" +
                "club_id=" + club_id +
                ", club='" + club_name + '\'' +
                '}';
    }
}
