package com.model2.mvc.service.product.impl;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.product.vo.ProductVO;

public class ProductServiceImpl implements ProductService{
	
	private ProductDAO productDAO;
	private ProductVO productVO;
	
	public ProductServiceImpl() {
		productDAO =  new ProductDAO();
	} 
	
	public HashMap<String,Object> getProductList(SearchVO searchVO) throws Exception{
		return productDAO.getProductList(searchVO);
		
	}
	
	public ProductVO updateProduct(ProductVO productVO) throws Exception{
	    return productDAO.updateProduct(productVO);
	}

	
	public ProductVO addProduct(ProductVO productVO)throws Exception{
		return productDAO.insertProduct(productVO);
	}
	
	public ProductVO getProduct(int prodNo) throws Exception{
		System.out.println("impgetpro");
		return productDAO.findProduct(prodNo);
	}
}
/*
 * 	impl ��  interface�� ���� ���¸� �����ؾ��� ==> return type, �Ķ���͸� ��ġ���Ѿ� ��. 
 * 	int�� price�� no �� �� �޴� ���� �ƴ� no�� �޴´�
*/
