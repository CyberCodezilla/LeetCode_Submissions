class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;

        for (int x : nums) {
            // Case 1: p^3
            int p = (int)Math.round(Math.cbrt(x));
            if (p * p * p == x && isPrime(p)) {
                ans += 1 + p + p * p + x;
                continue;
            }

            // Case 2: p * q (distinct primes)
            int d = -1;
            for (int i = 2; i * i <= x; i++) {
                if (x % i == 0) {
                    d = i;
                    break;
                }
            }

            if (d == -1) continue;

            int q = x / d;
            if (d != q && isPrime(d) && isPrime(q)) {
                ans += 1 + d + q + x;
            }
        }
        return ans;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

