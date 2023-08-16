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
 * 	impl 과  interface는 같은 형태를 유지해야함 ==> return type, 파라미터를 일치시켜야 함. 
 * 	int는 price와 no 둘 다 받는 것이 아닌 no만 받는다
*/
