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

    public PlantData getById(int id) {
        for (PlantData plantData: this.myPlantDataList) {
            if (plantData.getId() == id) return plantData;
        }
        return null;
    }

    public PlantData updateById(int id, PlantData updatedPlantData) {
        for (PlantData plantData: this.myPlantDataList) {
            if (plantData.getId() == id) {
                int index = this.myPlantDataList.indexOf(plantData);
                this.myPlantDataList.set(index, updatedPlantData);
                return this.myPlantDataList.get(index);
            }
        }
        return null;
    }
}
