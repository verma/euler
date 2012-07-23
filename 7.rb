require 'prime'

def compute(till)
  i = 0
  Prime.series do |n|
    i = i+1
    return n if i >= till
  end
end

puts "#{compute 10001}"
