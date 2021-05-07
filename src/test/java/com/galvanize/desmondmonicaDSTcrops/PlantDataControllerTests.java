package com.galvanize.desmondmonicaDSTcrops;

import net.minidev.json.writer.JsonReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@WebMvcTest
public class PlantDataControllerTests {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    PlantDataService plantDataService;

    List<PlantData> plantDataList;

    @BeforeEach
    void setUp() {
        plantDataList = new ArrayList<>();

        String[] seasons = {"autumn"};
        plantDataList.add(new PlantData("Carrot Plant", "Oblong Seed", seasons, 0 ));
    }

    @Test
    void findAllPlants_ReturnsAllPlantData() throws Exception {
        when(plantDataService.findAllPlants()).thenReturn(plantDataList);
        mockMvc.perform(MockMvcRequestBuilders.get("/plants"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)));
    }

    @Test
    void addPlant_addsAPlant() throws Exception {
        String[] seasons = {"autumn"};
        when(plantDataService.addPlant(any(PlantData.class))).thenReturn(new PlantData("Carrot Plant", "Oblong Seed", seasons, 0));
        mockMvc.perform(MockMvcRequestBuilders.post("/plants")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":0,\"name\":\"Carrot Plant\",\"seasons\":[\"autumn\"],\"seedName\":\"Oblong Seed\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("Carrot Plant"));

    }

    @Test
    void getPlantById() throws Exception {
        String[] seasons = {"spring", "summer"};
        PlantData actual = new PlantData("Got By Id Plant", "Oblong Seed", seasons, 1);
        when(plantDataService.getById(anyInt())).thenReturn(actual);
        mockMvc.perform(MockMvcRequestBuilders.get("/plants/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("Got By Id Plant"));
    }

    @Test
    void deletePlantById() throws Exception {
        String[] seasons = {"spring", "summer" };
        PlantData actual = new PlantData("Deleted", "Oblong Seed", seasons, 1);
        when(plantDataService.deleteById(anyInt())).thenReturn(actual);
        mockMvc.perform(MockMvcRequestBuilders.delete("/plants/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("Deleted"));
    }
    @Test
    void updatePlantById() throws Exception {
        String[] seasons = {"spring", "summer"};
        PlantData actual = new PlantData("Update By Id Plant", "Oblong Seed", seasons, 1);
        when(plantDataService.updateById(anyInt(), any(PlantData.class))).thenReturn(new PlantData("Has Been Updated!", "Oblong Seed", seasons, 1));

        mockMvc.perform(MockMvcRequestBuilders.put("/plants/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"Has Been Updated!\",\"seasons\":[\"spring, summer\"],\"seedName\":\"Oblong Seed\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("Has Been Updated!"));

    }

    @Test
    void getPlantsBySeason() throws Exception {
        String[] seasons = {"spring", "summer"};
        PlantData summerPlant1 = new PlantData("summerPlant1", "Oblong Seed", seasons, 1);
        PlantData summerPlant2 = new PlantData("summerPlant2", "Oblong Seed", seasons, 2);

        List<PlantData> summerPlants = new ArrayList<>();
        summerPlants.add(summerPlant1);
        summerPlants.add(summerPlant2);

        when(plantDataService.getPlantsBySeason(anyString())).thenReturn(summerPlants);
        mockMvc.perform(MockMvcRequestBuilders.get("/plants/findBySeason?season=summer"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }
}
