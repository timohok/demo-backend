package app.repository;

import app.JsonApiException;
import app.resource.model.Player;
import app.service.PlayerService;
import app.service.ServiceException;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryV2;
import io.crnk.core.resource.list.ResourceList;

import javax.enterprise.inject.spi.CDI;
import javax.ws.rs.core.Response;

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
        } catch (ServiceException e) {
            throw new JsonApiException(Response.Status.NOT_FOUND.getStatusCode(), "1", "Fetching player failed", "Error occurred when fetching player with ID = " + id);
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
