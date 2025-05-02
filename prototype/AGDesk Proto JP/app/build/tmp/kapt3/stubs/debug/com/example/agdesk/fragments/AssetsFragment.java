package com.example.agdesk.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0016J\u000e\u0010\'\u001a\u00020#2\u0006\u0010(\u001a\u00020)J\u0012\u0010*\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00103\u001a\u00020#H\u0016J\u001a\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020\u0017H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f\u00a8\u00068"}, d2 = {"Lcom/example/agdesk/fragments/AssetsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/agdesk/models/OnClick;", "()V", "_binding", "Lcom/example/agdesk/databinding/FragmentAssetsBinding;", "assetsAdapter", "Lcom/example/agdesk/adapters/AssetsAdapter;", "getAssetsAdapter", "()Lcom/example/agdesk/adapters/AssetsAdapter;", "setAssetsAdapter", "(Lcom/example/agdesk/adapters/AssetsAdapter;)V", "binding", "getBinding", "()Lcom/example/agdesk/databinding/FragmentAssetsBinding;", "databaseHelper", "Lcom/example/agdesk/database/DatabaseHelper;", "getDatabaseHelper", "()Lcom/example/agdesk/database/DatabaseHelper;", "setDatabaseHelper", "(Lcom/example/agdesk/database/DatabaseHelper;)V", "listOfAssets", "", "Lcom/example/agdesk/models/AssetModel;", "getListOfAssets", "()Ljava/util/List;", "setListOfAssets", "(Ljava/util/List;)V", "taskViewModel", "Lcom/example/agdesk/ViewModels/TaskViewModel;", "getTaskViewModel", "()Lcom/example/agdesk/ViewModels/TaskViewModel;", "taskViewModel$delegate", "Lkotlin/Lazy;", "checkAndInsertDefaultAssets", "", "clicked", "pos", "", "filter", "text", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "onViewCreated", "view", "showAssetDialog", "asset", "app_debug"})
public final class AssetsFragment extends androidx.fragment.app.Fragment implements com.example.agdesk.models.OnClick {
    @org.jetbrains.annotations.Nullable()
    private com.example.agdesk.databinding.FragmentAssetsBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.agdesk.models.AssetModel> listOfAssets;
    public com.example.agdesk.database.DatabaseHelper databaseHelper;
    public com.example.agdesk.adapters.AssetsAdapter assetsAdapter;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy taskViewModel$delegate = null;
    
    public AssetsFragment() {
        super();
    }
    
    private final com.example.agdesk.databinding.FragmentAssetsBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.AssetModel> getListOfAssets() {
        return null;
    }
    
    public final void setListOfAssets(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.AssetModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.agdesk.database.DatabaseHelper getDatabaseHelper() {
        return null;
    }
    
    public final void setDatabaseHelper(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.database.DatabaseHelper p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.agdesk.adapters.AssetsAdapter getAssetsAdapter() {
        return null;
    }
    
    public final void setAssetsAdapter(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.adapters.AssetsAdapter p0) {
    }
    
    private final com.example.agdesk.ViewModels.TaskViewModel getTaskViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
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
    
    @java.lang.Override()
    public void onResume() {
    }
    
    public final void checkAndInsertDefaultAssets() {
    }
    
    private final void showAssetDialog(com.example.agdesk.models.AssetModel asset) {
    }
    
    public final void filter(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    @java.lang.Override()
    public void clicked(int pos) {
    }
}