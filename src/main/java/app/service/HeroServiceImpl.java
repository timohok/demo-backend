package app.service;

import app.RestApp;
import app.client.ClientProvider;
import app.resource.HeroDetails;
import app.resource.model.Hero;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Named
public class HeroServiceImpl extends BaseService implements HeroService {

    @Inject
    ClientProvider clientProvider;

    @Override
    public Hero getHero(String id) throws ServiceException {
        return getHeroes().stream().findFirst().filter(h -> h.getId().equals(id)).get();
    }

    @Override
    public List<Hero> getHeroes() throws ServiceException {
        try {
            final String json = clientProvider.get("https://api.opendota.com/api/heroes");
            List<Hero> heroes = RestApp.getMapper().readValue(json, new TypeReference<List<Hero>>() {
            });
            return heroes;
        } catch (Exception e) {
            log.error("getHeroes failed", e);
            throw new ServiceException("getHeroes failed [" + e.getMessage() + "]");
        }
    }

    @Override
    public List<Hero> getHeroesByPlayerId(String playerId) throws ServiceException {
        try {
            List<Hero> allHeroes = getHeroes();
            List<Hero> resultHeroes = new ArrayList<>();
            final String json =
                    clientProvider.get(
                            String.format("https://api.opendota.com/api/players/%s/heroes", playerId));
            List<HeroDetails> heroDetails =
                    RestApp.getMapper().readValue(json, new TypeReference<List<HeroDetails>>() {
                    });
            allHeroes.forEach(hero -> {
                Optional<HeroDetails> details = heroDetails.stream().filter(d -> hero.getId().equals(d.getId())).findFirst();
                if (details.isPresent()) {
                    hero.setHeroDetails(details.get());
                    resultHeroes.add(hero);
                }
            });
            return resultHeroes;
        } catch (Exception e) {
            log.error("getHeroesByPlayerId failed", e);
            throw new ServiceException("getHeroesByPlayerId failed [" + e.getMessage() + "]");
        }
    }
}
