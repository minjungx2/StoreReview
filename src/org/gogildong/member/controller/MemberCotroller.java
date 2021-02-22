package org.gogildong.member.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gogildong.common.controller.MultiController;
import org.gogildong.common.utill.PageInfo;
import org.gogildong.common.utill.PageMaker;
import org.gogildong.member.dao.MemberDAO;
import org.gogildong.member.domain.Member;
import org.gogildong.store.dao.StoreDAO;
import org.gogildong.store.domain.Store;

/**
 * Servlet implementation class StoreCotroller
 */
@WebServlet("/member/*")
public class MemberCotroller extends MultiController {

	private MemberDAO memberDAO = new MemberDAO();

	public String loginGET(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String referer = req.getHeader("referer");

		HttpSession session = req.getSession(true);

		session.setAttribute("referer", referer);

		req.setAttribute("referer", referer);

		return "member/login";

	}

	public String loginPOST(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String referer = req.getParameter("referer");

		String mid = req.getParameter("mid");

		String getMid = memberDAO.getMid(mid);

		if (getMid == null) {
			return "re:login";
		}

		HttpSession session = req.getSession(true);
		session.setAttribute("userMid", getMid);

		String sessionReferer = (String) session.getAttribute("referer");

		return "re:" + sessionReferer;

	}

	public String logoutGET(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession(true);

		String sessionReferer = (String) session.getAttribute("referer");

		session.invalidate();

		return "re:" + sessionReferer;

	}

}
