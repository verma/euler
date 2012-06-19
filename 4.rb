def num_palins
  arr = []
  999.downto(100).each do |i|
    (i).downto(100).each do |j|
      prod = i * j
      if block_given?
        yield 
      else
        arr << prod
      end if prod.to_s == prod.to_s.reverse
    end
  end
  arr if !block_given?
end

puts "Answer: #{num_palins.sort.last}"
