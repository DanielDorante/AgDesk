package com.example.agdesk.WorkManger;

import com.example.agdesk.repository.NetworkRepository;
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
public final class CustomWorkerFactory_Factory implements Factory<CustomWorkerFactory> {
  private final Provider<NetworkRepository> networkRepositoryProvider;

  public CustomWorkerFactory_Factory(Provider<NetworkRepository> networkRepositoryProvider) {
    this.networkRepositoryProvider = networkRepositoryProvider;
  }

  @Override
  public CustomWorkerFactory get() {
    return newInstance(networkRepositoryProvider.get());
  }

  public static CustomWorkerFactory_Factory create(
      Provider<NetworkRepository> networkRepositoryProvider) {
    return new CustomWorkerFactory_Factory(networkRepositoryProvider);
  }

  public static CustomWorkerFactory newInstance(NetworkRepository networkRepository) {
    return new CustomWorkerFactory(networkRepository);
  }
}
