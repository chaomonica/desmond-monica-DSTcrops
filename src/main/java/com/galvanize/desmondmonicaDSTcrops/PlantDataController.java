package com.galvanize.desmondmonicaDSTcrops;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlantDataController {
    PlantDataService plantDataService;

    public PlantDataController(PlantDataService plantDataService){
        this.plantDataService = plantDataService;
    }

    @GetMapping("/plants")
    public List<PlantData> returnPlants() {
        return plantDataService.findAllPlants();
    }

    @PostMapping("/plants")
    public PlantData addToPlants(@RequestBody PlantData plantData){

        return plantDataService.addPlant(plantData);
    }

    @GetMapping("/plants/{plantId}")
    public PlantData getPlantById(@PathVariable int plantId) {
        return plantDataService.getById(plantId);
    }


    @DeleteMapping("/plants/{plantId}")
    public PlantData deletePlantById(@PathVariable int plantId) {
        return plantDataService.deleteById(plantId);
    }

    @PutMapping("/plants/{plantId}")
    public PlantData updatePlantById(@PathVariable int plantId, @RequestBody PlantData plantData){
        return plantDataService.updateById(plantId, plantData);

    }

    @GetMapping("/plants/findBySeason")
    public List<PlantData> returnPlantsBySeason(@RequestParam String season) {
        return plantDataService.getPlantsBySeason(season);
    }
}
