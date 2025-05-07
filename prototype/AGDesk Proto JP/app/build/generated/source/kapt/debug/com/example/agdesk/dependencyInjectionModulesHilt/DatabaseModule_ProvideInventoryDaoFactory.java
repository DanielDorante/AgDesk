package com.example.agdesk.dependencyInjectionModulesHilt;

import com.example.agdesk.DataLayer.DAOs.InventoryDAO;
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
public final class DatabaseModule_ProvideInventoryDaoFactory implements Factory<InventoryDAO> {
  private final Provider<AgDeskDatabase> agDeskDatabaseProvider;

  public DatabaseModule_ProvideInventoryDaoFactory(
      Provider<AgDeskDatabase> agDeskDatabaseProvider) {
    this.agDeskDatabaseProvider = agDeskDatabaseProvider;
  }

  @Override
  public InventoryDAO get() {
    return provideInventoryDao(agDeskDatabaseProvider.get());
  }

  public static DatabaseModule_ProvideInventoryDaoFactory create(
      Provider<AgDeskDatabase> agDeskDatabaseProvider) {
    return new DatabaseModule_ProvideInventoryDaoFactory(agDeskDatabaseProvider);
  }

  public static InventoryDAO provideInventoryDao(AgDeskDatabase agDeskDatabase) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideInventoryDao(agDeskDatabase));
  }
}
