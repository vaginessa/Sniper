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

package com.igoticecream.pokemon.sniper.data.remote.pokemon.pokesniper;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.igoticecream.pokemon.sniper.data.mapper.Mapper;
import com.igoticecream.pokemon.sniper.domain.feature.pokemon.Pokemon;

import timber.log.Timber;

@Singleton
@SuppressWarnings({"unused", "FieldCanBeLocal", "WeakerAccess"})
public final class PokeSniperEntityMapper extends Mapper<PokeSniperEntity.PokeSniperPokemon, Pokemon> {

	@Inject
	public PokeSniperEntityMapper() {

	}

	@Nullable
	@Override
	public Pokemon transform(PokeSniperEntity.PokeSniperPokemon from) {
		if (from != null && from.getCoordinates() != null && from.getExpirationDate() != null) {
			try {
				return Pokemon.builder()
					.setId(from.getId())
					.setName(from.getName())
					.setIv(from.getIv())
					.setVerified(false)
					.setLatitude(Double.valueOf(from.getCoordinates().split(",")[0]))
					.setLongitude(Double.valueOf(from.getCoordinates().split(",")[1]))
					.setExpirationDate(from.getExpirationDate().getTime())
					.build();
			}
			catch (Exception e) {
				Timber.e(e, "Cannot format pokemon entity: %s", from.toString());
			}
		}
		return null;
	}
}
