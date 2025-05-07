package com.example.agdesk.dependencyInjectionModulesHilt;

import com.example.agdesk.DataLayer.DAOs.DbSyncDAO;
import com.example.agdesk.DataLayer.database.AgDeskDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class DatabaseModule_ProvideSyncDaoFactory implements Factory<DbSyncDAO> {
  private final Provider<AgDeskDatabase> agDeskDatabaseProvider;

  public DatabaseModule_ProvideSyncDaoFactory(Provider<AgDeskDatabase> agDeskDatabaseProvider) {
    this.agDeskDatabaseProvider = agDeskDatabaseProvider;
  }

  @Override
  public DbSyncDAO get() {
    return provideSyncDao(agDeskDatabaseProvider.get());
  }

  public static DatabaseModule_ProvideSyncDaoFactory create(
      Provider<AgDeskDatabase> agDeskDatabaseProvider) {
    return new DatabaseModule_ProvideSyncDaoFactory(agDeskDatabaseProvider);
  }

  public static DbSyncDAO provideSyncDao(AgDeskDatabase agDeskDatabase) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideSyncDao(agDeskDatabase));
  }
}
