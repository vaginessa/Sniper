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

package com.igoticecream.pokemon.sniper.presentation.executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.igoticecream.pokemon.sniper.domain.executor.PostExecutionThread;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

@Singleton
@SuppressWarnings({"unused", "FieldCanBeLocal", "WeakerAccess"})
public final class UiThread implements PostExecutionThread {

	@Inject
	public UiThread() {
	}

	@Override
	public Scheduler getScheduler() {
		return AndroidSchedulers.mainThread();
	}
}
