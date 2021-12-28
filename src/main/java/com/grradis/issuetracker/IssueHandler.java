package com.grradis.issuetracker;

import java.util.HashMap;

public class IssueHandler {
  public static void SendError(String plugin, String func, HashMap<String, String> var, String stack) {
    ErrorLog log = new ErrorLog(plugin, func, var, stack);
    IssueCommitter.CommitIssue(log);
  }
}
