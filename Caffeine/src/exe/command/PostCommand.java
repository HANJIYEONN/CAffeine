package exe.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.PostDAO;
import exe.entity.PostEntity;

public class PostCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request) throws IOException, ServletException {
		ActionForward action = new ActionForward();
		
		String num = request.getParameter("num");
		
		PostDAO dao = new PostDAO();
		PostEntity post = dao.select(num);
		
		request.setAttribute("post", post);
		
		action.setPath("/WEB-INF/post.jsp");
		action.setSend(false);
		
		return action;
	}

}
