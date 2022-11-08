package synthesizer

import chisel3._

object SynthesizerMain extends App {
  //chisel3.Driver.execute(Array("--target-dir", "out"), () => new LEDTopWrapper())
  (new stage.ChiselStage).emitVerilog(new SynthesizerTopWrapper(), Array("--target-dir", "out"))
}