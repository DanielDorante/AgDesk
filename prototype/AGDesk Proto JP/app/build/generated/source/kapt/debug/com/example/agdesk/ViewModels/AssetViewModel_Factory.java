package com.example.agdesk.ViewModels;

import com.example.agdesk.repository.AssetRepository;
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
public final class AssetViewModel_Factory implements Factory<AssetViewModel> {
  private final Provider<AssetRepository> assetRepositoryProvider;

  public AssetViewModel_Factory(Provider<AssetRepository> assetRepositoryProvider) {
    this.assetRepositoryProvider = assetRepositoryProvider;
  }

  @Override
  public AssetViewModel get() {
    return newInstance(assetRepositoryProvider.get());
  }

  public static AssetViewModel_Factory create(Provider<AssetRepository> assetRepositoryProvider) {
    return new AssetViewModel_Factory(assetRepositoryProvider);
  }

  public static AssetViewModel newInstance(AssetRepository assetRepository) {
    return new AssetViewModel(assetRepository);
  }
}
