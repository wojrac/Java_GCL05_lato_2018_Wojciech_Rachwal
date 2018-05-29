package com.example.hibernate.dao;

import com.example.hibernate.entity.Player;
import com.example.hibernate.entity.Club;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClubDAO extends AbstractDAO {

    public ClubDAO() {
        setClazz(Club.class);
    }

    public Club getClubByName(String club_name) {
        return (Club) entityManager.createQuery("SElECT c FROM Club c WHERE c.club_name=:clubName")
                .setParameter("clubName", club_name)
                .getSingleResult();
    }
    public Club getClubByID(int id) {
        return (Club) entityManager.createQuery("SElECT cl FROM Club cl WHERE cl.club_id=:clubId")
                .setParameter("clubId", id)
                .getSingleResult();
    }

    public List<Player> getPlayersInClub(String name) {
        Club club = getClubByName(name);
        return club.getPlayerList();
    }
}
