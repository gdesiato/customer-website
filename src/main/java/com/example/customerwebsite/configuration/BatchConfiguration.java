package com.example.customerwebsite.configuration;

import com.example.customerwebsite.model.Customer;
import com.example.customerwebsite.repositories.CustomerRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.item.Chunk;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

//    @Bean
//    public Job job(JobBuilderFactory jobBuilderFactory, Step nameStep, Step designationStep) {
//        return jobBuilderFactory.get("customer-loader-job")
//                .incrementer(new RunIdIncrementer())
//                .start(nameStep)
//                .next(designationStep)
//                .build();
//    }
//
//    @Bean
//    public Step nameStep(StepBuilderFactory stepBuilderFactory, ItemReader<Customer> csvReader,
//                         NameProcessor processor, EmployeeWriter writer) {
//        // This step just reads the csv file and then writes the entries into the database
//        return stepBuilderFactory.get("name-step")
//                .<Customer, Customer>chunk(250)
//                .reader(csvReader)      // EXTRACT
//                .processor(processor)   // TRANSFORM
//                .writer(writer)         // LOAD
//                .build();
//    }
//
//    @Bean
//    public Step designationStep(StepBuilderFactory stepBuilderFactory, ItemReader<Customer> repositoryReader,
//                                DesignationProcessor processor, EmployeeWriter writer) {
//        // This step reads the data from the database and then converts the designation into the matching Enums.
//        return stepBuilderFactory.get("designation-step")
//                .<Customer, Customer>chunk(250)
//                .reader(repositoryReader)   // EXTRACT
//                .processor(processor)       // TRANSFORM
//                .writer(writer)             // LOAD
////           ---     .faultTolerant()
////           ---     .skipLimit(10)
////           ---     .skip(Exception.class)
//                .build();
//    }
//
//    @Bean
//    public FlatFileItemReader<Customer> csvReader(@Value("${inputFile}") String inputFile) {
//        return new FlatFileItemReaderBuilder<Customer>()
//                .name("csv-reader")
//                .resource(new ClassPathResource(inputFile))
//                .delimited()
//                .names("id", "name", "designation")
//                .linesToSkip(1)
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{setTargetType(Customer.class);}})
//                .build();
//    }
//
//    @Bean
//    public RepositoryItemReader<Customer> repositoryReader(CustomerRepository customerRepository) {
//        return new RepositoryItemReaderBuilder<Customer>()
//                .repository(customerRepository)
//                .methodName("findAll")
//                .sorts(Map.of("id", Sort.Direction.ASC))
//                .name("repository-reader")
//                .build();
//    }
//
//    @Component
//    public static class NameProcessor implements ItemProcessor<Customer, Customer> {
//        // This helps you to process the names of the employee at a set time
//        @Override
//        public Customer process(Customer customer) {
//            customer.setFullName(customer.getFullName().toUpperCase());
//            return customer;
//        }
//    }
//
//    @Component
//    public static class DesignationProcessor implements ItemProcessor<Customer, Customer> {
//        // This helps you to convert the designations of the employees into the Enum you defined earlier
//        @Override
//        public Customer process(Customer customer) {
////            customer.setDesignation(Designation.getByCode(employee.getDesignation()).getTitle());
////            employee.setDesignationUpdatedAt(new Date());
//            return customer;
//        }
//    }
//
//
//    @Component
//    public static class EmployeeWriter implements ItemWriter<Customer> {
//
//        @Autowired
//        private CustomerRepository customerRepository;
//
//        @Value("${sleepTime}")
//        private Integer SLEEP_TIME;
//
//        @Override
//        public void write(List<? extends Customer> employees) throws Exception {
//            customerRepository.saveAll(employees);
//            Thread.sleep(SLEEP_TIME);
//            System.out.println("Saved employees: " + employees);
//        }

//    }
}
