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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.igoticecream.pokemon.sniper.common.Preconditions.checkNotNull;

@SuppressWarnings({"unused", "FieldCanBeLocal", "WeakerAccess"})
public final class Strings {

	public static final String EMPTY = "";
	public static final String DOT = ".";
	public static final String COLON = ":";
	public static final String SPACE = " ";

	private Strings() {
		throw new AssertionError("No instances");
	}

	public static boolean isNullOrEmpty(@Nullable String string) {
		return string == null || string.trim().length() == 0;
	}

	public static String nullToEmpty(@Nullable String string) {
		return (string == null) ? EMPTY : string;
	}

	@Nullable
	public static String emptyToNull(@Nullable String string) {
		return isNullOrEmpty(string) ? null : string;
	}

	public static String valueOrDefault(@Nullable String string, String defaultString) {
		return isNullOrEmpty(string) ? defaultString : string;
	}

	public static String truncateAt(@Nonnull String string, int length) {
		checkNotNull(string);
		return (string.length() > length) ? string.substring(0, length) : string;
	}

	public static String padEnd(@Nonnull String string, int minLength, char padChar) {
		checkNotNull(string);

		if (string.length() >= minLength) {
			return string;
		}
		StringBuilder sb = new StringBuilder(minLength);
		sb.append(string);
		for (int i = string.length(); i < minLength; i++) {
			sb.append(padChar);
		}
		return sb.toString();
	}

	public static String padStart(@Nonnull String string, int minLength, char padChar) {
		checkNotNull(string);

		if (string.length() >= minLength) {
			return string;
		}
		StringBuilder sb = new StringBuilder(minLength);
		for (int i = string.length(); i < minLength; i++) {
			sb.append(padChar);
		}
		sb.append(string);
		return sb.toString();
	}
}
