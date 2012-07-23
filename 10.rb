require 'prime'

def compute
  sum = 0
  Prime.series do |i|
    return sum if i > 2_000_000
    sum += i
  end
end

puts "Answer: #{compute}"
