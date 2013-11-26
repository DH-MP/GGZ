package com.ggz.model;

import com.sunnyd.Base;
import com.sunnyd.IModel;
import com.sunnyd.annotations.ActiveRecordField;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Mike
 * Date: 11/20/13
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Inventory extends Base implements IModel {

    @ActiveRecordField
    private Integer totalTime;

    @ActiveRecordField
    private String inventoryName;

    @ActiveRecordField
    private String address;



    public Inventory() {
        super();
    }

    public Inventory(Map<String, Object> HM) {
        super(HM);
    }


    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
        setUpdateFlag(true);
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
        setUpdateFlag(true);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        setUpdateFlag(true);
    }
}
