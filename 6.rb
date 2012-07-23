def compute(n)
  sq = 0
  1.upto(n) { |i|
    sq += i*i
  }
  snq = n * (n + 1) / 2
  snq*snq - sq
end

puts "Answer: #{compute 100}"
