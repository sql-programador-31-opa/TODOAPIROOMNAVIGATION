package com.opapruebas.pruebastodoapi.di

import android.app.Application
import com.opapruebas.pruebastodoapi.data.daoTarea
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.opapruebas.pruebastodoapi.TareaRepository.TareaRepository
import com.opapruebas.pruebastodoapi.data.BDMaster

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideTareaRepository(
        daoTarea: daoTarea
    ): TareaRepository{
        return TareaRepository(daotarea = daoTarea)
    }

    @Singleton
    @Provides
    fun provideDBMaster(app : Application): BDMaster {
        return BDMaster.getInstance(context = app)
    }
    @Singleton
    @Provides
    fun provideTareaDao(dbMaster: BDMaster):daoTarea{
        return dbMaster.daoTarea()
    }
}