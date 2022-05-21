"""
Combinatorics calculator to solve various types of combinatorics problems.

Supports:
    Combinations calculation nCr
    Permutations calculation nPr
    Permutation with repetition
    Permutation without repetition
    Combination with repetition
    Combination without repetition
    Permutation with indistinguishable items
    Permutation with indistinguishable items using 1..x
    Permutation with indistinguishable items using x..max number of items

@author Vincent Zhang
@since 2 October 2021
"""


import itertools, math

def output(data):
    print("LEN: ", len(data))
    shouldPrint = input("print?: ")
    if shouldPrint in yes:
        for d in data:
            print("".join(d))
    print()


#combData = [1, 2, 3]
#combOut = itertools.combinations(combData, 2)

#output(permOut)
#output(combOut)



def pickInt(valFloat, valInt):
    if valFloat == valInt:
        return valInt
    return valFloat


def perm(n, r):
    # nPr
    val = math.factorial(n)/math.factorial(n-r)
    return pickInt(val, int(val))

def comb(n, r):
    # nCr
    val = perm(n, r)/math.factorial(r)
    return pickInt(val, int(val))


yes = ['yes', 'y']
no = ['no', 'n']
yesno = yes + no


def main():
    choice = input('"perm" or "comb" or "does order matter?" or "perm indistinguishable": ').lower()
    if choice in ['perm', 'p', 'comb', 'c']: # Direct nCr, nPr formula.
        n = int(input('n: '))
        r = int(input('r: '))

        if choice in ['perm', 'p']:
            print(perm(n, r))
        elif choice in ['comb', 'c']:
            print(comb(n, r))
    elif choice in yesno: # Order matters or does not matter: perm or comb
        rep = ""
        while rep not in yesno:
            rep = input('Is repetition of each element allowed?: ') # With or without repetition.

        n = int(input('n (types): '))
        r = int(input('r (objs): '))
        if choice in yes: # perm
            if rep in yes: # n^r
                # Permutation with repetition of items allowed
                print("EXAMPLE ------- password permutation with a-z A-z 0-9.")
                print(math.pow(n, r))
            else:
                # Permutation repetition of items not allowed
                print("EXAMPLE ------- arrange 3 of 5 books on a bookshelf.")
                print(perm(n, r))
        else: # comb
            if rep in yes: # donut problem
                # Combination with repetition of items (stars and bars method) (objects + types-1)C(objects)
                print("EXAMPLE ------- choose 10 donuts from 3 flavours")
                print(comb(n+r-1, r))
            else: # standard comb
                # Combination without repetition of items
                print("EXAMPLE ------- choose 5 people from a 9 people sports team")
                print(comb(n, r))
    elif choice in ['perm indistinguishable', 'perm ind', 'pi']:
        # Permutation wtih indistinguishable objects: e.g., number of distinct permutations of 'AABCCCCDE'
        word = input('Enter word: ')
        permData = list(word)
        permOut = set(itertools.permutations(permData))
        output(permOut) # Print number of distinct permutations and optionally each individually.
        
        lessEqual = input("<= ?: ")
        sum = 0
        if lessEqual not in no:
            # All 1, 2,..lessEqual character permutations using letters from the input word.
            for i in range(1, min(int(lessEqual)+1, len(word)+1)):
                sum += len(set(itertools.permutations(permData, i)))
        else:
            a = int(input(">= ?: "))
            for i in range(a, len(word)+1):
                sum += len(set(itertools.permutations(permData, i)))
        print("sum:", sum)

if __name__ == '__main__':
    main()

