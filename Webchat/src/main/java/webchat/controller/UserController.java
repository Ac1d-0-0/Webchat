package webchat.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import webchat.service.UserService;

@Controller
@RequestMapping("/user") //www.xxx.com/user
public class UserController 
{
	@Resource
	private UserService uservice;
	@RequestMapping("/login")//www.xxx.com/user/login
	@ResponseBody
	public JSONObject Login(HttpServletRequest request)
	{
		JSONObject jo = new JSONObject();
		String ID = request.getParameter("UserID");
		String pass = request.getParameter("Password");
		int i = uservice.login(ID, pass);
		return jo;		
	}
	@RequestMapping("/loginpage")//www.xxx.com/Webchat/user/loginpage
	public ModelAndView showlogin(HttpServletRequest request)
	{
		ModelAndView modelview = new ModelAndView("/loginpage");//		www.xxx.com/user/loginpage/
		return modelview;
	}
}
