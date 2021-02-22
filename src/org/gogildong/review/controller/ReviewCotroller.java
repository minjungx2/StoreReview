package org.gogildong.review.controller;

import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.gogildong.common.controller.MultiController;
import org.gogildong.common.utill.PageInfo;
import org.gogildong.common.utill.PageMaker;
import org.gogildong.member.dao.MemberDAO;
import org.gogildong.review.dao.ReviewDAO;
import org.gogildong.review.domain.Like;
import org.gogildong.review.domain.Review;
import org.gogildong.store.dao.StoreDAO;
import org.gogildong.store.domain.Store;

import lombok.extern.log4j.Log4j;

/**
 * Servlet implementation class StoreCotroller
 */
@WebServlet("/review/*")
@Log4j
@MultipartConfig(location = "C:\\upload")
public class ReviewCotroller extends MultiController {

	private ReviewDAO reviewDAO = new ReviewDAO();
	private StoreDAO storeDAO = new StoreDAO();
	private MemberDAO memberDAO = new MemberDAO();

	public String viewGET(HttpServletRequest req, HttpServletResponse res) throws Exception {

		Long sno = Long.parseLong(req.getParameter("sno"));

		Store store = storeDAO.getOne(sno);

		PageInfo pageInfo = new PageInfo();

		pageInfo.setPage(getInt(req, "page", 1));
		pageInfo.setPersheet(getInt(req, "perSheet", 6));
		pageInfo.setLong(sno);

		int total = reviewDAO.getTotal(sno);

		PageMaker pageMaker = new PageMaker(pageInfo, total);

		List<Review> review = reviewDAO.getReview(pageInfo);

		req.setAttribute("store", store);

		req.setAttribute("review", review);

		req.setAttribute("pageMaker", pageMaker);

		return "review/view";
	}

	public String registerGET(HttpServletRequest req, HttpServletResponse res) throws Exception {

		Long sno = Long.parseLong(req.getParameter("sno"));

		Store store = storeDAO.getOne(sno);

		req.setAttribute("store", store);

		return "review/register";

	}

	public String registerPOST(HttpServletRequest req, HttpServletResponse res) throws Exception {

		req.setCharacterEncoding("UTF-8");

		Long sno = Long.parseLong(req.getParameter("sno"));
		String mid = req.getParameter("mid");
		String context = req.getParameter("context");
		Long score = Long.parseLong(req.getParameter("score"));

		Part filePart = req.getPart("file");
		String img = filePart.getSubmittedFileName();
		filePart.write(img);

		Review review = Review.builder().sno(sno).mid(mid).context(context).score(score).img(img).build();

		log.info(review);

		reviewDAO.insertReview(review);

		return "re:view?sno=" + sno;

	}

	public String likePOST(HttpServletRequest req, HttpServletResponse res) throws Exception {

		System.out.println("like.....................................");


		Long rno = Long.parseLong(req.getParameter("rno"));

		String mid = req.getParameter("mid");

		Like like = Like.builder().rno(rno).mid(mid).build();

		Like realLike = reviewDAO.selectLike(like);

		if (mid != "") {

			if (realLike == null) {

				reviewDAO.insertLike(like);

			} else if (realLike.getValue() == 1L) {

				reviewDAO.disLike(like);

			} else {

				reviewDAO.updateLike(like);

			}

		} else {

			return "re:/member/login";

		}

		return "re:/store/list";

	}

}
