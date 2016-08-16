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

package com.igoticecream.pokemon.sniper.data.remote.pokesniper;

import java.util.Date;
import java.util.List;

import javax.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
@AutoValue
@SuppressWarnings({"unused", "FieldCanBeLocal", "WeakerAccess"})
public abstract class PokeSniperEntity {

	public static TypeAdapter<PokeSniperEntity> typeAdapter(Gson gson) {
		return new AutoValue_PokeSniperEntity.GsonTypeAdapter(gson);
	}

	@Nullable
	@SerializedName("results")
	public abstract List<PokeSniperPokemon> getList();

	@AutoValue
	public static abstract class PokeSniperPokemon {

		public static TypeAdapter<PokeSniperPokemon> typeAdapter(Gson gson) {
			return new AutoValue_PokeSniperEntity_PokeSniperPokemon.GsonTypeAdapter(gson);
		}

		@Nullable
		@SerializedName("id")
		public abstract Integer getId();

		@Nullable
		@SerializedName("name")
		public abstract String getName();

		@Nullable
		@SerializedName("coords")
		public abstract String getCoordinates();

		@Nullable
		@SerializedName("until")
		public abstract Date getExpirationDate();

		@Nullable
		@SerializedName("iv")
		public abstract Integer getIv();
	}
}
