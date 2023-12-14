package com.plcoding.searchfieldcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

@OptIn(FlowPreview::class)
class MainViewModel: ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _plants = MutableStateFlow(allPlants)
    val plants = searchText
        .debounce(1000L)
        .onEach { _isSearching.update { true } }
        .combine(_plants) { text, _plants ->
            if(text.isBlank()) {
                _plants
            } else {
                delay(2000L)
                _plants.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _plants.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }
}

data class Plant(
    val name: String
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$name",
            "${name.first()}}",
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}

private val allPlants = listOf(
    Plant(
        name = "shittake"
    ),
    Plant(
        name = "Sharttake",
    ),
)