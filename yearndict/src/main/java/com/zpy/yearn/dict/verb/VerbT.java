package com.zpy.yearn.dict.verb;

import com.zpy.yearn.dict.meta.pos.Noun;
import com.zpy.yearn.dict.meta.sense.Sense;
import lombok.Data;

import java.util.function.BiFunction;

/**
 * Created by zpy on 2018/10/8.
 */
@Data
public abstract class VerbT extends Sense implements BiFunction  {
    private Noun subject;
    private Noun object;

}
/*

public interface VerbT {
	VerbStatus status = null;
	void negate();
}

enum VerbStatus{

	HAPPENED, NOT_HAPPENED
}
 */