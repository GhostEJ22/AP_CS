import processing.core.PApplet;
import processing.core.PVector;

public class Sketch extends PApplet {
  KochFractal k;
  

  public void settings() {
    size(640, 360);
  }

  public void setup() {
    frameRate(1); // Animate slowly
    k = new KochFractal(this);

  }

  public void draw() {
    background(0);
    // Draws the snowflake!
    k.render();
    // Iterate
    k.nextLevel();
    // Let's not do it more than 5 times. . .
    if (k.getCount() > 5) {
      k.restart();
    }
  }
}