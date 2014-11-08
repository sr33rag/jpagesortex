package net.codesree.web;

import java.io.IOException;

import java.util.Map;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.codesree.web.View;
import net.codesree.web.IAction;

public class ActionServlet extends AbstractActionServlet {

  private static Map<String,IAction> actionMap=null;
  
  public void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
	//check for cross-site scripting attack
	//check for cross-site request forgery attacks
	String url=req.getRequestURL().substring();  
	View view=null;
	IAction action=getAction(url);
	if(null!=action)
	 view=action.execute(req,res);
	if(view==null||view.getToUrl().equals(null)||view.getToUrl().equals("")||view.getToUrl().length()<=0) {
	  view=new View(null,"index.do",true);
	} 
	if(view.isTobeRedirected())
	  res.sendRedirect(view.getToUrl());
	else
	  req.getRequestDispatcher(view.getToUrl()).forward(req,res);
  }
  
  public void bindUrls() {
	actionMap=new HashMap<>();
	actionMap.put("login",new net.codesree.actions.user.LoginAction());
	actionMap.put("register",new net.codesree.actions.user.RegisterAction());
	actionMap.put("forgotPasswd",new net.codesree.actions.user.ForgotPasswdAction());
	actionMap.put("logout",new net.codesree.actions.user.LogoutAction());
	actionMap.put("changePasswd",new net.codesree.actions.user.ChangePasswdAction());
  }
  
  public IAction getAction(String url) {
	IAction action=actionMap.get(url);
	if(action.equals(null))
	  throw new Exception("No action found bound to this url.");
	else
	  return action;
  }
	  
  public void destroy() {}

}
