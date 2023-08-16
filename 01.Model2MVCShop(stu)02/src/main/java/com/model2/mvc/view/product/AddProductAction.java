package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;
import com.model2.mvc.service.user.vo.UserVO;

public class AddProductAction extends Action {
	/*
	 * prodno, price ==> int 형 받을 수 있는 걸로 변경
	 * 	==>parseInt를 어디에 사용할지 
	 * productService 를 만들어야 하나? 어디
	 */
	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		ProductVO productVO=new ProductVO();
		
		//==>문자열 to int
		//String pPriceStr = request.getParameter("price");
		//int pPriceInt= Integer.parseInt(request.getParameter("price"));
		
		//==>sysdate '-' replace 
		//String reqStr = request.getParameter("manuDate");
		
		//productVO.setProdNo(request.getParameter("prodNo"))
		productVO.setProdName(request.getParameter("prodName"));
		productVO.setProdDetail(request.getParameter("prodDetail"));
		productVO.setManuDate(request.getParameter("manuDate").replace("-", ""));
		//productVO.setPrice(request.getParameter("price"));
		productVO.setPrice(Integer.parseInt(request.getParameter("price")));
		
		productVO.setFileName(request.getParameter("fileName"));
		productVO.setProTranCode(request.getParameter("proTranCode"));
		
		System.out.println(productVO);
		
		ProductService pService=new ProductServiceImpl();
		pService.addProduct(productVO);
		
		request.setAttribute("pvo", productVO);
		
		return "forward:/product/addProduct.jsp";
	}
}
