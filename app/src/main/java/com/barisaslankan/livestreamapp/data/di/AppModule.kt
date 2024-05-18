package com.barisaslankan.livestreamapp.data.di

import com.barisaslankan.livestreamapp.data.remote.WindyApi
import com.barisaslankan.livestreamapp.data.repository.Repository
import com.barisaslankan.livestreamapp.domain.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideWindyApi(): WindyApi {
        return Retrofit.Builder()
            .baseUrl("https://api.windy.com/webcams/api/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WindyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api : WindyApi) : Repository{
        return RepositoryImpl(api = api)
    }
}
