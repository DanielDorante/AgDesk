package com.example.agdesk.DataLayer.Converters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\bH\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/example/agdesk/DataLayer/Converters/DatabaseConverter;", "", "()V", "dateToUnix", "", "date", "Ljava/util/Date;", "fromLatLng", "", "latLngList", "", "Lcom/google/android/gms/maps/model/LatLng;", "fromUUID", "uuid", "Ljava/util/UUID;", "fromUnix", "timestamp", "toLatLng", "", "uuidFromString", "string", "app_debug"})
public final class DatabaseConverter {
    
    public DatabaseConverter() {
        super();
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromLatLng(@org.jetbrains.annotations.NotNull()
    java.util.List<com.google.android.gms.maps.model.LatLng> latLngList) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.google.android.gms.maps.model.LatLng> toLatLng(@org.jetbrains.annotations.NotNull()
    java.lang.String latLngList) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromUUID(@org.jetbrains.annotations.Nullable()
    java.util.UUID uuid) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID uuidFromString(@org.jetbrains.annotations.NotNull()
    java.lang.String string) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date fromUnix(long timestamp) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    public final long dateToUnix(@org.jetbrains.annotations.NotNull()
    java.util.Date date) {
        return 0L;
    }
}