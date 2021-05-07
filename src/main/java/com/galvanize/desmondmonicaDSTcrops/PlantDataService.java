package com.galvanize.desmondmonicaDSTcrops;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PlantDataService {
    List<PlantData> myPlantDataList = new ArrayList<>();

    public List<PlantData> findAllPlants() {

        return myPlantDataList;
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
            }
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

    public List<PlantData> getPlantsBySeason(String season){
        List<PlantData> result = new ArrayList<>();

        for (PlantData plantData: this.myPlantDataList) {
            if (Arrays.asList(plantData.seasons).contains(season)) {
                result.add(plantData);
            }
        }
        return result;
    }
}
