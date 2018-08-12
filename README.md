# PerlinNoise2d 
The goal of this project is to create a visualization of the Perlin Noise algorithm, a type of gradient noise. 
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
- The algorithm generates "smooth" noise and has applications in procedural content generation for game development

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


In the diagram below, I've chosen the vectors (-1, 1), (1, 1), (1, -1), and (-1, -1)

![Noise Image](ListofGradients.png?raw=true "Gradient List")

- Determine the distance vectors

Distance vectors are simply a line pointing from the corner of the grid square to the pixel as shown below.

![Noise Image](DetermineDistanceVectors.png?raw=true "Determine the Distance Vectors")

- Calculate dot product

![Noise Image](DotProducts.png?raw=true "Calculate the Dot Products")

3. Fade Function and Bilinear Interpolation

In order to prevent any artifacts in the resulting image or terrain, we must first
 apply a fade function to the relative location of the pixel in the grid square. For example, the relative location of the center
 of the grid square would be (0.5, 0.5), hereinafter denoted by FracX and FracY respectively. The fade functions,
 also known as an ease curve has the following form:
 
  ![FadeFunction](fadefunction1.png?raw=true "FadeFunction")
 
 We input FracX and FracY to this function and use the resulting values in the next step, 
 where we use bilinear interpolation to get the final pixel value.
 
 
  ![FadeFunction](BilinearInterpolation.png?raw=true "FadeFunction")
  
  
This gives us the final pixel value. In a simple application this value can denote the brightness of a pixel.
When used in procedural terrain generation, this value can denote the height of the terrain at a given point.
 
 
 
