package app.service;

import app.resource.Team;

import java.io.IOException;
import java.util.List;

public interface TeamService {

  List<Team> getTeams() throws IOException;
}
