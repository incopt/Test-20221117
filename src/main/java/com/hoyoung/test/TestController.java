package com.hoyoung.test;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hoyoung.test.dao.IDao;
import com.hoyoung.test.dto.MemberDto;

@Controller
public class TestController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value="/join")
	public String joinPage() {
		
		return "join";
	
	}
	
	@RequestMapping("/joinMember")
	public String joinMember(HttpServletRequest request,Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		model.addAttribute("memberID", mid);
		
		return "joinOk";
	}
	
	@RequestMapping(value="/memberList")
	public String memberlist(Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		ArrayList<MemberDto> memberDtos = dao.memberList();
		model.addAttribute("MemberDto", memberDtos);
		
		
		return "memberlist";
	}
	
	@RequestMapping("/searchId")
	public String searchId(Model model) {
		
		
		
		return "idSearch";
	}
	
	@RequestMapping(value="idOk")
	public String idOk(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		String searchId = request.getParameter("searchId");
		MemberDto mdto = dao.searchIdOk(searchId);
		
		model.addAttribute("searchRs", mdto);
		
		return "idOk";
	}
	
	

}
