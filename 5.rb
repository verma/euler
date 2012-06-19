Inf = 1.0/0

def compute
  nums_to_check = [20, 19, 18, 17, 16, 15, 14, 13, 12, 11]
  (20..Inf).step(20).each do |i|
    all_div = true
    nums_to_check.each do |j|
      all_div = false if i % j != 0
      break if !all_div
    end
    return i if all_div
  end
end

puts "Answer: #{compute}"
