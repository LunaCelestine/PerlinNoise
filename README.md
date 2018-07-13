# PerlinNoise2d 
The goal of this project is to create visualization of the Perlin Noise algorithm, a type of gradient noise. 
The algorithm was originally created by Dr. Ken Perlin of NYU in 1983. The original algorithm suffered from second order interpolation discontinuity and unoptimal gradient
computation. However, later in 2003, he developed an improved version of the algorithm which runs faster and appears more natural.
This project uses this improved algorithm to create a visualization of the noise, displayed inside of a JFrame.

[Ken Perlin's 2002 paper on the improved noise algorithm](https://mrl.nyu.edu/~perlin/paper445.pdf)


This program will populate a JFrame with noise; here is an example of what it looks like:

![Noise Image](PerlinNoise.jpg?raw=true "Perlin Noise")

As you can see here the noise gradient, that is the change from black to white, is smooth and mimics naturally occuring
effects such as the topography of natural terrain. 


