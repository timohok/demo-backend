package app.repository;

import app.resource.model.Player;
import app.resource.model.Team;
import app.service.PlayerService;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.RelationshipRepositoryV2;
import io.crnk.core.resource.list.DefaultResourceList;
import io.crnk.core.resource.list.ResourceList;

import javax.enterprise.inject.spi.CDI;
import java.util.ArrayList;
import java.util.List;

public class TeamToPlayerRepository implements RelationshipRepositoryV2<Team, Long, Player, Long> {

    @Override
    public Class<Team> getSourceResourceClass() {
        return Team.class;
    }

    @Override
    public Class<Player> getTargetResourceClass() {
        return Player.class;
    }

    @Override
    public void setRelation(Team team, Long aLong, String s) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void setRelations(Team team, Iterable<Long> iterable, String s) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void addRelations(Team team, Iterable<Long> iterable, String s) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void removeRelations(Team team, Iterable<Long> iterable, String s) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Player findOneTarget(Long aLong, String s, QuerySpec querySpec) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public ResourceList<Player> findManyTargets(Long teamId, String s, QuerySpec querySpec) {
        List<Player> players = new ArrayList<>();
        try {
            players.addAll(CDI.current().select(PlayerService.class).get().getPlayersByTeamId(teamId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DefaultResourceList<>(players, null, null);
    }

}
