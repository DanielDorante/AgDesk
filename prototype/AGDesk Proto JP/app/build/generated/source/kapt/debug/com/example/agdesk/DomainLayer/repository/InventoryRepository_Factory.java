package com.example.agdesk.DomainLayer.repository;

import com.example.agdesk.DataLayer.DAOs.InventoryDAO;
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
public final class InventoryRepository_Factory implements Factory<InventoryRepository> {
  private final Provider<InventoryDAO> inventoryDAOProvider;

  public InventoryRepository_Factory(Provider<InventoryDAO> inventoryDAOProvider) {
    this.inventoryDAOProvider = inventoryDAOProvider;
  }

  @Override
  public InventoryRepository get() {
    return newInstance(inventoryDAOProvider.get());
  }

  public static InventoryRepository_Factory create(Provider<InventoryDAO> inventoryDAOProvider) {
    return new InventoryRepository_Factory(inventoryDAOProvider);
  }

  public static InventoryRepository newInstance(InventoryDAO inventoryDAO) {
    return new InventoryRepository(inventoryDAO);
  }
}
