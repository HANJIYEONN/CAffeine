package exe.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import exe.common.ActionForward;
import exe.common.Command;
import exe.dao.PostDAO;
import exe.entity.PostEntity;

public class MainCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request) throws IOException, ServletException {
		ActionForward action = new ActionForward();
	
		String page = request.getParameter("page");
		
		int pageCount = 3;
		int pageGroupCount = 3;
		
		int curPage = 1;
		
		if(page != null) {
			curPage = Integer.parseInt(page);
		}
		
		int groupStartNum = (curPage - 1) / pageGroupCount * pageGroupCount + 1;
		
		int startNum = (curPage - 1) * pageCount + 1;

		PostDAO dao = new PostDAO();
		
		int totalRow = dao.getTotalRow();
		int totalPage = (totalRow -1 ) / pageCount + 1;
		
		ArrayList<PostEntity> list = dao.selectAll(startNum, pageCount);
		
		request.setAttribute("list", list);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("groupStartNum", groupStartNum);
		request.setAttribute("pageGroupCount", pageGroupCount);
		
		System.out.println();
		
		
		action.setPath("WEB-INF/main.jsp");
		action.setSend(false);
		
		return action;
	}

}
