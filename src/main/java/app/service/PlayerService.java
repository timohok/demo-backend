package app.service;

import app.resource.model.Player;

import java.util.List;

public interface PlayerService {

    /**
     * Get player by id
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    Player getPlayer(Long id) throws ServiceException;

    /**
     * Get player by team id
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    List<Player> getPlayersByTeamId(Long id) throws ServiceException;

}
