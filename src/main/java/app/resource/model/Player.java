package app.resource.model;

import app.resource.PlayerDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelation;
import io.crnk.core.resource.annotations.JsonApiResource;
import io.crnk.core.resource.annotations.LookupIncludeBehavior;

import java.util.ArrayList;
import java.util.List;

@JsonApiResource(type = "players")
public class Player {

    @JsonApiRelation(lookUp = LookupIncludeBehavior.AUTOMATICALLY_WHEN_NULL)
    public List<Hero> heroes = new ArrayList<>();
    @JsonApiId
    @JsonProperty("account_id")
    private String accountId;
    private String name;
    @JsonProperty("is_current_team_member")
    private Boolean currentTeamMember;
    private PlayerDetails details;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCurrentTeamMember() {
        return currentTeamMember;
    }

    public void setCurrentTeamMember(Boolean currentTeamMember) {
        this.currentTeamMember = currentTeamMember;
    }

    public PlayerDetails getDetails() {
        return details;
    }

    public void setDetails(PlayerDetails details) {
        this.details = details;
    }
}
