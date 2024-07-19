package com.dellux.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.dellux.listener.JobMonitoringListener;
import com.dellux.model.ExamResult;
import com.dellux.processor.ExamResultItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	private JobBuilderFactory jobFactory;
	
	@Autowired
	private StepBuilderFactory stepFactory;
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private JobMonitoringListener listener;
	
	@Autowired
	private ExamResultItemProcessor processor;
	
	@Bean(name="jcir")
	public JdbcCursorItemReader<ExamResult> createReader(){
		
		return new JdbcCursorItemReaderBuilder<ExamResult>()
				.name("reader")
				.dataSource(ds)
				.sql("SELECT ID,DOB,SEMESTER,PERCENTAGE FROM EXAM_RESULT1")
				.beanRowMapper(ExamResult.class)
				.build();
	}
	
	@Bean(name="ffiw")
	public FlatFileItemWriter<ExamResult> createWriter(){
		return new FlatFileItemWriterBuilder<ExamResult>()
				.name("writer")
				.resource(new FileSystemResource("TopBrains.csv"))
				.lineSeparator("\r\n")
				.delimited().delimiter(",")
				.names("id","dob","semester","percentage")
				.build();
				
	}
	@Bean(name = "step1")
	public Step createStep1() {
		System.out.println("BatchConfig.createStep1()");
		return stepFactory.get("step1")
				.<ExamResult, ExamResult>chunk(100)
				.reader(createReader())
				.writer(createWriter())
				.processor(processor)
				.build();
	}

	@Bean(name = "job1")
	public Job createJob1() {
		System.out.println("BatchConfig.createJob1()");
		return jobFactory.get("job1")
				.listener(listener)
				.incrementer(new RunIdIncrementer())
				.start(createStep1())
				.build();

	}

	
}
