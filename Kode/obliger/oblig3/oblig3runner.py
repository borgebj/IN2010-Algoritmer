import insertion, quick, bubble, heap
from countswaps import CountSwaps
from countcompares import CountCompares
import math
import time

# The student can adjust these parameters to conduct their experiments

ALGS1 = [heap.sort, quick.sort]
ALGS2 = [heap.sort, quick.sort]

TIME_LIMIT_MS = 100
INCREMENT = 1


# We use the module as name for the algorithm
def algname(alg):
    return alg.__module__


def checkIfSorted(A):
    for i in range(len(A) - 1):
        if A[i] > A[i + 1]:
            print("Feil!", A[i], A[i + 1])
            return False
    return True


# Run all sorting algorithms and create .out files
def run_algs_part1(A, infilename):
    for alg in ALGS1:
        countA = CountSwaps([CountCompares(x) for x in A])
        outfilename = infilename + '_' + algname(alg) + '.out'
        outstr = '\n'.join(map(str, alg(countA)))
        with open(outfilename, 'w') as f:
            f.write(outstr)

        print(algname(alg) + "> sorted: ", checkIfSorted(countA))  # sjekker om listen er sortert
        print(countA)


# Generate the header for the given sorting algorithm
def algheader(alg):
    name = algname(alg)
    return '%s_cmp, %s_swaps, %s_time' % (name, name, name)


# Make the header string for the CSV
def makeheader(algs, digits):
    headers = ', '.join([algheader(alg) for alg in algs])
    fmt = '%' + str(digits) + 's, %s'
    return fmt % ('n', headers)


# Generate a format string for printing results of a run
def runstringfmt(alg):
    c, s, t = map(len, algheader(alg).split(', '))
    fmt = "%%%dd, %%%dd, %%%dd"
    return fmt % (c, s, t)


# Run a sorting and return a description of the execution as a CSV row
def runalg(alg, A, i, discarded):
    fmt = runstringfmt(alg)

    if alg in discarded:
        res = fmt % (0, 0, 0)
        return res.replace('0', ' ')

    countingA = CountSwaps([CountCompares(x) for x in A[:i]])
    now = time.time_ns()

    alg(countingA)

    timeus = (time.time_ns() - now) / 1000
    timems = timeus / 1000

    if timems > TIME_LIMIT_MS:
        discarded.add(alg)
        print('\nGiving up on ' + algname(alg) + '\n')

    comparisons = sum(x.compares for x in countingA)
    swaps = countingA.swaps

    return fmt % (comparisons, swaps, timeus)


# Run all sorting algorithms from 0 to n, and write CSV file
def run_algs_part2(A, infilename):
    outfilename = infilename + '_results.csv'
    discarded = set()

    f = open(outfilename, 'w')
    digits = int(math.log10(len(A)) + 1)
    header = makeheader(ALGS2, digits)

    f.write(header + '\n')
    print(header)

    rowfmt = '%' + str(digits) + 'd'
    printtime = time.time_ns()

    for i in range(0, len(A) + 1, INCREMENT):
        row = rowfmt % i

        for alg in ALGS2:
            row += ', ' + runalg(alg, A, i, discarded)

        if set(ALGS2) == discarded:
            break

        f.write(row + '\n')

        now = time.time_ns()
        if now - printtime > 10e8:
            print(row)
            printtime = now
            f.flush()

    f.close()
