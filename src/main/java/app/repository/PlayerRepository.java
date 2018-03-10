package app.repository;

import app.resource.model.Player;
import app.service.PlayerService;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryV2;
import io.crnk.core.resource.list.ResourceList;

import javax.enterprise.inject.spi.CDI;

public class PlayerRepository implements ResourceRepositoryV2<Player, Long> {

  @Override
  public Class<Player> getResourceClass() {
    return Player.class;
  }

  @Override
  public Player findOne(Long id, QuerySpec querySpec) {
    Player player = null;
    try {
      player = (CDI.current().select(PlayerService.class).get().getPlayer(id));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return player;
  }

  @Override
  public ResourceList<Player> findAll(QuerySpec querySpec) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public ResourceList<Player> findAll(Iterable<Long> iterable, QuerySpec querySpec) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public void delete(Long aLong) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public <S extends Player> S create(S s) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public <S extends Player> S save(S s) {
    throw new UnsupportedOperationException("Not implemented");
  }
}
