/*
 * Copyright(c)2018-2020, 赵鹏阳
 * 项目名称:Yearn 文件名称:TestEvaluate.scala
 * Date:2020/1/1 下午9:21
 * Author: 赵鹏阳
 */

package yearn.burns

import com.zpy.yearn.dict.basic.cause.Cause
import com.zpy.yearn.facade.context.BotContext
import com.zpy.yearn.service.机器人的头脑
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by zpy on 2019/5/11.
  */
class TestEvaluate extends FlatSpec with Matchers {



}
object TestEvaluate{

  def evalShouldNotCauseMoodDirectly(机器人的反应: BotContext): Boolean = {
    val 期望的错误命题 = 机器人的反应.heardStcs.filter(_.isInstanceOf[Cause]).head

    机器人的头脑.错误命题.contains(  期望的错误命题)
  }
}