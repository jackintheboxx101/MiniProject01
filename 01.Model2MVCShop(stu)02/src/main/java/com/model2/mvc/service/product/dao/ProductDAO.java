package com.model2.mvc.service.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.vo.UserVO;

public class ProductDAO {

	
	public ProductDAO() {					//multiple
		// TODO Auto-generated constructor stub
	}

	public ProductVO insertProduct(ProductVO productVO) throws Exception {
		
		Connection con = DBUtil.getConnection();

		String sql = "insert into PRODUCT(PROD_NO, PROD_NAME, PROD_DETAIL, MANUFACTURE_DAY,PRICE, REG_DATE) values (seq_product_prod_no.NEXTVAL,?,?,?,?,sysdate)";
		
		
		PreparedStatement stmt = con.prepareStatement(sql);
		//stmt.setInt(1, productVO.getProdNo());
		stmt.setString(1, productVO.getProdName());
		stmt.setString(2, productVO.getProdDetail());
		stmt.setString(3, productVO.getManuDate());
		stmt.setInt(4, productVO.getPrice());
		//stmt.setString(6, productVO.getRegDate());				//Date는 varchar로 받는데 String이 오류나는 이유? ==> sysdate로 바로 받음 
		stmt.executeUpdate();
		
		con.close();
		
		return productVO;
	}

	public ProductVO findProduct(int prodNo) throws Exception {
		
		Connection con = DBUtil.getConnection();

		String sql = "select * from PRODUCT where PROD_NO=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, prodNo);
			
		ResultSet rs = stmt.executeQuery();
//		System.out.println("dao");
		ProductVO productVO = null;
		while (rs.next()) {
			productVO = new ProductVO();
			productVO.setProdNo(rs.getInt("PROD_NO"));
			productVO.setProdName(rs.getString("PROD_NAME"));
			productVO.setProdDetail(rs.getString("PROD_DETAIL"));
			productVO.setManuDate(rs.getString("MANUFACTURE_DAY"));
			productVO.setPrice(rs.getInt("PRICE"));
			productVO.setRegDate(rs.getDate("REG_DATE"));			//regdat 받을 값 정해지면 수정 ===>String 이나 int가 아닌 getDate 로 받는다. 
		}
		
		con.close();

		return productVO;
	}
//======>아래 공부하고 시작 
	public HashMap<String,Object> getProductList(SearchVO searchVO) throws Exception {			
		/*hashmap선언  key = String || value = Object
		 * 
		 * 	searchVO ==> common package
		 * 
		*/
		
		
		Connection con = DBUtil.getConnection();
		/*
		 * seachVO.searchCondition ==> 어떤 방식으로 작동되는거지?
		 *equals를 0, 1로 비교하는 이유 
		 * searchKeyword ==> 검색한 제품의 번호, 이름 
		 */
		String sql = "select * from PRODUCT ";
		if (searchVO.getSearchCondition() != null) {												//seachVO.searchCondition ==> ???
			if (searchVO.getSearchCondition().equals("0")) {
				sql += " where PROD_NO='" + searchVO.getSearchKeyword() 			//searchKeyword ==> 검색한 제품의 번호, 이름 
						+ "'";
			} else if (searchVO.getSearchCondition().equals("1")) {
				sql += " where PROD_NAME='" + searchVO.getSearchKeyword()
						+ "'";
			}
		}
		sql += " order by PROD_NO";

		PreparedStatement stmt = 
			con.prepareStatement(	sql,
														ResultSet.TYPE_SCROLL_INSENSITIVE,
														ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery();

		rs.last();
		int total = rs.getRow();
		System.out.println("로우의 수:" + total);

		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("count", new Integer(total));

		rs.absolute(searchVO.getPage() * searchVO.getPageUnit() - searchVO.getPageUnit()+1);
		System.out.println("searchVO.getPage():" + searchVO.getPage());
		System.out.println("searchVO.getPageUnit():" + searchVO.getPageUnit());

		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		if (total > 0) {
			for (int i = 0; i < searchVO.getPageUnit(); i++) {
				ProductVO productVO = new ProductVO();
				productVO = new ProductVO();
				productVO.setProdNo(rs.getInt("PROD_NO"));
				productVO.setProdName(rs.getString("PROD_NAME"));
				productVO.setProdDetail(rs.getString("PROD_DETAIL"));
				productVO.setManuDate(rs.getString("MANUFACTURE_DAY"));
				productVO.setPrice(rs.getInt("PRICE"));
				productVO.setRegDate(rs.getDate("REG_DATE"));

				list.add(productVO);
				if (!rs.next())
					break;
			}
		}
		System.out.println("list.size() : "+ list.size());
		map.put("list", list);
		System.out.println("map().size() : "+ map.size());

		con.close();
			
		return map;
	}

	public ProductVO updateProduct(ProductVO productVO) throws Exception {
		
		Connection con = DBUtil.getConnection();

		String sql = "update PRODUCT set PROD_NAME=?,PROD_DETAIL=?,MANUFACTURE_DAY=?,PRICE=? where PROD_NO=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1, productVO.getProdNo());
		stmt.setString(2, productVO.getProdName());
		stmt.setString(3, productVO.getProdDetail());
		stmt.setString(4, productVO.getManuDate());
		stmt.setInt(5, productVO.getPrice());
		stmt.executeUpdate();
		con.close();
		
		return productVO;
	}

}