package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;

public class UpdateProductViewAction extends Action{

		@Override
		public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
				
				String prodNo = request.getParameter("prodNo");
				
				ProductService service = new ProductServiceImpl();
				ProductVO pvo = service.getProduct(Integer.parseInt(prodNo));
				
				request.setAttribute("prodNo", pvo);
				System.out.println("=========updateProductViewAccess=========");
				return "forward:/product/updateProduct.jsp";
		
	}	
}
