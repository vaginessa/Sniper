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

package com.igoticecream.pokemon.sniper.common.rx;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

@SuppressWarnings({"unused", "FieldCanBeLocal", "WeakerAccess"})
public final class RxBus {
	
	private static volatile RxBus sInstance = null;
	
	public static RxBus getInstance() {
		if (sInstance == null) {
			synchronized (RxBus.class) {
				if (sInstance == null) {
					sInstance = new RxBus();
				}
			}
		}
		return sInstance;
	}
	
	private final Subject<Object, Object> mSubject = new SerializedSubject<>(PublishSubject.create());
	
	private RxBus() {
	}
	
	public void post(Object event) {
		mSubject.onNext(event);
	}
	
	public <T> Subscription receive(final Class<T> klass, Action1<T> onNext) {
		return receive(klass).subscribe(onNext);
	}
	
	public <T> Observable<T> receive(final Class<T> klass) {
		return receive().ofType(klass);
	}
	
	public Observable<Object> receive() {
		return mSubject.asObservable();
	}
}
