package app.service;

import app.resource.Player;

import java.io.IOException;
import java.util.List;

public interface PlayerService {

  Player getPlayer(Long id) throws IOException;

  List<Player> getPlayersByTeamId(Long id) throws Exception;

}
