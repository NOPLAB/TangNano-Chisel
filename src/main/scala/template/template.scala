package template

import chisel3._
import chisel3.util._
class templateTop(var count: Int) extends Module {
  // Pin configuration
  val io = IO(new Bundle {
    val led = Output(UInt(1.W))
  })
  
  io.led := 0.U
}

class templateTopWrapper extends RawModule {
  val io = IO(new Bundle{
    val led = Output(UInt(1.W))
    val clock = Input(Clock())
    val nrst = Input(Bool())
  })
  val top = withClockAndReset(io.clock, !io.nrst){ Module(new templateTop(24 * 1000 * 1000))}
  io.led <> top.io.led
}