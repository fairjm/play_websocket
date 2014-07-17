package info

import model._
import org.hyperic.sigar.Sigar

object SystemInfo {

  def cpus:List[CPU] = {
    val sigar = new Sigar
    val array = 
    for(cpu <- sigar.getCpuInfoList()) 
      yield CPU(cpu.getMhz,cpu.getVendor,cpu.getModel,cpu.getCacheSize)
    sigar.close
    array.toList
  }
  
  def cpu_status:List[CPUPerc] = {
    val sigar = new Sigar
    val array = 
    for(cpu_status <- sigar.getCpuPercList())
      yield CPUPerc(cpu_status.getUser(),cpu_status.getSys(),cpu_status.getWait(),cpu_status.getIdle(),cpu_status.getNice(),cpu_status.getCombined())
    sigar.close
    array.toList
  }
}