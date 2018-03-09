package app.service;

import app.resource.Hero;

import java.io.IOException;
import java.util.List;

public interface HeroService {

  Hero getHero(String id) throws IOException;

  List<Hero> getHeroes() throws IOException;

  List<Hero> getHeroesByPlayerId(String playerId) throws IOException;

}
