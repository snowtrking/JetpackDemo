package com.example.jetpackdemo.viewmodel

import androidx.lifecycle.*
import com.example.jetpackdemo.db.data.Shoe
import com.example.jetpackdemo.db.repository.ShoeRepository

class ShoeModel constructor(shoeRepository: ShoeRepository) : ViewModel() {

    private val brand = MutableLiveData<String>().apply {
        value = ALL
    }

    val shoes: LiveData<List<Shoe>> = brand.switchMap {
        shoeRepository.getAllShoes()
    }

    fun setBrand(brand: String) {
        this.brand.value = brand

        this.brand.map {

        }
    }

    fun clearBrand() {
        this.brand.value = ALL
    }

    companion object {
        private const val ALL = "所有"

        public const val NIKE = "Nike"
        public const val ADIDAS = "Adidas"
        public const val OTHER = "other"
    }
}