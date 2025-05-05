package com.example.agdesk.TestData;

import com.example.agdesk.repository.AssetRepository;
import com.example.agdesk.repository.NetworkRepository;
import com.example.agdesk.repository.TaskRepository;
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
public final class dbDataCreator_Factory implements Factory<dbDataCreator> {
  private final Provider<NetworkRepository> networkRepositoryProvider;

  private final Provider<AssetRepository> assetRepositoryProvider;

  private final Provider<TaskRepository> taskRepositoryProvider;

  public dbDataCreator_Factory(Provider<NetworkRepository> networkRepositoryProvider,
      Provider<AssetRepository> assetRepositoryProvider,
      Provider<TaskRepository> taskRepositoryProvider) {
    this.networkRepositoryProvider = networkRepositoryProvider;
    this.assetRepositoryProvider = assetRepositoryProvider;
    this.taskRepositoryProvider = taskRepositoryProvider;
  }

  @Override
  public dbDataCreator get() {
    return newInstance(networkRepositoryProvider.get(), assetRepositoryProvider.get(), taskRepositoryProvider.get());
  }

  public static dbDataCreator_Factory create(Provider<NetworkRepository> networkRepositoryProvider,
      Provider<AssetRepository> assetRepositoryProvider,
      Provider<TaskRepository> taskRepositoryProvider) {
    return new dbDataCreator_Factory(networkRepositoryProvider, assetRepositoryProvider, taskRepositoryProvider);
  }

  public static dbDataCreator newInstance(NetworkRepository networkRepository,
      AssetRepository assetRepository, TaskRepository taskRepository) {
    return new dbDataCreator(networkRepository, assetRepository, taskRepository);
  }
}
