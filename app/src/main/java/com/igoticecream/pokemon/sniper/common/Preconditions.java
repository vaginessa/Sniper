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

package com.igoticecream.pokemon.sniper.common;

import javax.annotation.Nullable;

@SuppressWarnings({"unused", "FieldCanBeLocal", "WeakerAccess"})
public final class Preconditions {

	private Preconditions() {
		throw new AssertionError("No instances");
	}

	public static void checkArgument(boolean expression) {
		if (!expression) {
			throw new IllegalArgumentException();
		}
	}

	public static void checkArgument(boolean expression, @Nullable Object errorMessage) {
		if (!expression) {
			throw new IllegalArgumentException(String.valueOf(errorMessage));
		}
	}

	public static void checkArgument(boolean expression, @Nullable Object errorMessageTemplate, @Nullable Object... errorMessageArgs) {
		if (!expression) {
			throw new IllegalArgumentException(String.format(String.valueOf(errorMessageTemplate), errorMessageArgs));
		}
	}

	public static <T> T checkNotNull(T reference) {
		if (reference == null) {
			throw new NullPointerException();
		}
		return reference;
	}

	public static <T> T checkNotNull(T reference, @Nullable Object errorMessage) {
		if (reference == null) {
			throw new NullPointerException(String.valueOf(errorMessage));
		}
		return reference;
	}

	public static <T> T checkNotNull(T reference, @Nullable Object errorMessageTemplate, @Nullable Object... errorMessageArgs) {
		if (reference == null) {
			throw new NullPointerException(String.format(String.valueOf(errorMessageTemplate), errorMessageArgs));
		}
		return reference;
	}
}
