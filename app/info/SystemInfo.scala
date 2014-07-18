package info

import model._
import org.hyperic.sigar.Sigar

object SystemInfo {

  def cpus: List[CPU] = {
    val sigar = new Sigar
    try {
      for (cpu <- sigar.getCpuInfoList().toList)
        yield CPU(cpu.getMhz, cpu.getVendor, cpu.getModel, cpu.getCacheSize)
    } finally {
      sigar.close
    }
  }

  def cpu_status: List[CPUPerc] = {
    val sigar = new Sigar
    try {
      for (cpu_status <- sigar.getCpuPercList().toList)
        yield CPUPerc(cpu_status.getUser(), cpu_status.getSys(), cpu_status.getWait(), cpu_status.getIdle(), cpu_status.getNice(), cpu_status.getCombined())
    } finally {
      sigar.close
    }
  }

  def mem_info: MemoryInfo = {
    val sigar = new Sigar
    val mem = sigar.getMem
    try {
      MemoryInfo(mem.getTotal, mem.getUsed, mem.getFree)
    } finally {
      sigar.close
    }
  }

  def swap_info: SwapInfo = {
    val sigar = new Sigar
    val swap = sigar.getSwap
    try {
      SwapInfo(swap.getTotal, swap.getUsed, swap.getFree)
    } finally {
      sigar.close
    }
  }
}