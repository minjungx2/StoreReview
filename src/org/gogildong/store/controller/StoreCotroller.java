package org.gogildong.store.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gogildong.common.controller.MultiController;
import org.gogildong.common.utill.PageInfo;
import org.gogildong.common.utill.PageMaker;
import org.gogildong.member.dao.MemberDAO;
import org.gogildong.store.dao.StoreDAO;
import org.gogildong.store.domain.Store;

/**
 * Servlet implementation class StoreCotroller
 */
@WebServlet("/store/*")
public class StoreCotroller extends MultiController {
	
	private StoreDAO storeDAO = new StoreDAO();
	private MemberDAO memberDAO = new MemberDAO();
	
	public String listGET(HttpServletRequest req, HttpServletResponse res)throws Exception {
		
		PageInfo pageInfo = new PageInfo();
		
		pageInfo.setPage(getInt(req,"page",1));
		pageInfo.setPersheet(getInt(req,"perSheet",6));
		
		int total = storeDAO.getTotal();
		
		PageMaker pageMaker = new PageMaker(pageInfo, total);
		
		List<Store> list = storeDAO.getAll(pageInfo);
		
		req.setAttribute("pageMaker", pageMaker);
		req.setAttribute("list", list);
		
		return "store/list";
		
	}
	
}
