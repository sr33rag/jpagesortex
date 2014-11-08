package net.codesree.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.codesree.web.IAction;

public abstract class AbstractActionServlet extends HttpServlet {
	
  public void init() { bindUrls(); }
 
  public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
	processRequest(req, res);
  }
  
  public abstract void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException;
  
  public abstract void bindUrls();
  
  public abstract IAction getAction(String url);

}
