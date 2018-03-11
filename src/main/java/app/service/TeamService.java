package app.service;

import app.resource.model.Team;

import java.util.List;

public interface TeamService {

    /**
     * Get all teams
     *
     * @return
     * @throws ServiceException
     */
    List<Team> getTeams() throws ServiceException;
}
