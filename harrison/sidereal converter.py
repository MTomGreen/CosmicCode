# middle value of hour long bin
binAvg = float(input("bin: "))+0.5
print("bin average: " + str(binAvg))

# sidereal time calculated
sidereal = (binAvg/24)*23.93446959
print(sidereal)
