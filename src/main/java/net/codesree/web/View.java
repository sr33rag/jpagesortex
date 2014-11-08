package net.codesree.web;

import java.io.Serializable;

public class View implements Serializable {

  private String fromurl=null,tourl=null;
  private boolean tobeRedirected=false;
  
  public View() { 
	this.tourl=""; 
	this.fromurl="";
  }
  
  public View(String _fromurl,String _tourl) { 
	View(_fromurl,_tourl,false);
  }
  
  public View(String _fromurl,String _tourl,boolean _tobeRedirected) { 
	setFromUrl(_fromurl); 
	setToUrl(_tourl); 	
	setTobeRedirected(_tobeRedirected);
  }
  
  public void setToUrl(String _tourl) { this.tourl=_tourl; }
  public String getToUrl() { return this.tourl; }
  
  public void setFromUrl(String _fromurl) { this.fromurl=_fromurl; }
  public String getFromUrl() { return this.fromurl; }
  
  public boolean isTobeRedirected() { return this.redirect; }
  public void setTobeRedirected(boolean _tobeRedirected) { this.tobeRedirected=_tobeRedirected; }

}
