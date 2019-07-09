
package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.UserDAO;
import exe.entity.UserEntity;

public class UserFindCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request) throws IOException, ServletException {

			try {
				request.setCharacterEncoding("UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String email = request.getParameter("userEmail");
			
			UserDAO dao = new UserDAO();
			UserEntity findUser = dao.findUser(email);
			
			//이메일 확인해서 아이디 알려주기
			ActionForward action = new ActionForward();
			if (findUser != null) {
				request.setAttribute("code", "41");
				request.setAttribute("findID", findUser.getId());
				
				action.setPath("WEB-INF/result.jsp");
				action.setSend(false);
				
			} else {
				request.setAttribute("code", "40");
				
				action.setPath("WEB-INF/result.jsp");
				action.setSend(false);
			}
		return action;
	}

}
