class Solution:
    def totalNumbers(self, digits: List[int]) -> int:
        unqnumbs=set()
        for p in permutations(digits,3):
            num = p[0] * 100 + p[1]*10 + p[2]
            if p[0] != 0 and p[2] % 2 == 0:
                unqnumbs.add(num)
        return len(unqnumbs)
        