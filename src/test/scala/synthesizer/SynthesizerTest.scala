package synthesizer

import chisel3._
import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class SynthesizerTester(c: SynthesizerTop) extends PeekPokeTester(c) {
  for (i <- 0 until 24 * 1000 * 1000 * 3) {
    step(1)
    println("speaker: " + peek(c.io.speaker))
  }
}
object SynthesizerTest extends App {
  iotesters.Driver.execute(args, () => new SynthesizerTop(24 * 1000 * 1000)) {
    c => new SynthesizerTester(c)
  }

  (new stage.ChiselStage).emitVerilog(new SynthesizerTopWrapper(), Array("--target-dir", "out"))
}