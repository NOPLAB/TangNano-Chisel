package led

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class LEDTester(c: LEDTop) extends PeekPokeTester(c) {
  // private val led = c
  // var cnt = 0
  // for(i <- 1 to 10 by 1) {
  //   step(2)
  //   cnt = (cnt + 1) % 8
  //   expect(led.io.led, cnt)
  // }
}
object LEDTest extends App {
  iotesters.Driver.execute(args, () => new LEDTop(2)) {
    c => new LEDTester(c)
  }
}