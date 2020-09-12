/*
 * Copyright (c) 2020 SHIFT GmbH.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.shift.camera;

import android.hardware.camera2.CaptureRequest;

public final class CaptureRequestKey {
    public static final CaptureRequest.Key<Integer> BOKEH_CAPTURE_LEVEL;
    public static final CaptureRequest.Key<Integer> BOKEH_PREVIEW_LEVEL;
    public static final CaptureRequest.Key<Integer> HDR_CAPTURE_ENABLE;
    public static final CaptureRequest.Key<Byte> NOISE_REDUCTION_ENABLE;
    public static final CaptureRequest.Key<Integer> SESSION_OPERATION_MODE;

    static {
        BOKEH_CAPTURE_LEVEL = new CaptureRequest.Key<>("com.shift.capture.bokeh.level", Integer.class);
        BOKEH_PREVIEW_LEVEL = new CaptureRequest.Key<>("com.shift.preview.bokeh.level", Integer.class);
        HDR_CAPTURE_ENABLE = new CaptureRequest.Key<>("com.shift.capture.hdr.enable", Integer.class);
        NOISE_REDUCTION_ENABLE = new CaptureRequest.Key<>("org.quic.camera.CustomNoiseReduction.CustomNoiseReduction", Byte.class);
        SESSION_OPERATION_MODE = new CaptureRequest.Key<>("com.shift.session.operation_mode", Integer.class);
    }

    private CaptureRequestKey() {
        // empty
    }
}
