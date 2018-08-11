# PerlinNoise2d 
The goal of this project is to create visualization of the Perlin Noise algorithm, a type of gradient noise. 
The algorithm was originally created by Dr. Ken Perlin of NYU in 1983. The original algorithm suffered from second order interpolation discontinuity and unoptimal gradient
computation. However, later in 2003, he developed an improved version of the algorithm which runs faster and appears more natural.
This project uses this improved algorithm to create a visualization of the noise, displayed inside of a JFrame.

[Ken Perlin's 2002 paper on the improved noise algorithm](https://mrl.nyu.edu/~perlin/paper445.pdf)


This program will populate a JFrame with noise; here is an example of what it looks like:

![Noise Image](PerlinNoise.jpg?raw=true "Perlin Noise")

As you can see here the noise gradient, that is the change from black to white, is smooth and mimics naturally occurring
effects such as the topography of natural terrain. 

Below is a explanation of how the algorithm works.

Perlin Noise

- Is an algorithm for generating pseudorandom noise
- The noise at each point has a relationship to its neighboring points in n-dimensions
- The algorithm generatss "smooth" noise and has applications in procedural content generation for game development

The Algorithm

1. Define a grid

- Each small square represents a pixel
- The goal is to color each pixel create smooth noise
- The grid overlay represents the location and direction of pseudorandom gradient vectors

![Noise Image](DefiningGrid.png?raw=true "Defiune a grid")

\* The larger grid squares are the gradient vector grid, changing its dimensions can increase or decrease the frequency of the noise.

2. Calculate the dot product of the random gradient and distance vector

- Determine the random gradient

![Noise Image](DetermineGradients.png?raw=true "Determine Random Gradients")

- Random gradients are selected from a list of vectors

![Noise Image](ListofGradients.png?raw=true "Gradient List")

- Determine the distance vectors

image

- Calculate dot product