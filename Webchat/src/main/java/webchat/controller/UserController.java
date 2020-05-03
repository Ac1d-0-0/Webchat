package webchat.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
	private SimpMessagingTemplate messagingTemplate;
	
	@RequestMapping("/login")
	@ResponseBody
	public String Login(HttpServletRequest request)
	{
		String result;
		String ID = request.getParameter("id");
		String pass = request.getParameter("pass");
		System.out.println(ID+"  "+pass);
		int i = uservice.login(ID, pass);
		if(i==1)
		{
			result = "true";
			HttpSession session = request.getSession();
			session.setAttribute("ID", ID);
		}
		else
			result = "false";
		return result;		
	}
	
	@RequestMapping("/loginpage")//www.xxx.com/Webchat/user/loginpage
	public ModelAndView showLogin(HttpServletRequest request)
	{
		ModelAndView modelview = new ModelAndView("/loginpage");//		www.xxx.com/user/loginpage/
		return modelview;
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public String Register(HttpServletRequest request)
	{
		String result;
		String UserName = request.getParameter("UserName");
		String pass = request.getParameter("Password");
		String Email = request.getParameter("Email");
		System.out.println(UserName+"  "+pass+"  "+Email);
//		int i = uservice.login(ID, pass);
//		if(i==1)
//		{
//			result = "true";
//			HttpSession session = request.getSession();
//			session.setAttribute("ID", ID);
//		}
//		else
//			result = "false";
		return "false";		
	}
	
	@RequestMapping("/registerpage")//www.xxx.com/Webchat/user/register
	public ModelAndView showRegister(HttpServletRequest request)
	{
		ModelAndView modelview = new ModelAndView("/registerpage");//		www.xxx.com/user/loginpage/
		return modelview;
	}
}
