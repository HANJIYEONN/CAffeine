package exe.factory;

import java.util.HashMap;

import exe.command.LoginCommand;
import exe.command.LoginFormCommand;
import exe.command.LogoutCommand;
import exe.command.MainCommand;
import exe.command.MyPageCommand;
import exe.command.PostCommand;
import exe.command.PostInsertCommand;
import exe.command.PostInsertFormCommand;
import exe.command.UserFindCommand;
import exe.command.UserFindFormCommand;
import exe.command.UserInsertCommand;
import exe.command.UserInsertFormCommand;
import exe.command.UserIntakeCommand;
import exe.command.UserIntakeFormCommand;
import exe.common.Command;

public class CommandFactory {
	private HashMap<String, Command> map = new HashMap<String, Command>();
	private static CommandFactory factory = new CommandFactory();
	
	private CommandFactory () {

		//회원 가입 관련
		map.put("/Caffeine/userInsertForm.do",		new UserInsertFormCommand());
		map.put("/Caffeine/userInsert.do",			new UserInsertCommand());
		
		//로그인 관련
		map.put("/Caffeine/loginForm.do",			new LoginFormCommand());
		map.put("/Caffeine/login.do",				new LoginCommand());
		map.put("/Caffeine/logout.do",				new LogoutCommand());
		 
		//회원 찾기 관련
		map.put("/Caffeine/userFindForm.do",		new UserFindFormCommand());
		map.put("/Caffeine/userFind.do",			new UserFindCommand());
		
		//메인
		map.put("/Caffeine/main.do",				new MainCommand());

		
		//마이페이지
		map.put("/Caffeine/myPage.do",				new MyPageCommand());	
		
		//게시글
		map.put("/Caffeine/postInsertForm.do",		new PostInsertFormCommand());
		map.put("/Caffeine/postInsert.do",			new PostInsertCommand());	
		map.put("/Caffeine/post.do",				new PostCommand());
		
		//유저 카페인 섭취량
		map.put("/Caffeine/userIntakeForm.do",		new UserIntakeFormCommand());
		map.put("/Caffeine/userIntake.do",			new UserIntakeCommand());
		

	}
	
	public static CommandFactory getInstance() {
		return factory;
	}
	
	public Command getCommand(String url) {
		return map.get(url);
	}
}
