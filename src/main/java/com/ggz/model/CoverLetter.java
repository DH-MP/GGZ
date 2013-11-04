package com.ggz.model;

import java.util.HashMap;
import com.sunnyd.annotations.ActiveRecordInheritFrom;

@ActiveRecordInheritFrom(childClassof = "Document")
public class CoverLetter extends Document {

    public static final String tableName = "cover_letters";

    public CoverLetter() {
        super();
    }

    public CoverLetter(HashMap<String, Object> HM) {
        super(HM);
    }

}
