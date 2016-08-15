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

import com.igoticecream.pokemon.sniper.data.PokeSniperService;
import com.igoticecream.pokemon.sniper.data.PokeSniperServiceFactory;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

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
	public PokeSniperService providePokeSniperService(Retrofit.Builder builder) {
		return PokeSniperServiceFactory.create(builder);
	}
}
