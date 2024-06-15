package com.example.order.common.util;

/* PK를 외부로 노출시키지 않기 위하여 외부에서 사용할 고유값을 생성하는 객체 */

import org.apache.commons.lang3.RandomStringUtils;

public class TokenGenerator {
    private static final int TOKEN_LENGTH = 20;

    public static String randomCharacter(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String randomCharacterWithPrefix(String prefix) {
        return prefix + randomCharacter(TOKEN_LENGTH - prefix.length());
    }
}
