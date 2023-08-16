package com.model2.mvc.view.product;

import java.util.HashMap;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.dao.UserDAO;
import com.model2.mvc.service.user.impl.UserServiceImpl;
import com.model2.mvc.service.user.vo.UserVO;

public class ListProductAction extends Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SearchVO searchVO = new SearchVO();

		int page = 1;
		if (request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));

		searchVO.setPage(page);
		searchVO.setSearchCondition(request.getParameter("searchCondition"));
		searchVO.setSearchKeyword(request.getParameter("searchKeyword"));

		String pageUnit = getServletContext().getInitParameter("pageSize");
		searchVO.setPageUnit(Integer.parseInt(pageUnit));

		ProductService service = new ProductServiceImpl();
		HashMap<String, Object> map = service.getProductList(searchVO);

		request.setAttribute("map", map);
		request.setAttribute("searchVO", searchVO);
		
	//====> jsp manage, search 분리 
		
		//UserVO dbVO = new UserVO();
//		UserDAO dao = new UserDAO();
//		
//		dao.findUser(vo.setUserId(userId));
		
		HttpSession session =request.getSession();
		UserVO vo= (UserVO)session.getAttribute("user");  
		System.out.println(":::::::::::::::::::::::::로그인 ID : "+vo.getUserId()+":::::::::::::::::::::::::ROLE : "+vo.getRole()+"::::::::::::::::::::::::::::::::::::::");
		
		
		//System.out.println();

		
		//String sep = (String)session.getAttribute("user");
		//System.out.println(session.getAttribute("user"));
		//System.out.println(dbVO.setRole(request.getParameter("role")));
		//System.out.println(dbVO.getRole());		//===>vo로 호출하니 null값 나옴 
		return "forward:/product/listProduct.jsp";
	}
}
