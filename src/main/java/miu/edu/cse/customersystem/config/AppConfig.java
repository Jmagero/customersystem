//package miu.edu.cse.customersystem.config;
//
//import miu.edu.cse.customersystem.dto.CustomerRequestDto;
//import miu.edu.cse.customersystem.dto.CustomerResponseDto;
//import miu.edu.cse.customersystem.model.Customer;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.PropertyMap;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AppConfig {
//    public ModelMapper modelMapper(){
//        ModelMapper modelMapper = new ModelMapper();
//
//        modelMapper.addMappings(
//                new PropertyMap<CustomerRequestDto, Customer>() {
//                    @Override
//                    protected void configure() {
//                        map().getName()
//                    }
//                }
//        )
//    }
//}
