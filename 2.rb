def fib(limit)
  last, this = 1, 2
  yield last if limit > 1
  while this < limit do
    yield this
    last, this = this, this+last
  end
end

def compute()
  sum = 0
  fib(4000000) { |i| sum += i if i % 2 == 0 }
  sum
end

puts "Answer: #{compute}"
