package com.sdu.spittr;

import com.sdu.spittr.bean.Spittle;
import com.sdu.spittr.controller.SpitterController;
import com.sdu.spittr.controller.SpittleController;
import com.sdu.spittr.service.SpitterService;
import com.sdu.spittr.service.SpittleService;
import com.sdu.spittr.controller.HomeController;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by J on 2017/1/10.
 */
public class test {

    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc =
                MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/homepage"))
                .andExpect(MockMvcResultMatchers.view().name("home"));
    }

    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles = new ArrayList<Spittle>();
        for(int i=0;i<count;i++){
            spittles.add(new Spittle("Spittle" + i,new Date()));
        }
        return spittles;
    }
    @Test
    public void testShowRecentSpittle()throws Exception{
        List<Spittle> expectedSpittles = createSpittleList(20);
//        SpittleService mockServiceImp = EasyMock.createMock(SpittleService.class);
//        EasyMock.expect(mockServiceImp.findSpittles(Long.MAX_VALUE,20)).andReturn(expectedSpittles);

        SpittleService mockServiceImp = Mockito.mock(SpittleService.class);
        Mockito.when(mockServiceImp.findRecent(20)).thenReturn(expectedSpittles);

        SpittleController spittleController = new SpittleController(mockServiceImp);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spittleController).setSingleView(
                new InternalResourceView("/WEB-INF/views/spittles.jsp")
        ).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittles")).
                andExpect(MockMvcResultMatchers.view().name("spittles")).
                andExpect(MockMvcResultMatchers.model().attributeExists("spittleList")).
                andExpect(MockMvcResultMatchers.model().attribute("spittleList",
                        IsCollectionContaining.hasItems(expectedSpittles.toArray())));

    }

    @Test
    public void testShowRecentSpittle2()throws Exception{
        List<Spittle> expectedSpittles = createSpittleList(50);

        SpittleService mockServiceImp = Mockito.mock(SpittleService.class);
        Mockito.when(mockServiceImp.findRecent(20)).thenReturn(expectedSpittles);

        SpittleController spittleController = new SpittleController(mockServiceImp);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spittleController).setSingleView(
                new InternalResourceView("/WEB-INF/views/spittles.jsp")
        ).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittles?count=20")).
                andExpect(MockMvcResultMatchers.view().name("spittles")).
                andExpect(MockMvcResultMatchers.model().attributeExists("spittleList")).
                andExpect(MockMvcResultMatchers.model().attribute("spittleList",
                        IsCollectionContaining.hasItems(expectedSpittles.toArray())));

    }
    @Test
    public void testSpittle() throws Exception {
        Spittle expectedSpittle = new Spittle("spittle", new Date());

        SpittleService mockServiceImp = Mockito.mock(SpittleService.class);
        Mockito.when(mockServiceImp.findOne(12345)).thenReturn(expectedSpittle);

        SpittleController spittleController = new SpittleController(mockServiceImp);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spittleController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittles/12345")).
                andExpect(MockMvcResultMatchers.view().name("spittle")).
                andExpect(MockMvcResultMatchers.model().attributeExists("spittle")).
                andExpect(MockMvcResultMatchers.model().attribute("spittle",expectedSpittle));

    }

    @Test
    public void testShowRegisterFrom() throws Exception {

        SpitterService mockServiceImp = Mockito.mock(SpitterService.class);

        SpitterController spitterController = new SpitterController(mockServiceImp);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spitterController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register")).
                andExpect(MockMvcResultMatchers.view().name("registerForm"));


    }


}
