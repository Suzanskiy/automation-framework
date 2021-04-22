package com.racetrac.mobile.multisite.racetrac.util;

import com.google.common.hash.Hashing;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;

public class CommonUtils {

    private static final Logger LOG = LoggerFactory.getLogger(CommonUtils.class);
    private static final String DIGITS_IN_BRACES_PATTERN = "\\((\\d+)\\)";
    private static final String CHARACTERS_WITH_SQUARE_BRACKETS = "\\[.*\\]";
    private static final String CURRENCY_PATTERN = "([A-Za-z]+)|(€)";
    private static final String SPACE_PATTERN = "(\\s)";

    public static String getCharacterInBraces(final String text) {
        return findTextUsingRegex(text, DIGITS_IN_BRACES_PATTERN);
    }

    public static String removeSubstringWithSquareBracket(final String text) {
        return text.replaceAll(CHARACTERS_WITH_SQUARE_BRACKETS, EMPTY);
    }

    public static String excludeCurrencySignFromString(final String text) {
        return text.replaceAll(CURRENCY_PATTERN, EMPTY).replace("+", EMPTY).replaceAll(SPACE_PATTERN, EMPTY).replace(".", EMPTY);
    }

    private static String findTextUsingRegex(final String fileText, final String pattern) {
        String foundText = StringUtils.EMPTY;
        final Pattern p = Pattern.compile(pattern);
        final Matcher m = p.matcher(fileText);
        while (m.find()) {
            foundText = m.group(1);
        }
        return foundText;
    }

    public static String getNumberFromString(final String value) {
        return removePatternOccurrences(value, "[^0-9]+");
    }

    public static String removePatternOccurrences(final String value, final String pattern) {
        return value.replaceAll(pattern, EMPTY);
    }

    public static String findPattern(final String text, final String pattern) {
        final Pattern p = Pattern.compile(pattern);
        final Matcher m = p.matcher(text);
        while (m.find()) {
            return m.group();
        }
        return EMPTY;
    }

    public static String findPattern(final String text, final String pattern, final int regexGroupNumber) {
        final Pattern p = Pattern.compile(pattern);
        final Matcher m = p.matcher(text);
        while (m.find()) {
            return m.group(regexGroupNumber);
        }
        return EMPTY;
    }

    public static String concatTimeSlotDate(final String date, final String time) {
        return date + SPACE + time.replace(".", ":");
    }

    public static synchronized String generateEmail(String domain) {
        return Long.toString(Math.abs(new Random().nextInt())) + (new Date()).getTime() + "@" + domain;
    }

    public static synchronized String generateCustomerIdHashFromEmail(String email) {
        return Hashing.sha256().hashString(email, StandardCharsets.UTF_8).toString();
    }

    public static String generatePhoneNumber(String prefix, int amountOfDigits) {
        return prefix + RandomStringUtils.random(amountOfDigits - prefix.length(), false, true);
    }

    public static String generateMobileNumberPrefixBE(String prefix) {
        return prefix + RandomStringUtils.random(1, '0', '1', '3', '5', '6', '7', '8');
    }

    public static synchronized String getLocalPartEmail(String email) {
        return email.substring(0, email.indexOf("@"));
    }

    public static synchronized String generateOrderNumber(String customerEmail) {
        return Math.abs(new Random().nextInt(1000)) + "_" + customerEmail.substring(0, customerEmail.indexOf("@")) + "_order";
    }

    public static synchronized String generateDeliveryAddressUid(String customerEmail) {
        return Long.toString(Math.abs(new Random().nextInt(100))) + " " + customerEmail;
    }
}
