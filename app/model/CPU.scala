package model

case class CPU(mhz:Int,vendor:String,model:String,cacheSize:Long)

case class CPUPerc(user:Double,sys:Double,_wait:Double,idle:Double,nice:Double,combined:Double)

case class MemoryInfo(total:Double,used:Double,free:Double)

case class SwapInfo(total:Double,used:Double,free:Double)
