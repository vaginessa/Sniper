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

package com.igoticecream.pokemon.sniper.presentation;

import javax.inject.Inject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.igoticecream.pokemon.sniper.R;
import com.igoticecream.pokemon.sniper.SniperApp;
import com.igoticecream.pokemon.sniper.domain.feature.pokemon.GetPokemon;
import com.igoticecream.pokemon.sniper.injection.application.ApplicationComponent;

import timber.log.Timber;

@SuppressWarnings({"unused", "FieldCanBeLocal", "WeakerAccess"})
public class HomeActivity extends AppCompatActivity {

	@Inject
	GetPokemon mGetPokemon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		ApplicationComponent component = SniperApp.get(this).getComponent();
		component.inject(this);

		mGetPokemon.execute().subscribe(pokemon -> Timber.d(pokemon.toString()), throwable -> Timber.e(throwable, "Ups"));
	}
}
