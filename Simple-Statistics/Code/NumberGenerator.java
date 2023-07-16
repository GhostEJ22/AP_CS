import java.util.Arrays;
public class NumberGenerator {
  // ENTER INSTANCE VARIABLES AND GETTERS BELOW
  private int[] numArray;
  private int arraySize;
  private double mean;
  private double median;
  private int min;
  private int max;
  private double standard_deviation;
  // Setter for test case
  
  public void setArray(int[] numArray) {
    this.numArray = numArray;
  }

  // ENTER REMAINING METHODS BELOW
  //instantiates array to a certain size
  public NumberGenerator(int num){
    numArray = new int[num];
    arraySize = num;
  }
  //getters for variables defined above
  public double getMean() {
    return mean;
  }
  public double getMedian() {
    return median;
  }
  public int getMin() {
    return min;
  }
  public int getMax() {
    return max;
  }
  public double getSD() {
    return standard_deviation;
  }
  //randomizer
  public void randomize() {
    int random;
    for(int i=0;i<numArray.length;i++) {
      random = (int)(Math.random()*1000);
      numArray[i] = random;
    }
  }
  //calculates all the instance variables
  public void calcMinAndMax() {
    min=numArray[0];
    max=numArray[0];
    for(int val: numArray){
      if(val>max){
        max = val;
      } 
      if(val<min){
        min = val;
      }
    }
  }
  public void calcMean() {
    double total =0;
    for(int val: numArray){
      total+=val;
    }
    mean = total/arraySize;
  }
  public void calcMedian(){
    Arrays.sort(numArray);
    int percent=numArray.length%2;
    
    if(percent==1) {
      median = numArray[(int)(numArray.length/2 + 1)];
    } else if(percent==0) {
      
      median = (double)((numArray[numArray.length/2-1] + numArray[numArray.length/2 ])/2.0);
    }
  }
  public void calcSD() {
    double SD = 0;
    for(int i=0; i<numArray.length;i++) {
      
      SD= SD + Math.pow(numArray[i]-mean,2);
    }
    SD=SD/(numArray.length-1);
    standard_deviation = Math.sqrt(SD);
  }  
  //prints the string
  public void showAllValues() {
    for(int num: numArray) {
      if(num!=numArray[numArray.length-1]) {
        System.out.print(num + ", ");
      } else System.out.print(num);
    }
  }
  //reverses the string and prints it 
  public void reverse() {
    int currentNum=numArray[0];
    for(int i = 0;i<numArray.length/2;i++){
      currentNum=numArray[i];
      numArray[i] = numArray[numArray.length-i-1];
      numArray[numArray.length-i-1] = currentNum;
      
      }
    
    
    
    }
  
    
}

