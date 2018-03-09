package app.repository;

import app.resource.Team;
import app.service.TeamService;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryV2;
import io.crnk.core.resource.list.DefaultResourceList;
import io.crnk.core.resource.list.ResourceList;

import javax.enterprise.inject.spi.CDI;
import java.util.ArrayList;
import java.util.List;

public class TeamRepository implements ResourceRepositoryV2<Team, Long> {

  @Override
  public Class<Team> getResourceClass() {
    return Team.class;
  }

  @Override
  public Team findOne(Long aLong, QuerySpec querySpec) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public ResourceList<Team> findAll(QuerySpec querySpec) {
    List<Team> teams = new ArrayList<>();
    try {
      teams.addAll((CDI.current().select(TeamService.class).get().getTeams()));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new DefaultResourceList<>(querySpec.apply(teams), null, null);
  }

  @Override
  public ResourceList<Team> findAll(Iterable<Long> iterable, QuerySpec querySpec) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public void delete(Long aLong) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public <S extends Team> S create(S s) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public <S extends Team> S save(S s) {
    throw new UnsupportedOperationException("Not implemented");
  }
}
