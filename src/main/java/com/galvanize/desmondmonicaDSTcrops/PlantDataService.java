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

    public PlantData deleteById(int id) {
        for (int i = 0; i < this.myPlantDataList.size(); i += 1) {
            if (this.myPlantDataList.get(i).id == id) {
                PlantData plantData = this.myPlantDataList.get(i);
                this.myPlantDataList.remove(i);
                return plantData;
            };
        }
        return null;
    }
}
