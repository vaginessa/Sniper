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

package com.igoticecream.pokemon.sniper.domain.feature.pokemon;

import javax.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
@SuppressWarnings({"unused", "FieldCanBeLocal", "WeakerAccess"})
public abstract class Pokemon {

	public static Builder builder() {
		return new AutoValue_Pokemon.Builder();
	}

	@Nullable
	public abstract String getName();
	@Nullable
	public abstract Integer getId();
	@Nullable
	public abstract Integer getIv();
	@Nullable
	public abstract Boolean getVerified();
	@Nullable
	public abstract Double getLatitude();
	@Nullable
	public abstract Double getLongitude();
	@Nullable
	public abstract Long getExpirationDate();

	@AutoValue.Builder
	public abstract static class Builder {
		public abstract Builder setId(@Nullable Integer id);
		public abstract Builder setName(@Nullable String name);
		public abstract Builder setIv(@Nullable Integer iv);
		public abstract Builder setVerified(@Nullable Boolean verified);
		public abstract Builder setLatitude(@Nullable Double latitude);
		public abstract Builder setLongitude(@Nullable Double longitude);
		public abstract Builder setExpirationDate(@Nullable Long expirationDate);

		public abstract Pokemon build();
	}
}
