package com.galvanize.desmondmonicaDSTcrops;

import org.springframework.web.bind.annotation.*;

@RestController
public class PlantDataController {
    PlantDataService plantDataService;

    public PlantDataController(PlantDataService plantDataService){
        this.plantDataService = plantDataService;
    }

    @GetMapping("/plants")
    public String returnPlants() {
        return "Carrot Plant";
    }

    @PostMapping("/plants")
    public PlantData addToPlants(@RequestBody PlantData plantData){

        return plantDataService.addPlant(plantData);
    }

    @GetMapping("/plants/{plantId}")
    public PlantData getPlantById(@PathVariable int plantId) {
        return plantDataService.getById(plantId);
    }

    @PutMapping("/plants/{plantId}")
    public PlantData updatePlantById(@PathVariable int plantId, @RequestBody PlantData plantData){
        return plantDataService.updateById(plantId, plantData);
    }
}
