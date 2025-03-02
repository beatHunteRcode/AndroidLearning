package com.example.androidlearning.dagger.di

import com.example.androidlearning.dagger.Computer
import com.example.androidlearning.dagger.Motherboard
import com.example.androidlearning.dagger.Processor
import com.example.androidlearning.dagger.RAM
import dagger.Module
import dagger.Provides

@Module
object AppModule {
    @Provides
    fun provideComputer(
        processor: Processor,
        motherboard: Motherboard,
        ram: RAM
    ): Computer = Computer(
        processor = processor,
        motherboard = motherboard,
        ram = ram
    )

    @Provides
    fun provideProcessor(): Processor = Processor()

    @Provides
    fun provideMotherboard(): Motherboard = Motherboard()

    @Provides
    fun provideRAM(): RAM = RAM()
}