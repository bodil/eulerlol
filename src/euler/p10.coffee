sieve = (limit) ->
  numbers = ((if n % 2 then true else false) for n in [0...limit])
  primes = [2]
  pos = 3
  while pos < limit and (numbers[pos] * numbers[pos]) < limit
    factor = pos
    if numbers[factor]
      primes.push pos
      (numbers[multiple] = null) for multiple in [factor...limit] by factor
    pos++
  pos = 3
  while pos < limit
    (primes.push pos) if numbers[pos]
    pos++
  primes

start = Date.now()
sum = 0
(sum += n) for n in sieve 2000000
console.log "Answer = #{sum}"
console.log "took #{Date.now() - start}ms"

