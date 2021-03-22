package com.racetrac.mobile.framework.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Indicates those MobileElements which are necessary to be loaded when Page is opened
 */
@Retention(RUNTIME)
@Target({FIELD, TYPE})
public @interface PageLoading {
}
