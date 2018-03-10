package app.service;

import app.resource.model.Team;

import java.io.IOException;
import java.util.List;

public interface TeamService {

  List<Team> getTeams() throws IOException;
}
