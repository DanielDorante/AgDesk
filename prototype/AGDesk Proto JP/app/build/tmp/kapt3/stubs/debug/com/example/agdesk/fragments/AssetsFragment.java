package com.example.agdesk.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u0003:\u00014B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\u0012\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010\'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u0018H\u0016J\u0010\u0010/\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u0018H\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\u001a\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u00103\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u0018H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u00065"}, d2 = {"Lcom/example/agdesk/fragments/AssetsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/agdesk/models/OnClick;", "Lcom/example/agdesk/adapters/AssetsAdapter$AssetItemListener;", "()V", "_binding", "Lcom/example/agdesk/databinding/FragmentAssetsBinding;", "assetViewModel", "Lcom/example/agdesk/ViewModels/AssetViewModel;", "getAssetViewModel", "()Lcom/example/agdesk/ViewModels/AssetViewModel;", "assetViewModel$delegate", "Lkotlin/Lazy;", "assetsAdapter", "Lcom/example/agdesk/adapters/AssetsAdapter;", "getAssetsAdapter", "()Lcom/example/agdesk/adapters/AssetsAdapter;", "setAssetsAdapter", "(Lcom/example/agdesk/adapters/AssetsAdapter;)V", "binding", "getBinding", "()Lcom/example/agdesk/databinding/FragmentAssetsBinding;", "listOfAssets", "", "Lcom/example/agdesk/models/UIModels/AssetModel;", "getListOfAssets", "()Ljava/util/List;", "setListOfAssets", "(Ljava/util/List;)V", "clicked", "", "pos", "", "filter", "text", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDeleteClick", "asset", "onEditClick", "onResume", "onViewCreated", "view", "showAssetDialog", "Companion", "app_debug"})
public final class AssetsFragment extends androidx.fragment.app.Fragment implements com.example.agdesk.models.OnClick, com.example.agdesk.adapters.AssetsAdapter.AssetItemListener {
    @org.jetbrains.annotations.Nullable()
    private com.example.agdesk.databinding.FragmentAssetsBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.agdesk.models.UIModels.AssetModel> listOfAssets;
    public com.example.agdesk.adapters.AssetsAdapter assetsAdapter;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy assetViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ARG_ASSET = "asset";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.agdesk.fragments.AssetsFragment.Companion Companion = null;
    
    public AssetsFragment() {
        super();
    }
    
    private final com.example.agdesk.databinding.FragmentAssetsBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.agdesk.models.UIModels.AssetModel> getListOfAssets() {
        return null;
    }
    
    public final void setListOfAssets(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.agdesk.models.UIModels.AssetModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.agdesk.adapters.AssetsAdapter getAssetsAdapter() {
        return null;
    }
    
    public final void setAssetsAdapter(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.adapters.AssetsAdapter p0) {
    }
    
    private final com.example.agdesk.ViewModels.AssetViewModel getAssetViewModel() {
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
    public void onEditClick(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.UIModels.AssetModel asset) {
    }
    
    @java.lang.Override()
    public void onDeleteClick(@org.jetbrains.annotations.NotNull()
    com.example.agdesk.models.UIModels.AssetModel asset) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void showAssetDialog(com.example.agdesk.models.UIModels.AssetModel asset) {
    }
    
    public final void filter(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    @java.lang.Override()
    public void clicked(int pos) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/agdesk/fragments/AssetsFragment$Companion;", "", "()V", "ARG_ASSET", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}