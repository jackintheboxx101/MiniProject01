package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class PurchaseServiceImpl  implements PurchaseService{

	private PurchaseVO purchaseVO;
	private PurchaseDAO purchaseDAO;
	
	public PurchaseServiceImpl() {
		purchaseDAO = new PurchaseDAO();
	}
	
	public PurchaseVO addPurchase(PurchaseVO purchaseVO) throws Exception{
		return purchaseVO; 
	}
		
//	public PurchaseVO getPurchase(int tranNo) throws Exception{}
//	
//	public HashMap<String, Object> getPurchaseList(SearchVO searchVO) throws Exception{}
//	//searchVO => String
//	public HashMap<String, Object> getSaleList(SearchVO searchVO) throws Exception{}
//	
//	public PurchaseVO updatePurchase(PurchaseVO purchaseVO)throws Exception{}
//	
//	public void updateTranCode(PurchaseVO purchaseVO) throws Exception{}
//		
//
//	
		
}
