import math

# middle value of hour long bin
binAvg = float(input("bin: "))+0.5
print("bin average: " + str(binAvg))

# calculated in radians converted to degrees
rotation = math.degrees((2*math.pi)*(binAvg/23.93446959))
print("rotation: " + str(rotation) + " degrees")





    
    
