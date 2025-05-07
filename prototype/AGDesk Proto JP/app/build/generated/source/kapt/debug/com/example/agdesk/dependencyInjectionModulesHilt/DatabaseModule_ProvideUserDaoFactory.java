package com.example.agdesk.dependencyInjectionModulesHilt;

import com.example.agdesk.DataLayer.DAOs.UserDAO;
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
public final class DatabaseModule_ProvideUserDaoFactory implements Factory<UserDAO> {
  private final Provider<AgDeskDatabase> agDeskDatabaseProvider;

  public DatabaseModule_ProvideUserDaoFactory(Provider<AgDeskDatabase> agDeskDatabaseProvider) {
    this.agDeskDatabaseProvider = agDeskDatabaseProvider;
  }

  @Override
  public UserDAO get() {
    return provideUserDao(agDeskDatabaseProvider.get());
  }

  public static DatabaseModule_ProvideUserDaoFactory create(
      Provider<AgDeskDatabase> agDeskDatabaseProvider) {
    return new DatabaseModule_ProvideUserDaoFactory(agDeskDatabaseProvider);
  }

  public static UserDAO provideUserDao(AgDeskDatabase agDeskDatabase) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideUserDao(agDeskDatabase));
  }
}
