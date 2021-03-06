package com.mochamadfghd.habitstracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// NIM   : 10117198
// Nama  : Mochamad Fikri Fadila Akbar
// Kelas : IF5

class HabitsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: HabitsRepository
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allHabits: LiveData<List<Habits>>

    init {
        val habitsDao = HabitsRoomDatabase.getDatabase(application, viewModelScope).habitsDao()
        repository = HabitsRepository(habitsDao)
        allHabits = repository.allHabits
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(habits: Habits) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(habits)
    }
    fun update(habits: Habits) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(habits)
    }
    fun delete(habits: Habits) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(habits)
    }
}