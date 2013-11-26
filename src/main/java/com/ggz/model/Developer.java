package com.ggz.model;

import com.sunnyd.Base;
import com.sunnyd.IModel;
import com.sunnyd.annotations.ActiveRecordField;

import java.util.Map;


public class Developer extends Base implements IModel
{

    @ActiveRecordField
    private String name;


    public Developer() {
        super();
    }

    public Developer(Map<String, Object> HM) {
        super(HM);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setUpdateFlag(true);
    }
}
