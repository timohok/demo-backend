package app.repository;

import app.resource.model.Hero;
import app.resource.model.Player;
import app.service.HeroService;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.RelationshipRepositoryV2;
import io.crnk.core.resource.list.DefaultResourceList;
import io.crnk.core.resource.list.ResourceList;

import javax.enterprise.inject.spi.CDI;
import java.util.ArrayList;
import java.util.List;

public class PlayerToHeroRepository implements RelationshipRepositoryV2<Player, String, Hero, Long> {

    @Override
    public Class<Player> getSourceResourceClass() {
        return Player.class;
    }

    @Override
    public Class<Hero> getTargetResourceClass() {
        return Hero.class;
    }

    @Override
    public void setRelation(Player player, Long aLong, String s) {

    }

    @Override
    public void setRelations(Player player, Iterable<Long> iterable, String s) {

    }

    @Override
    public void addRelations(Player player, Iterable<Long> iterable, String s) {

    }

    @Override
    public void removeRelations(Player player, Iterable<Long> iterable, String s) {

    }

    @Override
    public Hero findOneTarget(String s, String s2, QuerySpec querySpec) {
        return null;
    }

    @Override
    public ResourceList<Hero> findManyTargets(String s, String s2, QuerySpec querySpec) {
        List<Hero> heroes = new ArrayList<>();
        try {
            heroes.addAll(CDI.current().select(HeroService.class).get().getHeroesByPlayerId(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DefaultResourceList<>(heroes, null, null);
    }
}
