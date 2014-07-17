package model

case class CPU(mhz:Int,vendor:String,model:String,cacheSize:Long)

case class CPUPerc(user:Double,sys:Double,_wait:Double,idle:Double,nice:Double,combined:Double)