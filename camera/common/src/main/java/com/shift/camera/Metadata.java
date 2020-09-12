package com.shift.camera;

import android.hardware.camera2.params.SessionConfiguration;

import java.util.HashSet;
import java.util.Set;

public final class Metadata {
    private Metadata() {
        // empty
    }

    public static final class Bokeh {
        public static final Integer SESSION_TYPE = 0x8003;

        private static final Set<Integer> SUPPORTED_CAMERA_IDS = new HashSet<>();
        static {
            SUPPORTED_CAMERA_IDS.add(4);
        }

        public static boolean supportsCameraId(final int cameraId) {
            return SUPPORTED_CAMERA_IDS.contains(cameraId);
        }

        public static final int CAPTURE_LEVEL_DEFAULT_VALUE = 75;
        public static final int PREVIEW_LEVEL_DEFAULT_VALUE = 75;

        private Bokeh() {
            // empty
        }
    }

    public static final class HDR {
        public static final Integer SESSION_TYPE = 0x8001;

        private static final Set<Integer> SUPPORTED_CAMERA_IDS = new HashSet<>();
        static {
            SUPPORTED_CAMERA_IDS.add(0);
            SUPPORTED_CAMERA_IDS.add(1);
        }

        public static boolean supportsCameraId(final int cameraId) {
            return SUPPORTED_CAMERA_IDS.contains(cameraId);
        }

        private HDR() {
            // empty
        }
    }

    public static final class LowLightShot {
        public static final Integer SESSION_TYPE = 0x8001;

        private static final Set<Integer> SUPPORTED_CAMERA_IDS = new HashSet<>();
        static {
            SUPPORTED_CAMERA_IDS.add(0);
            SUPPORTED_CAMERA_IDS.add(1);
        }

        public static boolean supportsCameraId(final int cameraId) {
            return SUPPORTED_CAMERA_IDS.contains(cameraId);
        }

        private LowLightShot() {
            // empty
        }
    }

    public static final class VideoStabilization {
        public static final Integer SESSION_TYPE = SessionConfiguration.SESSION_REGULAR;
        public static final Integer STREAM_CONFIG_OPT_MODE = 0x8002;

        private static final Set<Integer> SUPPORTED_CAMERA_IDS = new HashSet<>();
        static {
            SUPPORTED_CAMERA_IDS.add(0);
        }

        public static boolean supportsCameraId(final int cameraId) {
            return SUPPORTED_CAMERA_IDS.contains(cameraId);
        }

        private VideoStabilization() {
            // empty
        }
    }
}
