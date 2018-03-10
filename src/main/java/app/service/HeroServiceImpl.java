package app.service;

import app.RestApp;
import app.client.ClientProvider;
import app.resource.HeroDetails;
import app.resource.model.Hero;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Named
public class HeroServiceImpl implements HeroService {

  @Inject ClientProvider clientProvider;

  @Override
  public Hero getHero(String id) throws IOException {
    return getHeroes().stream().findFirst().filter(h -> h.getId().equals(id)).get();
  }

  @Override
  public List<Hero> getHeroes() throws IOException {
    final String json = clientProvider.get("https://api.opendota.com/api/heroes");
    List<Hero> heroes = RestApp.getMapper().readValue(json, new TypeReference<List<Hero>>() {});
    return heroes;
  }

  @Override
  public List<Hero> getHeroesByPlayerId(String playerId) throws IOException {
    List<Hero> allHeroes = getHeroes();
    List<Hero> resultHeroes = new ArrayList<>();
    final String json = clientProvider.get(String.format("https://api.opendota.com/api/players/%s/heroes", playerId));
    List<HeroDetails> heroDetails = RestApp.getMapper().readValue(json, new TypeReference<List<HeroDetails>>() {});
    for (Hero hero : allHeroes) {
      for (HeroDetails hd : heroDetails) {
        if (hero.getId().equals(hd.getId())) {
            hero.setHeroDetails(hd);
         resultHeroes.add(hero);
        }
      }
    }
    return resultHeroes;
  }

}
