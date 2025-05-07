package com.example.agdesk.ViewModels;

import com.example.agdesk.DomainLayer.repository.FieldRepository;
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
public final class FieldViewModel_Factory implements Factory<FieldViewModel> {
  private final Provider<FieldRepository> repositoryProvider;

  public FieldViewModel_Factory(Provider<FieldRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public FieldViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static FieldViewModel_Factory create(Provider<FieldRepository> repositoryProvider) {
    return new FieldViewModel_Factory(repositoryProvider);
  }

  public static FieldViewModel newInstance(FieldRepository repository) {
    return new FieldViewModel(repository);
  }
}
