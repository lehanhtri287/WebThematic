package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.repository.TaikhoanDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HandshopApplicationTests {
	
	@Autowired
	TaikhoanDAO taikhoanDAO;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testFindByEmail(){
		assertEquals("trinhpham0415@gmail", taikhoanDAO.findByEmail("trinhpham0415@gmail"));
	}

}
