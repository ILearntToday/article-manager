package com.iLearntToday.blogManagerService.blogmanager;


import com.iLearntToday.blogManagerService.blogmanager.controller.BlogManagerController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith (SpringRunner.class) @WebMvcTest (value = BlogManagerController.class, secure = false) public class BlogManagerControllerTest
{

    @Autowired private MockMvc mockMvc;


    @Test public void testGetCall() throws Exception
    {
        this.mockMvc.perform( get( "http://localhost:8080/blogdetails/v1/getblogs/1" ).accept( MediaType.ALL ) )
            .andExpect( status().is( 200 ) );
    }


}
