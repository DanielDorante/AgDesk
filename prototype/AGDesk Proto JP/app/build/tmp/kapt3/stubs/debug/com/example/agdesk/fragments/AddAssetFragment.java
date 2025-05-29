package com.example.agdesk.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001BB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\"\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u00020 2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010/\u001a\u00020 H\u0016J\u001a\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020*2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u00102\u001a\u00020 H\u0002J\u0012\u00103\u001a\u0004\u0018\u00010\u001c2\u0006\u00104\u001a\u00020\u0017H\u0002J\b\u00105\u001a\u00020 H\u0002J\b\u00106\u001a\u00020 H\u0002J\b\u00107\u001a\u00020 H\u0002J\b\u00108\u001a\u00020 H\u0002J\u0010\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020\u001cH\u0002J\u001c\u0010;\u001a\u00020 2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020 0=H\u0002J\b\u0010>\u001a\u00020 H\u0002J\b\u0010?\u001a\u00020 H\u0002J\u0010\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00040\u00040\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006C"}, d2 = {"Lcom/example/agdesk/fragments/AddAssetFragment;", "Landroidx/fragment/app/Fragment;", "()V", "TAG", "", "assetViewModel", "Lcom/example/agdesk/ViewModels/AssetViewModel;", "getAssetViewModel", "()Lcom/example/agdesk/ViewModels/AssetViewModel;", "assetViewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/example/agdesk/databinding/FragmentAddAssetBinding;", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "existingAsset", "Lcom/example/agdesk/models/UIModels/AssetModel;", "isEditMode", "", "pickImage", "Landroidx/activity/result/ActivityResultLauncher;", "qrBitmap", "Landroid/graphics/Bitmap;", "selectedDateManufactured", "Ljava/util/Date;", "selectedDatePurchased", "selectedImageUri", "Landroid/net/Uri;", "generateQRCode", "content", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "saveAsset", "saveBitmapToCache", "bitmap", "setupAssetPrefixSpinner", "setupDatePickers", "setupImageUpload", "setupUI", "shareImage", "imageUri", "showDatePicker", "onDateSelected", "Lkotlin/Function1;", "showGenerateQRDialog", "startQRScanner", "updateFormFieldsVisibility", "assetPrefix", "Companion", "app_debug"})
public final class AddAssetFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.example.agdesk.databinding.FragmentAddAssetBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "AddAssetFragment";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy assetViewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap qrBitmap;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri selectedImageUri;
    private final java.util.Calendar calendar = null;
    @org.jetbrains.annotations.Nullable()
    private java.util.Date selectedDateManufactured;
    @org.jetbrains.annotations.Nullable()
    private java.util.Date selectedDatePurchased;
    private boolean isEditMode = false;
    @org.jetbrains.annotations.Nullable()
    private com.example.agdesk.models.UIModels.AssetModel existingAsset;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFIX_LV = "LV";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFIX_HV = "HV";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFIX_SE = "SE";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFIX_LE = "LE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ARG_ASSET = "asset";
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> pickImage = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.agdesk.fragments.AddAssetFragment.Companion Companion = null;
    
    public AddAssetFragment() {
        super();
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
    
    private final void setupUI() {
    }
    
    private final void setupAssetPrefixSpinner() {
    }
    
    private final void updateFormFieldsVisibility(java.lang.String assetPrefix) {
    }
    
    private final void setupDatePickers() {
    }
    
    private final void showDatePicker(kotlin.jvm.functions.Function1<? super java.util.Date, kotlin.Unit> onDateSelected) {
    }
    
    private final void setupImageUpload() {
    }
    
    private final void saveAsset() {
    }
    
    private final void showGenerateQRDialog() {
    }
    
    private final void startQRScanner() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final android.graphics.Bitmap generateQRCode(java.lang.String content) {
        return null;
    }
    
    private final android.net.Uri saveBitmapToCache(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final void shareImage(android.net.Uri imageUri) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/agdesk/fragments/AddAssetFragment$Companion;", "", "()V", "ARG_ASSET", "", "PREFIX_HV", "PREFIX_LE", "PREFIX_LV", "PREFIX_SE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}