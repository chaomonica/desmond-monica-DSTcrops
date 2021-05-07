package com.galvanize.desmondmonicaDSTcrops;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlantDataServiceTest {
    PlantDataService plantDataService;

    @BeforeEach
    void setUp() {
        plantDataService = new PlantDataService();
        PlantData plant = new PlantData("Carrot Plant");
        plantDataService.myPlantDataList.add(plant);
    }

    @Test
    void plantDataServiceHasField_myPlantDataList() {
        assertNotNull(plantDataService.myPlantDataList);
    }

}
