require 'test/unit'

def is_prime(n)
  return false if n == 1
  return true if n == 2 or n == 3
  return false if n % 2 == 0 or n % 3 == 0
  k = 1
  sqrt_n = Math.sqrt(n)
  while true do
    n1, n2 = 6*k - 1, 6*k + 1
    break if n1 > sqrt_n and n2 > sqrt_n
    return false if n % n1 == 0 and n1 <= sqrt_n
    return false if n % n2 == 0 and n2 <= sqrt_n
    k += 1
  end
  true
end

def find_multiplier(n)
  start = 2
  while start <= n / 2
    return n / start if n % start == 0 and is_prime(n / start)
    start += 1
  end
end

puts "#{find_multiplier 13195  }"
puts "#{find_multiplier 600851475143  }"

