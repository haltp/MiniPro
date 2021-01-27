package co.micol.minipro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.minipro.common.Service;
import co.micol.minipro.member.dao.MemberDao;

public class MemberIdCheck implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		//아이디 중복 체크
		MemberDao dao = new MemberDao();
		String id = request.getParameter("mid"); //idCheck.do?mid="+str;
		boolean bool = dao.isIdCheck(id);
		String message = null;
		if(bool) {
			message = id + "사용할 수 있는 아이디입니다.";
			
		}else {
			message = id + "사용할 수 없는 아이디입니다.";
		}
		request.setAttribute("msg", message);
		request.setAttribute("check", bool);
		return "views/member/idCheck.jsp";
	}

}
