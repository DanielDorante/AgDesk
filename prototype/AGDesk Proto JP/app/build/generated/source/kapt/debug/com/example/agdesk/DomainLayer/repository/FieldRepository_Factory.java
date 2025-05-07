package com.example.agdesk.DomainLayer.repository;

import com.example.agdesk.DataLayer.DAOs.FieldDAO;
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
public final class FieldRepository_Factory implements Factory<FieldRepository> {
  private final Provider<FieldDAO> fieldDAOProvider;

  public FieldRepository_Factory(Provider<FieldDAO> fieldDAOProvider) {
    this.fieldDAOProvider = fieldDAOProvider;
  }

  @Override
  public FieldRepository get() {
    return newInstance(fieldDAOProvider.get());
  }

  public static FieldRepository_Factory create(Provider<FieldDAO> fieldDAOProvider) {
    return new FieldRepository_Factory(fieldDAOProvider);
  }

  public static FieldRepository newInstance(FieldDAO fieldDAO) {
    return new FieldRepository(fieldDAO);
  }
}
