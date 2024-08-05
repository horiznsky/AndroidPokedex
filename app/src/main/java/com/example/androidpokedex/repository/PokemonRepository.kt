package com.example.androidpokedex.repository

import com.example.androidpokedex.data.remote.PokeAPI
import com.example.androidpokedex.data.remote.responses.PokemonList
import com.example.androidpokedex.data.remote.responses.Pokemon
import com.example.androidpokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeAPI
){
    suspend fun getPokemonList(limit: Int, offset: Int):Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        }catch (e: Exception) {
            return Resource.Error("An Unknown Error Occured")
        }
        return Resource.Success(response)
    }


    suspend fun getPokemonInfo(pokemonName: String):Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        }catch (e: Exception) {
            return Resource.Error("An Unknown Error Occured")
        }
        return Resource.Success(response)
    }
}