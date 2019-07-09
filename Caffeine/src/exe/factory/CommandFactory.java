package exe.factory;

import java.util.HashMap;

import exe.command.LoginCommand;
import exe.command.LoginFormCommand;
import exe.command.LogoutCommand;
import exe.command.MainCommand;
import exe.command.MyFageCommand;
import exe.command.PostCommand;
import exe.command.PostInsertCommand;
import exe.command.PostInsertFormCommand;
import exe.command.UserFindCommand;
import exe.command.UserFindFormCommand;
import exe.command.UserInsertCommand;
import exe.command.UserInsertFormCommand;
import exe.command.UserIntakeCommand;
import exe.command.UserIntakeFormCommand;
import exe.command.UserUpdateFormCommand;
import exe.common.Command;

public class CommandFactory {
	private HashMap<String, Command> map = new HashMap<String, Command>();
	private static CommandFactory factory = new CommandFactory();
	
	private CommandFactory () {

		//ȸ�� ���� ����
		map.put("/Caffeine/userInsertForm.do",		new UserInsertFormCommand());
		map.put("/Caffeine/userInsert.do",			new UserInsertCommand());
		
		//�α��� ����
		map.put("/Caffeine/loginForm.do",			new LoginFormCommand());
		map.put("/Caffeine/login.do",				new LoginCommand());
		map.put("/Caffeine/logout.do",				new LogoutCommand());
		 
		//ȸ�� ã�� ����
		map.put("/Caffeine/userFindForm.do",		new UserFindFormCommand());
		map.put("/Caffeine/userFind.do",			new UserFindCommand());
		
		//ȸ�� ���� ����
		map.put("/Caffeine/userUpdateForm.do",		new UserUpdateFormCommand());
//		map.put("/Caffeine/userUpdate.do",			new UserUpdateCommand());
		
		//����
		map.put("/Caffeine/main.do",				new MainCommand());

		
		//����������
		map.put("/Caffeine/myFage.do",				new MyFageCommand());	
		
		//�Խñ�
		map.put("/Caffeine/postInsertForm.do",		new PostInsertFormCommand());
		map.put("/Caffeine/postInsert.do",			new PostInsertCommand());	
		map.put("/Caffeine/post.do",				new PostCommand());
		
		//���� ī���� ���뷮
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
