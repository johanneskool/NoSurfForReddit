/*
 * Copyright (c) 2018-present, Aaron J. Halbert.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See
 * the License for the specific language governing permissions and limitations under the License.
 */

package com.aaronhalbert.nosurfforreddit;

import android.app.Application;

import com.aaronhalbert.nosurfforreddit.di.application.ApplicationComponent;
import com.aaronhalbert.nosurfforreddit.di.application.ApplicationModule;
import com.aaronhalbert.nosurfforreddit.di.application.DaggerApplicationComponent;
import com.squareup.leakcanary.LeakCanary;

public class NoSurfApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initLeakCanary();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    @SuppressWarnings("UnusedReturnValue")
    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
