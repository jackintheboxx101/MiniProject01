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

public class GetProductAction extends Action{
	
	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		
		
		String getNo=request.getParameter("prodNo");
		
		String menu = request.getParameter("menu");
		System.out.println("getProdAct access : "+menu);
		
		ProductService pService=new ProductServiceImpl();
		ProductVO pvo=pService.getProduct(Integer.parseInt(getNo));
		
		request.setAttribute("pvo", pvo);
		
		System.out.println("getProdAct : "+pvo);
		
	
		if(menu != null && menu.equals("manage")){
			return "forward:/product/updateProduct.jsp";
		}else {
			return "forward:/product/getProduct.jsp";
		}
	}
}
