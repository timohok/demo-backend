package app.service;

import app.resource.model.Hero;

import java.util.List;

public interface HeroService {

    /**
     * Get hero by id
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    Hero getHero(String id) throws ServiceException;

    /**
     * Get all heroes
     *
     * @return
     * @throws ServiceException
     */
    List<Hero> getHeroes() throws ServiceException;

    /**
     * Get heroes by player id
     *
     * @param playerId
     * @return
     * @throws ServiceException
     */
    List<Hero> getHeroesByPlayerId(String playerId) throws ServiceException;
}
