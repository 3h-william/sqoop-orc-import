// generated by src/scripts/write-version-info.cmd
package org.apache.sqoop;

public class SqoopVersion {
  public SqoopVersion() {
  }

  public static final String VERSION="-1.4.5-cdh5.4.0-orc-0.1";
  public static final String GIT_HASH="454495686bb79259e2e161de4df80c5a0ba7b9af";
  public static final String COMPILE_USER="";
  public static final String COMPILE_DATE="2015/09/25 ����-16:02:15.75";

  @Override
  public String toString() {
    return "Sqoop " + VERSION + "\n"
        + "git commit id " + GIT_HASH + "\n"
        + "Compiled by " + COMPILE_USER
        + " on " + COMPILE_DATE + "\n";
  }
}
