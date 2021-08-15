package com.billqk.ordersystem;

import com.billqk.ordersystem.model.MenuDto;
import com.billqk.ordersystem.model.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.assertEquals;


public class IntegratedTest extends AbstractTest  {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void CreateUser() throws Exception {
        String uri = "/api/user/";
        UserDto userDto = new UserDto();
        userDto.setAge(19);
        userDto.setEmail("123@gmail.com");
        userDto.setFirstname("hello");
        userDto.setLastname("World");

        String inputJson = super.mapToJson(userDto);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201,status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "User added");
    }

    @Test
    public void CreateOrder() throws Exception {
        String uri = "/api/menu/";
        MenuDto menuDto = new MenuDto(); 
    }


}
