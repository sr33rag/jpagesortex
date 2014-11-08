package net.codesree.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.codesree.web.View;
import net.codesree.web.IAction;

public abstract class AbstractAction implements IAction {
  
  protected View view=null;
  protected boolean redirect=false;
  protected HttpSession sess=null;  
  protected HttpServletResponse res=null;
  protected HttpServletRequest req=null;
  protected ServletContext application=null;

  public abstract void preProcess();
  public abstract void processRequest() throws IOException,ServletException;
  public abstract void postProcess();
  
  public View execute(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
    this.req=req;
    this.res=res;
    this.sess=req.getSession(false);
    this.application=req.getServletContext();
    preProcess();
    processRequest();
    postRequest();
    return this.view;
  }
}
