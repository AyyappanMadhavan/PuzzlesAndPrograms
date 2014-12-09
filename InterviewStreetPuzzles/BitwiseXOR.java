 class BitwiseXOR{ 
  public static void main(String args[]){
  System.out.println(" ^ XOR operator");
  int x = 1 ^ 1;
  char A[] = {'0'};
  char B[] = {'1'};
  int idx=0;
  System.out.println("0 ^ 0 = " + (false ^ false));
  System.out.println("0 ^ 1 = " + (false ^ true));
  System.out.println("1 ^ 0 = " + (true ^ false));
  System.out.println("1 ^ 1 = " + (true ^ true));
  System.out.println("char ="+ ('1'^'1'));
    System.out.println("char ="+ (A[idx]^B[idx]));

  }
}