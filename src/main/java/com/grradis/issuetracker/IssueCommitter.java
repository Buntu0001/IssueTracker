package com.grradis.issuetracker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import java.util.Random;

import org.bukkit.Bukkit;

public class IssueCommitter {
  private static File errorLogFile = new File(String.valueOf(Util.plugin.getDataFolder()));

  public static void CommitIssue(ErrorLog log) {
    Random random = new Random();
    String generatedString = random.ints(48, 122 + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(16)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
    String path = errorLogFile + "/error_log_" + generatedString + ".log";
    WriteIssueConsole(log, path);
    WriteIssueFile(log, path);
  }

  public static void WriteIssueConsole(ErrorLog log, String path) {
    try {
      Bukkit.getLogger().info(Util.translate("&c==============ERROR============="));
      Bukkit.getLogger().info(Util.translate("&3Plugin: " + log.getPlugin()));
      Bukkit.getLogger().info(Util.translate("&aFunc: " + log.getFunc()));
      Bukkit.getLogger().info(Util.translate("&eInternal Variables:"));
      for (Map.Entry<String, String> entry : log.getVar().entrySet()) {
        Bukkit.getLogger().info(Util.translate("&6" + entry.getKey() + ": " + entry.getValue() + "\n"));
      }
      Bukkit.getLogger().info(Util.translate("&cError Stack: " + log.getStack()));
      Bukkit.getLogger().info(Util.translate("&bFile Path: " + path));
      Bukkit.getLogger().info(Util.translate("&c===============END=============="));
    } catch (Exception ex) {
      Bukkit.getLogger().info("==============ERROR=============");
      Bukkit.getLogger().info("Plugin: IssueTracker");
      Bukkit.getLogger().info("Func: WriteIssueConsole");
      Bukkit.getLogger().info("Internal Variables:");
      Bukkit.getLogger().info("errorLogFile: " + errorLogFile);
      Bukkit.getLogger().info("error stack: " + ex.getMessage());
      Bukkit.getLogger().info("===============END==============");
    }
  }

  public static void WriteIssueFile(ErrorLog log, String path) {
    try (BufferedWriter writer = new BufferedWriter(
        new FileWriter(path))) {
      writer.append("=============ERROR=============\n");
      writer.append("Plugin: " + log.getPlugin() + "\n");
      writer.append("Func: " + log.getFunc() + "\n");
      writer.append("Internal Variables:\n");
      for (Map.Entry<String, String> entry : log.getVar().entrySet()) {
        writer.append(entry.getKey() + ": " + entry.getValue() + "\n");
      }
      writer.append("Error Stack: " + log.getStack() + "\n");
      writer.append("==============END==============");
    } catch (Exception ex) {
      Bukkit.getLogger().info("==============ERROR=============");
      Bukkit.getLogger().info("Plugin: IssueTracker");
      Bukkit.getLogger().info("Func: WriteIssueFile");
      Bukkit.getLogger().info("Internal Variables:");
      Bukkit.getLogger().info("errorLogFile: " + errorLogFile);
      Bukkit.getLogger().info("error stack: " + ex.getMessage());
      Bukkit.getLogger().info("===============END==============");
    }
  }
}
