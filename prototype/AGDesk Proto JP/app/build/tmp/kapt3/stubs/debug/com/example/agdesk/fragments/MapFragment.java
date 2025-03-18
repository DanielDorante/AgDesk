package com.example.agdesk.fragments;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0016\u0010\u001f\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110!H\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\u0016\u0010$\u001a\u00020\u001d2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00190!H\u0002J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010\'\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J$\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u001dH\u0016J\u0010\u00102\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110!2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110!H\u0002J\b\u00104\u001a\u00020\u001dH\u0002J\u0018\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\b\u00107\u001a\u00020\u001dH\u0002J\u0018\u00108\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lcom/example/agdesk/fragments/MapFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "()V", "_binding", "Lcom/example/agdesk/databinding/FragmentMapBinding;", "binding", "getBinding", "()Lcom/example/agdesk/databinding/FragmentMapBinding;", "check", "", "currentFieldMarkers", "", "Lcom/google/android/gms/maps/model/Marker;", "currentPolygon", "Lcom/google/android/gms/maps/model/Polygon;", "fieldPoints", "Lcom/google/android/gms/maps/model/LatLng;", "fieldViewModel", "Lcom/example/agdesk/ViewModels/FieldViewModel;", "getFieldViewModel", "()Lcom/example/agdesk/ViewModels/FieldViewModel;", "fieldViewModel$delegate", "Lkotlin/Lazy;", "fieldsModelData", "Lcom/example/agdesk/models/FieldsModel;", "googleMap", "Lcom/google/android/gms/maps/GoogleMap;", "addCustomMarker", "", "position", "calculateCentroid", "points", "", "clickListeners", "dismissFieldCreation", "drawAll", "savedFields", "drawPolygon", "field", "finalizeFieldCreation", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onMapReady", "orderPointsForPolygon", "showAddFieldDialog", "showFieldNameInsidePolygon", "fieldName", "showNameFieldDialog", "updateFieldNamePosition", "app_debug"})
public final class MapFragment extends androidx.fragment.app.Fragment implements com.google.android.gms.maps.OnMapReadyCallback {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy fieldViewModel$delegate = null;
    private com.google.android.gms.maps.GoogleMap googleMap;
    @org.jetbrains.annotations.Nullable()
    private com.example.agdesk.databinding.FragmentMapBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.agdesk.models.FieldsModel> fieldsModelData = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String check = "";
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.google.android.gms.maps.model.LatLng> fieldPoints = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.google.android.gms.maps.model.Marker> currentFieldMarkers = null;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.maps.model.Polygon currentPolygon;
    
    public MapFragment() {
        super();
    }
    
    private final com.example.agdesk.ViewModels.FieldViewModel getFieldViewModel() {
        return null;
    }
    
    private final com.example.agdesk.databinding.FragmentMapBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void clickListeners() {
    }
    
    private final void showAddFieldDialog() {
    }
    
    private final void addCustomMarker(com.google.android.gms.maps.model.LatLng position) {
    }
    
    private final void drawPolygon(com.example.agdesk.models.FieldsModel field) {
    }
    
    private final java.util.List<com.google.android.gms.maps.model.LatLng> orderPointsForPolygon(java.util.List<com.google.android.gms.maps.model.LatLng> points) {
        return null;
    }
    
    private final void showNameFieldDialog() {
    }
    
    private final com.google.android.gms.maps.model.LatLng calculateCentroid(java.util.List<com.google.android.gms.maps.model.LatLng> points) {
        return null;
    }
    
    private final void showFieldNameInsidePolygon(java.lang.String fieldName, com.google.android.gms.maps.model.LatLng position) {
    }
    
    private final void dismissFieldCreation() {
    }
    
    private final void finalizeFieldCreation() {
    }
    
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap googleMap) {
    }
    
    private final void drawAll(java.util.List<com.example.agdesk.models.FieldsModel> savedFields) {
    }
    
    private final void updateFieldNamePosition(java.lang.String fieldName, com.google.android.gms.maps.model.LatLng position) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}