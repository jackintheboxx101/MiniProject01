package com.model2.mvc.service.product;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.product.vo.ProductVO;

public interface ProductService {
	
	
	public HashMap<String,Object> getProductList(SearchVO searchVO) throws Exception;
	
	public ProductVO updateProduct(ProductVO productVO) throws Exception;
	
	public ProductVO addProduct(ProductVO productVO) throws Exception;
	
	public ProductVO getProduct(int prodNo) throws Exception;			//나중에 확인 
	
	
}
