"""
Program to plot a piecwise composed function.
@author Vincent Zhang
@since 27 October 2021
"""

import matplotlib.pyplot as plt

def f(x):
    """Return pre-image f(x) for image x.
    Function f(x) is:
        1 - x,  x <= 0
        x^2  ,  x > 0
    """
    if x<=0:
        return 1-x
    return x*x

def g(x):
    """Return pre-image g(x) for image x.
    Function g(x) is:
        -x ,  x < 1
        x+1,  x >= 1
    """
    if x < 1:
        return -x
    return x+1

# Plot 40 x-values from x=-2 (inclusive) to x=2 (exclusive)
for i in range(-20, 20):
    x = i / 10
    plt.scatter(x, f(g(x)))

plt.show()