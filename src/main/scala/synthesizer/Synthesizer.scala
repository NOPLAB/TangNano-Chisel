package synthesizer

import chisel3._
import chisel3.util._
class SynthesizerTop(var count: Int) extends Module {
  // Pin configuration
  val io = IO(new Bundle {
    val speaker = Output(UInt(1.W))
    val led = Output(UInt(1.W))
  })

  val reg = RegInit(0.U(1.W))

  io.led := 0.U

  // Initialize Counter
  val counter = Counter(count / 523 / 2)
  // Count up
  counter.inc()

  when(counter.value === 0.U)
  {
    io.speaker := ~io.speaker
  } .otherwise
  {
    io.speaker := io.speaker
  }
}

class SynthesizerTopWrapper extends RawModule {
  val io = IO(new Bundle{
    val speaker = Output(UInt(1.W))
    val led = Output(UInt(1.W))
    val clock = Input(Clock())
    val nrst = Input(Bool())
  })
  val top = withClockAndReset(io.clock, !io.nrst){ Module(new SynthesizerTop(24 * 1000 * 1000))}
  io.speaker <> top.io.speaker
  io.led <> top.io.led
}