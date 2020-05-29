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
import android.util.Pair;
import android.util.Size;

import com.shift.cameraximpl.Logger;
import com.shift.cameraximpl.SettableCaptureStage;
import com.shift.cameraximpl.ShiftCaptureRequestKey;
import com.shift.cameraximpl.ShiftMetadata;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Stub implementation for HDR preview use case.
 *
 * <p>This class should be implemented by OEM and deployed to the target devices.
 *
 * @since 1.0
 */
public final class HdrPreviewExtenderImpl implements PreviewExtenderImpl {
    private static final String TAG = HdrPreviewExtenderImpl.class.getSimpleName();

    public HdrPreviewExtenderImpl() {
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
    public CaptureStageImpl getCaptureStage() {
        Logger.d(TAG, "getCaptureStage");

        final SettableCaptureStage captureStage = new SettableCaptureStage(0);
        captureStage
                .addCaptureRequestParameters(ShiftCaptureRequestKey.SESSION_OPERATION_MODE, ShiftMetadata.Session.TYPE_HDR)
                ;

        return captureStage;
    }

    @Override
    public ProcessorType getProcessorType() {
        Logger.d(TAG, "getProcessorType");

        return ProcessorType.PROCESSOR_TYPE_NONE;
    }

    @Override
    public ProcessorImpl getProcessor() {
        Logger.d(TAG, "getProcessor");

        return null;
    }

    @Override
    public void onInit(String cameraId, CameraCharacteristics cameraCharacteristics,
            Context context) {
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
