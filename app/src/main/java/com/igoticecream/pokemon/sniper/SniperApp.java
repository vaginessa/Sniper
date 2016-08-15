/*
 * Copyright (c) 2016. Pedro Diaz <igoticecream@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.igoticecream.pokemon.sniper;

import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nonnull;

import android.app.Application;
import android.content.Context;

import com.igoticecream.pokemon.sniper.common.logging.DebugTree;
import com.igoticecream.pokemon.sniper.injection.application.ApplicationComponent;
import com.igoticecream.pokemon.sniper.injection.application.ApplicationModule;
import com.igoticecream.pokemon.sniper.injection.application.DaggerApplicationComponent;
import com.igoticecream.pokemon.sniper.injection.network.NetworkModule;

import timber.log.Timber;

@SuppressWarnings({"unused", "FieldCanBeLocal", "WeakerAccess"})
public class SniperApp extends Application {

	public static SniperApp get(@Nonnull Context context) {
		return (SniperApp) context.getApplicationContext();
	}

	private ApplicationComponent mApplicationComponent;

	@Override
	public void onCreate() {
		super.onCreate();

		if (BuildConfig.DEBUG) {
			Timber.plant(DebugTree.create());
		}
	}

	public ApplicationComponent getComponent() {
		if (mApplicationComponent == null) {
			mApplicationComponent = DaggerApplicationComponent.builder()
				.applicationModule(new ApplicationModule(this))
				.networkModule(new NetworkModule(Proxy.NO_PROXY, 10, TimeUnit.SECONDS))
				.build();
		}
		return mApplicationComponent;
	}
}
