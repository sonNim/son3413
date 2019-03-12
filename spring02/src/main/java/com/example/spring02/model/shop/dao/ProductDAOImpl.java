package com.example.spring02.model.shop.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring02.model.shop.dto.ProductDTO;

@Repository 
public class ProductDAOImpl implements ProductDAO {

	@Inject //의존관계 주입
	SqlSession sqlSession;
	
	@Override
	public List<ProductDTO> listProduct() {
		return sqlSession.selectList("product.product_list"); 
	}

	@Override
	public ProductDTO detailProduct(int product_id) {
		return sqlSession.selectOne(
				"product.detail_product", product_id);  
	}
//상품정보 수정
	@Override
	public void updateProduct(ProductDTO dto) {
		sqlSession.update("product.update_product", dto); 
	}
//상품 레코드 삭제
	@Override
	public void deleteProduct(int product_id) {
		sqlSession.delete("product.product_delete", product_id); 
	}
//상품 등록
	@Override
	public void insertProduct(ProductDTO dto) {
		sqlSession.insert("product.insert", dto); 
	}
//첨부파일 이름 리턴
	@Override
	public String fileInfo(int product_id) { 
		return sqlSession.selectOne(
				"product.fileInfo", product_id);
	}

}




