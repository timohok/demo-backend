package app.service;

import app.RestApp;
import app.client.ClientProvider;
import app.resource.model.Player;
import app.resource.PlayerDetails;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerServiceImpl implements PlayerService {

  @Inject ClientProvider clientProvider;

  @Override
  public Player getPlayer(Long id) throws IOException {
    return null;
  }

  @Override
  public List<Player> getPlayersByTeamId(Long teamId) throws IOException {
    final String json = clientProvider.get(String.format("https://api.opendota.com/api/teams/%s/players", teamId));
    List<Player> players = (RestApp.getMapper().readValue(json, new TypeReference<List<Player>>() {}));
    players = players.stream().filter(p -> Boolean.TRUE.equals(p.getCurrentTeamMember())).collect(Collectors.toList());
    players.forEach(p -> {
        try {
        final String detailsJson = clientProvider.get(String.format("https://api.opendota.com/api/players/%s", p.getAccountId()));
            PlayerDetails details = (RestApp.getMapper().readValue(detailsJson, PlayerDetails.class));
            p.setDetails(details);
        } catch (IOException e) {
            e.printStackTrace();
        }
    });
    return players;
  }
}
