package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {
	
	@Autowired OrderService orderService;
	
	@Test
	public void testGetOrderDetail(){
		assertEquals(2, orderService.getOrderDetailById(32).size());
	}
	
	@Test
	public void testGetOrderById(){
		assertTrue(orderService.getOrderById(32).getIdOrder().equals(32));
	}
	
	@Test
	public void testCancelOrderById(){
		assertTrue(orderService.cancelOrderById(34));
	}
}
