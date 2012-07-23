def compute
  1.upto(999) do |a|
    a.upto(999) do |b|
      c = 1000 - a - b
      begin
        puts "#{a}, #{b}, #{c}"
        return a*b*c
      end if a*a + b*b == c*c
    end
  end
end

puts "Answer: #{compute}"
