/**
 * 
 */
package com.way2learnonline.batch;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;



public class ProductJdbcItemWriter implements ItemWriter<Product> {
	
	private static final String INSERT_PRODUCT = "insert into product (id,name,description,price) values(?,?,?,?)";
	
	private static final String UPDATE_PRODUCT = "update product set name=?, description=?, price=? where id = ?";
	
	private JdbcTemplate jdbcTemplate;
	
	
	public ProductJdbcItemWriter(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	public void write(List<? extends Product> items) throws Exception {
		
		for(Product item : items) {
			System.out.println(item.getName());
			try {
				int updated = jdbcTemplate.update(UPDATE_PRODUCT,
						item.getName(),item.getDescription(),item.getPrice(),item.getId()
					);
					if(updated == 0) {
						jdbcTemplate.update(
							INSERT_PRODUCT,
							item.getId(),item.getName(),item.getDescription(),item.getPrice()
						);	
					}					
			} catch (Exception e) {
				e.printStackTrace();
			}
						
		}
	}

}
