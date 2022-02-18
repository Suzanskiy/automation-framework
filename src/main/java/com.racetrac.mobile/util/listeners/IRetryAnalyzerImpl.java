package com.racetrac.mobile.util.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyzerImpl implements IRetryAnalyzer {
  private int retryCount = 0;
  private int maxRetryCount = 0;

  @Override
  public boolean retry(final ITestResult iTestResult) {
    if (retryCount < maxRetryCount) {
      retryCount++;
      return true;
    }
    return false;
  }
}
