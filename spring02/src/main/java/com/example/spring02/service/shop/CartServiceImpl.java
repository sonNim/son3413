package com.example.spring02.service.shop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring02.model.shop.dao.CartDAO;
import com.example.spring02.model.shop.dto.CartDTO;

@Service //service bean으로 등록
public class CartServiceImpl implements CartService {

	@Inject //의존관계 주입
	CartDAO cartDao;
	
//상품별 장바구니 금액 통계	
	@Override
	public List<CartDTO> cartMoney() {
		return cartDao.cartMoney();
	}
	@Override
	public void insert(CartDTO dto) {
		cartDao.insert(dto); 
	}

	@Override
	public List<CartDTO> listCart(String userid) {
		return cartDao.listCart(userid); 
	}

	@Override
	public void delete(int cart_id) {
		cartDao.delete(cart_id); 
	}
//장바구니 비우기
	@Override
	public void deleteAll(String userid) {
		cartDao.deleteAll(userid); 
	}

	@Override
	public void update(int cart_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public int sumMoney(String userid) {
		return cartDao.sumMoney(userid);
	}

	@Override
	public int countCart(String userid, int product_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCart(CartDTO dto) {
		// TODO Auto-generated method stub

	}
//장바구니 수정
	@Override
	public void modifyCart(CartDTO dto) {
		cartDao.modifyCart(dto); 
	}

}








