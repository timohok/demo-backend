package app.service;

import app.RestApp;
import app.client.ClientProvider;
import app.resource.model.Team;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@ApplicationScoped
@Named
public class TeamServiceImpl extends BaseService implements TeamService {

    @Inject
    ClientProvider clientProvider;

    @Override
    public List<Team> getTeams() throws ServiceException {
        try {
            final String json = clientProvider.get("https://api.opendota.com/api/teams");
            List<Team> teams = RestApp.getMapper().readValue(json, new TypeReference<List<Team>>() {
            });
            return teams;
        } catch (Exception e) {
            log.error("getTeams failed", e);
            throw new ServiceException("getTeams failed [" + e.getMessage() + "]");
        }
    }
}
