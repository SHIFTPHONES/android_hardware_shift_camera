/*
 * Copyright 2019 The Android Open Source Project
 * Copyright (c) 2019-2020 SHIFT GmbH.
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

package androidx.camera.extensions.impl;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.util.Pair;
import android.util.Size;

import com.shift.cameraximpl.Logger;
import com.shift.cameraximpl.SettableCaptureStage;
import com.shift.cameraximpl.ShiftCaptureRequestKey;
import com.shift.cameraximpl.ShiftMetadata;

import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Stub implementation for HDR image capture use case.
 *
 * <p>This class should be implemented by OEM and deployed to the target devices.
 *
 * @since 1.0
 */
public final class HdrImageCaptureExtenderImpl implements ImageCaptureExtenderImpl {
    private static final String TAG = HdrImageCaptureExtenderImpl.class.getSimpleName();

    public HdrImageCaptureExtenderImpl() {
        // empty
    }

    @Override
    public boolean isExtensionAvailable(@NonNull String cameraId,
            @Nullable CameraCharacteristics cameraCharacteristics) {
        Logger.d(TAG, "isExtensionAvailable(" + cameraId + ", ...)");

        // we only support HDR for cameraId 0 and 1
        switch (cameraId) {
            case "0":
            case "1":
                return true;
            default:
                return false;
        }
    }

    @Override
    public void init(String cameraId, CameraCharacteristics cameraCharacteristics) {
        Logger.d(TAG, "enableExtension");
    }

    @Override
    public CaptureProcessorImpl getCaptureProcessor() {
        Logger.d(TAG, "getCaptureProcessor");

        return null;
    }

    @Override
    public List<CaptureStageImpl> getCaptureStages() {
        Logger.d(TAG, "getCaptureStages");

        final SettableCaptureStage captureStage = new SettableCaptureStage(0);
        captureStage
                .addCaptureRequestParameters(ShiftCaptureRequestKey.SESSION_OPERATION_MODE, ShiftMetadata.Session.TYPE_HDR)
                .addCaptureRequestParameters(CaptureRequest.CONTROL_MODE, CaptureRequest.CONTROL_MODE_USE_SCENE_MODE)
                .addCaptureRequestParameters(CaptureRequest.CONTROL_SCENE_MODE, CaptureRequest.CONTROL_SCENE_MODE_HDR)
                .addCaptureRequestParameters(ShiftCaptureRequestKey.HDR_CAPTURE_ENABLE, 1)
                .addCaptureRequestParameters(ShiftCaptureRequestKey.NOISE_REDUCTION_ENABLE, (byte) 0x01)
                ;

        return Collections.singletonList((CaptureStageImpl) captureStage);
    }

    @Override
    public int getMaxCaptureStage() {
        Logger.d(TAG, "getMaxCaptureStage");

        return 1;
    }

    @Override
    public void onInit(String cameraId, CameraCharacteristics cameraCharacteristics, Context context) {
        Logger.d(TAG, "onInit");
    }

    @Override
    public void onDeInit() {
        Logger.d(TAG, "onDeInit");
    }

    @Override
    public CaptureStageImpl onPresetSession() {
        Logger.d(TAG, "onPresetSession");

        final SettableCaptureStage presetSessionStage = new SettableCaptureStage(0);
        presetSessionStage
                .addCaptureRequestParameters(ShiftCaptureRequestKey.SESSION_OPERATION_MODE, ShiftMetadata.Session.TYPE_HDR)
                ;

        return presetSessionStage;
    }

    @Override
    public CaptureStageImpl onEnableSession() {
        Logger.d(TAG, "onEnableSession");

        final SettableCaptureStage enableSessionStage = new SettableCaptureStage(0);
        enableSessionStage
                .addCaptureRequestParameters(ShiftCaptureRequestKey.SESSION_OPERATION_MODE, ShiftMetadata.Session.TYPE_HDR)
                ;

        return enableSessionStage;
    }

    @Override
    public CaptureStageImpl onDisableSession() {
        Logger.d(TAG, "onDisableSession");

        return null;
    }

    @Override
    public List<Pair<Integer, Size[]>> getSupportedResolutions() {
        Logger.d(TAG, "getSupportedResolutions");

        // we support any resolution
        return null;
    }
}
