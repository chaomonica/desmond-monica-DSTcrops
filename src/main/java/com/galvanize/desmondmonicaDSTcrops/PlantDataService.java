package com.galvanize.desmondmonicaDSTcrops;

import java.util.ArrayList;
import java.util.List;

public class PlantDataService {
    List<PlantData> myPlantDataList = new ArrayList<>();

    public Object findAllPlants() {
        return null;
    }

    public PlantData addPlant(PlantData plantData){
        myPlantDataList.add(plantData);
        return null;
    }
}
