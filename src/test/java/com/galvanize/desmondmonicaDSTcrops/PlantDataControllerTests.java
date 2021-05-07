package com.galvanize.desmondmonicaDSTcrops;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

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
        plantDataList.add(new PlantData("Carrot Plant"));
    }

    @Test
    void findAllPlants_ReturnsAllPlantData() throws Exception {
        when(plantDataService.findAllPlants()).thenReturn(plantDataList);
        mockMvc.perform(MockMvcRequestBuilders.get("/plants"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Carrot Plant"));
    }
}
