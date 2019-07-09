package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.UserDAO;
import exe.entity.UserEntity;

public class UserInsertCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request) throws IOException, ServletException {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		UserEntity user = new UserEntity();
		user.setId(request.getParameter("userID"));
		user.setPw(request.getParameter("userPassword"));
		user.setName(request.getParameter("userName"));
		user.setNickname(request.getParameter("userNickname"));
		user.setEmail(request.getParameter("userEmail"));
		
		UserDAO dao = new UserDAO();
		boolean result = dao.addUser(user);
		
		
		ActionForward action = new ActionForward();
		if (result) {
			request.setAttribute("code", "10");
			
			action.setPath("WEB-INF/result.jsp");
			action.setSend(false);
		} else {
			request.setAttribute("code", "11");
		
			action.setPath("WEB-INF/result.jsp");
			action.setSend(false);
		
		}
		
		return action;
	}

}
