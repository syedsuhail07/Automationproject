package com.automationproj.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TEST STARTED: " + result.getName());
        // You can add logic here to start a new test entry in your report
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TEST PASSED: " + result.getName());
        // Add logic to mark the test as passed in your report
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TEST FAILED: " + result.getName());
        // Add logic to mark the test as failed and possibly capture a screenshot
    }
    
    // You can also implement other methods like onTestSkipped, onStart, etc.
}