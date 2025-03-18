package com.example.agdesk.DataLayer.DAOs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'\u00a8\u0006\u0005"}, d2 = {"Lcom/example/agdesk/DataLayer/DAOs/AssetDAO;", "", "getAll", "", "Lcom/example/agdesk/DataLayer/entities/Asset;", "app_debug"})
@androidx.room.Dao()
public abstract interface AssetDAO {
    
    @androidx.room.Query(value = "SELECT * FROM Asset")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.agdesk.DataLayer.entities.Asset> getAll();
}