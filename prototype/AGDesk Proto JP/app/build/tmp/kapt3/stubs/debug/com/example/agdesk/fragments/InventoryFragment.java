package com.example.agdesk.fragments;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u001eH\u0016J\u001a\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\"2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010,\u001a\u00020\u001eH\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\b\u0010.\u001a\u00020\u001eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006/"}, d2 = {"Lcom/example/agdesk/fragments/InventoryFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/agdesk/databinding/FragmentInventoryBinding;", "binding", "getBinding", "()Lcom/example/agdesk/databinding/FragmentInventoryBinding;", "dbHelper", "error/NonExistentClass", "getDbHelper", "()Lerror/NonExistentClass;", "setDbHelper", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "inventoryAdapter", "Lcom/example/agdesk/adapters/InventoryAdapter;", "getInventoryAdapter", "()Lcom/example/agdesk/adapters/InventoryAdapter;", "setInventoryAdapter", "(Lcom/example/agdesk/adapters/InventoryAdapter;)V", "listOfInventories", "Ljava/util/ArrayList;", "Lcom/example/agdesk/models/InventoryModel;", "Lkotlin/collections/ArrayList;", "getListOfInventories", "()Ljava/util/ArrayList;", "setListOfInventories", "(Ljava/util/ArrayList;)V", "filter", "", "text", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setAdapter", "setSortSpinner", "showAddInventoryDialog", "app_debug"})
public final class InventoryFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.agdesk.databinding.FragmentInventoryBinding _binding;
    @org.jetbrains.annotations.Nullable()
    private error.NonExistentClass dbHelper;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.agdesk.models.InventoryModel> listOfInventories;
    public com.example.agdesk.adapters.InventoryAdapter inventoryAdapter;
    
    public InventoryFragment() {
        super();
    }
    
    private final com.example.agdesk.databinding.FragmentInventoryBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final error.NonExistentClass getDbHelper() {
        return null;
    }
    
    public final void setDbHelper(@org.jetbrains.annotations.Nullable()
    error.NonExistentClass p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.agdesk.models.InventoryModel> getListOfInventories() {
        return null;
    }
    
    public final void setListOfInventories(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.agdesk.models.InventoryModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.agdesk.adapters.InventoryAdapter getInventoryAdapter() {
        return null;
    }
    
    public final void setInventoryAdapter(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.adapters.InventoryAdapter p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setAdapter() {
    }
    
    private final void showAddInventoryDialog() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    private final void setSortSpinner() {
    }
    
    public final void filter(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
}