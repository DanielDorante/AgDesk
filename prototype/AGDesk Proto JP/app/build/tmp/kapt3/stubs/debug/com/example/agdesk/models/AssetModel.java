package com.example.agdesk.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b5\b\u0086\b\u0018\u00002\u00020\u0001B\u00a5\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0016J\u000b\u00103\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u0010\u00105\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u0010\u00106\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u0010\u00107\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u0010\u00108\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u0010\u00109\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001dJ\u000b\u0010:\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u0010\u0010A\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u00ce\u0001\u0010C\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020\u00142\b\u0010F\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010G\u001a\u00020\u000bH\u00d6\u0001J\t\u0010H\u001a\u00020\u0005H\u00d6\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0018\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b%\u0010\"R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b+\u0010\"R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b,\u0010\"R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b-\u0010\"R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b2\u0010\"\u00a8\u0006I"}, d2 = {"Lcom/example/agdesk/models/AssetModel;", "", "uid", "Ljava/util/UUID;", "assetPrefix", "", "name", "manufac", "parts", "location", "dateMade", "", "dateBuy", "image", "farmId", "vin", "serialNo", "reg", "syncId", "checkoutStatus", "", "checkoutBy", "(Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)V", "getAssetPrefix", "()Ljava/lang/String;", "getCheckoutBy", "setCheckoutBy", "(Ljava/lang/String;)V", "getCheckoutStatus", "()Ljava/lang/Boolean;", "setCheckoutStatus", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDateBuy", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDateMade", "getFarmId", "getImage", "getLocation", "getManufac", "getName", "getParts", "getReg", "getSerialNo", "getSyncId", "getUid", "()Ljava/util/UUID;", "setUid", "(Ljava/util/UUID;)V", "getVin", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/example/agdesk/models/AssetModel;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class AssetModel {
    @androidx.room.TypeConverters(value = {com.example.agdesk.DataLayer.Converters.DatabaseConverter.class})
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID uid;
    @androidx.room.ColumnInfo(name = "asset_Prefix")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String assetPrefix = null;
    @androidx.room.ColumnInfo(name = "asset_Name")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String name = null;
    @androidx.room.ColumnInfo(name = "manufacture")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String manufac = null;
    @androidx.room.ColumnInfo(name = "part_List")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String parts = null;
    @androidx.room.ColumnInfo(name = "location")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String location = null;
    @androidx.room.ColumnInfo(name = "date_Manufactured")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer dateMade = null;
    @androidx.room.ColumnInfo(name = "date_Purchased")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer dateBuy = null;
    @androidx.room.ColumnInfo(name = "asset_Image")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String image = null;
    @androidx.room.ColumnInfo(name = "farm_Id")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer farmId = null;
    @androidx.room.ColumnInfo(name = "vin")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer vin = null;
    @androidx.room.ColumnInfo(name = "serial_Number")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer serialNo = null;
    @androidx.room.ColumnInfo(name = "registration")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer reg = null;
    @androidx.room.ColumnInfo(name = "global_Id")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer syncId = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean checkoutStatus;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String checkoutBy;
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.agdesk.models.AssetModel copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID uid, @org.jetbrains.annotations.Nullable()
    java.lang.String assetPrefix, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String manufac, @org.jetbrains.annotations.Nullable()
    java.lang.String parts, @org.jetbrains.annotations.Nullable()
    java.lang.String location, @org.jetbrains.annotations.Nullable()
    java.lang.Integer dateMade, @org.jetbrains.annotations.Nullable()
    java.lang.Integer dateBuy, @org.jetbrains.annotations.Nullable()
    java.lang.String image, @org.jetbrains.annotations.Nullable()
    java.lang.Integer farmId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer vin, @org.jetbrains.annotations.Nullable()
    java.lang.Integer serialNo, @org.jetbrains.annotations.Nullable()
    java.lang.Integer reg, @org.jetbrains.annotations.Nullable()
    java.lang.Integer syncId, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean checkoutStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String checkoutBy) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    public AssetModel(@org.jetbrains.annotations.Nullable()
    java.util.UUID uid, @org.jetbrains.annotations.Nullable()
    java.lang.String assetPrefix, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String manufac, @org.jetbrains.annotations.Nullable()
    java.lang.String parts, @org.jetbrains.annotations.Nullable()
    java.lang.String location, @org.jetbrains.annotations.Nullable()
    java.lang.Integer dateMade, @org.jetbrains.annotations.Nullable()
    java.lang.Integer dateBuy, @org.jetbrains.annotations.Nullable()
    java.lang.String image, @org.jetbrains.annotations.Nullable()
    java.lang.Integer farmId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer vin, @org.jetbrains.annotations.Nullable()
    java.lang.Integer serialNo, @org.jetbrains.annotations.Nullable()
    java.lang.Integer reg, @org.jetbrains.annotations.Nullable()
    java.lang.Integer syncId, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean checkoutStatus, @org.jetbrains.annotations.Nullable()
    java.lang.String checkoutBy) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getUid() {
        return null;
    }
    
    public final void setUid(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAssetPrefix() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getManufac() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getParts() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getDateMade() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getDateBuy() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getFarmId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getVin() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getSerialNo() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getReg() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getSyncId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getCheckoutStatus() {
        return null;
    }
    
    public final void setCheckoutStatus(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCheckoutBy() {
        return null;
    }
    
    public final void setCheckoutBy(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
}