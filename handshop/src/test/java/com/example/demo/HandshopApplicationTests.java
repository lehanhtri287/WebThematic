package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.TaikhoanDAO;
import com.example.demo.entities.Taikhoan;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HandshopApplicationTests {
	
	@Autowired
	TaikhoanDAO taikhoanDAO;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testSignUp(){
		Taikhoan taikhoan = new Taikhoan("trinhpham96@gmail.com", "1234", "KH", "Trinh Phạm", "KP 6 Phường Linh Trung", "01234", 1);
		assertEquals("trinhpham96@gmail.com", taikhoanDAO.signUp(taikhoan));
	}

}
