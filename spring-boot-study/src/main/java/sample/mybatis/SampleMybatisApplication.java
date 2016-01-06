package sample.mybatis;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sample.mybatis.mapper.CityMapper;


@SpringBootApplication
public class SampleMybatisApplication implements CommandLineRunner {
    
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(SampleMybatisApplication.class);

    @Autowired
    private CityMapper cityMapper;
    
    public static void main(String[] args) {
        
        SpringApplication.run(SampleMybatisApplication.class, args);
    }

    public void run(String... args) throws Exception {
//        logger.info("Enter into run of CommandLineRunner");
//        
//        Arrays.asList(args).forEach(System.out::println);
        System.out.println(this.cityMapper.selectCityById(1));
    }
}
