package com.zpy.yearn.dict.meta;

import com.zpy.yearn.dict.relation.verb.Target;
import com.zpy.yearn.dict.verb.Way;
import lombok.Data;

/**
 * Created by zpy on 2018/9/19.
 */
@Data
public class SenseGroup {
    private Way way;
    private Target target;
}
