package com.example.agdesk.DomainLayer.repository;

import com.example.agdesk.DataLayer.DAOs.AssetDAO;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class AssetRepository_Factory implements Factory<AssetRepository> {
  private final Provider<AssetDAO> assetDAOProvider;

  public AssetRepository_Factory(Provider<AssetDAO> assetDAOProvider) {
    this.assetDAOProvider = assetDAOProvider;
  }

  @Override
  public AssetRepository get() {
    return newInstance(assetDAOProvider.get());
  }

  public static AssetRepository_Factory create(Provider<AssetDAO> assetDAOProvider) {
    return new AssetRepository_Factory(assetDAOProvider);
  }

  public static AssetRepository newInstance(AssetDAO assetDAO) {
    return new AssetRepository(assetDAO);
  }
}
