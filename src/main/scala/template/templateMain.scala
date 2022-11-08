package template

import chisel3._

object templateMain extends App {
  (new stage.ChiselStage).emitVerilog(new templateTopWrapper(), Array("--target-dir", "out"))
}