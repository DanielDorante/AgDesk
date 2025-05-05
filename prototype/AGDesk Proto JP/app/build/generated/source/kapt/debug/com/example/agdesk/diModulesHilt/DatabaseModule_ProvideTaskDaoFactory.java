package com.example.agdesk.diModulesHilt;

import com.example.agdesk.DataLayer.DAOs.TaskDAO;
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
public final class DatabaseModule_ProvideTaskDaoFactory implements Factory<TaskDAO> {
  private final Provider<AgDeskDatabase> agDeskDatabaseProvider;

  public DatabaseModule_ProvideTaskDaoFactory(Provider<AgDeskDatabase> agDeskDatabaseProvider) {
    this.agDeskDatabaseProvider = agDeskDatabaseProvider;
  }

  @Override
  public TaskDAO get() {
    return provideTaskDao(agDeskDatabaseProvider.get());
  }

  public static DatabaseModule_ProvideTaskDaoFactory create(
      Provider<AgDeskDatabase> agDeskDatabaseProvider) {
    return new DatabaseModule_ProvideTaskDaoFactory(agDeskDatabaseProvider);
  }

  public static TaskDAO provideTaskDao(AgDeskDatabase agDeskDatabase) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideTaskDao(agDeskDatabase));
  }
}
