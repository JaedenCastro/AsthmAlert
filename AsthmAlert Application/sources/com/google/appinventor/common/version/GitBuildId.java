package com.google.appinventor.common.version;

import org.jose4j.jws.AlgorithmIdentifiers;

public final class GitBuildId {
    public static final String ANT_BUILD_DATE = "March 31 2024";
    public static final String GIT_BUILD_FINGERPRINT = "a745e2605d4392a37899931114b3fa5ad01d039d";
    public static final String GIT_BUILD_VERSION = "1.5C.3-Fenix";

    public static String getDate() {
        return ANT_BUILD_DATE;
    }

    public static String getFingerprint() {
        return GIT_BUILD_FINGERPRINT;
    }

    public static String getVersion() {
        return GIT_BUILD_VERSION != "" ? GIT_BUILD_VERSION : AlgorithmIdentifiers.NONE;
    }

    private GitBuildId() {
    }
}
