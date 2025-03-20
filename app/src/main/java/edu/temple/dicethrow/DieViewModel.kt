package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel : ViewModel(){

    private var dieSides = 6

    private val currentRoll : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun getCurrentRoll() : LiveData<Int> {
        return currentRoll
    }

    fun setCurrentRoll(roll: Int) {
        currentRoll.value = roll
    }

    fun rollDie() {
        setCurrentRoll(Random.nextInt(1, dieSides + 1))
    }


}