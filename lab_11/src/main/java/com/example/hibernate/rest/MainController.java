package com.example.hibernate.rest;

import com.example.hibernate.dao.PlayerDAO;
import com.example.hibernate.dao.ClubDAO;
import com.example.hibernate.entity.Player;
import com.example.hibernate.entity.Club;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class MainController {

    private final PlayerDAO playerDAO;

    private final ClubDAO clubDAO;

    @Autowired
    public MainController(PlayerDAO playerDAO, ClubDAO clubDAO) {
        this.playerDAO = playerDAO;
        this.clubDAO =clubDAO;
    }

    @RequestMapping(value = "/player/add", method = RequestMethod.POST)
    public void addPlayer(@RequestParam(value = "player_name") String player_name, @RequestParam(value = "player_lastname") String player_lastname, @RequestParam(value = "email") String email) {
        playerDAO.create(new Player(player_name, player_lastname, email));
    }

    @RequestMapping(value = "/player/{id}", method = RequestMethod.GET)
    public Player getPlayer(@PathVariable(value = "id") int player_id) {
        try {
            System.out.println(playerDAO.getPlayerByID(player_id));
            return playerDAO.getPlayerByID(player_id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    @RequestMapping(value = "/player/{id}/club", method = RequestMethod.GET)
    public List getPlayerClubs(@PathVariable(value = "id") int player_id) {
        System.out.println(playerDAO.getClubsByplayer(player_id));
        return playerDAO.getClubsByplayer(player_id);
    }

    @RequestMapping(value = "/player/{id}", method = RequestMethod.DELETE)
    public void removePlayer(@PathVariable(value = "id") int player_id) {
        try {
            Player player = playerDAO.getPlayerByID(player_id);
            playerDAO.delete(player);
        } catch (NoResultException e) {

        }

    }

    @RequestMapping(value = "/player/all", method = RequestMethod.DELETE)
    public void removeAllPlayers() {
        List<Player> list = playerDAO.findAll();
        for (Player p : list) {
            playerDAO.delete(p);
        }
    }

    @RequestMapping(value = "/club/add", method = RequestMethod.POST)
    public void addClub(@RequestParam(value = "club") String name) {
        clubDAO.create(new Club(name));

    }
    /*@RequestMapping(value = "/club/{club_name}", method = RequestMethod.GET)
    public Club getClub(@PathVariable(value = "club_name") String name) {
        try {
            System.out.println(clubDAO.getClubByName(name));
            return clubDAO.getClubByName(name);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }*/
   /*@RequestMapping(value = "/club/{id}", method = RequestMethod.DELETE)
    public void removeClub(@RequestParam(value = "id") int club_id) {
        Club cl = clubDAO.getClubByID(club_id);
       clubDAO.delete(cl);
    }*/
  /*  @RequestMapping(value = "/club/{name}", method = RequestMethod.DELETE)
    public void removeClub(@RequestParam(value = "name") String name) {
        Club c = clubDAO.getClubByName(name);
        clubDAO.delete(c);
    }*/

    @RequestMapping(value = "/club/all", method = RequestMethod.DELETE)
    public void removeAllClubs() {
        List<Club> ClubList = clubDAO.findAll();
        for (Club c : ClubList) {
            clubDAO.delete(c);
        }
    }

    @RequestMapping(value = "/club/{club}/add/{player}", method = RequestMethod.POST)
    public void addPlayerToClub(@PathVariable(value = "club") String club, @PathVariable(value = "player") int pid) {
        Club c = clubDAO.getClubByName(club);
        Player p = playerDAO.getPlayerByID(pid);
        c.getPlayerList().add(p);
        clubDAO.update(c);
    }

    @RequestMapping(value = "/club/{club}/remove/{player}", method = RequestMethod.POST)
    public void removePlayerFromClub(@PathVariable(value = "club") String club, @PathVariable(value = "player") int id) {
        Club c = clubDAO.getClubByName(club);
        Player p = playerDAO.getPlayerByID(id);
        c.getPlayerList().remove(p);
        clubDAO.update(c);
    }




}
