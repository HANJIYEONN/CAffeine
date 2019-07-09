package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;
import exe.entity.UserEntity;

public class UserUpdateFormCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request) throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		ActionForward action = new ActionForward();
		UserEntity user = (UserEntity)session.getAttribute("user");
		
		if (user == null) {
			action.setPath("loginForm.do");
			action.setSend(true);
		
		} else {
			request.setAttribute("user", user);
		
			action.setPath("WEB-INF/userUpdateForm.jsp");
			action.setSend(false);
		}
		
		
		return action;
	}

}
