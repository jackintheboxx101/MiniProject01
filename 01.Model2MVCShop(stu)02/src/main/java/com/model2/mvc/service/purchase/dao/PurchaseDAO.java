package com.model2.mvc.service.purchase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.vo.PurchaseVO;
import com.model2.mvc.service.user.vo.UserVO;

public class PurchaseDAO {

		public PurchaseDAO() {}
		
		public PurchaseVO findPurchase(int tranNo)throws Exception{
			//구매정보 상세 조회
			Connection con = DBUtil.getConnection();
			
			String sql = "SELECT * FROM transaction WHERE tran_no=?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, tranNo);
			
			ResultSet rs = stmt.executeQuery();
			
			ProductVO productVO = null;
			PurchaseVO purchaseVO =  null;
			UserVO userVO = null;
			
			while (rs.next()) {
				
				productVO = new ProductVO();
				purchaseVO = new PurchaseVO();
				
				
				productVO.setProdNo(rs.getInt("prod_no"));
				productVO.setProdName(rs.getString("prod_name"));
				productVO.setProdDetail(rs.getString("prod_detail"));
				productVO.setManuDate(rs.getString("manufacture_day"));
				productVO.setPrice(rs.getInt("price"));
				productVO.setRegDate(rs.getDate("reg_date"));
				
				//(UserVO)purchaseVO.setBuyer(rs.getObject("buyer_id"));
				purchaseVO.setPaymentOption(rs.getString("payment_option"));
				purchaseVO.setReceiverName(rs.getString("receiver_name"));
				purchaseVO.setReceiverPhone(rs.getString("receiver_phone"));
				purchaseVO.setDlvyAddr(rs.getString("dlvy_addr"));
				purchaseVO.setDlvyRequest(rs.getString("dlvy_request"));
				purchaseVO.setDlvyDate(rs.getDate("dlvy_date"));
				
				
				/*
				 * 둘이 조인해서 하나로 리턴해야하나
				 */
			}
		}
		
		public HashMap<String, Object> getPurchaseList(SearchVO String)throws Exception{
		//구매목록 보기 	
			
		}
		
		public HashMap<String, Object> getSaleList(SearchVO searchVO)throws Exception{
		//판매목록 보기 	
		}
		
		public void insertPurchase (PurchaseVO purchaseVO)throws Exception{
		//구매	
		}
		
		public void updatePurchase(PurchaseVO purchaseVO)throws Exception{
		//구매정보수정 	
		}
		
		public void updateTranCode(PurchaseVO purchaseVO)throws Exception{
		//구매 상태 코드 수정 	
		}
}
