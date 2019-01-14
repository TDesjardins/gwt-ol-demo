package com.github.tdesjardins.ol.demo.client.model;

import java.lang.String;

public final class UUID {

    private static final char[] CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    private UUID() {
    }

    public static String get() {

        char[] uuid = new char[36];
        int r;
        uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
        uuid[14] = '4';
        for (int i = 0; i < 36; i++) {
            if (uuid[i] == 0) {
                r = (int)(Math.random() * 16);
                uuid[i] = CHARS[(i == 19) ? (r & 0x3) | 0x8 : r & 0xf];
            }
        }

        return new String(uuid);

    }

}
