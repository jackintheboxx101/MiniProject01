package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;
import com.model2.mvc.service.user.vo.UserVO;

public class UpdateProductAction extends Action{

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		//String prodNo = request.getParameter("prodNo");
		
		//String prodNo = (String)request.getParameter("ProdNo");
		
		ProductVO productVO=new ProductVO();
		productVO.setProdNo(Integer.parseInt(request.getParameter("prodNo")));
		productVO.setProdName(request.getParameter("prodName"));
		productVO.setProdDetail(request.getParameter("prodDetail"));
		productVO.setManuDate(request.getParameter("manuDate"));
		productVO.setPrice(Integer.parseInt(request.getParameter("price")));
		
		ProductService pService=new ProductServiceImpl();
		pService.updateProduct(productVO);
		
		System.out.println("updateProdAct : "+productVO.toString());

		
		return "redirect:/getProduct.do?prodNo="+productVO.getProdNo(); //���� �����ұ� 
	}
}
