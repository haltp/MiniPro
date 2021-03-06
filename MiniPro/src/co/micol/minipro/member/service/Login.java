package co.micol.minipro.member.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.minipro.common.Service;
import co.micol.minipro.member.dao.MemberDao;

public class Login implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 로그인과정을 처리한다.
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setmId(request.getParameter("mId"));
		vo.setmPassword(request.getParameter("mPassword"));
		
		vo = dao.select(vo);
		
		String viewPage = null;
		
		if(vo.getmAuth()!= null) {
			HttpSession session = request.getSession(); 
			session.setAttribute("mid", vo.getmId());	
			session.setAttribute("mauth", vo.getmAuth());	
			request.setAttribute("vo", vo);
			viewPage="views/member/JoinSuccess.jsp";			
		}else {
			viewPage = "views/member/JoinFail.jsp";
		}
				
		
		return viewPage;
	}

}
