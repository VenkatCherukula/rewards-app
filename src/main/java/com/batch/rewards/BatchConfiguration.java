/**
 * 
 */
package com.batch.rewards;

import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import com.batch.rewards.processor.RewardsProcessor;
import com.batch.rewards.writer.RewardsWriter;

/**
 * Batch configuration class.
 *
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration extends DefaultBatchConfigurer{
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
    @Override
    public void setDataSource(DataSource dataSource) {
        //This BatchConfigurer ignores any DataSource
    }
    

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	@StepScope
	public FlatFileItemReader<PurchaseItem> reader() 
	{
			System.out.println("Inside reader() ");

			//Create reader instance
	        FlatFileItemReader<PurchaseItem> reader = new FlatFileItemReader<>();
	         
	        //Set input file location
	        reader.setResource(new ClassPathResource("test-file.csv"));
	        reader.setName("test-file");

	        //Set number of lines to skips. Use it if file has header rows.
	        reader.setLinesToSkip(1);   
	         
	        //Configure how each line will be parsed and mapped to different values
	        reader.setLineMapper(new DefaultLineMapper() {
	            {
	                //3 columns in each row
	                setLineTokenizer(new DelimitedLineTokenizer() {
	                    {
	                        setNames(new String[] {"customerID", "customerNa", "itemID",  "itemName", "quantity", "price", "date",
	                       	  "rewards" });
	                    }
	                });
	                //Set values in Employee class
	                setFieldSetMapper(new BeanWrapperFieldSetMapper<PurchaseItem>() {
	                    {
	                        setTargetType(PurchaseItem.class);
	                    }
	                });
	            }
	        });
	        return reader;
	}
	
	@Bean
	public RewardsProcessor processor() {
		return new RewardsProcessor();
	}
	
	@Bean 
	public RewardsWriter writer() {
		return new RewardsWriter();
	}
	
	
	@Bean
	public Job job(Step step1) {
	  return jobBuilderFactory.get("importUserJob")
	    .incrementer(new RunIdIncrementer())
	    .flow(this.step1())
	    .end()
	    .build();
	}

	@Bean
	public Step step1() {
	  return stepBuilderFactory.get("step1")
	    .<PurchaseItem, PurchaseItem> chunk(50)
	    .reader(this.reader())
	    .processor(this.processor())
	    .writer(this.writer())
	    .build();
	}
	
}
