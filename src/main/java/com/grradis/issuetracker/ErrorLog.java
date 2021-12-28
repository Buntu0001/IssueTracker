package com.grradis.issuetracker;

import java.util.HashMap;

public class ErrorLog {
  private String plugin;
  private String func;
  private HashMap<String, String> var = new HashMap<>();
  private String stack;

  public ErrorLog(String pl, String fu, HashMap<String, String> va, String st) {
    this.plugin = pl;
    this.func = fu;
    this.var = va;
    this.stack = st;
  }

  public String getPlugin() {
    return this.plugin;
  }

  public String getFunc() {
    return this.func;
  }

  public HashMap<String, String> getVar() {
    return this.var;
  }

  public String getStack() {
    return this.stack;
  }
}
