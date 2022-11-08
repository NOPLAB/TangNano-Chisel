package led

import chisel3._

object LEDMain extends App {
  //chisel3.Driver.execute(Array("--target-dir", "out"), () => new LEDTopWrapper())
  (new stage.ChiselStage).emitVerilog(new LEDTopWrapper(), Array("--target-dir", "out"))
}