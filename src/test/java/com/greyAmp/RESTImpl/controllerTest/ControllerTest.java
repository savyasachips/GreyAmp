package com.greyAmp.RESTImpl.controllerTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greyAmp.RESTImpl.controller.MainController;
import com.greyAmp.RESTImpl.model.GreyAmpTable;
import com.greyAmp.RESTImpl.service.MainService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(value = ControllerTest.class)
public class ControllerTest {

    @MockBean
    MainController mainController;

    @MockBean
    MainService mainService;

    @Autowired
    MockMvc mockMvc;


    @Before
    public static GreyAmpTable createNew(){
        GreyAmpTable g = new GreyAmpTable();
        g.setEntityId(1);
        g.setEntityName("New user");
        g.setPrice(100);
        g.setStatus(2);
        return g;
    }

    @Test
    public void testCreate() throws Exception {
        GreyAmpTable test = ControllerTest.createNew();
        //Mockito.when(mainController.addNew(test)).thenReturn(test);
        ObjectMapper map = new ObjectMapper();
        byte[] input = map.writeValueAsString(test).getBytes();
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/new")
                .accept(MediaType.APPLICATION_JSON).content(input).contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

    }
    
    
}
