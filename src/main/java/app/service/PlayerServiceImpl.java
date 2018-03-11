package app.service;

import app.RestApp;
import app.client.ClientProvider;
import app.resource.PlayerDetails;
import app.resource.model.Player;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerServiceImpl extends BaseService implements PlayerService {

    public static final String API_ENDPOINT_PLAYERS = "https://api.opendota.com/api/teams/%s/players";
    public static final String API_ENDPOINT_PLAYER_DETAILS = "https://api.opendota.com/api/players/%s";

    @Inject
    ClientProvider clientProvider;

    @Override
    public Player getPlayer(Long id) throws ServiceException {
        throw new ServiceException("Not implemented");
    }

    @Override
    public List<Player> getPlayersByTeamId(Long teamId) throws ServiceException {
        try {
            final String json =
                    clientProvider.get(String.format(API_ENDPOINT_PLAYERS, teamId));
            List<Player> players =
                    (RestApp.getMapper().readValue(json, new TypeReference<List<Player>>() {
                    }));
            players =
                    players
                            .stream()
                            .filter(p -> Boolean.TRUE.equals(p.getCurrentTeamMember()))
                            .collect(Collectors.toList());
            for (Player p : players) {
                final String detailsJson =
                        clientProvider.get(
                                String.format(API_ENDPOINT_PLAYER_DETAILS, p.getAccountId()));
                PlayerDetails details =
                        (RestApp.getMapper().readValue(detailsJson, PlayerDetails.class));
                p.setDetails(details);
            }
            return players;
        } catch (Exception e) {
            log.error("getPlayersByTeamId failed", e);
            throw new ServiceException("getPlayersByTeamId failed [" + e.getMessage() + "]");
        }
    }
}
