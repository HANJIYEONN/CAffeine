package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.UserDAO;
import exe.entity.UserEntity;

public class LoginCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request) throws IOException, ServletException {
		ActionForward action = new ActionForward();
		
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPassword");
		
		UserDAO dao = new UserDAO();
		UserEntity user = dao.login(id, pw);
		
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			action.setPath("main.do");
			action.setSend(true);
		} else {
			request.setAttribute("code", "00");
			
			action.setPath("WEB-INF/result.jsp");
			action.setSend(false);
		}
		
		return action;
	}

}
