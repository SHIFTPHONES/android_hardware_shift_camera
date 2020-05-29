/*
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

package com.shift.cameraximpl;

import android.hardware.camera2.CaptureRequest;
import android.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.camera.extensions.impl.CaptureStageImpl;

/**
 * Wrapper around {@link CaptureStageImpl} to provide a better looking API for adding
 * {@link CaptureRequest.Key}s and their values.
 */
public final class SettableCaptureStage implements CaptureStageImpl {
    private final int mId;
    private final Map<CaptureRequest.Key, Object> mCaptureRequestKeyValueMap = new HashMap<>();

    public SettableCaptureStage(int id) {
        this.mId = id;
    }

    public SettableCaptureStage addCaptureRequestParameters(CaptureRequest.Key requestKey, Object requestObject) {
        this.mCaptureRequestKeyValueMap.put(requestKey, requestObject);
        return this;
    }

    @Override
    public int getId() {
        return this.mId;
    }

    @Override
    public List<Pair<CaptureRequest.Key, Object>> getParameters() {
        final ArrayList<Pair<CaptureRequest.Key, Object>> parameterList = new ArrayList<>();
        for (final Map.Entry entry : this.mCaptureRequestKeyValueMap.entrySet()) {
            parameterList.add(Pair.create((CaptureRequest.Key) entry.getKey(), entry.getValue()));
        }
        return parameterList;
    }
}
