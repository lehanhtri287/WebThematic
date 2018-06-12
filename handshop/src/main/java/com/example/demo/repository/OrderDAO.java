package com.example.demo.repository;

import java.util.List;

import com.example.demo.entities.Chitietdonhang;
import com.example.demo.entities.Donhang;

public interface OrderDAO {
	public List<Donhang> getListOrders();

	public int getInsertedID();

	public boolean insertOrder(Donhang donhang);

	public boolean updateOrder(Donhang donhang);

	public boolean deleteOrder(int idOrder);

	public boolean insertOrderDetail(int idDonhang, int idSanpham, int soLuong);

	public int size();

	public List<Donhang> getNewOrders();
	
	public List<Donhang> getOrdersByEmail(String email);
	
	public List<Chitietdonhang> getOrderDetailById(Integer orderId);
	
	public Donhang getOrderById(Integer orderId);
	
	public boolean cancelOrderById(Integer orderId);
}
