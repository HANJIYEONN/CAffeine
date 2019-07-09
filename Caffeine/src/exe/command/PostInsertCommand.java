package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.IntakeDAO;
import exe.dao.PostDAO;
import exe.entity.IntakeEntity;
import exe.entity.PostEntity;
import exe.entity.UserEntity;

public class PostInsertCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request) throws IOException, ServletException {
		ActionForward action = new ActionForward();
		
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity)session.getAttribute("user");
		
		PostEntity post = new PostEntity();
		post.setTitle(request.getParameter("title"));
		post.setWriter(request.getParameter("writer"));
		post.setDate(request.getParameter("date"));
		post.setContent(request.getParameter("content"));
		post.setPicture(request.getParameter("brand"));
		post.setCaffeine(Integer.parseInt(request.getParameter("caffeine")));
		post.setEmail(user.getEmail());

		PostDAO dao = new PostDAO();
		boolean result = dao.insertPost(post);
		
		// 글 넣는 것을 성공
		if (result == true) {
			String email = user.getEmail();
			
			IntakeDAO _dao = new IntakeDAO();
			IntakeEntity userIntake = _dao.find(email);
			
			IntakeEntity amount = new IntakeEntity();
			amount.setAmount(Integer.parseInt(request.getParameter("caffeine")));
			amount.setEmail(user.getEmail());

			if (( userIntake != null ? _dao.update(amount) : _dao.insert(amount) )) {
				action.setPath("main.do");
				action.setSend(true);
			} else {
				request.setAttribute("code", "30");
				
				action.setPath("WEB-INF/result.jsp");
				action.setSend(false);
			}
		} else {
			request.setAttribute("code", "30");
			
			action.setPath("WEB-INF/result.jsp");
			action.setSend(false);
		}
		
		return action;
	}

}
