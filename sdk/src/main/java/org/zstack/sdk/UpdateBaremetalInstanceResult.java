package org.zstack.sdk;

import org.zstack.sdk.BaremetalInstanceInventory;

public class UpdateBaremetalInstanceResult {
    public BaremetalInstanceInventory inventory;
    public void setInventory(BaremetalInstanceInventory inventory) {
        this.inventory = inventory;
    }
    public BaremetalInstanceInventory getInventory() {
        return this.inventory;
    }

}
