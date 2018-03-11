package app.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerDetails {

    @JsonProperty("solo_competitive_rank")
    private String mmr;

    public String getMmr() {
        return mmr;
    }

    public void setMmr(String mmr) {
        this.mmr = mmr;
    }
}
