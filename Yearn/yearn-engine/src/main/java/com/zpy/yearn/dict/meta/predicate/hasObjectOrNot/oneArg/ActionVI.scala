/*
 * Copyright(c)2018-2020, 赵鹏阳
 * 项目名称:Yearn 文件名称:ActionVI.scala
 * Date:2020/1/1 下午9:21
 * Author: 赵鹏阳
 */

package com.zpy.yearn.dict.meta.predicate.hasObjectOrNot.oneArg

import com.zpy.yearn.dict.meta.hasArgs.TPred
import com.zpy.yearn.dict.meta.ib.{TAction, TIb}

/**
  * Created by zpy on 2019/5/29.
  */
abstract class ActionVI extends TAction with VI {


  override def genArgInf: Set[TPred] = argInf1ArgFunc[TIb](sbj)
}