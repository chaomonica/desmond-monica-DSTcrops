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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
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
                .andExpect(MockMvcResultMatchers.content().string("Carrot Plant"));
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
}
