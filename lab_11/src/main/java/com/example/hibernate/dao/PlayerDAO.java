package com.example.hibernate.dao;

import com.example.hibernate.entity.Player;
import com.example.hibernate.entity.Club;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDAO extends AbstractDAO {

    public PlayerDAO() {
        setClazz(Player.class);
    }

    public Player getPlayerByID(int id) {
        return (Player) entityManager.createQuery("SElECT p FROM Player p WHERE p.id=:playerId")
                .setParameter("playerId", id)
                .getSingleResult();
    }

   public Player getPlayerBylastname(String player_lastname) {
        return (Player) entityManager.createQuery("SElECT p FROM Player p WHERE p.player_lastname=:playerLastname")
                .setParameter("playerLastname", player_lastname)
                .getSingleResult();
    }

    public List<Club> getClubsByplayer(int id) {
        Player player = getPlayerByID(id);
        return player.getPlayerGroupList();
    }


}
