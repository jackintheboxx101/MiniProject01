package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class AddPurchaseAction extends Action{

	
	public String excute( HttpServletRequest request,
								HttpServletResponse response)throws Exception{
		
		PurchaseVO purchaseVO = new PurchaseVO();
		ProductVO productVO = new ProductVO();
		
		productVO.setProdNo(Integer.parseInt(request.getParameter("prodNo")));
		productVO.setProdName(request.getParameter("prodName"));
		productVO.setProdDetail(request.getParameter("prodDetail"));
		productVO.setPrice(Integer.parseInt(request.getParameter("price")));
		productVO.setManuDate(request.getParameter("manuDate").replace("-", ""));
		
		purchaseVO.setBuyer(request.getSession("buyer"));
		purchaseVO.setReceiverName(request.getParameter("recieverName"));
		purchaseVO.setReceiverPhone(request.getParameter("recieverPhone"));
		purchaseVO.setDlvyAddr(request.getParameter("dlvyAddr"));
		purchaseVO.setDlvyRequest(request.getParameter("dlvyRequest"));
		purchaseVO.setDlvyDate(request.getParameter("dlvyDate").replace("-", ""));
		
		PurchaseService service = new PurchaseServiceImpl();
		service.addPurchaseVO(purchaseVO);
		
		request.setAttribute("purchaseVO", purchaseVO);
		
		return "forward:/purchase/addPurchase.jsp";
	}
}
