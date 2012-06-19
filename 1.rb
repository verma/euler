def compute()
  (1...1000).select { |i| i % 3 == 0 or i % 5 == 0 }.inject(0) { |sum, ele| sum + ele }
end

puts "Answer: #{compute}"
