package com.shift.camera;

public final class Metadata {
    private Metadata() {
        // empty
    }

    public static final class Bokeh {
        public static final Integer CAMERA_ID = 4;

        public static final int CAPTURE_LEVEL_DEFAULT_VALUE = 75;
        public static final int PREVIEW_LEVEL_DEFAULT_VALUE = 75;

        private Bokeh() {
            // empty
        }
    }

    public static final class Session {
        public static final Integer TYPE_HDR = 0x8001;
        public static final Integer TYPE_LLS = 0x8001;
        public static final Integer TYPE_BOKEH = 0x8003;
        public static final Integer TYPE_VIDEO_STAB = 0x8004;

        private Session() {
            // empty
        }
    }
}
