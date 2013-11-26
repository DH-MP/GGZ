package com.ggz.model;

import com.sunnyd.Base;
import com.sunnyd.IModel;
import com.sunnyd.annotations.ActiveRecordField;

import java.util.Map;

public class Platform extends Base implements IModel {

    //Table attributes
    @ActiveRecordField
    private String name;

    public Platform() {
        super();
    }

    public Platform(Map<String, Object> HM) {
        super(HM);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        setUpdateFlag(true);
    }
}
