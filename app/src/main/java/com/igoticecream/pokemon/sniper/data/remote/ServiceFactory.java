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

package com.igoticecream.pokemon.sniper.data.remote;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressWarnings({"unused", "FieldCanBeLocal", "WeakerAccess"})
public abstract class ServiceFactory {

	protected static Retrofit createRetrofit(OkHttpClient client, Gson gson, String baseUrl) {
		return new Retrofit.Builder()
			.client(client)
			.baseUrl(baseUrl)
			.addConverterFactory(GsonConverterFactory.create(gson))
			.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
			.build();
	}
}
