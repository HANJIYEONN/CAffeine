package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.IntakeDAO;
import exe.entity.IntakeEntity;
import exe.entity.UserEntity;

public class UserIntakeFormCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request) throws IOException, ServletException {
		ActionForward action = new ActionForward();

		HttpSession session = request.getSession();
		UserEntity user = (UserEntity)session.getAttribute("user");
		
		if (user == null) {
			action.setPath("login.do");
			action.setSend(true);
			
		} else {
			IntakeDAO dao = new IntakeDAO();
			IntakeEntity userIntake = dao.find(user.getEmail());
			int amount = ( userIntake == null ? 0 : userIntake.getAmount() );
			request.setAttribute("amount", amount);
			
			action.setPath("WEB-INF/userIntakeForm.jsp");
			action.setSend(false);
			
		}

		return action;
	}

}
