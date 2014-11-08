package net.codesree.web;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.codesree.web.View;

public interface IAction extends Serializable {
  public View execute(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException;
}
