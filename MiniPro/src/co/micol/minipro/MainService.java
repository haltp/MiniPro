package co.micol.minipro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.minipro.common.Service;

public class MainService implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 단순히 메인화면을 보여준다.
		return "views/main/main.jsp";
	}

}