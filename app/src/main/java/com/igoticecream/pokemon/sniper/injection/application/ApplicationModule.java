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

package com.igoticecream.pokemon.sniper.injection.application;

import javax.inject.Singleton;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.igoticecream.pokemon.sniper.data.executor.IoThread;
import com.igoticecream.pokemon.sniper.data.remote.pokemon.PokemonDataRepository;
import com.igoticecream.pokemon.sniper.data.remote.pokemon.pokesniper.PokeSniperService;
import com.igoticecream.pokemon.sniper.data.remote.pokemon.pokesniper.PokeSniperServiceFactory;
import com.igoticecream.pokemon.sniper.data.remote.pokemon.skiplagged.SkipLaggedService;
import com.igoticecream.pokemon.sniper.data.remote.pokemon.skiplagged.SkipLaggedServiceFactory;
import com.igoticecream.pokemon.sniper.domain.executor.ExecutorThread;
import com.igoticecream.pokemon.sniper.domain.executor.PostExecutionThread;
import com.igoticecream.pokemon.sniper.domain.feature.pokemon.PokemonRepository;
import com.igoticecream.pokemon.sniper.presentation.executor.UiThread;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
@SuppressWarnings({"unused", "FieldCanBeLocal", "WeakerAccess"})
public final class ApplicationModule {

	private final Application mApplication;

	public ApplicationModule(@NonNull Application application) {
		mApplication = application;
	}

	@Provides
	public Application provideApplication() {
		return mApplication;
	}

	@Provides
	@ApplicationContext
	public Context provideContext() {
		return mApplication;
	}

	@Provides
	@Singleton
	public PokeSniperService providePokeSniperService(OkHttpClient client, Gson gson) {
		return PokeSniperServiceFactory.create(client, gson);
	}

	@Provides
	@Singleton
	public SkipLaggedService provideSkipLaggedService(OkHttpClient client, Gson gson) {
		return SkipLaggedServiceFactory.create(client, gson);
	}

	@Provides
	@Singleton
	public PokemonRepository providePokemonRepository(PokemonDataRepository repository) {
		return repository;
	}

	@Provides
	@Singleton
	public ExecutorThread provideExecutorThread(IoThread thread) {
		return thread;
	}

	@Provides
	@Singleton
	public PostExecutionThread providePostExecutionThread(UiThread thread) {
		return thread;
	}
}
