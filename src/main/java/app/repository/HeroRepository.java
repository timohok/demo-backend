package app.repository;

import app.resource.Hero;
import app.service.HeroService;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryV2;
import io.crnk.core.resource.list.DefaultResourceList;
import io.crnk.core.resource.list.ResourceList;

import javax.enterprise.inject.spi.CDI;
import java.util.ArrayList;
import java.util.List;

public class HeroRepository implements ResourceRepositoryV2<Hero, String> {

  @Override
  public Class<Hero> getResourceClass() {
    return Hero.class;
  }

  @Override
  public Hero findOne(String id, QuerySpec querySpec) {
    Hero hero = null;
    try {
      hero = (CDI.current().select(HeroService.class).get().getHero(id));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return hero;
  }

  @Override
  public ResourceList<Hero> findAll(QuerySpec querySpec) {
    List<Hero> heroes = new ArrayList<>();
    try {
      heroes.addAll((CDI.current().select(HeroService.class).get().getHeroes()));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new DefaultResourceList<>(heroes, null, null);
  }

  @Override
  public ResourceList<Hero> findAll(Iterable<String> iterable, QuerySpec querySpec) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public <S extends Hero> S save(S entity) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public <S extends Hero> S create(S s) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public void delete(String id) {
    throw new UnsupportedOperationException("Not implemented");
  }
}
