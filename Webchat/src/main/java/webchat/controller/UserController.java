package webchat.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import webchat.model.User;
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
		String name = request.getParameter("UserName");
		String pass = request.getParameter("Password");
		User u = uservice.login(name, pass);
		if(u != null)
		{
			//result = "true";
			HttpSession session = request.getSession();
			session.setAttribute("ID",u.getUserId());
			return "true";
		}
		return "false";		
	}
	
	@RequestMapping("/loginpage")
	public ModelAndView showLogin(HttpServletRequest request)
	{
		ModelAndView modelview = new ModelAndView("/loginpage");
		return modelview;
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public String Register(HttpServletRequest request)
	{
		
		String UserName = request.getParameter("UserName");
		String Pass = request.getParameter("UserPass");
		String Email = request.getParameter("UserEmail");
		int result = uservice.register(Pass,UserName,Email);
		if(result==1) {
			return "true";
		}
		return "false";		
	}
	
	@RequestMapping("/registerpage")
	public ModelAndView showRegister(HttpServletRequest request)
	{
		ModelAndView modelview = new ModelAndView("/registerpage");
		return modelview;
	}
	
	
	
	
	@RequestMapping("/chatpage")
	public ModelAndView showChat(HttpServletRequest request)
	{
		ModelAndView modelview = new ModelAndView("/chatpage");
		Object o = request.getSession().getAttribute("ID");
		String toid="";
		if (request.getParameter("ToID")!=null)
			toid=request.getParameter("ToID");
		if (o != null)
		{
			String IDstr1 = o.toString();
			int myid = Integer.parseInt(IDstr1);	
			List<User> l= uservice.getFriends(myid);
			modelview.addObject("friendslist",l);
			modelview.addObject("id",myid);
			if(toid!="") {
				int tid=Integer.parseInt(toid);
				modelview.addObject("ToID",tid);
			}

			System.out.print(modelview);
			return modelview;
		}
		else
		{
			return new ModelAndView("/loginpage");
		}
	}
	
	

	@RequestMapping("/addfriend")
	@ResponseBody
	public int addFriend(HttpServletRequest request) 
	{
		String IDstr1 = (request.getSession().getAttribute("ID")).toString();
		int myid = Integer.parseInt(IDstr1);
		String femail = request.getParameter("FriendEmail");
		int state = uservice.makefriends(myid, femail);
		return state;
		
	} 
	
	
}
