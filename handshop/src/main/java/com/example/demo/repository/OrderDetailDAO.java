package com.example.demo.repository;

import com.example.demo.entities.ChitietdonhangId;

public interface OrderDetailDAO {
	public boolean insertOrderDetail(ChitietdonhangId chitietdonhangId);

	public boolean updateOrderDetail(ChitietdonhangId chitietdonhangId);

	public boolean deleteOrderDetail(int id);
}
