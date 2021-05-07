package com.galvanize.desmondmonicaDSTcrops;

public class PlantData {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSeasons() {
        return seasons;
    }

    public void setSeasons(String[] seasons) {
        this.seasons = seasons;
    }

    public String getSeedName() {
        return seedName;
    }

    public void setSeedName(String seedName) {
        this.seedName = seedName;
    }

    String name;
    String[] seasons;
    String seedName;

    public PlantData() {
    }

    public PlantData(String name, String seedName, String[] seasons, int id) {
        this.id = id;
        this.name = name;
        this.seasons = seasons;
        this.seedName = seedName;
    }
}
