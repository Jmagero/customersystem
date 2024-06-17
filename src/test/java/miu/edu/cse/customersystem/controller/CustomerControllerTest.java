//package miu.edu.cse.customersystem.controller;
//
//import com.google.gson.Gson;
//import miu.edu.cse.customersystem.dto.CustomerResponseDto;
//import miu.edu.cse.customersystem.model.Customer;
//import miu.edu.cse.customersystem.model.Order;
//import miu.edu.cse.customersystem.model.Product;
//import miu.edu.cse.customersystem.repository.CustomerRepository;
//import miu.edu.cse.customersystem.service.customer.CustomerService;
//import org.apache.logging.log4j.message.StringFormattedMessage;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.json.GsonTester;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//@WebMvcTest(CustomerController.class)
//class CustomerControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private CustomerService customerService;
//
//    @Test
//    void findCustomer() throws Exception {
//        Customer customer = new Customer();
//        customer.setId(1L);
//        customer.setName("Nick");
//        Order order = new Order();
//        order.setCustomer(customer);
//        order.setOrderDate(LocalDate.now());
//        order.setProducts(Arrays.asList(new Product(
//                "Apple", BigDecimal.valueOf(100)
//        )));
//        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
//        customerResponseDto.setId(1L);
//        customerResponseDto.setName("Nick");
//        customerResponseDto.setOrders(Arrays.asList(order));
//
//        Mockito.when(customerService.getCustomer(1L))
//                .thenReturn( Optional.of(customerResponseDto));
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/api/v1/customers")
//                        .contentType("application/json")
//                        .content(new Gson().toJson(customerResponseDto))
//                )
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//
//
//    }
//}