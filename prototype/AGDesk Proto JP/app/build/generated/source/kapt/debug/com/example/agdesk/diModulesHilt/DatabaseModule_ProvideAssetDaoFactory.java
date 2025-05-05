package com.example.agdesk.diModulesHilt;

import com.example.agdesk.DataLayer.DAOs.AssetDAO;
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
public final class DatabaseModule_ProvideAssetDaoFactory implements Factory<AssetDAO> {
  private final Provider<AgDeskDatabase> agDeskDatabaseProvider;

  public DatabaseModule_ProvideAssetDaoFactory(Provider<AgDeskDatabase> agDeskDatabaseProvider) {
    this.agDeskDatabaseProvider = agDeskDatabaseProvider;
  }

  @Override
  public AssetDAO get() {
    return provideAssetDao(agDeskDatabaseProvider.get());
  }

  public static DatabaseModule_ProvideAssetDaoFactory create(
      Provider<AgDeskDatabase> agDeskDatabaseProvider) {
    return new DatabaseModule_ProvideAssetDaoFactory(agDeskDatabaseProvider);
  }

  public static AssetDAO provideAssetDao(AgDeskDatabase agDeskDatabase) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideAssetDao(agDeskDatabase));
  }
}
