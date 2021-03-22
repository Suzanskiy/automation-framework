package com.racetrac.mobile.util.appium;

@FunctionalInterface
public interface Action<T> {

    T execute();
}
