package template

import chisel3._
import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class templateTester(c: templateTop) extends PeekPokeTester(c) {
  for (i <- 0 until 100) {
    step(1)
    println("led: " + peek(c.io.led))
  }
}
object templateTest extends App {
  iotesters.Driver.execute(args, () => new templateTop(24 * 1000 * 1000)) {
    c => new templateTester(c)
  }

  (new stage.ChiselStage).emitVerilog(new templateTopWrapper(), Array("--target-dir", "out"))
}