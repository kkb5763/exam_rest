package membership.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import membership.domain.Membership;
import membership.service.MembershipService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(MembershipController.class)
public class MembershipControllerTest {

    @MockBean
    private MembershipService membershipService;

    @Autowired
    private MockMvc mvc;

    private JacksonTester<Membership> json;
    @Before
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void getUrlSuccTest() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                get("/api/v1/memberShip")
                        .accept(MediaType.APPLICATION_JSON_VALUE).header("X-USER-ID","test9"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    @Test
    public void postUrlSuccTest() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                post("/api/v1/memberShip").accept(MediaType.APPLICATION_JSON_VALUE).header("X-USER-ID","test9"))

                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
    @Test
    public void getContentTypeFailTest() throws Exception {

        MockHttpServletResponse response = mvc.perform(
                get("/api/v1/memberShip")
                        .accept(MediaType.APPLICATION_ATOM_XML))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void getHeaderFailTest() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                get("/api/v1/membeqrShip")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void getdateFailTest() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                get("/api/v1/memberShip")
                        .accept(MediaType.APPLICATION_JSON_VALUE).header("X-fail-ID","test9"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //###errer desc###
        //Missing request header 'X-USER-ID' for method parameter of type String
        //org.springframework.web.bind.MissingRequestHeaderException: Missing request header 'X-USER-ID' for method parameter of type String
    }
    @Test
    public void ddddddd() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                get("/api/v1/memberShip")
                        .accept(MediaType.APPLICATION_JSON_VALUE).header("X-fail-ID","test9"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //###errer desc###
        //Missing request header 'X-USER-ID' for method parameter of type String
        //org.springframework.web.bind.MissingRequestHeaderException: Missing request header 'X-USER-ID' for method parameter of type String
    }

}
