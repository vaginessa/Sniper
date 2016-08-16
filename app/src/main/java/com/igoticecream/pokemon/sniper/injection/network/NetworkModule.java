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

package com.igoticecream.pokemon.sniper.injection.network;

import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.igoticecream.pokemon.sniper.common.gson.GsonAdapterFactory;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module
@SuppressWarnings({"unused", "FieldCanBeLocal", "WeakerAccess"})
public class NetworkModule {

	@Nullable
	private final Proxy mProxy;
	private final long mTimeout;
	private final TimeUnit mTimeUnit;

	public NetworkModule(@Nullable Proxy proxy, long timeout, @NonNull TimeUnit timeUnit) {
		mProxy = proxy;
		mTimeout = timeout;
		mTimeUnit = timeUnit;
	}

	@Provides
	public Proxy provideProxy() {
		return (mProxy == null) ? Proxy.NO_PROXY : mProxy;
	}

	@Provides
	@Singleton
	public Cache provideCache(Application application) {
		return new Cache(application.getCacheDir(), 10 * 1024 * 1024); // 10 MB
	}

	@Provides
	@Singleton
	public HttpLoggingInterceptor provideLoggingInterceptor() {
		return new HttpLoggingInterceptor(Timber::d).setLevel(HttpLoggingInterceptor.Level.NONE);
	}

	@Provides
	@Singleton
	public Interceptor provideInterceptor() {
		return chain -> chain.proceed(chain.request());
	}

	@Provides
	@Singleton
	public Gson provideGson() {
		return new GsonBuilder()
			.registerTypeAdapterFactory(GsonAdapterFactory.create())
			.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.create();
	}

	@Provides
	@Singleton
	public OkHttpClient provideClient(Cache cache, Proxy proxy, Interceptor interceptor, HttpLoggingInterceptor logging) {
		return new OkHttpClient.Builder()
			.cache(cache)
			.proxy(proxy)
			.followRedirects(false)
			.followSslRedirects(false)
			.addInterceptor(logging)
			.addInterceptor(interceptor)
			.readTimeout(mTimeout, mTimeUnit)
			.writeTimeout(mTimeout, mTimeUnit)
			.connectTimeout(mTimeout, mTimeUnit)
			.build();
	}
}
