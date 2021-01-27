package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.micol.minipro.common.Service;
import co.micol.minipro.member.dao.MemberDao;

public class MemberJoin implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원가입시 DB에 저장하는 메소드
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setmId(request.getParameter("mId"));
		vo.setmPassword(request.getParameter("mPassword"));
		vo.setmName(request.getParameter("mName"));
		
		String viewPage = null;
		int n = dao.insert(vo);
		request.setAttribute("vo", vo);
		
		if (n != 0) {
			viewPage = "views/member/JoinFail.jsp";
		}else {
			viewPage = "views/member/JoinSuccess.jsp";
		}
					
		
		return viewPage;
		

	}

}
